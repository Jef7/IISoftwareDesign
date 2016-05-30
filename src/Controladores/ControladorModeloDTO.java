package Controladores;

/**
 * Created by Esteban on 29/5/2016.
 */
public class ControladorModeloDTO {
  String nombreCliente;
  int plazoPrestamo;
  double montoPrestamo;
  double tasaInteres;

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
