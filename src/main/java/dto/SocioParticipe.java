package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class SocioParticipe extends Empresa {

    private Integer idSocio;
    private Boolean postulante;
    private String estatuto;
    private Integer balances;
    private String manifestacionesBienes;
    private Date fechaRecepcion;
    private Boolean estadoDoc;
    private Integer accionesA;

    private SocioParticipe() {
        super();
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public Boolean getPostulante() {
        return postulante;
    }

    public String getEstatuto() {
        return estatuto;
    }

    public Integer getBalances() {
        return balances;
    }

    public String getManifestacionesBienes() {
        return manifestacionesBienes;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public Boolean getEstadoDoc() {
        return estadoDoc;
    }

    public Integer getAccionesA() {
        return accionesA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SocioParticipe that = (SocioParticipe) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getIdSocio(), that.getIdSocio())
                .append(getPostulante(), that.getPostulante())
                .append(getEstatuto(), that.getEstatuto())
                .append(getBalances(), that.getBalances())
                .append(getManifestacionesBienes(), that.getManifestacionesBienes())
                .append(getFechaRecepcion(), that.getFechaRecepcion())
                .append(getEstadoDoc(), that.getEstadoDoc())
                .append(getAccionesA(), that.getAccionesA())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getIdSocio())
                .append(getPostulante())
                .append(getEstatuto())
                .append(getBalances())
                .append(getManifestacionesBienes())
                .append(getFechaRecepcion())
                .append(getEstadoDoc())
                .append(getAccionesA())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idSocio", idSocio)
                .append("postulante", postulante)
                .append("estatuto", estatuto)
                .append("balances", balances)
                .append("manifestacionesBienes", manifestacionesBienes)
                .append("fechaRecepcion", fechaRecepcion)
                .append("estadoDoc", estadoDoc)
                .append("accionesA", accionesA)
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
        private Integer idSocio;
        private Boolean postulante;
        private String estatuto;
        private Integer balances;
        private String manifestacionesBienes;
        private Date fechaRecepcion;
        private Boolean estadoDoc;
        private Integer accionesA;

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

        public Builder withIdSocio(Integer idSocio) {
            this.idSocio = idSocio;
            return this;
        }

        public Builder withPostulante(Boolean postulante) {
            this.postulante = postulante;
            return this;
        }

        public Builder withEstatuto(String estatuto) {
            this.estatuto = estatuto;
            return this;
        }

        public Builder withBalances(Integer balances) {
            this.balances = balances;
            return this;
        }

        public Builder withManifestacionesBienes(String manifestacionesBienes) {
            this.manifestacionesBienes = manifestacionesBienes;
            return this;
        }

        public Builder withFechaRecepcion(Date fechaRecepcion) {
            this.fechaRecepcion = fechaRecepcion;
            return this;
        }

        public Builder withEstadoDoc(Boolean estadoDoc) {
            this.estadoDoc = estadoDoc;
            return this;
        }

        public Builder withAccionesA(Integer accionesA) {
            this.accionesA = accionesA;
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

        public Builder withFechaInicio(Date fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }


        public Empresa build() {
            SocioParticipe empresa = new SocioParticipe();
            empresa.cuit = cuit;
            empresa.razonSocial = razonSocial;
            empresa.fechaInicio = fechaInicio;
            empresa.tipo = tipo;
            empresa.actividadPrincipal = actividadPrincipal;
            empresa.direccion = direccion;
            empresa.telefono = telefono;
            empresa.correoElectronico = correoElectronico;
            empresa.idSocio = idSocio;
            empresa.postulante = postulante;
            empresa.estatuto = estatuto;
            empresa.balances = balances;
            empresa.manifestacionesBienes = manifestacionesBienes;
            empresa.fechaRecepcion = fechaRecepcion;
            empresa.estadoDoc = estadoDoc;
            empresa.accionesA = accionesA;
            return empresa;
        }
    }

}
