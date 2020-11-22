package dto.Operacion;

import dto.Enumeration.CtaCorriente;
import utils.Utils;

import java.util.Date;
import java.util.UUID;

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
        protected Comision comisiones;
        protected Float importeTotal;
        private String empresaCC;
        private Date fechaVencimiento;
        private CtaCorriente cuenta;
        protected String id = null;


        private Builder() {
        }

        public static Builder newBuilder() {
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

        public Tipo2 build() {
            Tipo2 tipo2 = new Tipo2();
            tipo2.importeTotal = this.importeTotal;
            tipo2.empresaCC = this.empresaCC;
            tipo2.comision = this.comisiones;
            tipo2.fechaVencimiento = this.fechaVencimiento;
            tipo2.cuenta = this.cuenta;
            tipo2.fecha = Utils.getDate();
            if (id == null) {
                tipo2.id = UUID.randomUUID().toString();
            }else{
                tipo2.id=id;
            }
            return tipo2;
        }
    }
}
