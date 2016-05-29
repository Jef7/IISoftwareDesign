package Modelo.TablasAmortizacion;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionFrances extends TablaAmortizacion {
  protected TablaAmortizacionFrances(String nombreCliente, int plazoPrestamo,
                                     double montoPrestamo, double tasaInteres) {
    super(nombreCliente, plazoPrestamo, montoPrestamo, tasaInteres);
  }

  //TODO Implementar cálculos de cuotas (amortización, interés, total)

  @Override
  protected double calcularTotalCuota(int numeroCuota) {
    return 0;
  }

  @Override
  protected double calcularAmortizacionCuota(int numeroCuota) {
    return 0;
  }

  @Override
  protected double calcularInteresCuota(int numeroCuota) {
    return 0;
  }

  @Override
  public TablaAmortizacionDTO generarInforme() {
    return super.generarInforme("Francés");
  }
}
