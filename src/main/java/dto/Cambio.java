package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import utils.Utils;

import java.util.Date;

public class Cambio {

    private Object nuevoObject;
    private Object oldObject;

    private String referencia;
    private String usuario;

    private Date dateChange;

    public Object getNuevoObject() {
        return nuevoObject;
    }

    public Object getOldObject() {
        return oldObject;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public Date getDateChange() {
        return dateChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cambio cambio = (Cambio) o;

        return new EqualsBuilder()
                .append(getNuevoObject(), cambio.getNuevoObject())
                .append(getOldObject(), cambio.getOldObject())
                .append(getReferencia(), cambio.getReferencia())
                .append(getUsuario(), cambio.getUsuario())
                .append(getDateChange(), cambio.getDateChange())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getNuevoObject())
                .append(getOldObject())
                .append(getReferencia())
                .append(getUsuario())
                .append(getDateChange())
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nuevoObject", nuevoObject)
                .append("oldObject", oldObject)
                .append("referencia", referencia)
                .append("usuario", usuario)
                .append("dateChange", dateChange)
                .toString();
    }


    public static final class Builder {
        private Object nuevoObject;
        private Object oldObject;
        private String referencia;
        private String usuario;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withNuevoObject(Object nuevoObject) {
            this.nuevoObject = nuevoObject;
            return this;
        }

        public Builder withOldObject(Object oldObject) {
            this.oldObject = oldObject;
            return this;
        }

        public Builder withReferencia(String referencia) {
            this.referencia = referencia;
            return this;
        }

        public Builder withUsuario(String usuario) {
            this.usuario = usuario;
            return this;
        }



        public Cambio build() {
            Cambio cambio = new Cambio();
            cambio.oldObject = this.oldObject;
            cambio.referencia = this.referencia;
            cambio.dateChange = Utils.getDate();
            cambio.nuevoObject = this.nuevoObject;
            cambio.usuario = this.usuario;
            return cambio;
        }
    }
}
