package controller;

import dto.Desembolso;
import dto.Empresa.Empresa;
import dto.Empresa.SocioParticipe;
import dto.LineaDeCredito;
import dto.Operacion.Comision;
import dto.Operacion.Operacion;
import dto.Operacion.Tipo1;
import utils.Utils;

import java.util.Date;
import java.util.List;

public class ControladorOperacion {


    public ControladorOperacion() {

    }

    public static Float calcularComisionesCheques(final Date dia) {
        List<LineaDeCredito> lineaDeCreditoList = (List<LineaDeCredito>) ControladorSocio.getListaSocioParticipe().stream().map(x -> x.getLineaDeCredito());
        List<Operacion> listOperaciones = (List<Operacion>) lineaDeCreditoList.stream().map(x -> x.getOperaciones());
        List<Comision> comisionList = (List<Comision>) listOperaciones.stream().map(x -> x.getComision());

        Float cantidadComisionCheques = (float) 0;

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

    public static List<Operacion> calcularCantidadOpMonetizadas(final Integer cuit, final Integer año, final Integer mes1, final Integer mes2) {

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

    public static float calcularValorPromedioTasa(final String tipoDeEmpresa, final Date periodo1, final Date periodo2) {

        List<Empresa> listaEmpresas = ControladorSocio.getListaEmpresas();
        List<SocioParticipe> empresasDeTipo = (List<SocioParticipe>) listaEmpresas.stream().filter(x -> x.getTipo() == tipoDeEmpresa);

        List<LineaDeCredito> lineaDeCreditoDeTipo = (List<LineaDeCredito>) empresasDeTipo.stream().map(x -> x.getLineaDeCredito());

        Float totalRecaudado = Float.valueOf(0);

        for (int i = 0; i < lineaDeCreditoDeTipo.size(); i++) {
            List<Operacion> operaciones = lineaDeCreditoDeTipo.get(i).getOperaciones();
            for (int j = 0; j < operaciones.size(); j++) {
                Operacion operacion = operaciones.get(j);
                if (operacion.getClass()== Tipo1.class){
                    if(operacion.getFecha().getDay() > periodo1.getDay() &
                            operacion.getFecha().getMonth() > periodo1.getMonth() &
                            operacion.getFecha().getYear() > periodo1.getYear() &
                            operacion.getFecha().getDay() < periodo2.getDay() &
                            operacion.getFecha().getMonth() < periodo2.getMonth() &
                            operacion.getFecha().getYear() < periodo2.getYear()){

                        totalRecaudado = operacion.getImporteTotal();
                    }
                }
            }
        }

        return (float) (totalRecaudado*(0.01));    }

    public static float totalChequesYPagares(final String tipoDeEmpresa, final Date periodo1, final Date periodo2) {
        List<Empresa> listaEmpresas = ControladorSocio.getListaEmpresas();
        List<SocioParticipe> empresasDeTipo = (List<SocioParticipe>) listaEmpresas.stream().filter(x -> x.getTipo() == tipoDeEmpresa);

        List<LineaDeCredito> lineaDeCreditoDeTipo = (List<LineaDeCredito>) empresasDeTipo.stream().map(x -> x.getLineaDeCredito());

        Float totalRecaudado = Float.valueOf(0);

        for (int i = 0; i < lineaDeCreditoDeTipo.size(); i++) {
            List<Operacion> operaciones = lineaDeCreditoDeTipo.get(i).getOperaciones();
            for (int j = 0; j < operaciones.size(); j++) {
                Operacion operacion = operaciones.get(j);
                if (operacion.getClass()== Tipo1.class){
                    if(operacion.getFecha().getDay() > periodo1.getDay() &
                            operacion.getFecha().getMonth() > periodo1.getMonth() &
                            operacion.getFecha().getYear() > periodo1.getYear() &
                            operacion.getFecha().getDay() < periodo2.getDay() &
                            operacion.getFecha().getMonth() < periodo2.getMonth() &
                            operacion.getFecha().getYear() < periodo2.getYear()){

                        totalRecaudado = operacion.getImporteTotal();
                    }
                }
            }
        }

        return totalRecaudado;


    }


    public static float calcularPorcentajeComision(final String tipoDeOperacion) {
        float valor = 0;
        if (tipoDeOperacion == "ChequeDeTerceros") {
            valor = 3;
        } else if (tipoDeOperacion == "ChequePropio") {
            valor = 3;
        } else if (tipoDeOperacion == "PagareBursatil") {
            valor = 3;
        } else if (tipoDeOperacion == "TarjetaDeCredito") {
            valor = 3;
        } else if (tipoDeOperacion == "CuentaCorrienteComercial") {
            valor = 3;
        } else if (tipoDeOperacion == "Prestamo") {
            valor = 4;
        }

        return valor;

    }

    public static Float obtenerMoraTotal(final Integer cuit) {
        SocioParticipe empresa = (SocioParticipe) ControladorSocio.buscarEmpresa(cuit);
        Desembolso desembolso = empresa.getLineaDeCredito().getDesembolso();
        Float moraDiaria = desembolso.getMora();
        Integer cantidadDeDias = obtenerCantidadDeDiasEntreDosFechas(desembolso.getFecha());
        float moraTotal = moraDiaria * cantidadDeDias;

        return moraTotal;
    }

    public static Integer obtenerCantidadDeDiasEntreDosFechas(final Date date1) {

        Date dateActual = Utils.getDate();

        Integer cantidadDeMeses = date1.getMonth() - dateActual.getMonth();
        //Se asume en este modelo que los meses tienen 30 dias
        Integer cantidadDeDias = 30 * cantidadDeMeses;
        int diferenciaDeDias = dateActual.getDay() - date1.getDay();
        if (diferenciaDeDias > 0) {
            cantidadDeDias = cantidadDeDias + diferenciaDeDias;
        } else if (diferenciaDeDias < 0) {
            cantidadDeDias = cantidadDeDias - diferenciaDeDias;
        }
        return cantidadDeDias;
    }

    public static Float obtenerMoraPorDia(final Integer cuit) {
        SocioParticipe empresa = (SocioParticipe) ControladorSocio.buscarEmpresa(cuit);
        return empresa.getLineaDeCredito().getDesembolso().getMora();
    }

    public static Float calcularConsolidadaUtilizado(final Integer cuit) {
        SocioParticipe empresa = (SocioParticipe) ControladorSocio.buscarEmpresa(cuit);
        return empresa.calcularUtilizadoEnLinea();
    }

    public static Float calcularConsolidadaRiesgo(final Integer cuit) {
        SocioParticipe empresa = (SocioParticipe) ControladorSocio.buscarEmpresa(cuit);
        return empresa.calcularRiesgoVivo();
    }


}
