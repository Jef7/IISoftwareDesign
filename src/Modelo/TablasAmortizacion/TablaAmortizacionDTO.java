package Modelo.TablasAmortizacion;

import java.util.ArrayList;

/**
 * Created by Esteban on 28/5/2016.
 */
public class TablaAmortizacionDTO {
  String tipoAmortizacion;
  String nombreCliente;
  int plazoPrestamo;
  double montoPrestamo;
  double tasaInteres;

  ArrayList<String[]> tablaCuotas;
  TablaAmortizacionDTO() {
    this.nombreCliente = "";
    this.plazoPrestamo = 0;
    this.montoPrestamo = 0;
    this.tasaInteres = 0;
    this.tipoAmortizacion = "Amortización";
    this.tablaCuotas = new ArrayList<>();
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public String getTipoAmortizacion(){
    return tipoAmortizacion;
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
