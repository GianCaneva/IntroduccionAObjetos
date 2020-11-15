package dto.Operacion;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Comision {

    private Integer tipoOperacion;
    private Float porcentaje;
    private String estado;

    public Integer getTipoOperacion() {
        return tipoOperacion;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Comision comision = (Comision) o;

        return new EqualsBuilder()
                .append(getTipoOperacion(), comision.getTipoOperacion())
                .append(getPorcentaje(), comision.getPorcentaje())
                .append(getEstado(), comision.getEstado())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getTipoOperacion())
                .append(getPorcentaje())
                .append(getEstado())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tipoOperacion", tipoOperacion)
                .append("porcentaje", porcentaje)
                .append("estado", estado)
                .toString();
    }


    public static final class Builder {
        private Integer tipoOperacion;
        private Float porcentaje;
        private String estado;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withTipoOperacion(Integer tipoOperacion) {
            this.tipoOperacion = tipoOperacion;
            return this;
        }

        public Builder withPorcentaje(Float porcentaje) {
            this.porcentaje = porcentaje;
            return this;
        }

        public Builder withEstado(final String estado) {
            this.estado = estado;
            return this;
        }

        public Comision build() {
            Comision comision = new Comision();
            comision.estado = this.estado;
            comision.porcentaje = this.porcentaje;
            comision.tipoOperacion = this.tipoOperacion;
            return comision;
        }
    }
}
