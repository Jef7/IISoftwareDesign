package Modelo.Registros;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Esteban on 29/5/2016.
 */
public abstract class Registro {
  protected String rutaArchivo;
  protected FileOutputStream streamArchivo;

  protected Registro(String rutaArchivo) throws IOException {
    this.rutaArchivo = rutaArchivo;
    this.streamArchivo = generarArchivo(rutaArchivo);
  }

  protected abstract FileOutputStream generarArchivo(String rutaArchivo) throws IOException;

  public abstract boolean registrarEntrada(String[] contenido) throws IOException;

  protected void cerrarArchivo() throws IOException {
    try {
      streamArchivo.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

}
