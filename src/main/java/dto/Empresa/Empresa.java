package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.Date;
import java.util.List;

public abstract class Empresa {

    public static final String _CUIT = "cuit";
    public static final String _RAZON_SOCIAL = "razonSocial";
    public static final String _FECHA_INICIO = "fechaInicio";
    public static final String _TIPO = "tipo";
    public static final String _ACTIVIDAD_PRINCIPAL = "actividadPrincipal";
    public static final String _DIRECCION = "direccion";
    public static final String _TELEFONO = "telefono";
    public static final String _CORREO_ELECTRONICO = "correoElectronico";
    protected Integer cuit;
    protected String razonSocial;
    protected Date fechaInicio;
    protected String tipo;
    protected String actividadPrincipal;
    protected String direccion;
    protected Integer telefono;
    protected String correoElectronico;

    protected Empresa() {
    }

    public Integer getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return new EqualsBuilder()
                .append(getCuit(), empresa.getCuit())
                .append(getRazonSocial(), empresa.getRazonSocial())
                .append(getFechaInicio(), empresa.getFechaInicio())
                .append(getTipo(), empresa.getTipo())
                .append(getActividadPrincipal(), empresa.getActividadPrincipal())
                .append(getDireccion(), empresa.getDireccion())
                .append(getTelefono(), empresa.getTelefono())
                .append(getCorreoElectronico(), empresa.getCorreoElectronico())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCuit())
                .append(getRazonSocial())
                .append(getFechaInicio())
                .append(getTipo())
                .append(getActividadPrincipal())
                .append(getDireccion())
                .append(getTelefono())
                .append(getCorreoElectronico())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(_CUIT, cuit)
                .append(_RAZON_SOCIAL, razonSocial)
                .append(_FECHA_INICIO, fechaInicio)
                .append(_TIPO, tipo)
                .append(_ACTIVIDAD_PRINCIPAL, actividadPrincipal)
                .append(_DIRECCION, direccion)
                .append(_TELEFONO, telefono)
                .append(_CORREO_ELECTRONICO, correoElectronico)
                .toString();
    }

}
