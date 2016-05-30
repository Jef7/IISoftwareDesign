package Modelo.Registros;

import java.io.IOException;

/**
 * Created by Esteban on 30/5/2016.
 */
public class FabricaRegistrosCsv implements FabricaRegistros {
  @Override
  public Registro nuevoRegistro(String nombreArchivo) throws IOException {
    return new RegistroCsv(nombreArchivo);
  }
}
