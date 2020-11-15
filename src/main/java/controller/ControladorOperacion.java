package controller;

import dto.Empresa.SocioParticipe;
import dto.LineaDeCredito;
import dto.Operacion.*;
import dto.enumeration.CtaCorriente;
import dto.enumeration.Prestamo;
import dto.enumeration.TipoCheque;

import java.util.Date;
import java.util.List;

public class ControladorOperacion {


    public ControladorOperacion() {

    }

    private Integer calcularComisionesCheques(final Date dia) {
        List<LineaDeCredito> lineaDeCreditoList = (List<LineaDeCredito>) ControladorSocio.getListaSocioParticipe().stream().map(x -> x.getLineaDeCredito());
        List<Operacion> listOperaciones = (List<Operacion>) lineaDeCreditoList.stream().map(x -> x.getOperaciones());
        List<Comision> comisionList = (List<Comision>) listOperaciones.stream().map(x -> x.getComision());

        Integer cantidadComisionCheques = 0;

        for (int i = 0; i < comisionList.size(); i++) {
            Comision comision = comisionList.get(i);
            Date fechaComision = comision.getFechaComision();
            if (fechaComision.getDay() == dia.getDay() &&
                    fechaComision.getYear() == dia.getYear() &&
                    fechaComision.getMonth() == dia.getMonth()) {
                cantidadComisionCheques = cantidadComisionCheques + 1;
            }
        }
        return cantidadComisionCheques;

    }

    private List<Operacion> calcularCantidadOpMonetizadas(final Integer cuit, final Integer año, final Integer mes1, final Integer mes2) {

        if (mes1 > mes2) {
            throw new RuntimeException("Error. El mes 1 no puede ser mayor que el mes 2");
        }

        List<Operacion> operacionesMonetizadasParaUnaFecha = null;
        SocioParticipe empresa = (SocioParticipe) ControladorSocio.buscarEmpresa(cuit);
        List<Operacion> operaciones = empresa.getLineaDeCredito().getOperaciones();

        List<Operacion> operacionesMonetizadas = (List<Operacion>) operaciones.stream().filter(x -> x.getEstado() == "Monetizado");

        for (int i = 0; i < operacionesMonetizadas.size(); i++) {
            Operacion operacion = operacionesMonetizadas.get(i);
            if (operacion.getFecha().getYear() == año && operacion.getFecha().getMonth() > mes1 && operacion.getFecha().getMonth() < mes2) {
                operacionesMonetizadasParaUnaFecha.add(operacion);
            }

        }
        return operacionesMonetizadasParaUnaFecha;


    }

    //
//    private int calcularValorPromedioTasa(){
//    }
//
    private float calcularPorcentajeComision(final Enum tipoDeOperacion) {
        float valor = 0;
        if (tipoDeOperacion == TipoCheque.ChequeDeTerceros) {
            valor = 3;
        } else if (tipoDeOperacion == TipoCheque.ChequePropio) {
            valor = 3;
        } else if (tipoDeOperacion == TipoCheque.PagareBursatil) {
            valor = 3;
        } else if (tipoDeOperacion == CtaCorriente.TarjetaDeCredito) {
            valor = 3;
        } else if (tipoDeOperacion == CtaCorriente.CuentaCorrienteComercial) {
            valor = 3;
        } else if (tipoDeOperacion == Prestamo.Prestamo) {
            valor = 4;
        }

        return valor;

    }
//    private int calcularSaldoMora(){
//    }
//    private int calcularConsolidada(){
//    }


}
