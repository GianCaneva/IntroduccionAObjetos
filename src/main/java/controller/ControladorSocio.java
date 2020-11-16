package controller;

import dto.*;
import dto.Empresa.Empresa;
import dto.Empresa.SocioParticipe;
import dto.Empresa.SocioProtector;
import dto.Operacion.*;
import dto.enumeration.CtaCorriente;
import dto.enumeration.Prestamo;
import dto.enumeration.TipoCheque;
import utils.Utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorSocio {
    private static List<Empresa> listaEmpresas;
    private static List<SocioParticipe> listaSocioParticipe;
    private static List<SocioProtector> listaSocioProtector;
    private Integer idSocio = 0;

    public ControladorSocio() {
    }

    public static List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public static List<SocioParticipe> getListaSocioParticipe() {
        return listaSocioParticipe;
    }

    private void agregarEmpresa(final Empresa empresa) {
        listaEmpresas.add(empresa);
    }

    private void agregarSocioParticipe(final SocioParticipe socioParticipe) {
        listaSocioParticipe.add(socioParticipe);
    }

    private void agregarSocioProtector(final SocioProtector socioProtector) {
        listaSocioProtector.add(socioProtector);
    }

    public void emicionDeFacturasPendientes() {
        //Se asume que el primer dia de la semana es Lunes y que no existen los feriados.
        //En caso de que asi sea se debera esperar hasta la proxima semana.
        //1 representa el dia lunes, 2 martes etc y 0 el doming
        if (Utils.getDate().getDay() != 1) {
            throw new RuntimeException("Error. Se debe esperar hasta el primer dia habil para hacer la emision de Facturas");
        }

        List<LineaDeCredito> lineaDeCreditoList = (List<LineaDeCredito>) listaSocioParticipe.stream().map(x -> x.getLineaDeCredito());
        List<Operacion> listOps = (List<Operacion>) lineaDeCreditoList.stream().map(LineaDeCredito::getOperaciones);
        List<Operacion> listaDeOps = listOps.stream().filter(x -> x.getEstado() == "calculada").collect(Collectors.toList());

        for (int y = 0; y < listaDeOps.size(); y++) {
            Operacion operacion = listaDeOps.get(y);
            operacion.cambiarAFacturada();
            for (int j = 0; j < lineaDeCreditoList.size(); j++) {
                List<Operacion> operaciones = lineaDeCreditoList.get(j).getOperaciones();
                for (int p = 0; p < operaciones.size(); p++) {
                    if (operaciones.get(p).getId() == operacion.getId()) {
                        lineaDeCreditoList.get(j).agregarFactura(operacion.getImporteTotal(), operacion.getId());
                    }
                }
            }
        }
    }

    public void operacionProsperada(
            final Integer cuit,
            final String operacionId) {
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        List<Operacion> operaciones = empresa.getLineaDeCredito().getOperaciones();
        Operacion operacion = buscarOperacion(operaciones, operacionId);

        if (operacion.getClass() == Tipo1.class) {
            operacion.crearComision((float) 3, 1);
        } else if (operacion.getClass() == Tipo2.class) {
            operacion.crearComision((float) 3, 2);
        } else if (operacion.getClass() == Tipo3.class) {
            operacion.crearComision((float) 4, 3);
        }
    }

    public void operar(final String id, final Integer cuit){

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        Desembolso desembolso = empresa.getLineaDeCredito().getDesembolso();

        if (desembolso != null){
            throw new RuntimeException("Ningún socio puede operar con desembolsos no cubiertos");
        }

        Operacion operacion = buscarOperacion(id);

        CertificadoDeGarantia certificadoDeGarantia = new CertificadoDeGarantia(cuit);
        operacion.agregarCertificadoDeGarantia(certificadoDeGarantia);
        operacion.modificarEstado("Con certificado emitido");

    }

    public String solicitarOperacionCheque(
            final Integer cuit,
            final TipoCheque tipo,
            final String bancoDelCheque,
            final Integer numeroDelCheque,
            final Date fechaDeVencimiento,
            final Integer cuitDelFirmante,
            final Float importe
    ) {

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);

        LineaDeCredito lineaDeCredito = empresa.getLineaDeCredito();
        if (!lineaDeCredito.getTipoOperaciones().contains(tipo)) {
            throw new RuntimeException("El socio no tiene la operacion en la linea de credito");
        }
        if (empresa.getPostulante()) {
            throw new RuntimeException("El socio es postulante.");
        }
        if (excesoPorcentajeFacturas(cuit)) {
            throw new RuntimeException("Ningún socio puede operar si debe facturas por más del 10% del total de la línea asignada.");
        }

        float porcentaje = (importe * 100) / getFDR();

        if (porcentaje > 5) {
            throw new RuntimeException("Ningún socio puede operar por más del 5% del FDR");
        }

        if (excesoChequesFirmante(cuit, importe)) {
            throw new RuntimeException("La SGR no puede recibir más del 5% del FDR en cheques de un mismo firmante");
        }

        Tipo1 cheque = Tipo1.Builder.newBuilder()
                .withBancoCheque(bancoDelCheque)
                .withNroCheque(numeroDelCheque)
                .withFechaVencimiento(fechaDeVencimiento)
                .withCuitFirmante(cuitDelFirmante)
                .withCheque(tipo)
                .withImporteTotal(importe)
                .build();

        cheque.modificarEstado("Ingresado");
        lineaDeCredito.agregarOperacion(cheque);

        return cheque.getId();

    }

    public String solicitarOperacionCCC(
            final Integer cuit,
            final String empresaCC,
            final Date fechaVencimiento,
            final CtaCorriente cuentaCr,
            final Float importe
    ) {

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);

        LineaDeCredito lineaDeCredito = empresa.getLineaDeCredito();
        if (!lineaDeCredito.getTipoOperaciones().contains(cuentaCr)) {
            throw new RuntimeException("El socio no tiene la operacion en la linea de credito");
        }
        if (empresa.getPostulante()) {
            throw new RuntimeException("El socio es postulante.");
        }
        if (excesoPorcentajeFacturas(cuit)) {
            throw new RuntimeException("Ningún socio puede operar si debe facturas por más del 10% del total de la línea asignada.");
        }

        float porcentaje = (importe * 100) / getFDR();

        if (porcentaje > 5) {
            throw new RuntimeException("Ningún socio puede operar por más del 5% del FDR");
        }

        Tipo2 cuenta = Tipo2.Builder.newBuilder()
                .withEmpresaCC(empresaCC)
                .withFechaVencimiento(fechaVencimiento)
                .withCuenta(cuentaCr)
                .withImporteTotal(importe)
                .build();

        cuenta.modificarEstado("Ingresado");
        lineaDeCredito.agregarOperacion(cuenta);

        return cuenta.getId();

    }

    public String solicitarOperacionPrestamo(
            final Integer cuit,
            final String bancoPrestamo,
            final Float importeTotal,
            final Float tasa,
            final Date fechaAcreditacion,
            final Integer cantidadCuotas,
            final String sistema

    ) {

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);

        LineaDeCredito lineaDeCredito = empresa.getLineaDeCredito();
        if (!lineaDeCredito.getTipoOperaciones().contains(Prestamo.Prestamo)) {
            throw new RuntimeException("El socio no tiene la linea de credito");
        }
        if (empresa.getPostulante()) {
            throw new RuntimeException("El socio es postulante.");
        }

        if (excesoPorcentajeFacturas(cuit)) {
            throw new RuntimeException("Ningún socio puede operar si debe facturas por más del 10% del total de la línea asignada.");
        }

        float porcentaje = (importeTotal * 100) / getFDR();

        if (porcentaje > 5) {
            throw new RuntimeException("Ningún socio puede operar por más del 5% del FDR");
        }

        Tipo3 prestamo = Tipo3.Builder.newBuilder()
                .withBancoPrestamo(bancoPrestamo)
                .withImporteTotal(importeTotal)
                .withTasa(tasa)
                .withFechaAcreditacion(fechaAcreditacion)
                .withCantidadCuotas(cantidadCuotas)
                .withSistema(sistema)
                .build();

        prestamo.modificarEstado("Ingresado");
        lineaDeCredito.agregarOperacion(prestamo);
        return prestamo.getId();

    }


    public void asignarLineaDeCredito(
            final Integer cuit,
            final float monto,
            final Date date,
            final List<Enum> operaciones) {
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);

        empresa.asignarLineaDeCredito(monto, date, operaciones);
    }


    public void suscribirAccion(
            final Integer cuit,
            final Integer cuitVendedor,
            final Float porcentaje,
            final Float precioUnitario
    ) {
        Empresa empresa = buscarEmpresa(cuit);
        empresa.suscribirAcciones(cuitVendedor, porcentaje, precioUnitario);

    }


    public void aprobarDocumento(final Integer cuit) {
        Empresa empresa = buscarEmpresa(cuit);

        if (empresa.getClass() == SocioProtector.class) {
            List<Accionista> listaAccionistas = (List<Accionista>) listaSocioParticipe.stream().map(x -> x.getAccionista());
            List<Integer> cuitAccionistas = (List<Integer>) listaAccionistas.stream().map(x -> x.getCuit());
            if (cuitAccionistas.contains(cuit)) {
                throw new RuntimeException("Un socio no puede ser aprobado como protector si es accionista de una empresa socia partícipe de la SGR");
            }
        }
        empresa.aprobarDocumento();
    }


    public void presentarDocumento(
            final Integer cuit,
            final String tipo,
            final String estado,
            final String usuario
    ) {

        Documento documento = Documento.Builder.newBuilder()
                .withTipo(tipo)
                .withEstado(estado)
                .withFechaDeRecepcion(Utils.getDate())
                .withUsuario(usuario)
                .build();

        Empresa empresa = buscarEmpresa(cuit);
        empresa.addDocumento(documento);

    }


    public void solicitarSocioParticipe(
            final Integer cuit,
            final String razonSocial,
            final Date fechaInicio,
            final String tipo,
            final String actividadPrincipal,
            final String direccion,
            final Integer telefono,
            final String correoElectronico,
            final List<Accionista> accionistas

    ) {

        Empresa newEmpresa = SocioParticipe.Builder.newBuilder()
                .withCuit(cuit)
                .withRazonSocial(razonSocial)
                .withFechaInicio(fechaInicio)
                .withTipo(tipo)
                .withActividadPrincipal(actividadPrincipal)
                .withDireccion(direccion)
                .withTelefono(telefono)
                .withCorreoElectronico(correoElectronico)
                .withAccionista(accionistas)
                .withIdSocio(idSocio)
                .withPostulante(true)
                .build();

        agregarEmpresa(newEmpresa);
        agregarSocioParticipe((SocioParticipe) newEmpresa);
        idSocio = idSocio + 1;
    }

    public void solicitarSocioProtector(
            final Integer cuit,
            final String razonSocial,
            final Date fechaInicio,
            final String tipo,
            final String actividadPrincipal,
            final String direccion,
            final Integer telefono,
            final String correoElectronico,
            final List<Accionista> accionistas

    ) {

        Empresa newEmpresa = SocioProtector.Builder.newBuilder()
                .withCuit(cuit)
                .withRazonSocial(razonSocial)
                .withFechaInicio(fechaInicio)
                .withTipo(tipo)
                .withActividadPrincipal(actividadPrincipal)
                .withDireccion(direccion)
                .withTelefono(telefono)
                .withCorreoElectronico(correoElectronico)
                .withAccionista(accionistas)
                .withIdSocio(idSocio)
                .withPostulante(true)
                .build();

        agregarEmpresa(newEmpresa);
        agregarSocioProtector((SocioProtector) newEmpresa);
        idSocio = idSocio + 1;
    }


    public static Empresa buscarEmpresa(final Integer empresaCuit) {
        Empresa empresaIndex = null;
        for (int i = 0; i < listaEmpresas.size(); i++) {
            Empresa empresa = listaEmpresas.get(i);
            if (empresa.getCuit() == empresaCuit) {
                empresaIndex = empresa;
            }
        }
        return empresaIndex;
    }

    public void agregarDesembolsos(final Integer cuit, final Float monto, final Float mora, final String tipo){
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        empresa.getLineaDeCredito().agregarDesembolso(monto, mora, tipo);
    }

    public void eliminarDesembolsos(final Integer cuit){
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        empresa.getLineaDeCredito().eliminarDesembolso();
    }

    private Operacion buscarOperacion(final List<Operacion> operaciones, final String numOperacion) {

        Operacion operacionDeRetorno = null;
        for (int i = 0; i < operaciones.size(); i++) {
            Operacion operacion = operaciones.get(i);
            if (operacion.getId() == numOperacion) {
                operacionDeRetorno = operacion;
            }
        }
        return operacionDeRetorno;
    }

    private Operacion buscarOperacion(final String numOperacion) {

        List<LineaDeCredito> lineaDeCredito = (List<LineaDeCredito>) listaSocioParticipe.stream().map(x -> x.getLineaDeCredito());
        List<Operacion> operaciones = (List<Operacion>) lineaDeCredito.stream().map(x -> x.getOperaciones());

        Operacion operacionDeRetorno = null;

        for (int i = 0; i < operaciones.size(); i++) {
            Operacion operacion = operaciones.get(i);
            if (operacion.getId() == numOperacion) {
                operacionDeRetorno = operacion;
            }
        }
        return operacionDeRetorno;
    }

    private boolean excesoPorcentajeFacturas(final Integer cuit) {
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        LineaDeCredito lineaDeCredito = empresa.getLineaDeCredito();
        List<Factura> facturaList = lineaDeCredito.getFacturaList();

        Float montoFacturas = Float.valueOf(0);

        Boolean valorDeRetorno = false;

        for (int a = 0; a < facturaList.size(); a++) {
            montoFacturas = montoFacturas + facturaList.get(a).getMonto();
        }

        float operacion = (montoFacturas * 100) / lineaDeCredito.getMonto();

        if (operacion > 10) {
            valorDeRetorno = true;
        }

        return valorDeRetorno;

    }

    private Float getFDR() {
        Float fdr = Float.valueOf(0);
        List<AporteDeCapital> aportesDeCapital = (List<AporteDeCapital>) listaSocioProtector.stream().map(x -> x.getCantidadAporteCapìtal());
        List<Float> montosTotales = (List<Float>) aportesDeCapital.stream().map(x -> x.getMonto());

        for (int i = 0; i < montosTotales.size(); i++) {
            fdr = fdr + montosTotales.get(i);
        }
        return fdr;
    }


    private boolean excesoChequesFirmante(final Integer firmante, final Float valorAgregado) {
        List<LineaDeCredito> lineaDeCredito = (List<LineaDeCredito>) listaSocioParticipe.stream().map(x -> x.getLineaDeCredito());
        List<Operacion> operaciones = (List<Operacion>) lineaDeCredito.stream().map(x -> x.getOperaciones());
        List<Tipo1> operacionesDeTipoCheque = null;

        for (int i = 0; i < operaciones.size(); i++) {
            Operacion operacion = operaciones.get(i);
            if (operacion.getClass() == Tipo1.class) {
                operacionesDeTipoCheque.add((Tipo1) operacion);
            }
        }
        List<Tipo1> operacionesFirmante = (List<Tipo1>) operacionesDeTipoCheque.stream().filter(x -> x.getCuitFirmante() == firmante);

        Float monto = Float.valueOf(0);
        for (int i = 0; i < operacionesFirmante.size(); i++) {
            Tipo1 tipo1 = operacionesFirmante.get(i);
            monto = monto + tipo1.getImporteTotal();
        }

        monto = monto + valorAgregado;
        Boolean valorDeRetorno = false;

        if (((monto * 100) / getFDR()) > 5) {
            valorDeRetorno = true;
        }

        return valorDeRetorno;
    }


}