package dto.Empresa;

import dto.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

public class SocioParticipe extends Empresa {

    private Integer idSocio;
    private Integer accionesA;
    private LineaDeCredito lineaDeCredito;

    public Integer getIdSocio() {
        return idSocio;
    }

    public Integer getAccionesA() {
        return accionesA;
    }

    public LineaDeCredito getLineaDeCredito() {
        return lineaDeCredito;
    }

    public void asignarLineaDeCredito(final Float monto, final Date date, final List<Enum> operaciones) {
        if (postulante) {
            throw new RuntimeException("El socio no se encuentra habilitado para operar");
        }
        lineaDeCredito = LineaDeCredito.Builder.newBuilder()
                .withMonto(monto)
                .withFechaVigencia(date)
                .withEstado(true)
                .withTipoOperaciones(operaciones)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SocioParticipe that = (SocioParticipe) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getIdSocio(), that.getIdSocio())
                .append(getAccionesA(), that.getAccionesA())
                .append(getLineaDeCredito(), that.getLineaDeCredito())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getIdSocio())
                .append(getAccionesA())
                .append(getLineaDeCredito())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idSocio", idSocio)
                .append("accionesA", accionesA)
                .append("lineaDeCredito", lineaDeCredito)
                .toString();
    }

    public static final class Builder {
        private static Integer cuit;
        private static String razonSocial;
        private static Date fechaInicio;
        private static String tipo;
        private static String actividadPrincipal;
        private static String direccion;
        private static Integer telefono;
        private static String correoElectronico;
        private static List<Accionista> accionista;
        private static Documento documento;
        private static ParticipacionSGR participacionSGR;
        private static Boolean postulante;

        private static Integer idSocio;
        private static Integer accionesA;
        private static LineaDeCredito lineaDeCredito;


        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withCuit(final Integer cuit) {
            this.cuit = cuit;
            return this;
        }

        public Builder withRazonSocial(final String razonSocial) {
            this.razonSocial = razonSocial;
            return this;
        }

        public Builder withFechaInicio(final Date fechaInicio) {
            this.fechaInicio = fechaInicio;
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

        public Builder withAccionista(final List<Accionista> accionista) {
            this.accionista = accionista;
            return this;
        }

        public Builder withDocumento(final Documento documento) {
            this.documento = documento;
            return this;
        }

        public Builder withParticipacionSGR(final ParticipacionSGR participacionSGR) {
            this.participacionSGR = participacionSGR;
            return this;
        }

        public Builder withPostulante(final Boolean postulante) {
            this.postulante = postulante;
            return this;
        }

        ////////////////////////////////////////////////////////

        public Builder withIdSocio(final Integer idSocio) {
            this.idSocio = idSocio;
            return this;
        }

        public Builder withAccionesA(final Integer accionesA) {
            this.accionesA = accionesA;
            return this;
        }

        public Builder withLineaDeCredito(final LineaDeCredito lineaDeCredito) {
            this.lineaDeCredito = lineaDeCredito;
            return this;
        }


        public Builder from(final SocioParticipe socioParticipe) {

            cuit = socioParticipe.getCuit();
            razonSocial = socioParticipe.getRazonSocial();
            fechaInicio = socioParticipe.getFechaInicio();
            tipo = socioParticipe.getTipo();
            actividadPrincipal = socioParticipe.getActividadPrincipal();
            direccion = socioParticipe.getDireccion();
            telefono = socioParticipe.getTelefono();
            correoElectronico = socioParticipe.getCorreoElectronico();
            accionista = socioParticipe.getAccionista();
            documento = socioParticipe.getDocumento();
            participacionSGR = socioParticipe.getParticipacionSGR();
            postulante = socioParticipe.getPostulante();

            idSocio = socioParticipe.getIdSocio();
            accionesA = socioParticipe.getAccionesA();
            lineaDeCredito = socioParticipe.getLineaDeCredito();

            return this;
        }


        public Empresa build() {
            SocioParticipe socioParticipe = new SocioParticipe();

            socioParticipe.cuit = cuit;
            socioParticipe.razonSocial = razonSocial;
            socioParticipe.fechaInicio = fechaInicio;
            socioParticipe.tipo = tipo;
            socioParticipe.actividadPrincipal = actividadPrincipal;
            socioParticipe.direccion = direccion;
            socioParticipe.telefono = telefono;
            socioParticipe.correoElectronico = correoElectronico;
            socioParticipe.accionista = accionista;
            socioParticipe.documento = documento;
            socioParticipe.participacionSGR = participacionSGR;
            socioParticipe.postulante = postulante;

            socioParticipe.idSocio = idSocio;
            socioParticipe.accionesA = accionesA;
            socioParticipe.lineaDeCredito = lineaDeCredito;

            return socioParticipe;
        }
    }
}
