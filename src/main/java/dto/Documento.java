package dto;

import dto.Empresa.SocioParticipe;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class Documento {

    private String tipo;
    private Date fechaDeRecepcion;
    private String estado;
    private String usuario;
    private Boolean aprobado = false;


    private Documento() {
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFechaDeRecepcion() {
        return fechaDeRecepcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void aprobarDocumento() {
        aprobado = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Documento documento = (Documento) o;

        return new EqualsBuilder()
                .append(getTipo(), documento.getTipo())
                .append(getFechaDeRecepcion(), documento.getFechaDeRecepcion())
                .append(getEstado(), documento.getEstado())
                .append(getUsuario(), documento.getUsuario())
                .append(getAprobado(), documento.getAprobado())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getTipo())
                .append(getFechaDeRecepcion())
                .append(getEstado())
                .append(getUsuario())
                .append(getAprobado())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tipo", tipo)
                .append("fechaDeRecepcion", fechaDeRecepcion)
                .append("estado", estado)
                .append("usuario", usuario)
                .append("aprobado", aprobado)
                .toString();
    }

    public static final class Builder {
        private String tipo;
        private Date fechaDeRecepcion;
        private String estado;
        private String usuario;
        private Boolean aprobado;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withTipo(final String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder withFechaDeRecepcion(final Date fechaDeRecepcion) {
            this.fechaDeRecepcion = fechaDeRecepcion;
            return this;
        }

        public Builder withEstado(final String estado) {
            this.estado = estado;
            return this;
        }

        public Builder withUsuario(final String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder withAprobado(final Boolean aprobado) {
            this.aprobado = aprobado;
            return this;
        }

        public Documento build() {
            Documento documento = new Documento();
            documento.tipo = this.tipo;
            documento.estado = this.estado;
            documento.fechaDeRecepcion = this.fechaDeRecepcion;
            documento.usuario = this.usuario;
            documento.aprobado = this.aprobado;
            return documento;
        }
    }
}
