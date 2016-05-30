package Modelo.Registros;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Esteban on 29/5/2016.
 */
public class RegistroXml extends Registro {
  // TODO Generar archivo XML

  public RegistroXml(String rutaArchivo) throws IOException {
    super(rutaArchivo);
  }

  @Override
  public boolean registrarEntrada(ArrayList<String> contenido) throws IOException {
    return false;
  }
}
