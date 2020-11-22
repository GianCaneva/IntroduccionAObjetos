package dto.Operacion;

import dto.Enumeration.TipoCheque;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import utils.Utils;

import java.util.Date;
import java.util.UUID;

public class Tipo1 extends Operacion {

    private Integer nroCheque;
    private String bancoCheque;
    private Date fechaVencimiento;
    private Integer cuitFirmante;
    private Float tasaDescuento;
    private TipoCheque cheque;

    public Tipo1() {
    }

    public Integer getNroCheque() {
        return nroCheque;
    }

    public String getBancoCheque() {
        return bancoCheque;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Integer getCuitFirmante() {
        return cuitFirmante;
    }

    public Float getTasaDescuento() {
        return tasaDescuento;
    }

    public TipoCheque getCheque() {
        return cheque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tipo1 tipo1 = (Tipo1) o;

        return new EqualsBuilder()
                .append(getNroCheque(), tipo1.getNroCheque())
                .append(getBancoCheque(), tipo1.getBancoCheque())
                .append(getFechaVencimiento(), tipo1.getFechaVencimiento())
                .append(getCuitFirmante(), tipo1.getCuitFirmante())
                .append(getTasaDescuento(), tipo1.getTasaDescuento())
                .append(getCheque(), tipo1.getCheque())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getNroCheque())
                .append(getBancoCheque())
                .append(getFechaVencimiento())
                .append(getCuitFirmante())
                .append(getTasaDescuento())
                .append(getCheque())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nroCheque", nroCheque)
                .append("bancoCheque", bancoCheque)
                .append("fechaVencimiento", fechaVencimiento)
                .append("cuitFirmante", cuitFirmante)
                .append("tasaDescuento", tasaDescuento)
                .append("cheque", cheque)
                .toString();
    }

    public static final class Builder {
        protected Comision comisiones;
        protected Float importeTotal;
        protected String id = null;

        private Integer nroCheque;
        private String bancoCheque;
        private Date fechaVencimiento;
        private Integer cuitFirmante;
        private Float tasaDescuento;
        private TipoCheque cheque;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withNroCheque(Integer nroCheque) {
            this.nroCheque = nroCheque;
            return this;
        }

        public Builder withBancoCheque(String bancoCheque) {
            this.bancoCheque = bancoCheque;
            return this;
        }

        public Builder withFechaVencimiento(Date fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
            return this;
        }

        public Builder withCuitFirmante(Integer cuitFirmante) {
            this.cuitFirmante = cuitFirmante;
            return this;
        }

        public Builder withTasaDescuento(Float tasaDescuento) {
            this.tasaDescuento = tasaDescuento;
            return this;
        }

        public Builder withCheque(TipoCheque cheque) {
            this.cheque = cheque;
            return this;
        }

        public Builder withComisiones(Comision comisiones) {
            this.comisiones = comisiones;
            return this;
        }

        public Builder withImporteTotal(Float importeTotal) {
            this.importeTotal = importeTotal;
            return this;
        }

        public Builder withId(final String id) {
            this.id = id;
            return this;
        }

        public Tipo1 build() {
            Tipo1 tipo1 = new Tipo1();
            tipo1.nroCheque = this.nroCheque;
            tipo1.fechaVencimiento = this.fechaVencimiento;
            tipo1.cheque = this.cheque;
            tipo1.bancoCheque = this.bancoCheque;
            tipo1.cuitFirmante = this.cuitFirmante;
            tipo1.comision = this.comisiones;
            tipo1.importeTotal = this.importeTotal;
            tipo1.tasaDescuento = this.tasaDescuento;
            tipo1.fecha = Utils.getDate();
            if (id == null) {
                tipo1.id = UUID.randomUUID().toString();
            }else{
                tipo1.id=id;
            }

            return tipo1;
        }
    }
}
