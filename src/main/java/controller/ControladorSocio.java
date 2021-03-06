package controller;

import dto.*;
import dto.Empresa.Accionista;
import dto.Empresa.Empresa;
import dto.Empresa.SocioParticipe;
import dto.Empresa.SocioProtector;
import dto.Enumeration.CtaCorriente;
import dto.Enumeration.Prestamo;
import dto.Enumeration.TipoCheque;
import dto.Operacion.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorSocio {
    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static List<SocioParticipe> listaSocioParticipe = new ArrayList<>();
    private static List<SocioProtector> listaSocioProtector = new ArrayList<>();
    private static List<Cambio> historial = new ArrayList<>();
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

    private void removerEmpresa(final Empresa empresa) {
        listaEmpresas.remove(empresa);
    }

    private void agregarSocioParticipe(final SocioParticipe socioParticipe) {
        listaSocioParticipe.add(socioParticipe);
    }

    private void agregarSocioProtector(final SocioProtector socioProtector) {
        listaSocioProtector.add(socioProtector);
    }

    private void removerSocioProtector(final SocioProtector socioProtector) {
        listaSocioProtector.remove(socioProtector);
    }

    private void removerSocioParticipe(final SocioParticipe socioParticipe) {
        listaSocioProtector.remove(socioParticipe);
    }

    private static void agregarCambio(final Cambio cambio) {
        historial.add(cambio);
    }

    public static void emicionDeFacturasPendientes() {
        //Se asume que el primer dia de la semana es Lunes y que no existen los feriados.
        //En caso de que asi sea se debera esperar hasta la proxima semana.
        //1 representa el dia lunes, 2 martes etc y 0 el doming
        if (Utils.getDate().getDay() != 1) {
            throw new RuntimeException("Error. Se debe esperar hasta el primer dia habil para hacer la emision de Facturas");
        }
        List<Operacion> listOpsTotal = new ArrayList<>();

        List<LineaDeCredito> lineaDeCreditoList = listaSocioParticipe.stream().map(SocioParticipe::getLineaDeCredito).collect(Collectors.toList());
        List<List<Operacion>> listOps = lineaDeCreditoList.stream().map(LineaDeCredito::getOperaciones).collect(Collectors.toList());

        for (int i = 0; i < listOps.size(); i++) {
            List<Operacion> operacions = listOps.get(i);

            for (int j = 0; j < operacions.size(); j++) {
                Operacion operacion = operacions.get(j);
                if (operacion.getEstado() == "calculada") {
                    listOpsTotal.add(operacion);
                }
            }
        }


        for (int y = 0; y < listOpsTotal.size(); y++) {
            Operacion operacion = listOpsTotal.get(y);
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

    public static void generarAportes(final Integer cuit, final Float monto) {

        SocioProtector empresa = (SocioProtector) buscarEmpresa(cuit);
        if (!listaSocioProtector.contains(empresa)) {
            throw new RuntimeException("La empresa no es una socia protectora como para generar aportes");
        }

        empresa.generarAporteCapital(monto);

    }

    public static void retirarAportes(final Integer cuit, final Date fecha) {

        SocioProtector empresa = (SocioProtector) buscarEmpresa(cuit);
        if (!listaSocioProtector.contains(empresa)) {
            throw new RuntimeException("La empresa no es una socia protectora como para generar aportes");
        }

        empresa.retirarAporteCapital(fecha);
    }


    public static void operacionProsperada(
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

    public static void operar(final String id, final Integer cuit) {

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        Desembolso desembolso = empresa.getLineaDeCredito().getDesembolso();

        if (desembolso != null) {
            throw new RuntimeException("Ningún socio puede operar con desembolsos no cubiertos");
        }

        Operacion operacion = buscarOperacion(id);

        CertificadoDeGarantia certificadoDeGarantia = new CertificadoDeGarantia(cuit);
        operacion.agregarCertificadoDeGarantia(certificadoDeGarantia);
        operacion.modificarEstado("Con certificado emitido");

    }

    public static String solicitarOperacionCheque(
            final Integer cuit,
            final String tipoParametro,
            final String bancoDelCheque,
            final Integer numeroDelCheque,
            final Date fechaDeVencimiento,
            final Integer cuitDelFirmante,
            final Float importe
    ) {

        TipoCheque tipo = null;

        if (tipoParametro == "ChequeDeTerceros") {
            tipo = TipoCheque.ChequeDeTerceros;
        } else if (tipoParametro == "ChequePropio") {
            tipo = TipoCheque.ChequePropio;
        } else if (tipoParametro == "PagareBursatil") {
            tipo = TipoCheque.PagareBursatil;
        }

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

    public static String solicitarOperacionCCC(
            final Integer cuit,
            final String empresaCC,
            final Date fechaVencimiento,
            final String tipoParametro,
            final Float importe
    ) {

        CtaCorriente cuentaCr = null;

        if (tipoParametro == "TarjetaDeCredito") {
            cuentaCr = CtaCorriente.TarjetaDeCredito;
        } else if (tipoParametro == "CuentaCorrienteComercial") {
            cuentaCr = CtaCorriente.CuentaCorrienteComercial;
        }

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

    public static String solicitarOperacionPrestamo(
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


    public static void asignarLineaDeCredito(
            final Integer cuit,
            final float monto,
            final Date date) {

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);

        empresa.asignarLineaDeCredito(monto, date);
    }


    public static void agregarOperaciones(final Integer cuit, final String tipoDeOperacion) {

        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);

        if (!listaSocioParticipe.contains(empresa)) {
            throw new RuntimeException("La empresa no es una socia participe, por lo tanto no tiene una linea de credito a la cual asignar operaciones");
        }

        LineaDeCredito lineaDeCredito = empresa.getLineaDeCredito();
        if (lineaDeCredito == null) {
            throw new RuntimeException("La empresa no tiene una linea de credito asignada");
        }

        if (tipoDeOperacion == "ChequeDeTerceros") {
            lineaDeCredito.agregarTipoDeOperacion(TipoCheque.ChequeDeTerceros);
        } else if (tipoDeOperacion == "ChequePropio") {
            lineaDeCredito.agregarTipoDeOperacion(TipoCheque.ChequePropio);
        } else if (tipoDeOperacion == "PagareBursatil") {
            lineaDeCredito.agregarTipoDeOperacion(TipoCheque.PagareBursatil);
        } else if (tipoDeOperacion == "TarjetaDeCredito") {
            lineaDeCredito.agregarTipoDeOperacion(CtaCorriente.TarjetaDeCredito);
        } else if (tipoDeOperacion == "CuentaCorrienteComercial") {
            lineaDeCredito.agregarTipoDeOperacion(CtaCorriente.CuentaCorrienteComercial);
        } else if (tipoDeOperacion == "Prestamo") {
            lineaDeCredito.agregarTipoDeOperacion(Prestamo.Prestamo);
        }

    }


    public static void suscribirAccion(
            final Integer cuit,
            final Integer cuitVendedor,
            final Float porcentaje,
            final Float precioUnitario
    ) {
        Empresa empresa = buscarEmpresa(cuit);
        empresa.suscribirAcciones(cuitVendedor, porcentaje, precioUnitario);

    }


    public static void aprobarDocumento(final Integer cuit) {
        List<Integer> cuitAccionistas = new ArrayList<>();
        Empresa empresa = buscarEmpresa(cuit);

        if (empresa.getClass() == SocioProtector.class) {
            List<List<Accionista>> listaAccionistas = listaSocioParticipe.stream().map(x -> x.getAccionista()).collect(Collectors.toList());

            for (int i = 0; i < listaAccionistas.size(); i++) {
                List<Accionista> accionistas = listaAccionistas.get(i);
                for (int j = 0; j < accionistas.size(); j++) {
                    Accionista accionista = accionistas.get(j);
                    cuitAccionistas.add(accionista.getCuit());
                }
            }
            if (cuitAccionistas.contains(cuit)) {
                throw new RuntimeException("Un socio no puede ser aprobado como protector si es accionista de una empresa socia partícipe de la SGR");
            }
        }
        empresa.aprobarDocumento();
    }


    public static void presentarDocumento(
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


    public Integer solicitarSocioParticipe(
            final Integer cuit,
            final String razonSocial,
            final Date fechaInicio,
            final String tipo,
            final String actividadPrincipal,
            final String direccion,
            final Integer telefono,
            final String correoElectronico

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
                .withIdSocio(idSocio)
                .withPostulante(true)
                .build();

        if (existeCuit(cuit)) {
            throw new RuntimeException("Ya existe una empresa con el CUIT solicitado");
        }

        agregarEmpresa(newEmpresa);
        agregarSocioParticipe((SocioParticipe) newEmpresa);
        return idSocio = idSocio + 1;
    }

    public Integer solicitarSocioProtector(
            final Integer cuit,
            final String razonSocial,
            final Date fechaInicio,
            final String tipo,
            final String actividadPrincipal,
            final String direccion,
            final Integer telefono,
            final String correoElectronico

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
                .withIdSocio(idSocio)
                .withPostulante(true)
                .build();


        if (existeCuit(cuit)) {
            throw new RuntimeException("Ya existe una empresa con el CUIT solicitado");
        }


        agregarEmpresa(newEmpresa);
        agregarSocioProtector((SocioProtector) newEmpresa);
        return idSocio = idSocio + 1;
    }

    private Boolean existeCuit(final Integer cuit) {
        Boolean existe = false;

        for (int i = 0; i < listaEmpresas.size(); i++) {
            Empresa empresa = listaEmpresas.get(i);
            if (empresa.getCuit() == cuit) {
                existe = true;
            }
        }

        return existe;

    }

    public void agregarAccionista(final Integer cuitEmpresa, final Integer cuitAccionista, final String razonSocial, final Float participacion) {
        Empresa empresa = buscarEmpresa(cuitEmpresa);
        Accionista accionista = Accionista.Builder.newBuilder().withCuit(cuitAccionista).withRazonSocial(razonSocial).withParticipacion(participacion).build();

        empresa.agregarAccionista(accionista);

    }

    public void eliminarAccionista(final Integer cuitEmpresa, final Integer cuitAccionista) {
        Empresa empresa = buscarEmpresa(cuitEmpresa);
        empresa.eliminarAccionista(cuitAccionista);

    }


    public static Empresa buscarEmpresa(final Integer empresaCuit) {
        Empresa empresaIndex = null;
        for (int i = 0; i < listaEmpresas.size(); i++) {
            Empresa empresa = listaEmpresas.get(i);
            if (empresa.getCuit() == empresaCuit) {
                empresaIndex = empresa;
            }
        }

        if (empresaIndex == null) {
            throw new RuntimeException("No existe ninguna empresa con con el CUIT solicitado");
        }

        return empresaIndex;
    }

    public static void agregarDesembolsos(final Integer cuit, final Float monto, final Float mora, final String tipo) {
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        empresa.getLineaDeCredito().agregarDesembolso(monto, mora, tipo);
    }

    public static void eliminarDesembolsos(final Integer cuit) {
        SocioParticipe empresa = (SocioParticipe) buscarEmpresa(cuit);
        empresa.getLineaDeCredito().eliminarDesembolso();
    }

    private static Operacion buscarOperacion(final List<Operacion> operaciones, final String numOperacion) {

        Operacion operacionDeRetorno = null;
        for (int i = 0; i < operaciones.size(); i++) {
            Operacion operacion = operaciones.get(i);
            if (operacion.getId() == numOperacion) {
                operacionDeRetorno = operacion;
            }
        }
        return operacionDeRetorno;
    }

    private static Operacion buscarOperacion(final String numOperacion) {
        List<Operacion> listaDef = new ArrayList<>();
        List<LineaDeCredito> lineaDeCredito = listaSocioParticipe.stream().map(SocioParticipe::getLineaDeCredito).collect(Collectors.toList());
        List<List<Operacion>> operaciones = lineaDeCredito.stream().map(LineaDeCredito::getOperaciones).collect(Collectors.toList());

        Operacion operacionDeRetorno = null;


        for (int i = 0; i < operaciones.size(); i++) {
            List<Operacion> operacions = operaciones.get(i);
            for (int j = 0; j < operacions.size(); j++) {

                listaDef.add(operacions.get(j));
            }
        }


        for (int i = 0; i < listaDef.size(); i++) {
            Operacion operacion = listaDef.get(i);
            if (operacion.getId() == numOperacion) {
                operacionDeRetorno = operacion;
            }
        }

        if (operacionDeRetorno == null) {
            throw new RuntimeException("No existe tal operacion");
        }
        return operacionDeRetorno;
    }

    private static boolean excesoPorcentajeFacturas(final Integer cuit) {
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

    private static Float getFDR() {
        float fdr = (float) 0;

        List<Float> listaMontosTotales = new ArrayList<>();
        List<List<AporteDeCapital>> aportesDeCapital = listaSocioProtector.stream().map(x -> x.getCantidadAporteCapital()).collect(Collectors.toList());
        for (int i = 0; i < aportesDeCapital.size(); i++) {
            List<AporteDeCapital> aporteDeCapitals = aportesDeCapital.get(i);
            for (int j = 0; j < aporteDeCapitals.size(); j++) {
                listaMontosTotales.add(aporteDeCapitals.get(j).getMonto());

            }

        }

        for (int i = 0; i < listaMontosTotales.size(); i++) {
            fdr = fdr + listaMontosTotales.get(i);
        }
        return fdr;
    }


    private static boolean excesoChequesFirmante(final Integer firmante, final Float valorAgregado) {
        List<LineaDeCredito> lineaDeCredito = listaSocioParticipe.stream().map(SocioParticipe::getLineaDeCredito).collect(Collectors.toList());
        List<List<Operacion>> operaciones = lineaDeCredito.stream().map(x -> x.getOperaciones()).collect(Collectors.toList());
        List<Operacion> listaIntermedia = new ArrayList<>();
        for (int i = 0; i < operaciones.size(); i++) {
            List<Operacion> operacions = operaciones.get(i);
            for (int j = 0; j < operacions.size(); j++) {
                listaIntermedia.add(operacions.get(j));
            }

        }

        List<Tipo1> operacionesDeTipoCheque = null;

        for (int i = 0; i < listaIntermedia.size(); i++) {
            Operacion operacion = listaIntermedia.get(i);
            if (operacion.getClass() == Tipo1.class) {
                operacionesDeTipoCheque.add((Tipo1) operacion);
            }
        }
        List<Tipo1> operacionesFirmante = null;
        if (operacionesDeTipoCheque != null) {
            operacionesFirmante = operacionesDeTipoCheque.stream().filter(x -> x.getCuitFirmante() == firmante).collect(Collectors.toList());
        }

        float monto = (float) 0;
        for (int i = 0; i < operacionesFirmante.size(); i++) {
            Tipo1 tipo1 = operacionesFirmante.get(i);
            monto = monto + tipo1.getImporteTotal();
        }

        monto = monto + valorAgregado;
        boolean valorDeRetorno = false;

        if (((monto * 100) / getFDR()) > 5) {
            valorDeRetorno = true;
        }

        return valorDeRetorno;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////MODIFICACIONES DE LAS ESTRUCTURAS////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////


    private static void log(final Object originalObject, final Object newObject, final String referencia, final String usuario) {
        agregarCambio(Cambio.Builder.newBuilder()
                .withOldObject(originalObject)
                .withNuevoObject(newObject)
                .withReferencia(referencia)
                .withUsuario(usuario)
                .build());

    }

    public Integer modificarSocioProtector(
            final Integer cuit,
            final String razonSocial,
            final Date fechaInicio,
            final String tipo,
            final String actividadPrincipal,
            final String direccion,
            final Integer telefono,
            final String correoElectronico,
            final String referencia,
            final String usuario

    ) {

        SocioProtector empresaOriginal = (SocioProtector) buscarEmpresa(cuit);

        Empresa empresaModificada = SocioProtector.Builder.newBuilder()
                .withCuit(cuit)
                .withRazonSocial(razonSocial)
                .withFechaInicio(fechaInicio)
                .withTipo(tipo)
                .withActividadPrincipal(actividadPrincipal)
                .withDireccion(direccion)
                .withTelefono(telefono)
                .withCorreoElectronico(correoElectronico)
                .withIdSocio(empresaOriginal.getIdSocio())
                .withPostulante(true)
                .withAccionesB(empresaOriginal.getAccionesB())
                .withCantidadAporteCapital(empresaOriginal.getCantidadAporteCapital())
                .withDesembolso(empresaOriginal.getDesembolso())
                .withAccionista(empresaOriginal.getAccionista())
                .withDocumento(empresaOriginal.getDocumento())
                .withParticipacionSGR(empresaOriginal.getParticipacionSGR())
                .build();


        removerEmpresa(empresaOriginal);
        agregarEmpresa(empresaModificada);
        removerSocioProtector(empresaOriginal);
        agregarSocioProtector((SocioProtector) empresaModificada);


        log(empresaOriginal, empresaModificada, referencia, usuario);
        return ((SocioProtector) empresaModificada).getIdSocio();

    }


    public Integer modificarSocioParticipe(
            final Integer cuit,
            final String razonSocial,
            final Date fechaInicio,
            final String tipo,
            final String actividadPrincipal,
            final String direccion,
            final Integer telefono,
            final String correoElectronico,
            final String referencia,
            final String usuario

    ) {
        SocioParticipe empresaOriginal = (SocioParticipe) buscarEmpresa(cuit);

        Empresa empresaModificada = SocioParticipe.Builder.newBuilder()
                .withCuit(cuit)
                .withRazonSocial(razonSocial)
                .withFechaInicio(fechaInicio)
                .withTipo(tipo)
                .withActividadPrincipal(actividadPrincipal)
                .withDireccion(direccion)
                .withTelefono(telefono)
                .withCorreoElectronico(correoElectronico)
                .withIdSocio(empresaOriginal.getIdSocio())
                .withPostulante(true)
                .withAccionista(empresaOriginal.getAccionista())
                .withDocumento(empresaOriginal.getDocumento())
                .withParticipacionSGR(empresaOriginal.getParticipacionSGR())
                .withPostulante(empresaOriginal.getPostulante())
                .withAccionesA(empresaOriginal.getAccionesA())
                .withLineaDeCredito(empresaOriginal.getLineaDeCredito())
                .build();

        removerEmpresa(empresaOriginal);
        agregarEmpresa(empresaModificada);
        removerSocioParticipe(empresaOriginal);
        agregarSocioParticipe((SocioParticipe) empresaModificada);

        log(empresaOriginal, empresaModificada, referencia, usuario);
        return ((SocioParticipe) empresaModificada).getIdSocio();


    }

    public static String modificarOperacionCheque(
            final Integer cuit,
            final String tipoParametro,
            final String bancoDelCheque,
            final Integer numeroDelCheque,
            final Date fechaDeVencimiento,
            final Integer cuitDelFirmante,
            final Float importe,
            final String id,
            final String referencia,
            final String usuario

    ) {
        TipoCheque tipo = null;

        if (tipoParametro == "ChequeDeTerceros") {
            tipo = TipoCheque.ChequeDeTerceros;
        } else if (tipoParametro == "ChequePropio") {
            tipo = TipoCheque.ChequePropio;
        } else if (tipoParametro == "PagareBursatil") {
            tipo = TipoCheque.PagareBursatil;
        }

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

        Operacion operacionOriginal = (Operacion) lineaDeCredito.getOperaciones().stream().filter(x -> x.getId().equals(id));

        if (operacionOriginal == null) {
            throw new RuntimeException("No existe una operacion con el ID solicitado");
        }

        Tipo1 chequeModificado = Tipo1.Builder.newBuilder()
                .withBancoCheque(bancoDelCheque)
                .withNroCheque(numeroDelCheque)
                .withFechaVencimiento(fechaDeVencimiento)
                .withCuitFirmante(cuitDelFirmante)
                .withCheque(tipo)
                .withImporteTotal(importe)
                .withId(operacionOriginal.getId())
                .build();


        chequeModificado.modificarEstado("Ingresado");

        lineaDeCredito.removeOperacion(operacionOriginal);
        lineaDeCredito.agregarOperacion(chequeModificado);

        log(operacionOriginal, chequeModificado, referencia, usuario);

        return chequeModificado.getId();

    }

    public static String modificarOperacionCCC(
            final Integer cuit,
            final String empresaCC,
            final Date fechaVencimiento,
            final String tipoParametro,
            final Float importe,
            final String id,
            final String referencia,
            final String usuario
    ) {

        CtaCorriente cuentaCr = null;

        if (tipoParametro == "TarjetaDeCredito") {
            cuentaCr = CtaCorriente.TarjetaDeCredito;
        } else if (tipoParametro == "CuentaCorrienteComercial") {
            cuentaCr = CtaCorriente.CuentaCorrienteComercial;
        }


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

        Operacion operacionOriginal = (Operacion) lineaDeCredito.getOperaciones().stream().filter(x -> x.getId().equals(id));

        if (operacionOriginal == null) {
            throw new RuntimeException("No existe una operacion con el ID solicitado");
        }

        Tipo2 cuentaModificada = Tipo2.Builder.newBuilder()
                .withEmpresaCC(empresaCC)
                .withFechaVencimiento(fechaVencimiento)
                .withCuenta(cuentaCr)
                .withImporteTotal(importe)
                .withId(id)
                .build();

        cuentaModificada.modificarEstado("Ingresado");
        lineaDeCredito.removeOperacion(operacionOriginal);
        lineaDeCredito.agregarOperacion(cuentaModificada);

        log(operacionOriginal, cuentaModificada, referencia, usuario);


        return cuentaModificada.getId();

    }

    public static String modificarOperacionPrestamo(
            final Integer cuit,
            final String bancoPrestamo,
            final Float importeTotal,
            final Float tasa,
            final Date fechaAcreditacion,
            final Integer cantidadCuotas,
            final String sistema,
            final String id,
            final String referencia,
            final String usuario

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

        Operacion operacionOriginal = (Operacion) lineaDeCredito.getOperaciones().stream().filter(x -> x.getId().equals(id));

        if (operacionOriginal == null) {
            throw new RuntimeException("No existe una operacion con el ID solicitado");
        }

        Tipo3 prestamoModificado = Tipo3.Builder.newBuilder()
                .withBancoPrestamo(bancoPrestamo)
                .withImporteTotal(importeTotal)
                .withTasa(tasa)
                .withFechaAcreditacion(fechaAcreditacion)
                .withCantidadCuotas(cantidadCuotas)
                .withSistema(sistema)
                .withId(id)
                .build();

        prestamoModificado.modificarEstado("Ingresado");
        lineaDeCredito.removeOperacion(operacionOriginal);
        lineaDeCredito.agregarOperacion(prestamoModificado);

        log(operacionOriginal, prestamoModificado, referencia, usuario);
        return prestamoModificado.getId();

    }

    public static void modificarDocumento(
            final Integer cuit,
            final String tipo,
            final String estado,
            final String usuario,
            final String referencia
    ) {

        Empresa empresa = buscarEmpresa(cuit);

        Documento documentoOriginal = empresa.getDocumento();


        Documento documentoModificado = Documento.Builder.newBuilder()
                .withTipo(tipo)
                .withEstado(estado)
                .withFechaDeRecepcion(documentoOriginal.getFechaDeRecepcion())
                .withUsuario(usuario)
                .build();

        empresa.addDocumento(documentoModificado);
        log(documentoOriginal, documentoModificado, referencia, usuario);


    }


}