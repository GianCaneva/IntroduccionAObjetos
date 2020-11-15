package dto.Operacion;


import java.util.UUID;

public class CertificadoDeGarantia {
    private Integer cuit;
    private String id;

    public CertificadoDeGarantia(Integer cuit) {
        this.cuit = cuit;
        final String uuid = UUID.randomUUID().toString();
    }

    public Integer getCuit() {
        return cuit;
    }

    public String getId() {
        return id;
    }


}
