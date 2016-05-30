//import Vistas.PrestamosFrameController;

import Controladores.Controlador;
import Controladores.FabricaControladoresConsola;

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

        try {
            Controlador consola = new FabricaControladoresConsola().crearNuevoControlador();
            consola.reporteNuevaTablaAmortizacionAleman();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
