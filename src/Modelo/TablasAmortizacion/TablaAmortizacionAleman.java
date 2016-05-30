package Modelo.TablasAmortizacion;

import Controladores.ControladorModeloDTO;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionAleman extends TablaAmortizacion {

  public TablaAmortizacionAleman(ControladorModeloDTO datosControlador) throws Exception {
    super(datosControlador);
  }

  @Override
  protected double calcularTotalCuota(int numeroCuota) {
    double cuota = (montoPrestamo / plazoPrestamo) + (tasaInteres * montoPrestamo);
    double reduccion = (tasaInteres * (montoPrestamo / plazoPrestamo));

    for (int cuentaCuota = 1; cuentaCuota < numeroCuota; cuentaCuota++) {
      cuota -= reduccion;
    }

    return cuota;
  }

  @Override
  protected double calcularAmortizacionCuota(int numeroCuota) {
    return (montoPrestamo / plazoPrestamo);
  }

  @Override
  protected double calcularInteresCuota(int numeroCuota) {
    double plazoPendiente = (plazoPrestamo - numeroCuota + 1);
    double interesConstantePrestamo = (montoPrestamo * (tasaInteres)) / plazoPrestamo;
    return plazoPendiente * interesConstantePrestamo;
  }

  @Override
  public TablaAmortizacionDTO generarInforme() throws Exception{
    return super.generarInforme("Alemán", 1);
  }

  @Override
  public TablaAmortizacionDTO generarInforme(double cambioMoneda) throws Exception{
    return super.generarInforme("Alemán", cambioMoneda);
  }
}
