package dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public abstract class Operacion {

    protected Integer comisiones;
    protected Integer importeTotal;

    public Integer getComisiones() {
        return comisiones;
    }

    public Integer getImporteTotal() {
        return importeTotal;
    }

    private Integer calcularRiesgoVivo;
}
