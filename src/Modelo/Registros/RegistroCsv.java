package Modelo.Registros;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Esteban on 29/5/2016.
 */
public class RegistroCsv extends Registro {
  // TODO Generar archivo CSV
  public RegistroCsv(String rutaArchivo) throws IOException {
    super(rutaArchivo);
  }

  @Override
  public boolean registrarEntrada(ArrayList<String> contenido) throws IOException {
    return false;
  }
}
