package Controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controladores.Observadores.ObservadorControlador;
import Modelo.Registros.FabricaRegistrosCsv;
import Modelo.Registros.FabricaRegistrosXml;
import Modelo.Registros.Registro;
import Validaciones.ValidacionTablasAmortizacion;

/**
 * Created by Esteban on 30/5/2016.
 */
public class FabricaControladoresConsola implements FabricaControladores {
  @Override
  public Controlador crearNuevoControlador() throws Exception {
    try {
      Controlador nuevoControlador = new ControladorConsola(new ValidacionTablasAmortizacion());
      agregarRegistrosAControlador(nuevoControlador);
      return nuevoControlador;

    } catch (Exception e) {
      throw new RuntimeException("No se puede fabricar el controlador para la vista consola.");
    }
  }

  @Override
  public void agregarRegistrosAControlador(Controlador controlador) throws IOException {
    String fechaHoraSistema = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss a").format(new Date());
    String rutaArchivo = System.getProperty("user.dir") + "LogConsola_" + fechaHoraSistema;

    Registro registroXml = new FabricaRegistrosXml().nuevoRegistro(rutaArchivo);
    Registro registroCsv = new FabricaRegistrosCsv().nuevoRegistro(rutaArchivo);

    controlador.agregarObservador(new ObservadorControlador(controlador, registroXml));
    controlador.agregarObservador(new ObservadorControlador(controlador, registroCsv));
  }
}
