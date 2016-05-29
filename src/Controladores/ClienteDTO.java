package Controladores;

/**
 * Created by Esteban on 28/5/2016.
 */
public class ClienteDTO {
  String nombreCliente;
  int plazoPrestamo;
  double montoPrestamo;
  double tasaInteres;

  public ClienteDTO(String nombreCliente, int plazoPrestamo,
                    double montoPrestamo, double tasaInteres) {
    this.nombreCliente = nombreCliente;
    this.plazoPrestamo = plazoPrestamo;
    this.montoPrestamo = montoPrestamo;
    this.tasaInteres = tasaInteres;
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

  public double getTasaInteres() {
    return tasaInteres;
  }
}
