package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class lineasDeCredito {

    public static final String _MONTO = "monto";
    public static final String _FECHA_VIGENCIA = "fechaVigencia";
    public static final String _NRO_LINEA_CREDITO = "nroLineaCredito";
    public static final String _ESTADO = "estado";
    private Integer monto;
    private Date fechaVigencia;
    private Integer nroLineaCredito;
    private Boolean estado;

    private lineasDeCredito() {}

    public Integer getMonto() {
        return monto;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public Integer getNroLineaCredito() {
        return nroLineaCredito;
    }

    public Boolean getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        lineasDeCredito that = (lineasDeCredito) o;

        return new EqualsBuilder()
                .append(getMonto(), that.getMonto())
                .append(getFechaVigencia(), that.getFechaVigencia())
                .append(getNroLineaCredito(), that.getNroLineaCredito())
                .append(getEstado(), that.getEstado())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getMonto())
                .append(getFechaVigencia())
                .append(getNroLineaCredito())
                .append(getEstado())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("monto", monto)
                .append("fechaVigencia", fechaVigencia)
                .append("nroLineaCredito", nroLineaCredito)
                .append("estado", estado)
                .toString();
    }

    public static final class Builder {
        private Integer monto;
        private Date fechaVigencia;
        private Integer nroLineaCredito;
        private Boolean estado;

        private Builder() {}

        public static lineasDeCredito.Builder newBuilder() {
            return new lineasDeCredito.Builder();
        }

        public lineasDeCredito.Builder withMonto(Integer monto){
            this.monto = monto;
            return this;
        }

        public lineasDeCredito.Builder withFechaVigencia(Date fechaVigencia){
            this.fechaVigencia = fechaVigencia;
            return this;
        }

        public lineasDeCredito.Builder withNroLineaCredito(Integer nroLineaCredito){
            this.nroLineaCredito = nroLineaCredito;
            return this;
        }

        public lineasDeCredito.Builder withEstado(Boolean estado){
            this.estado = estado;
            return this;
        }

        public lineasDeCredito build() {
            lineasDeCredito LineasDeCredito = new lineasDeCredito();
            LineasDeCredito.monto = this.monto;
            LineasDeCredito.fechaVigencia = this.fechaVigencia;
            LineasDeCredito.nroLineaCredito = this.nroLineaCredito;
            LineasDeCredito.estado = this.estado;
            return LineasDeCredito;
        }
    }
}
