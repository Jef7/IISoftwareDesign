package Modelo.Registros;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Esteban on 29/5/2016.
 */
public class RegistroXml extends Registro {
  // TODO Generar archivo XML

  protected RegistroXml(String rutaArchivo) throws IOException {
    super(rutaArchivo);
  }

  @Override
  protected FileOutputStream generarArchivo(String rutaArchivo) throws IOException {
    return null;
  }

  @Override
  public boolean registrarEntrada(String[] contenido) throws IOException {
    return false;
  }
}