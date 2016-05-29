package Validaciones;

/**
 * Created by Esteban on 28/5/2016.
 */
public class ValidacionDatosCliente implements Validacion {

  // Clase Singleton
  public ValidacionDatosCliente(){};

  /**
   * Valida que el String ingresado sólo tenga letras alfanuméricas.
   * @param entrada Entrada del usuario.
   * @return Resultado de comparación.
   */
  @Override
  public boolean contieneSoloLetras(String entrada) {
    return entrada.matches("^[A-Za-z]+$");
  }

  /**
   * Valida que la opción ingresada asociada a un valor int esté en un rango.
   * numérico (cantidad de opciones).
   * @param opcion Número de opción seleccionada. Debe ser un valor positivo.
   * @param rango Rango numérico inclusivo de opciones disponibles. Debe ser un valor positivo.
   * @return Resultado de comparación.
   */
  @Override
  public boolean validarOpcion(int opcion, int rango) {
    return (opcion >= 0) && (opcion <= rango);
  }

  /**
   * Valida que un valor double ingresado sea positivo.
   * @param numero Número real (doble precisión) ingresado.
   * @return Resultado de comparación.
   */
  @Override
  public boolean validarDoublePositivo(double numero) {
    return (numero >= 0);
  }

  /**
   * Valida que el plazo de tiempo ingresado sea válido.
   * @param tiempoPlazo Plazo de tiempo ingresado.
   * @return Resultado de comparación.
   */
  @Override
  public boolean validarPlazo(int tiempoPlazo) {
    return (tiempoPlazo >= 1);
  }

  /**
   * Valida que el monto de dinero ingresado sea igual o mayor que el mínimo.
   * @param monto Monto de dinero ingresado.
   * @return Resultado de comparación.
   */
  @Override
  public boolean validarMonto(double monto, double minimo) {
    return validarDoublePositivo(monto) && (monto >= minimo);
  }
}
