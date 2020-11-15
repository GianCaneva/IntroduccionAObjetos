package dto.Operacion;

import java.util.Date;

public abstract class Operacion {

    protected String id;
    protected Comision comision;
    protected Float importeTotal;
    protected CertificadoDeGarantia certificadoDeGarantia;
    protected String estado;
    protected Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public Comision getComision() {
        return comision;
    }

    public Float getImporteTotal() {
        return importeTotal;
    }

    public String getEstado() {
        return estado;
    }

    public CertificadoDeGarantia getCertificadoDeGarantia() {
        return certificadoDeGarantia;
    }

    private Integer calcularRiesgoVivo;


    public void agregarCertificadoDeGarantia(final CertificadoDeGarantia certificadoDeGarantia) {
        this.certificadoDeGarantia = certificadoDeGarantia;
    }

    public void modificarEstado(final String newEstado) {
        estado = newEstado;
    }

    public String getIdCertificado() {
        return certificadoDeGarantia.getId();
    }

    public void crearComision(final Float porcentaje, final Integer tipo) {

        estado = "Monetizado";

        comision = Comision.Builder.newBuilder()
                .withEstado("calculada")
                .withPorcentaje(porcentaje)
                .withTipoOperacion(tipo)
                .build();
    }

    public void cambiarAFacturada() {
        estado = "facturada";
    }


}
