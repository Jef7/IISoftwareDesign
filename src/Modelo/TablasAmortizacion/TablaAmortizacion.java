package Modelo.TablasAmortizacion;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import Controladores.ControladorModeloDTO;
import Validaciones.Validacion;


/**
 * Created by Esteban on 28/5/2016.
 */
public abstract class TablaAmortizacion {
  protected String nombreCliente;
  protected int plazoPrestamo;
  protected double montoPrestamo;
  protected double tasaInteres;
  protected ArrayList<Cuota> tablaCuotas;
  Validacion validadorDatos;


  protected TablaAmortizacion(ControladorModeloDTO datosControlador, Validacion validadorDatos)
      throws Exception {
    this.nombreCliente = datosControlador.getNombreCliente();
    this.plazoPrestamo = datosControlador.getPlazoPrestamo();
    this.montoPrestamo = datosControlador.getMontoPrestamo();
    this.tasaInteres = datosControlador.getTasaInteres();
    this.tablaCuotas = generarTablaCuotas();
    this.validadorDatos = validadorDatos;
  }

  protected abstract double calcularTotalCuota(int numeroCuota);

  protected abstract double calcularAmortizacionCuota(int numeroCuota);

  protected abstract double calcularInteresCuota(int numeroCuota);

  public abstract TablaAmortizacionDTO generarInforme() throws Exception;

  public abstract TablaAmortizacionDTO generarInforme(double cambioMoneda)
      throws Exception;

  Cuota generarCuota(int numeroCuota) {
    double amortizacionCuota = calcularAmortizacionCuota(numeroCuota);
    double interesCuota = calcularInteresCuota(numeroCuota);


    double deudaInicial = montoPrestamo;
    if (!tablaCuotas.isEmpty() && (numeroCuota > 1)){
      Cuota ultimaCuota = tablaCuotas.get(tablaCuotas.size() - 1);
      deudaInicial = ultimaCuota.getSaldoActual() - ultimaCuota.getMontoAmortizacion();
    }

    return new Cuota(numeroCuota, deudaInicial, amortizacionCuota, interesCuota);
  }

  ArrayList<Cuota> generarTablaCuotas() throws Exception {
    ArrayList<Cuota> nuevaTabla = new ArrayList<>();

    if (tablaCuotas == null){
      tablaCuotas = nuevaTabla;
    }

    for (int numeroCuota = 1; numeroCuota <= plazoPrestamo; numeroCuota++) {
      nuevaTabla.add(generarCuota(numeroCuota));
    }
    return nuevaTabla;
  }

  TablaAmortizacionDTO generarInforme(String subTipo, double cambioMoneda)
      throws Exception {
    if (!validadorDatos.validarDoublePositivo(cambioMoneda) || (cambioMoneda < 0)) {
      throw new InvalidParameterException("El tipo de cambio debe ser mayor que cero.");
    }

    TablaAmortizacionDTO nuevoDTO = new TablaAmortizacionDTO();

    nuevoDTO.tipoAmortizacion = subTipo;
    nuevoDTO.nombreCliente = this.nombreCliente;
    nuevoDTO.montoPrestamo = this.montoPrestamo;
    nuevoDTO.plazoPrestamo = this.plazoPrestamo;
    nuevoDTO.tasaInteres = this.tasaInteres;

    double totalAmortizacionCuotas = 0;
    double totalInteresCuotas = 0;
    double totalRentaCuotas = 0;

    if (tablaCuotas != null) {
      for (Cuota cuota : tablaCuotas) {
        totalAmortizacionCuotas += cuota.getMontoAmortizacion() / cambioMoneda;
        totalInteresCuotas += cuota.getMontoInteres() / cambioMoneda;
        totalRentaCuotas += cuota.getTotalCuota() / cambioMoneda;

        String[] datosCuota = (cambioMoneda == 1)?
            cuota.toString().split("\\t") : cuota.toString(cambioMoneda).split("\\t");

        nuevoDTO.tablaCuotas.add(datosCuota);
      }

      nuevoDTO.tablaCuotas.add(new String[]{
              "Total", "0", String.format("%.2f", totalAmortizacionCuotas),
              String.format("%.2f", totalInteresCuotas),
              String.format("%.2f", totalRentaCuotas)
          }
      );
    }
    return nuevoDTO;
  }

  public TablaAmortizacionDTO generarInforme(ControladorModeloDTO consulta) throws Exception {
    return generarInforme(consulta.getNombreMoneda(), consulta.getCambioMoneda());
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public int getPlazoPrestamo() {
    return plazoPrestamo;
  }

  public double getMontoPrestamo() {
    return montoPrestamo;
  }

  public double getTasaInteres() {
    return tasaInteres;
  }


}
