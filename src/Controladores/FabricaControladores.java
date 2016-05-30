package Controladores;

import java.io.IOException;

/**
 * Created by Esteban on 30/5/2016.
 */
public interface FabricaControladores {
  Controlador crearNuevoControlador() throws Exception;
  void agregarRegistrosAControlador(Controlador controlador) throws IOException;

}
