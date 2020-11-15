package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

public class LineaDeCredito {

    private Float monto;
    private Date fechaVigencia;
    private Integer nroLineaCredito;
    private Boolean estado;
    private List<Enum> tipoOperaciones;

    private LineaDeCredito() {}

    public Float getMonto() {
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

    public List<Enum> getTipoOperaciones() {
        return tipoOperaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        LineaDeCredito that = (LineaDeCredito) o;

        return new EqualsBuilder()
                .append(getMonto(), that.getMonto())
                .append(getFechaVigencia(), that.getFechaVigencia())
                .append(getNroLineaCredito(), that.getNroLineaCredito())
                .append(getEstado(), that.getEstado())
                .append(getTipoOperaciones(), that.getTipoOperaciones())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getMonto())
                .append(getFechaVigencia())
                .append(getNroLineaCredito())
                .append(getEstado())
                .append(getTipoOperaciones())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("monto", monto)
                .append("fechaVigencia", fechaVigencia)
                .append("nroLineaCredito", nroLineaCredito)
                .append("estado", estado)
                .append("tipoOperaciones", tipoOperaciones)
                .toString();
    }

    public static final class Builder {
        private Float monto;
        private Date fechaVigencia;
        private Integer nroLineaCredito;
        private Boolean estado;
        private List<Enum> tipoOperaciones;

        private Builder() {}

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withMonto(Float monto){
            this.monto = monto;
            return this;
        }

        public Builder withFechaVigencia(Date fechaVigencia){
            this.fechaVigencia = fechaVigencia;
            return this;
        }

        public Builder withNroLineaCredito(Integer nroLineaCredito){
            this.nroLineaCredito = nroLineaCredito;
            return this;
        }

        public Builder withEstado(Boolean estado){
            this.estado = estado;
            return this;
        }

        public Builder withTipoOperaciones(List<Enum> tipoOperaciones){
            this.tipoOperaciones = tipoOperaciones;
            return this;
        }

        public LineaDeCredito build() {
            LineaDeCredito lineaDeCredito = new LineaDeCredito();
            lineaDeCredito.monto = monto;
            lineaDeCredito.fechaVigencia = fechaVigencia;
            lineaDeCredito.nroLineaCredito = nroLineaCredito;
            lineaDeCredito.estado = estado;
            lineaDeCredito.tipoOperaciones = tipoOperaciones;

            return lineaDeCredito;
        }
    }
}
