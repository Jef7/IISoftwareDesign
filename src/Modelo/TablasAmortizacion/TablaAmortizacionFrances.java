package Modelo.TablasAmortizacion;

import Controladores.ControladorModeloDTO;
import Validaciones.Validacion;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionFrances extends TablaAmortizacion {
  public TablaAmortizacionFrances(ControladorModeloDTO datosControlador,
                                  Validacion validadorDatos) throws Exception {
    super(datosControlador, validadorDatos);
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
  public TablaAmortizacionDTO generarInforme() throws Exception{
    return super.generarInforme("Francés", 1);
  }

  @Override
  public TablaAmortizacionDTO generarInforme(double cambioMoneda)
      throws Exception{
    return super.generarInforme("Francés", cambioMoneda);
  }
}
