package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

public class SocioProtector extends Empresa {

    private Boolean postulante;
    private Boolean estadoDoc;
    private Integer accionesB;
    private List<AporteDeCapital> cantidadAporteCapital;

    private SocioProtector() {
        super();
    }

    public Boolean getPostulante() {
        return postulante;
    }

    public Boolean getEstadoDoc() {
        return estadoDoc;
    }

    public Integer getAccionesB() {
        return accionesB;
    }

    public List<AporteDeCapital> getCantidadAporteCapital() {
        return cantidadAporteCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SocioProtector that = (SocioProtector) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getPostulante(), that.getPostulante())
                .append(getEstadoDoc(), that.getEstadoDoc())
                .append(getAccionesB(), that.getAccionesB())
                .append(getCantidadAporteCapital(), that.getCantidadAporteCapital())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getPostulante())
                .append(getEstadoDoc())
                .append(getAccionesB())
                .append(getCantidadAporteCapital())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("postulante", postulante)
                .append("estadoDoc", estadoDoc)
                .append("accionesB", accionesB)
                .append("cantidadAporteCapital", cantidadAporteCapital)
                .append("cuit", cuit)
                .append("razonSocial", razonSocial)
                .append("fechaInicio", fechaInicio)
                .append("tipo", tipo)
                .append("actividadPrincipal", actividadPrincipal)
                .append("direccion", direccion)
                .append("telefono", telefono)
                .append("correoElectronico", correoElectronico)
                .toString();
    }

    public static final class Builder {
        private Boolean postulante;
        private Boolean estadoDoc;
        private Integer accionesB;
        private List<AporteDeCapital> cantidadAporteCapital;
        private Integer cuit;
        private String razonSocial;
        private Date fechaInicio;
        private String tipo;
        private String actividadPrincipal;
        private String direccion;
        private Integer telefono;
        private String correoElectronico;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withPostulante(Boolean postulante) {
            this.postulante = postulante;
            return this;
        }

        public Builder withFechaInicio(Date fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder withEstadoDoc(Boolean estadoDoc) {
            this.estadoDoc = estadoDoc;
            return this;
        }

        public Builder withAccionesB(Integer accionesB) {
            this.accionesB = accionesB;
            return this;
        }

        public Builder withCantidadAporteCapital(List<AporteDeCapital> cantidadAporteCapital) {
            this.cantidadAporteCapital = cantidadAporteCapital;
            return this;
        }

        public Builder withCuit(Integer cuit) {
            this.cuit = cuit;
            return this;
        }

        public Builder withRazonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
            return this;
        }

        public Builder withTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder withActividadPrincipal(String actividadPrincipal) {
            this.actividadPrincipal = actividadPrincipal;
            return this;
        }

        public Builder withDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder withTelefono(Integer telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder withCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return this;
        }

        public Empresa build() {
            SocioProtector empresa = new SocioProtector();
            empresa.cuit = cuit;
            empresa.razonSocial = razonSocial;
            empresa.fechaInicio = fechaInicio;
            empresa.tipo = tipo;
            empresa.actividadPrincipal = actividadPrincipal;
            empresa.direccion = direccion;
            empresa.telefono = telefono;
            empresa.correoElectronico = correoElectronico;
            empresa.postulante = postulante;
            empresa.estadoDoc = estadoDoc;
            empresa.accionesB = accionesB;
            empresa.cantidadAporteCapital = cantidadAporteCapital;
            return empresa;
        }
    }

}
