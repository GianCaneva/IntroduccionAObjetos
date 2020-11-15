package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class SocioParticipe extends Empresa {

    private Integer idSocio;
    private Boolean postulante;
    private String estatuto;
    private Integer balances;
    private String manifestacionesBienes;
    private Instant fechaRecepcion;
    private String estadoDoc;
    private Integer accionesA;
    private List<Accionista> accionista;
    private String usuarioAlta;

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

    public Instant getFechaRecepcion() {
        return fechaRecepcion;
    }

    public String getEstadoDoc() {
        return estadoDoc;
    }

    public Integer getAccionesA() {
        return accionesA;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public List<Accionista> getAccionista() {
        return accionista;
    }

    public void changeToPostulante() {
        postulante = true;
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
                .append(getAccionista(), that.getAccionista())
                .append(getUsuarioAlta(), that.getUsuarioAlta())
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
                .append(getAccionista())
                .append(getUsuarioAlta())
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
                .append("accionista", accionista)
                .append("usuarioAlta", usuarioAlta)
                .toString();
    }

    public static final class Builder {
        private static Integer idSocio;
        private static Boolean postulante;
        private static String estatuto;
        private static Integer balances;
        private static String manifestacionesBienes;
        private static Instant fechaRecepcion;
        private static String estadoDoc;
        private static Integer accionesA;
        private static String usuarioAlta;

        private static Integer cuit;
        private static String razonSocial;
        private static Date fechaInicio;
        private static String tipo;
        private static String actividadPrincipal;
        private static String direccion;
        private static Integer telefono;
        private static String correoElectronico;
        private static List<Accionista> accionista;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder from(final SocioParticipe empresa) {

            idSocio = empresa.getIdSocio();
            postulante = empresa.getPostulante();
            estatuto = empresa.getEstatuto();
            balances = empresa.getBalances();
            manifestacionesBienes = empresa.getManifestacionesBienes();
            fechaRecepcion = empresa.getFechaRecepcion();
            estadoDoc = empresa.getEstadoDoc();
            accionesA = empresa.getAccionesA();
            cuit = empresa.getCuit();
            razonSocial = empresa.getRazonSocial();
            fechaInicio = empresa.getFechaInicio();
            tipo = empresa.getTipo();
            actividadPrincipal = empresa.getActividadPrincipal();
            direccion = empresa.getDireccion();
            telefono = empresa.getTelefono();
            correoElectronico = empresa.getCorreoElectronico();
            accionista = empresa.getAccionista();
            usuarioAlta = empresa.getUsuarioAlta();

            return this;

        }

        public Builder withIdSocio(final Integer idSocio) {
            this.idSocio = idSocio;
            return this;
        }

        public Builder withAccionista(final List<Accionista> accionista) {
            this.accionista = accionista;
            return this;
        }

        public Builder withPostulante(final Boolean postulante) {
            this.postulante = postulante;
            return this;
        }

        public Builder withEstatuto(final String estatuto) {
            this.estatuto = estatuto;
            return this;
        }

        public Builder withBalances(final Integer balances) {
            this.balances = balances;
            return this;
        }

        public Builder withManifestacionesBienes(final String manifestacionesBienes) {
            this.manifestacionesBienes = manifestacionesBienes;
            return this;
        }

        public Builder withFechaRecepcion(final Instant fechaRecepcion) {
            this.fechaRecepcion = fechaRecepcion;
            return this;
        }

        public Builder withEstadoDoc(final String estadoDoc) {
            this.estadoDoc = estadoDoc;
            return this;
        }

        public Builder withAccionesA(final Integer accionesA) {
            this.accionesA = accionesA;
            return this;
        }

        public Builder withCuit(final Integer cuit) {
            this.cuit = cuit;
            return this;
        }

        public Builder withRazonSocial(final String razonSocial) {
            this.razonSocial = razonSocial;
            return this;
        }

        public Builder withTipo(final String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder withActividadPrincipal(final String actividadPrincipal) {
            this.actividadPrincipal = actividadPrincipal;
            return this;
        }

        public Builder withDireccion(final String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder withTelefono(final Integer telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder withCorreoElectronico(final String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return this;
        }

        public Builder withFechaInicio(final Date fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder withUsuarioAlta(final String usuarioAlta) {
            this.usuarioAlta = usuarioAlta;
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
            empresa.accionista = accionista;
            empresa.usuarioAlta = usuarioAlta;
            return empresa;
        }

    }

}
