package dto;

import java.util.Date;

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



    public static final class Builder {
        protected Integer comisiones;
        protected Integer importeTotal;
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

        public Builder withComisiones(Integer comisiones) {
            this.comisiones = comisiones;
            return this;
        }

        public Builder withImporteTotal(Integer impporteTotal) {
            this.importeTotal = impporteTotal;
            return this;
        }

        public Tipo1 build() {
            Tipo1 tipo1 = new Tipo1();
            tipo1.nroCheque = this.nroCheque;
            tipo1.fechaVencimiento = this.fechaVencimiento;
            tipo1.cheque = this.cheque;
            tipo1.bancoCheque = this.bancoCheque;
            tipo1.cuitFirmante = this.cuitFirmante;
            tipo1.comisiones = this.comisiones;
            tipo1.importeTotal = this.importeTotal;
            tipo1.tasaDescuento = this.tasaDescuento;
            return tipo1;
        }
    }
}
