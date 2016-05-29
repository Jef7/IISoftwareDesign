//import Vistas.PrestamosFrameController;

import Modelo.TablasAmortizacion.TablaAmortizacion;
import Modelo.TablasAmortizacion.TablaAmortizacionAleman;

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

      TablaAmortizacion prueba = new TablaAmortizacionAleman("Ejemplo", 5, 1000000, 0.15);
      prueba.generarInforme();

      System.out.println("READY");

    }
}
