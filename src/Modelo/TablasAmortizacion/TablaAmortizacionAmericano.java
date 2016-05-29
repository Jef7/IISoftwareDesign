package Modelo.TablasAmortizacion;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionAmericano extends TablaAmortizacion {
  public TablaAmortizacionAmericano(String nombreCliente, int plazoPrestamo,
                                    double montoPrestamo, double tasaInteres) {
    super(nombreCliente, plazoPrestamo, montoPrestamo, tasaInteres);
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
    return tasaInteres * montoPrestamo;
  }

  @Override
  public TablaAmortizacionDTO generarInforme() {
    return super.generarInforme("Americano");
  }
}
