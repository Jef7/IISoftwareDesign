//import Vistas.PrestamosFrameController;

import Controladores.Controlador;
import Controladores.ControladorGUI;
import Controladores.FabricaControladoresConsola;
import Validaciones.Validacion;
import Vistas.GUI.PrestamosFrame;

/**
 * Created by Jeffrey on 26/5/2016.
 */
public class Main {
  public static void main(String[] args) {
//        //instancio un nuevo controller del prestamosFrame
//        PrestamosFrameController prestamosFrameController = new PrestamosFrameController();
//        //lo muestro
//        prestamosFrameController.showPrestamosFrame();
//    }

    Controlador controlador;

    try {
      if (args.length >= 1) {
        String arg0 = args[0];
        if (arg0.contentEquals("gui")) {
            //gui
            //instancio un nuevo controller del prestamosFrame
            Controlador prestamosFrameController = new ControladorGUI();
            //lo muestro
            //prestamosFrameController.showPrestamosFrame();
        }
      } else {
        FabricaControladoresConsola fabrica = new FabricaControladoresConsola();
        controlador = fabrica.crearNuevoControlador();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
