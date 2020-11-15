package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class contragarantia {
    public static final String _TIPO = "tipo";
    public static final String _IMPORTE_ASEGURADO = "importeAsegurado";
    private String tipo;
    private Integer importeAsegurado;

    public contragarantia() {
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

        contragarantia that = (contragarantia) o;

        return new EqualsBuilder()
                .append(getTipo(), that.getTipo())
                .append(getImporteAsegurado(), that.getImporteAsegurado())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
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

        public static contragarantia.Builder newBuilder() {
            return new contragarantia.Builder();
        }

        public contragarantia.Builder withTipo(String tipo){
            this.tipo = tipo;
            return this;
        }

        public contragarantia.Builder withImporteAsegurado(Integer importeAsegurado){
            this.importeAsegurado = importeAsegurado;
            return this;
        }

        public contragarantia build() {
            contragarantia Contragarantias = new contragarantia();
            Contragarantias.tipo = this.tipo;
            Contragarantias.importeAsegurado = this.importeAsegurado;
            return Contragarantias;
        }
    }
}
