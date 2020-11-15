package controller;

import dto.*;
import dto.Empresa.Empresa;
import dto.Empresa.SocioParticipe;
import dto.Empresa.SocioProtector;
import utils.Utils;

import java.util.Date;
import java.util.List;

public class ControladorSocio {
    private Integer idSocio = 0;

    private List<Empresa> listaEmpresas;

    private void agregarEmpresa(final Empresa empresa) {
        listaEmpresas.add(empresa);

    }

    public ControladorSocio() {
    }

    private Empresa crearEmpresa(final int cuit, final String razonSocial, final Date fechaInicio, final String tipo, final String actividadPrincipal, final String direccion, final int telefono, final String correoElectronico) {

    }

    private socioParticipe solicitarSocioParticipe(final String cuit) {

    }

    private Float operar(final Empresa empresa) {
        LineaDeCredito LineaDeCredito = empresa.getLineaDeCredito();
        if (LineaDeCredito.getFechaVigencia() > fechaDeHoy) {
            //  levantarError
        }
        if (desembolsos != 0) {
            //    levantarError
        }

    }

    private boolean habilitaOperacion() {

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
        idSocio = idSocio + 1;
    }


    private Empresa buscarEmpresa(final Integer empresaCuit) {
        Empresa empresaIndex = null;
        for (int i = 0; i < listaEmpresas.size(); i++) {
            Empresa empresa = listaEmpresas.get(i);
            if (empresa.getCuit() == empresaCuit) {
                empresaIndex = empresa;
            }
        }
        return empresaIndex;
    }

    private Integer buscarIndexEmpresa(final Integer empresaCuit) {
        Integer posicion = 0;
        for (int i = 0; i < listaEmpresas.size(); i++) {
            Empresa empresa = listaEmpresas.get(i);
            if (empresa.getCuit() == empresaCuit) {
                posicion = i;
            }
        }
        return posicion;
    }
}