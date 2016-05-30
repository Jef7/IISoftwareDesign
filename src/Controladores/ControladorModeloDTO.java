package Controladores;

/**
 * Created by Esteban on 29/5/2016.
 */
public class ControladorModeloDTO {
  String nombreCliente;
  int plazoPrestamo;
  double montoPrestamo;
  double tasaInteres;
  String nombreMoneda;
  double cambioMoneda;

  public ControladorModeloDTO() {
    this.nombreCliente = "";
    this.plazoPrestamo = 0;
    this.montoPrestamo = 0;
    this.tasaInteres = 0;
    this.nombreMoneda = "";
    this.cambioMoneda = 1;
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

  public String getNombreMoneda() {
    return nombreMoneda;
  }

  public double getCambioMoneda() {
    return cambioMoneda;
  }

  public double getTasaInteres() {
    return tasaInteres;
  }
}
