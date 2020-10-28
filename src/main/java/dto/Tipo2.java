package dto;

import java.util.Date;

public class Tipo2 extends Operacion {

    private String empresaCC;
    private Date fechaVencimiento;
    private CtaCorriente cuenta;

    public Tipo2() {
    }

    public String getEmpresaCC() {
        return empresaCC;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public CtaCorriente getCuenta() {
        return cuenta;
    }


    public static final class Builder {
        protected Integer comisiones;
        protected Integer importeTotal;
        private String empresaCC;
        private Date fechaVencimiento;
        private CtaCorriente cuenta;

        private Builder() {
        }

        public static Builder aTipo2() {
            return new Builder();
        }

        public Builder withEmpresaCC(String empresaCC) {
            this.empresaCC = empresaCC;
            return this;
        }

        public Builder withFechaVencimiento(Date fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
            return this;
        }

        public Builder withCuenta(CtaCorriente cuenta) {
            this.cuenta = cuenta;
            return this;
        }

        public Builder withComisiones(Integer comisiones) {
            this.comisiones = comisiones;
            return this;
        }

        public Builder withImporteTotal(Integer importeTotal) {
            this.importeTotal = importeTotal;
            return this;
        }

        public Tipo2 build() {
            Tipo2 tipo2 = new Tipo2();
            tipo2.importeTotal = this.importeTotal;
            tipo2.empresaCC = this.empresaCC;
            tipo2.comisiones = this.comisiones;
            tipo2.fechaVencimiento = this.fechaVencimiento;
            tipo2.cuenta = this.cuenta;
            return tipo2;
        }
    }
}
