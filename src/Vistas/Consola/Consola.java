package Vistas.Consola;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

import Controladores.ControladorVistaDTO;
import Validaciones.Validacion;
import Vistas.Vista;
import Vistas.VistaControladorDTO;

/**
 * Created by Esteban on 30/5/2016.
 */
public class Consola implements Vista {

  Validacion validacion;

  public Consola(Validacion validacion) {
    this.validacion = validacion;
  }

  private String entradaString() throws Exception {
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      return bufferedReader.readLine();
    } catch (Exception e) {
      throw new IOException("No se pudo obtener la entrada del usuario.");
    }
  }

  private double entradaDouble() throws Exception {
    try {
      String entradaUsuario = entradaString();
      return Double.parseDouble(entradaUsuario);
    } catch (NumberFormatException e) {
      throw new NumberFormatException("El dato ingresado no es un número (Double)");
    } catch (Exception e) {
      throw e;
    }
  }

  private int entradaInt() throws Exception {
    try {
      String entradaUsuario = entradaString();
      return Integer.parseInt(entradaUsuario);
    } catch (NumberFormatException e) {
      throw new NumberFormatException("El dato ingresado no es un número entero (int)");
    } catch (Exception e) {
      throw e;
    }
  }

  @NotNull
  private String ingresarNombre() throws Exception {
    System.out.println("Por favor ingrese el nombre del cliente:  ");
    try {
      String nombre = entradaString();
      if (!validacion.contieneSoloLetras(nombre)) {
        throw new InvalidParameterException("El nombre ingresado sólo puede contener letras.");
      }
      return nombre;
    } catch (Exception e) {
      throw e;
    }

  }

  @NotNull
  private Double ingresarMonto() throws Exception {
    System.out.println("Ingrese el monto de dinero a solicitar: ");
    try {
      Double monto = entradaDouble();

      if (!validacion.validarMonto(monto, 1000)) {
        throw new InvalidParameterException("El monto ingresado es menor al mínimo.");
      }
      return monto;
    } catch (Exception e) {
      throw e;
    }
  }

  private int ingresarPlazo() throws Exception {
    System.out.println("Ingrese el plazo en años de la amortización: ");
    try {
      int plazo = entradaInt();
      if (!validacion.validarPlazo(plazo)) {
        throw new InvalidParameterException("El plazo del préstamo está por debajo del mínimo.");
      }
      return plazo;
    } catch (Exception e) {
      throw e;
    }
  }

  private double ingresarInteres() throws Exception {
    System.out.println("Ingrese la tasa de interés (porcentaje): ");
    try {
      double interes = entradaDouble();
      if (!validacion.validarDoublePositivo(interes)) {
        throw new InvalidParameterException("El interés ingresado debe ser positivo.");
      }
      return interes / 100.0;
    } catch (Exception e) {
      throw e;
    }
  }

  private int ingresarOpcionNumerica(String pregunta, int rangoOpciones) throws Exception {
    System.out.println(pregunta);

    try {
      int opcion = entradaInt();

      if (!validacion.validarOpcion(opcion, 3)) {
        throw new RuntimeException("La opción seleccionada no es válida.");
      }
      if (opcion == 0) {
        System.out.println("Operación cancelada.");
        return 0;
      }
      return opcion;
    } catch (Exception e) {
      throw e;
    }
  }

  private String ingresarTipoMoneda() throws Exception {
    String str = "Seleccione el tipo de moneda que desea ver en la tabla:\n";
    str += "1 - Colones\n2 - Dólares\n0 - Cancelar operación";

    try {
      int opcionSeleccionada = ingresarOpcionNumerica(str, 2);
      switch (opcionSeleccionada) {
        case 1:
          return "Colones";
        case 2:
          return "Dólares";
        default:
          return "";
      }

    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public int seleccionarTipoAmortizacion() throws Exception {
    String str = "Seleccione el tipo de amortización que desea generar en la tabla:\n";
    str += "1 - Alemán\n2 - Americano\n3 - Francés\n0 - Cancelar operación\n";

    return ingresarOpcionNumerica(str, 3);

  }

  @Override
  public VistaControladorDTO obtenerDatosEntrada() throws Exception {
    try {
      VistaControladorDTO datosEntrada = new VistaControladorDTO();

      String nuevoNombreCliente = ingresarNombre();
      double nuevoMontoCliente = ingresarMonto();
      int nuevoPlazoPrestamo = ingresarPlazo();
      double nuevaTasaInteres = ingresarInteres();
      int tipoAmortizacion = seleccionarTipoAmortizacion();

      datosEntrada.setNombreCliente(nuevoNombreCliente);
      datosEntrada.setMontoPrestamo(nuevoMontoCliente);
      datosEntrada.setPlazoPrestamo(nuevoPlazoPrestamo);
      datosEntrada.setTasaInteres(nuevaTasaInteres);
      datosEntrada.setTipoAmortizacion(tipoAmortizacion);

      return datosEntrada;
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public void mostrarResultado(ControladorVistaDTO resultado) throws Exception {
    try {
      // TODO Completar luego de agregar web services
      String mensaje = "";

      /* mensaje += "Tipo de cambio compra del BCCR para " + resultado.getTipoCambioExterno().get(0)
          + ": " + resultado.getTipoCambioExterno().get(1) + "\n"; */

      mensaje += "Fecha y Hora (Chucky): " + resultado.getFechaHora() + "\n";

      mensaje += "Datos de la consulta:\n"
          + "Nombre del cliente: " + resultado.getNombreCliente() + "\n"
          + "Monto de préstamo otorgado: " + resultado.getMontoPrestamo() + " colones\n"
          + "Plazo de préstamo otorgado: " + resultado.getPlazoPrestamo() + " años\n"
          + "Tasa de interés anual: " + resultado.getTasaInteres() + "\n";

      mensaje += "\n--- Tabla de Amortización ---\n\n";
      mensaje += "Numero Cuota\tDeuda Actual\tCuota Amortización\tCuota Interés\tTotal Cuota\n";

      for (String[] cuota : resultado.getTablaCuotas()) {
        for (int cuenta = 0; cuenta < cuota.length; cuenta++) {
          mensaje += cuota[cuenta] + (((cuenta + 1) < cuota.length) ? "\t\t\t" : "\n");
        }
      }

      System.out.println(mensaje);
    } catch (Exception e) {
      throw e;
    }
  }
}
