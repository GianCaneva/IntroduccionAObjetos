package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class ParticipacionSGR {
    private Float porcentaje;
    private Integer vendedor;
    private Date fecha;
    private Float precioUnidad;

    public ParticipacionSGR() {
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public Integer getVendedor() {
        return vendedor;
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

        ParticipacionSGR that = (ParticipacionSGR) o;

        return new EqualsBuilder()
                .append(getPorcentaje(), that.getPorcentaje())
                .append(getVendedor(), that.getVendedor())
                .append(getFecha(), that.getFecha())
                .append(getPrecioUnidad(), that.getPrecioUnidad())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getPorcentaje())
                .append(getVendedor())
                .append(getFecha())
                .append(getPrecioUnidad())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("porcentaje", porcentaje)
                .append("vendedor", vendedor)
                .append("fecha", fecha)
                .append("precioUnidad", precioUnidad)
                .toString();
    }

    public static final class Builder {
        private Float porcentaje;
        private Integer vendedor;
        private Date fecha;
        private Float precioUnidad;

        private Builder() {
        }

        public static ParticipacionSGR.Builder newBuilder() {
            return new Builder();
        }

        public Builder withPorcentaje(final Float porcentaje) {
            this.porcentaje = porcentaje;
            return this;
        }

        public Builder withVendedor(final Integer vendedor) {
            this.vendedor = vendedor;
            return this;
        }

        public Builder withFecha(final Date fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder withPrecioUnidad(final Float precioUnidad) {
            this.precioUnidad = precioUnidad;
            return this;
        }

        public ParticipacionSGR build() {
            ParticipacionSGR participacionSGR = new ParticipacionSGR();
            porcentaje = this.porcentaje;
            vendedor = this.vendedor;
            fecha = this.fecha;
            precioUnidad = this.precioUnidad;
            return participacionSGR;
        }
    }
}
