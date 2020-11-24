package dto.Empresa;

import dto.Documento;
import dto.ParticipacionSGR;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Empresa {

    protected Integer cuit;
    protected String razonSocial;
    protected Date fechaInicio;
    protected String tipo;
    protected String actividadPrincipal;
    protected String direccion;
    protected Integer telefono;
    protected String correoElectronico;
    protected List<Accionista> accionista = new ArrayList<>();
    protected Documento documento;
    protected ParticipacionSGR participacionSGR;
    protected Boolean postulante = true;


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

    public Boolean getPostulante() {
        return postulante;
    }

    public void addDocumento(final Documento documento) {
        this.documento = documento;
    }

    public void aprobarDocumento() {
        documento.aprobarDocumento();
    }

    public void suscribirAcciones(final Integer cuitVendedor, final float porcentaje, final float precioUnitario) {
        if (!documento.getAprobado()) {
            throw new RuntimeException("Documentacion pendiente de aproabacion");
        }

        this.participacionSGR = ParticipacionSGR.Builder.newBuilder()
                .withVendedor(cuitVendedor)
                .withPorcentaje(porcentaje)
                .withPrecioUnidad(precioUnitario)
                .withFecha(Utils.getDate())
                .build();

        postulante = false;

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
                .append(getAccionista(), empresa.getAccionista())
                .append(getDocumento(), empresa.getDocumento())
                .append(getParticipacionSGR(), empresa.getParticipacionSGR())
                .append(getPostulante(), empresa.getPostulante())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCuit())
                .append(getRazonSocial())
                .append(getFechaInicio())
                .append(getTipo())
                .append(getActividadPrincipal())
                .append(getDireccion())
                .append(getTelefono())
                .append(getCorreoElectronico())
                .append(getAccionista())
                .append(getDocumento())
                .append(getParticipacionSGR())
                .append(getPostulante())
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
                .append("postulante", postulante)
                .toString();
    }

    public void agregarAccionista(final Accionista newAccionista) {
        List<Integer> cuitDeAccionistas =  accionista.stream().map(Accionista::getCuit).collect(Collectors.toList());

        if (cuitDeAccionistas.contains(newAccionista.getCuit())) {
            throw new RuntimeException("El accionista ya se encuentra registrado");
        }

        accionista.add(newAccionista);
    }

    public void eliminarAccionista(final Integer cuitDeAccionista) {
        boolean eliminado = false;

        for (int i = 0; i < accionista.size(); i++) {
            Accionista accionistaActual = this.accionista.get(i);
            if (accionistaActual.getCuit() == cuitDeAccionista) {
                accionista.remove(accionistaActual);
                eliminado = true;
            }
        }

        if (eliminado == false) {
            throw new RuntimeException("No existe un accionista con el cuit solicitado");
        }

    }
}
