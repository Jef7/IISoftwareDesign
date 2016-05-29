package Modelo.TablasAmortizacion;

import java.util.ArrayList;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionDTO {
  String tipo;
  String nombreCliente;
  int plazoPrestamo;
  double montoPrestamo;
  double tasaInteres;
  ArrayList<String[]> tablaCuotas;

  TablaAmortizacionDTO(String nombreCliente, int plazoPrestamo,
                       double montoPrestamo, double tasaInteres) {
    this.nombreCliente = nombreCliente;
    this.plazoPrestamo = plazoPrestamo;
    this.montoPrestamo = montoPrestamo;
    this.tasaInteres = tasaInteres;
    tipo = "Amortización";
    tablaCuotas = new ArrayList<>();
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public String getTipo(){
    return tipo;
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

  public ArrayList<String[]> getTablaCuotas() {
    return tablaCuotas;
  }
}
