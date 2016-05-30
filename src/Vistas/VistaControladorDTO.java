package Vistas;

/**
 * Created by Esteban on 29/5/2016.
 */
public class VistaControladorDTO {
  String nombreCliente;
  String nombreMoneda;
  double montoPrestamo;
  int plazoPrestamo;
  double tasaInteres;

  public VistaControladorDTO() {
    nombreCliente = "";
    nombreMoneda = "";
    montoPrestamo = 0;
    plazoPrestamo = 0;
    tasaInteres = 0;
  }

  public String getNombreMoneda() {
    return nombreMoneda;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public double getMontoPrestamo() {
    return montoPrestamo;
  }

  public int getPlazoPrestamo() {
    return plazoPrestamo;
  }

  public double getTasaInteres() {
    return tasaInteres;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public void setNombreMoneda(String nombreMoneda) {
    this.nombreMoneda = nombreMoneda;
  }

  public void setMontoPrestamo(double montoPrestamo) {
    this.montoPrestamo = montoPrestamo;
  }

  public void setPlazoPrestamo(int plazoPrestamo) {
    this.plazoPrestamo = plazoPrestamo;
  }

  public void setTasaInteres(double tasaInteres) {
    this.tasaInteres = tasaInteres;
  }
}
