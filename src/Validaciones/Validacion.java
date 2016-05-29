package Validaciones;

/**
 * Created by Esteban on 28/5/2016.
 */

/**
 * Interfaz para validación de datos.
 */
public interface Validacion {
  /**
   * @param entrada Entrada del usuario.
   * @return Resultado de comparación.
   */
  boolean contieneSoloLetras(String entrada);

  /**
   * @param opcion Número de opción seleccionada.
   * @param rango Rango numérico de opciones disponibles.
   * @return Resultado de comparación.
   */
  boolean validarOpcion(int opcion, int rango);

  /**
   * @param numero Número real (doble precisión) ingresado.
   * @return Resultado de comparación.
   */
  boolean validarDoublePositivo(double numero);

  /**
   * @param tiempoPlazo Plazo de tiempo ingresado.
   * @return Resultado de validación de plazo.
   */
  boolean validarPlazo(int tiempoPlazo);

  /**
   * @param monto Monto de dinero ingresado.
   * @return Resultado de validación de monto.
   */
  boolean validarMonto(double monto, double minimo);
}
