package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class participacionSGR {
    public static final String _PORCENTAJE = "porcentaje";
    public static final String _COMPRADOR = "comprador";
    public static final String _FECHA = "fecha";
    public static final String _PRECIO_UNIDAD = "precioUnidad";
    private Float porcentaje;
    private String comprador;
    private Date fecha;
    private Float precioUnidad;

    public participacionSGR() {
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public String getComprador() {
        return comprador;
    }

    public Date getFecha() {
        return fecha;
    }

    public Float getPrecioUnidad() {
        return precioUnidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        participacionSGR that = (participacionSGR) o;

        return new EqualsBuilder()
                .append(getPorcentaje(), that.getPorcentaje())
                .append(getComprador(), that.getComprador())
                .append(getFecha(), that.getFecha())
                .append(getPrecioUnidad(), that.getPrecioUnidad())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPorcentaje())
                .append(getComprador())
                .append(getFecha())
                .append(getPrecioUnidad())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("porcentaje", porcentaje)
                .append("comprador", comprador)
                .append("fecha", fecha)
                .append("precioUnidad", precioUnidad)
                .toString();
    }

    public static final class Builder {
        private Float porcentaje;
        private String comprador;
        private Date fecha;
        private Float precioUnidad;

        private Builder() {}

        public static participacionSGR.Builder newBuilder() {
            return new participacionSGR.Builder();
        }

        public participacionSGR.Builder withPorcentaje(Float porcentaje){
            this.porcentaje = porcentaje;
            return this;
        }

        public participacionSGR.Builder withComprador(String comprador){
            this.comprador = comprador;
            return this;
        }

        public participacionSGR.Builder withFecha(Date fecha){
            this.fecha = fecha;
            return this;
        }

        public participacionSGR.Builder withPrecioUnidad(Float precioUnidad){
            this.precioUnidad = precioUnidad;
            return this;
        }
        public participacionSGR build() {
            participacionSGR ParticipacionSGR = new participacionSGR();
            ParticipacionSGR.porcentaje = this.porcentaje;
            ParticipacionSGR.comprador = this.comprador;
            ParticipacionSGR.fecha = this.fecha;
            ParticipacionSGR.precioUnidad = this.precioUnidad;
            return ParticipacionSGR;
        }
    }
}
