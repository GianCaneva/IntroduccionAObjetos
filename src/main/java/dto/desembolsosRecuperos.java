package dto;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class desembolsosRecuperos {
    public static final String _NRO_LINEA_CREDITO = "nroLineaCredito";
    public static final String _MONTO = "monto";
    public static final String _MORA = "mora";
    public static final String _TIPO = "tipo";

    private Integer nroLineaCredito;
    private Integer monto;
    private Integer mora;
    private String tipo;

    public desembolsosRecuperos() {
    }

    public Integer getNroLineaCredito() {
        return nroLineaCredito;
    }

    public Integer getMonto() {
        return monto;
    }

    public Integer getMora() {
        return mora;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        desembolsosRecuperos that = (desembolsosRecuperos) o;

        return new EqualsBuilder()
                .append(getNroLineaCredito(), that.getNroLineaCredito())
                .append(getMonto(), that.getMonto())
                .append(getMora(), that.getMora())
                .append(getTipo(), that.getTipo())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
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
        private Integer nroLineaCredito;
        private Integer monto;
        private Integer mora;
        private String tipo;

        private Builder(){

        }
        public static desembolsosRecuperos.Builder newBuilder() {
            return new desembolsosRecuperos.Builder();
        }

        public desembolsosRecuperos.Builder withNroLineaCredito(Integer nroLineaCredito){
            this.nroLineaCredito = nroLineaCredito;
            return this;
        }

        public desembolsosRecuperos.Builder withMonto(Integer monto){
            this.monto = monto;
            return this;
        }

        public desembolsosRecuperos.Builder withMora(Integer mora){
            this.mora = mora;
            return this;
        }

        public desembolsosRecuperos.Builder withTipo(String tipo){
            this.tipo = tipo;
            return this;
        }

        public desembolsosRecuperos build() {
            desembolsosRecuperos desembolsosRecuperos = new desembolsosRecuperos();
            desembolsosRecuperos.nroLineaCredito = this.nroLineaCredito;
            desembolsosRecuperos.monto = this.monto;
            desembolsosRecuperos.mora = this.mora;
            desembolsosRecuperos.tipo = this.tipo;
            return desembolsosRecuperos;
        }
    }
}
