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
  String tipoAmortizacion;


  ArrayList<String[]> tipoCambioExterno;   // Tipo de cambio según Web Service. Dólar por defecto.
  ArrayList<String[]> tablaCuotas;

  public ControladorVistaDTO() {
    this.nombreCliente = "";
    this.montoPrestamo = "";
    this.plazoPrestamo = "";
    this.tasaInteres = "";
    this.fechaHora = "";
    this.nombreMoneda = "";
    this.tipoCambio = "";
    this.tipoAmortizacion = "";
    this.tipoCambioExterno = new ArrayList<>();
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

  public String getTipoAmortizacion() { return tipoAmortizacion; }

  public ArrayList<String[]> getTipoCambioExterno() {
    return tipoCambioExterno;
  }
  public ArrayList<String[]> getTablaCuotas() {
    return tablaCuotas;
  }
}
