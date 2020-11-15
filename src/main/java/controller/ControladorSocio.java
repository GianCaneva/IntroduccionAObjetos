package controller;

import dto.Empresa;
import dto.lineasDeCredito;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class ControladorSocios {
    public ControladorSocios() {
    }

    private Empresa crearEmpresa(final int cuit, final String razonSocial, final Date fechaInicio, final String tipo, final String actividadPrincipal, final String direccion, final int telefono, final String correoElectronico){

    }

    private socioParticipe solicitarSocioParticipe(final String cuit){

    }

    private Float operar(final Empresa empresa){
        lineasDeCredito LineaDeCredito = empresa.getLineaDeCredito();
        if (LineaDeCredito.getFechaVigencia() > fechaDeHoy){
          //  levantarError
        }
        if (desembolsos!= 0){
        //    levantarError
        }

    }

    private boolean habilitaOperacion(){

    }
}
