package Modelo.Registros;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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

  @Override
  protected void finalize(){
    try {
      cerrarArchivo();
    } catch (IOException e) {
      System.out.println("No se pudo cerrar el archivo.");
    }
  }

  protected FileOutputStream generarArchivo(String rutaArchivo) throws IOException {
    return new FileOutputStream(rutaArchivo);
  }

  protected void cerrarArchivo() throws IOException {
    try {
      streamArchivo.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

  public abstract boolean registrarEntrada(ArrayList<String> contenido) throws IOException;



}
