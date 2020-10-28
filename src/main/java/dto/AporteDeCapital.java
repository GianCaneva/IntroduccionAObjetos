package dto;

import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class AporteDeCapital {
    public static final String _MONTO = "monto";
    public static final String _FECHA_APORTE = "fechaAporte";
    private Integer monto;
    private Date fechaAporte;

    private AporteDeCapital() {}

    public Integer getMonto() {
        return monto;
    }

    public Date getFechaAporte() {
        return fechaAporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AporteDeCapital that = (AporteDeCapital) o;

        return new EqualsBuilder()
                .append(getMonto(), that.getMonto())
                .append(getFechaAporte(), that.getFechaAporte())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getMonto())
                .append(getFechaAporte())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(_MONTO, monto)
                .append(_FECHA_APORTE, fechaAporte)
                .toString();
    }


    public static final class Builder {
        private Integer monto;
        private Date fechaAporte;

        private Builder() {}

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withMonto(Integer monto) {
            this.monto = monto;
            return this;
        }

        public Builder withFechaAporte(Date fechaAporte) {
            this.fechaAporte = fechaAporte;
            return this;
        }

        public AporteDeCapital build() {
            AporteDeCapital aporteDeCapital = new AporteDeCapital();
            aporteDeCapital.monto = this.monto;
            aporteDeCapital.fechaAporte = this.fechaAporte;
            return aporteDeCapital;
        }
    }
}
