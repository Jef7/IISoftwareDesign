package Modelo.Registros;

import java.io.IOException;

/**
 * Created by Esteban on 30/5/2016.
 */
public interface FabricaRegistros {
  Registro nuevoRegistro(String nombreArchivo) throws IOException;
}
