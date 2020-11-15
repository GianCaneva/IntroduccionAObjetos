package dto.Operacion;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import sun.nio.ch.Util;
import utils.Utils;

import java.util.Date;
import java.util.UUID;

public class Factura {

    private String id;
    private Float monto;
    private Date fechaEmision;
    private String nombreDeSocio;
    private String estado;

    public Factura() {
    }

    public String getId() {
        return id;
    }

    public Float getMonto() {
        return monto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public String getNombreDeSocio() {
        return nombreDeSocio;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        return new EqualsBuilder()
                .append(getId(), factura.getId())
                .append(getMonto(), factura.getMonto())
                .append(getFechaEmision(), factura.getFechaEmision())
                .append(getNombreDeSocio(), factura.getNombreDeSocio())
                .append(getEstado(), factura.getEstado())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getMonto())
                .append(getFechaEmision())
                .append(getNombreDeSocio())
                .append(getEstado())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("monto", monto)
                .append("fechaEmision", fechaEmision)
                .append("nombreDeSocio", nombreDeSocio)
                .append("estado", estado)
                .toString();
    }

    public static final class Builder {
        private Float monto;
        private String nombreDeSocio;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withMonto(Float monto) {
            this.monto = monto;
            return this;
        }

        public Builder withNombreDeSocio(String nombreDeSocio) {
            this.nombreDeSocio = nombreDeSocio;
            return this;
        }

        public Factura build() {
            Factura factura = new Factura();
            factura.nombreDeSocio = this.nombreDeSocio;
            factura.monto = this.monto;
            factura.id = UUID.randomUUID().toString();
            factura.fechaEmision = Utils.getDate();
            return factura;
        }
    }
}
