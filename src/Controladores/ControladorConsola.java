package Controladores;

import Validaciones.Validacion;
import Vistas.Consola.Consola;
import Vistas.VistaControladorDTO;

/**
 * Created by Esteban on 30/5/2016.
 */
public class ControladorConsola extends Controlador {


  protected ControladorConsola(Validacion validadorEntradas) throws Exception {
    super(validadorEntradas);
    vista = new Consola(validadorEntradas);
  }

  @Override
  public void generarNuevaTablaAmortizacion() throws Exception {
    VistaControladorDTO entrada = vista.obtenerDatosEntrada();
    int opcion = vista.seleccionarTipoAmortizacion();

    ControladorVistaDTO resultado = null;

    switch(opcion){
      case 1:
        resultado = reporteNuevaTablaAmortizacionAleman(entrada);
        vista.mostrarResultado(resultado);
        break;
      case 2:
        resultado = reporteNuevaTablaAmortizacionAmericano(entrada);
        vista.mostrarResultado(resultado);
        break;
      case 3:
        resultado = reporteNuevaTablaAmortizacionFrances(entrada);
        vista.mostrarResultado(resultado);
        break;
      case 0:
        System.out.println("Operación cancelada.");
        return;
      default:
        throw new RuntimeException("Operación inválida.");
    }

    if (resultado != null) {
      vista.mostrarResultado(resultado);
    }
  }
}
