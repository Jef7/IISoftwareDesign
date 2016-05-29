package Modelo.TablasAmortizacion;

/**
 * Created by Esteban on 28/5/2016.
 */
public class Cuota {
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
}
