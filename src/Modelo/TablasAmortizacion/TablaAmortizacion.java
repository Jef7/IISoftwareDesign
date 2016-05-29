package Modelo.TablasAmortizacion;

import java.util.ArrayList;


/**
 * Created by Esteban on 28/5/2016.
 */
public abstract class TablaAmortizacion {
  protected String nombreCliente;
  protected int plazoPrestamo;
  protected double montoPrestamo;
  protected double tasaInteres;
  protected ArrayList<Cuota> tablaCuotas;

  protected TablaAmortizacion(String nombreCliente, int plazoPrestamo,
                              double montoPrestamo, double tasaInteres) {
    this.nombreCliente = nombreCliente;
    this.plazoPrestamo = plazoPrestamo;
    this.montoPrestamo = montoPrestamo;
    this.tasaInteres = tasaInteres;
    this.tablaCuotas = generarTablaCuotas();
  }

  protected abstract double calcularTotalCuota(int numeroCuota);

  protected abstract double calcularAmortizacionCuota(int numeroCuota);

  protected abstract double calcularInteresCuota(int numeroCuota);

  public abstract TablaAmortizacionDTO generarInforme();

  Cuota generarCuota(int numeroCuota) throws RuntimeException {
    double amortizacionCuota = calcularAmortizacionCuota(numeroCuota);
    double interesCuota = calcularInteresCuota(numeroCuota);

    double totalCuota = calcularTotalCuota(numeroCuota);
    double deudaInicial = montoPrestamo - (amortizacionCuota * (numeroCuota - 1));

    if ((totalCuota) == (amortizacionCuota + interesCuota)) {
      return new Cuota(numeroCuota, deudaInicial, amortizacionCuota, interesCuota);
    } else {
      throw new RuntimeException("ERROR calculo");
    }
  }

  ArrayList<Cuota> generarTablaCuotas() {
    ArrayList<Cuota> nuevaTabla = new ArrayList<>();

    for (int numeroCuota = 1; numeroCuota <= plazoPrestamo; numeroCuota++) {
      nuevaTabla.add(generarCuota(numeroCuota));
    }
    return nuevaTabla;
  }

  TablaAmortizacionDTO generarInforme(String subTipo) {
    TablaAmortizacionDTO nuevoDTO = new TablaAmortizacionDTO(nombreCliente, plazoPrestamo,
        montoPrestamo, tasaInteres);
    nuevoDTO.tipo = subTipo;

    double totalAmortizacionCuotas = 0;
    double totalInteresCuotas = 0;
    double totalRentaCuotas = 0;

    if (tablaCuotas != null) {
      for (Cuota cuota : tablaCuotas) {
        totalAmortizacionCuotas += cuota.getMontoAmortizacion();
        totalInteresCuotas += cuota.getMontoInteres();
        totalRentaCuotas += cuota.getTotalCuota();

        String[] datosCuota = cuota.toString().split("\\t");
        nuevoDTO.tablaCuotas.add(datosCuota);
      }

      nuevoDTO.tablaCuotas.add(new String[]{
              "Total", "0", String.format("%.2f", totalAmortizacionCuotas),
              String.format("%.2f", totalInteresCuotas),
              String.format("%.2f", totalRentaCuotas)
          }
      );
    }
    return nuevoDTO;
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
