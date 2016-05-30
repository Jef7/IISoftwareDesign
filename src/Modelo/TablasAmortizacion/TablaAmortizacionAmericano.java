package Modelo.TablasAmortizacion;

import Controladores.ControladorModeloDTO;
import Validaciones.Validacion;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionAmericano extends TablaAmortizacion {

  public TablaAmortizacionAmericano(ControladorModeloDTO datosControlador,
                                    Validacion validacionDatos) throws Exception {
    super(datosControlador, validacionDatos);
  }

  @Override
  protected double calcularTotalCuota(int numeroCuota) {
    double amortizacion = calcularAmortizacionCuota(numeroCuota);
    double interes = calcularInteresCuota(numeroCuota);
    return amortizacion + interes;
  }

  @Override
  protected double calcularAmortizacionCuota(int numeroCuota) {
    if (numeroCuota < plazoPrestamo) {
      return 0;
    }
    return montoPrestamo;
  }

  @Override
  protected double calcularInteresCuota(int numeroCuota) {
    return montoPrestamo * tasaInteres;
  }

  @Override
  public TablaAmortizacionDTO generarInforme() throws Exception {
    return super.generarInforme("Americano", 1);
  }

  @Override
  public TablaAmortizacionDTO generarInforme(double cambioMoneda)
      throws Exception {
    return super.generarInforme("Americano", cambioMoneda);
  }
}
