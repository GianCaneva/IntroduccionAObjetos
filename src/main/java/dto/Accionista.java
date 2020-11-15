package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Accionista {
    public static final String _CUIT = "cuit";
    public static final String _RAZON_SOCIAL = "razonSocial";
    public static final String _PARTICIPACION = "participacion";
    private Integer cuit;
    private String razonSocial;
    private Float participacion;

    private Accionista() {
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

        Accionista that = (Accionista) o;

        return new EqualsBuilder()
                .append(getCuit(), that.getCuit())
                .append(getRazonSocial(), that.getRazonSocial())
                .append(getParticipacion(), that.getParticipacion())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
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

        public Accionista build() {
            Accionista Accionista = new Accionista();
            Accionista.cuit = this.cuit;
            Accionista.razonSocial = this.razonSocial;
            Accionista.participacion = this.participacion;
            return Accionista;
        }
    }
}
