package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

public class Desembolso {


    private String nroLineaCredito;
    private Float monto;
    private Float mora;
    private String tipo;

    public String getNroLineaCredito() {
        return nroLineaCredito;
    }

    public Float getMonto() {
        return monto;
    }

    public Float getMora() {
        return mora;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Desembolso that = (Desembolso) o;

        return new EqualsBuilder()
                .append(getNroLineaCredito(), that.getNroLineaCredito())
                .append(getMonto(), that.getMonto())
                .append(getMora(), that.getMora())
                .append(getTipo(), that.getTipo())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getNroLineaCredito())
                .append(getMonto())
                .append(getMora())
                .append(getTipo())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nroLineaCredito", nroLineaCredito)
                .append("monto", monto)
                .append("mora", mora)
                .append("tipo", tipo)
                .toString();
    }

    public static final class Builder {
        private Float monto;
        private Float mora;
        private String tipo;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withMonto(Float monto) {
            this.monto = monto;
            return this;
        }

        public Builder withMora(Float mora) {
            this.mora = mora;
            return this;
        }

        public Builder withTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Desembolso build() {
            Desembolso desembolso = new Desembolso();
            desembolso.nroLineaCredito = UUID.randomUUID().toString();
            desembolso.mora = this.mora;
            desembolso.monto = this.monto;
            desembolso.tipo = this.tipo;
            return desembolso;
        }
    }
}
