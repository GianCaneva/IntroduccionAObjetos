package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class accionistas {
    public static final String _CUIT = "cuit";
    public static final String _RAZON_SOCIAL = "razonSocial";
    public static final String _PARTICIPACION = "participacion";
    private Integer cuit;
    private String razonSocial;
    private Float participacion;

    private accionistas() {
    }

    public Integer getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Float getParticipacion() {
        return participacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        accionistas that = (accionistas) o;

        return new EqualsBuilder()
                .append(getCuit(), that.getCuit())
                .append(getRazonSocial(), that.getRazonSocial())
                .append(getParticipacion(), that.getParticipacion())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCuit())
                .append(getRazonSocial())
                .append(getParticipacion())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cuit", cuit)
                .append("razonSocial", razonSocial)
                .append("participacion", participacion)
                .toString();
    }

    public static final class Builder {
        private Integer cuit;
        private String razonSocial;
        private Float participacion;

        private Builder() {}

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withCuit(Integer cuit){
            this.cuit = cuit;
            return this;
        }

        public Builder withRazonSocial(String razonSocial){
            this.razonSocial = razonSocial;
            return this;
        }

        public Builder withParticipacion(Float participacion){
            this.participacion = participacion;
            return this;
        }

        public accionistas build() {
            accionistas Accionistas = new accionistas();
            Accionistas.cuit = this.cuit;
            Accionistas.razonSocial = this.razonSocial;
            Accionistas.participacion = this.participacion;
            return Accionistas;
        }
    }
}
