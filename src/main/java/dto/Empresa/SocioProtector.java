package dto.Empresa;

import dto.AporteDeCapital;
import dto.Documento;
import dto.ParticipacionSGR;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocioProtector extends Empresa {

    private Integer idSocio;
    private Integer accionesB;
    private List<AporteDeCapital> cantidadAporteCapital = new ArrayList<>();
    private List<AporteDeCapital> aportesExtraidos = new ArrayList<>();
    private Float desembolso;

    private SocioProtector() {
    }

    public Integer getIdSocio() {
        return idSocio;
    }

      public Integer getAccionesB() {
        return accionesB;
    }

    public List<AporteDeCapital> getCantidadAporteCapital() {
        return cantidadAporteCapital;
    }

    public Float getDesembolso() {
        return desembolso;
    }

    public List<AporteDeCapital> getAportesExtraidos() {
        return aportesExtraidos;
    }

    public void generarAporteCapital(final Float monto) {

        if(postulante){
            throw new RuntimeException("Al momento de la fecha el socio no se encuentra habilitado para operar");
        }

        AporteDeCapital aporteDeCapital = AporteDeCapital.Builder.newBuilder()
                .withMonto(monto)
                .withFechaAporte(Utils.getDate())
                .build();
        cantidadAporteCapital.add(aporteDeCapital);
    }

    public void retirarAporteCapital(final Date fechaDeAporte) throws RuntimeException {

        if(postulante){
            throw new RuntimeException("Al momento de la fecha el socio no se encuentra habilitado para operar");
        }

        AporteDeCapital aporteDeCapital = cantidadAporteCapital.stream()
                .filter(x -> x.getFechaAporte().equals(fechaDeAporte))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe un aporte de capital realizado para tal fecha"));

        if (aporteDeCapital.getFechaAporte().getYear()+2<fechaDeAporte.getYear()){
            throw new RuntimeException("No han pasado el minimo de dos años para realizar la extraccion");
        }
        aportesExtraidos.add(aporteDeCapital);
        cantidadAporteCapital.remove(aporteDeCapital);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SocioProtector that = (SocioProtector) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getIdSocio(), that.getIdSocio())
                .append(getPostulante(), that.getPostulante())
                .append(getAccionesB(), that.getAccionesB())
                .append(getCantidadAporteCapital(), that.getCantidadAporteCapital())
                .append(getAportesExtraidos(), that.getAportesExtraidos())
                .append(getDesembolso(), that.getDesembolso())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getIdSocio())
                .append(getPostulante())
                .append(getAccionesB())
                .append(getCantidadAporteCapital())
                .append(getAportesExtraidos())
                .append(getDesembolso())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idSocio", idSocio)
                .append("postulante", postulante)
                .append("accionesB", accionesB)
                .append("cantidadAporteCapital", cantidadAporteCapital)
                .append("aportesExtraidos", aportesExtraidos)
                .append("desembolso", desembolso)
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
        private static List<Accionista> accionista = new ArrayList<>();
        private static Documento documento;
        private static ParticipacionSGR participacionSGR;

        private static Integer idSocio;
        private static Boolean postulante;
        private static Integer accionesB;
        private static List<AporteDeCapital> cantidadAporteCapital;
        private static float desembolso;


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
        ////////////////////////////////////////////////////////

        public Builder withIdSocio(final Integer idSocio) {
            this.idSocio = idSocio;
            return this;
        }

        public Builder withPostulante(final Boolean postulante) {
            this.postulante = postulante;
            return this;
        }

        public Builder withAccionesB(final Integer accionesB) {
            this.accionesB = accionesB;
            return this;
        }

        public Builder withCantidadAporteCapital(final List<AporteDeCapital> cantidadAporteCapital) {
            this.cantidadAporteCapital = cantidadAporteCapital;
            return this;
        }

        public Builder withDesembolso(final Float desembolso) {
            this.desembolso = desembolso;
            return this;
        }


        public Builder from(final SocioProtector socioProtector) {

            cuit = socioProtector.getCuit();
            razonSocial = socioProtector.getRazonSocial();
            fechaInicio = socioProtector.getFechaInicio();
            tipo = socioProtector.getTipo();
            actividadPrincipal = socioProtector.getActividadPrincipal();
            direccion = socioProtector.getDireccion();
            telefono = socioProtector.getTelefono();
            correoElectronico = socioProtector.getCorreoElectronico();
            accionista = socioProtector.getAccionista();
            documento = socioProtector.getDocumento();
            participacionSGR = socioProtector.getParticipacionSGR();

            idSocio = socioProtector.getIdSocio();
            postulante = socioProtector.getPostulante();
            accionesB = socioProtector.getAccionesB();
            cantidadAporteCapital = socioProtector.getCantidadAporteCapital();
            desembolso = socioProtector.getDesembolso();

            return this;
        }


        public Empresa build() {
            SocioProtector socioProtector = new SocioProtector();

            socioProtector.cuit = cuit;
            socioProtector.razonSocial = razonSocial;
            socioProtector.fechaInicio = fechaInicio;
            socioProtector.tipo = tipo;
            socioProtector.actividadPrincipal = actividadPrincipal;
            socioProtector.direccion = direccion;
            socioProtector.telefono = telefono;
            socioProtector.correoElectronico = correoElectronico;
            socioProtector.accionista = accionista;
            socioProtector.documento = documento;
            socioProtector.participacionSGR = participacionSGR;

            socioProtector.idSocio = idSocio;
            socioProtector.postulante = postulante;
            socioProtector.accionesB = accionesB;
            socioProtector.cantidadAporteCapital = cantidadAporteCapital;
            socioProtector.desembolso = desembolso;

            return socioProtector;
        }
    }
}
