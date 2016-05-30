package Modelo.TablasAmortizacion;

import java.security.InvalidParameterException;

import Validaciones.Validacion;
import Validaciones.ValidacionTablasAmortizacion;

/**
 * Created by Esteban on 28/5/2016.
 */
class Cuota {
  int numeroCuota;
  double saldoActual;
  double montoAmortizacion;
  double montoInteres;

  Cuota(int numeroCuota, double saldoActual, double montoAmortizacion, double montoInteres) {
    this.numeroCuota = numeroCuota;
    this.saldoActual = saldoActual;
    this.montoAmortizacion = montoAmortizacion;
    this.montoInteres = montoInteres;
  }

  public int getNumeroCuota() {
    return numeroCuota;
  }

  public double getSaldoActual() {
    return saldoActual;
  }

  public double getMontoAmortizacion() {
    return montoAmortizacion;
  }

  public double getMontoInteres() {
    return montoInteres;
  }

  public double getTotalCuota() {
    return montoAmortizacion + montoInteres;
  }

  @Override
  public String toString() {
    String strNumeroCuota = Integer.toString(numeroCuota);
    String strSaldoActual = String.format("%.2f", saldoActual);
    String strMontoAmortizacion = String.format("%.2f", montoAmortizacion);
    String strMontoInteres = String.format("%.2f", montoInteres);
    String strTotalCuota = String.format("%.2f", getTotalCuota());

    return (strNumeroCuota + "\t" + strSaldoActual + "\t" + strMontoInteres + "\t" +
        strMontoAmortizacion + "\t" + strTotalCuota);
  }

  public String toString(double cambioMoneda) throws Exception {
    Validacion validador = new ValidacionTablasAmortizacion();

    if (!validador.validarMonto(cambioMoneda, 1)){
      throw new InvalidParameterException("Tipo de cambio debe ser mayor que cero.");
    }

    String strNumeroCuota = Integer.toString(numeroCuota);
    String strSaldoActual = String.format("%.2f", saldoActual / cambioMoneda);
    String strMontoAmortizacion = String.format("%.2f", montoAmortizacion / cambioMoneda);
    String strMontoInteres = String.format("%.2f", montoInteres / cambioMoneda);
    String strTotalCuota = String.format("%.2f", getTotalCuota() / cambioMoneda);

    return (strNumeroCuota + "\t" + strSaldoActual + "\t" + strMontoInteres + "\t" +
        strMontoAmortizacion + "\t" + strTotalCuota);
  }
}
