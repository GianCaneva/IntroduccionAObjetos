package dto.Empresa;

import dto.Accionista;
import dto.Documento;
import dto.ParticipacionSGR;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

public abstract class Empresa {

    protected Integer cuit;
    protected String razonSocial;
    protected Date fechaInicio;
    protected String tipo;
    protected String actividadPrincipal;
    protected String direccion;
    protected Integer telefono;
    protected String correoElectronico;
    protected List<Accionista> accionista;
    protected Documento documento;
    protected ParticipacionSGR participacionSGR;

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

    public List<Accionista> getAccionista() {
        return accionista;
    }

    public Documento getDocumento() {
        return documento;
    }

    public ParticipacionSGR getParticipacionSGR() {
        return participacionSGR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return new EqualsBuilder()
                .append(cuit, empresa.cuit)
                .append(razonSocial, empresa.razonSocial)
                .append(fechaInicio, empresa.fechaInicio)
                .append(tipo, empresa.tipo)
                .append(actividadPrincipal, empresa.actividadPrincipal)
                .append(direccion, empresa.direccion)
                .append(telefono, empresa.telefono)
                .append(correoElectronico, empresa.correoElectronico)
                .append(accionista, empresa.accionista)
                .append(documento, empresa.documento)
                .append(participacionSGR, empresa.participacionSGR)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cuit)
                .append(razonSocial)
                .append(fechaInicio)
                .append(tipo)
                .append(actividadPrincipal)
                .append(direccion)
                .append(telefono)
                .append(correoElectronico)
                .append(accionista)
                .append(documento)
                .append(participacionSGR)
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cuit", cuit)
                .append("razonSocial", razonSocial)
                .append("fechaInicio", fechaInicio)
                .append("tipo", tipo)
                .append("actividadPrincipal", actividadPrincipal)
                .append("direccion", direccion)
                .append("telefono", telefono)
                .append("correoElectronico", correoElectronico)
                .append("accionista", accionista)
                .append("documento", documento)
                .append("participacionSGR", participacionSGR)
                .toString();
    }
}
