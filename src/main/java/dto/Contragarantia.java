package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Contragarantia {
    public static final String _TIPO = "tipo";
    public static final String _IMPORTE_ASEGURADO = "importeAsegurado";
    private String tipo;
    private Integer importeAsegurado;

    public Contragarantia() {
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getImporteAsegurado() {
        return importeAsegurado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Contragarantia that = (Contragarantia) o;

        return new EqualsBuilder()
                .append(getTipo(), that.getTipo())
                .append(getImporteAsegurado(), that.getImporteAsegurado())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getTipo())
                .append(getImporteAsegurado())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tipo", tipo)
                .append("importeAsegurado", importeAsegurado)
                .toString();
    }

    public static final class Builder {
        private String tipo;
        private Integer importeAsegurado;

        private Builder() {}

        public static Contragarantia.Builder newBuilder() {
            return new Contragarantia.Builder();
        }

        public Contragarantia.Builder withTipo(String tipo){
            this.tipo = tipo;
            return this;
        }

        public Contragarantia.Builder withImporteAsegurado(Integer importeAsegurado){
            this.importeAsegurado = importeAsegurado;
            return this;
        }

        public Contragarantia build() {
            Contragarantia Contragarantias = new Contragarantia();
            Contragarantias.tipo = this.tipo;
            Contragarantias.importeAsegurado = this.importeAsegurado;
            return Contragarantias;
        }
    }
}
