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
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getTipo())
                .append(getFechaDeRecepcion())
                .append(getEstado())
                .append(getUsuario())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tipo", tipo)
                .append("fechaDeRecepcion", fechaDeRecepcion)
                .append("estado", estado)
                .append("usuario", usuario)
                .toString();
    }


    public static final class Builder {
        private String tipo;
        private Date fechaDeRecepcion;
        private String estado;
        private String usuario;


        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder withFechaDeRecepcion(Date fechaDeRecepcion) {
            this.fechaDeRecepcion = fechaDeRecepcion;
            return this;
        }

        public Builder withEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder withUsuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Documento build() {
            Documento documento = new Documento();
            documento.tipo = this.tipo;
            documento.estado = this.estado;
            documento.fechaDeRecepcion = this.fechaDeRecepcion;
            documento.usuario = this.usuario;
            return documento;
        }
    }
}
