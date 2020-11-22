package dto.Operacion;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import utils.Utils;

import java.util.Date;
import java.util.UUID;

public class Tipo3 extends Operacion {

    private String bancoPrestamo;
    private Float importeTotal;
    private Float tasa;
    private Date fechaAcreditacion;
    private Integer cantidadCuotas;
    private Integer cantidadCuotasImpagas;
    private String sistema;

    public String getBancoPrestamo() {
        return bancoPrestamo;
    }

    public Float getPrecioDeCuota() {
        return importeTotal / cantidadCuotas;
    }

    public Integer getCantidadCuotasImpagas() {
        return cantidadCuotasImpagas;
    }

    public void pagarCuota() {
        cantidadCuotasImpagas = cantidadCuotasImpagas - 1;
    }

    @Override
    public Float getImporteTotal() {
        return importeTotal;
    }

    public Float getTasa() {
        return tasa;
    }

    public Date getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public String getSistema() {
        return sistema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tipo3 tipo3 = (Tipo3) o;

        return new EqualsBuilder()
                .append(getBancoPrestamo(), tipo3.getBancoPrestamo())
                .append(getImporteTotal(), tipo3.getImporteTotal())
                .append(getTasa(), tipo3.getTasa())
                .append(getFechaAcreditacion(), tipo3.getFechaAcreditacion())
                .append(getCantidadCuotas(), tipo3.getCantidadCuotas())
                .append(getSistema(), tipo3.getSistema())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getBancoPrestamo())
                .append(getImporteTotal())
                .append(getTasa())
                .append(getFechaAcreditacion())
                .append(getCantidadCuotas())
                .append(getSistema())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("bancoPrestamo", bancoPrestamo)
                .append("importeTotal", importeTotal)
                .append("tasa", tasa)
                .append("fechaAcreditacion", fechaAcreditacion)
                .append("cantidadCuotas", cantidadCuotas)
                .append("sistema", sistema)
                .toString();
    }


    public static final class Builder {
        private String bancoPrestamo;
        private Float importeTotal;
        private Float tasa;
        private Date fechaAcreditacion;
        private Integer cantidadCuotas;
        private String sistema;
        protected String id = null;


        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withBancoPrestamo(String bancoPrestamo) {
            this.bancoPrestamo = bancoPrestamo;
            return this;
        }

        public Builder withImporteTotal(Float importeTotal) {
            this.importeTotal = importeTotal;
            return this;
        }

        public Builder withTasa(Float tasa) {
            this.tasa = tasa;
            return this;
        }

        public Builder withFechaAcreditacion(Date fechaAcreditacion) {
            this.fechaAcreditacion = fechaAcreditacion;
            return this;
        }

        public Builder withCantidadCuotas(Integer cantidadCuotas) {
            this.cantidadCuotas = cantidadCuotas;
            return this;
        }

        public Builder withSistema(String sistema) {
            this.sistema = sistema;
            return this;
        }

        public Builder withId(final String id) {
            this.id = id;
            return this;
        }

        public Tipo3 build() {
            Tipo3 tipo3 = new Tipo3();
            tipo3.cantidadCuotas = this.cantidadCuotas;
            tipo3.fechaAcreditacion = this.fechaAcreditacion;
            tipo3.sistema = this.sistema;
            tipo3.importeTotal = this.importeTotal;
            tipo3.bancoPrestamo = this.bancoPrestamo;
            tipo3.tasa = this.tasa;
            tipo3.fecha = Utils.getDate();
            if (id == null) {
                tipo3.id = UUID.randomUUID().toString();
            }else{
                tipo3.id=id;
            }
            tipo3.cantidadCuotasImpagas = cantidadCuotas;
            return tipo3;
        }
    }
}
