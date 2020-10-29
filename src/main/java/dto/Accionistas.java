package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

public class Accionistas {

    public static final String _CUIT = "cuit";
    public static final String _RAZON_SOCIAL = "razonSocial";
    public static final String _PARTICIPACION = "participacion";
    private String cuit;
    private String razonSocial;
    private Float correoElectronico;

    private Accionistas() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Accionistas that = (Accionistas) o;

        return new EqualsBuilder()
                .append(cuit, that.cuit)
                .append(razonSocial, that.razonSocial)
                .append(correoElectronico, that.correoElectronico)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cuit)
                .append(razonSocial)
                .append(correoElectronico)
                .toHashCode();
    }

    public static String getCuit() {
        return _CUIT;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public static String getRazonSocial() {
        return _RAZON_SOCIAL;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Float getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(Float correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public static String getParticipacion() {
        return _PARTICIPACION;
    }
}
