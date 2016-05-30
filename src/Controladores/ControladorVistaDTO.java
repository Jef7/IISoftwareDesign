package Controladores;

import java.util.ArrayList;

/**
 * Created by Esteban on 29/5/2016.
 */
public class ControladorVistaDTO {
  String nombreCliente;
  String montoPrestamo;
  String plazoPrestamo;
  String tasaInteres;
  String fechaHora;
  String nombreMoneda;
  String tipoCambio;
  ArrayList<String[]> tablaCuotas;

  public ControladorVistaDTO() {
    this.nombreCliente = "";
    this.montoPrestamo = "";
    this.plazoPrestamo = "";
    this.tasaInteres = "";
    this.fechaHora = "";
    this.nombreMoneda = "";
    this.tipoCambio = "";
    this.tablaCuotas = new ArrayList<>();
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public String getMontoPrestamo() {
    return montoPrestamo;
  }

  public String getPlazoPrestamo() {
    return plazoPrestamo;
  }

  public String getTasaInteres() {
    return tasaInteres;
  }

  public String getFechaHora() {
    return fechaHora;
  }

  public String getTipoCambio() {
    return tipoCambio;
  }

  public String getNombreMoneda() {
    return nombreMoneda;
  }

  public ArrayList<String[]> getTablaCuotas() {
    return tablaCuotas;
  }
}
