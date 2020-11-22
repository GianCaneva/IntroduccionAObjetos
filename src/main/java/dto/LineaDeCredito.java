package dto;

import dto.Operacion.Factura;
import dto.Operacion.Operacion;
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
    private List<Operacion> operaciones;
    private List<Factura> facturaList;
    private Desembolso desembolso;

    private LineaDeCredito() {
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

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

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public Desembolso getDesembolso() {
        return desembolso;
    }

    public void agregarOperacion(final Operacion operacion) {
        operaciones.add(operacion);
    }
    public void removeOperacion(final Operacion operacion) {
        operaciones.remove(operacion);
    }

    public void agregarFactura(final Float monto, final String name) {
        Factura factura = Factura.Builder.newBuilder().withMonto(monto).withNombreDeSocio(name).build();
        facturaList.add(factura);
    }

    public void agregarDesembolso(final Float monto, final Float mora, final String tipo) {
        this.desembolso = Desembolso.Builder.newBuilder()
                .withMonto(monto)
                .withMora(mora)
                .withTipo(tipo)
                .build();
    }

    public void eliminarDesembolso() {
        this.desembolso = null;
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
                .append(getOperaciones(), that.getOperaciones())
                .append(getFacturaList(), that.getFacturaList())
                .append(getDesembolso(), that.getDesembolso())
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
                .append(getOperaciones())
                .append(getFacturaList())
                .append(getDesembolso())
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
                .append("operaciones", operaciones)
                .append("facturaList", facturaList)
                .append("desembolso", desembolso)
                .toString();
    }

    public static final class Builder {
        private Float monto;
        private Date fechaVigencia;
        private Integer nroLineaCredito;
        private Boolean estado;
        private List<Enum> tipoOperaciones;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withMonto(Float monto) {
            this.monto = monto;
            return this;
        }

        public Builder withFechaVigencia(Date fechaVigencia) {
            this.fechaVigencia = fechaVigencia;
            return this;
        }

        public Builder withNroLineaCredito(Integer nroLineaCredito) {
            this.nroLineaCredito = nroLineaCredito;
            return this;
        }

        public Builder withEstado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        public Builder withTipoOperaciones(List<Enum> tipoOperaciones) {
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
