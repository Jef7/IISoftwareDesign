package Controladores;

import Validaciones.Validacion;
import Validaciones.ValidacionTablasAmortizacion;
import Vistas.Consola.Consola;
import Vistas.Vista;
import Vistas.VistaControladorDTO;

/**
 * Created by Esteban on 30/5/2016.
 */
public class ControladorConsola extends Controlador {

  protected ControladorConsola(Validacion validadorEntradas) throws Exception {
    super(validadorEntradas);

    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entradaUsuario =  consola.obtenerDatosEntrada();

    int tipoAmortizacion = consola.seleccionarTipoAmortizacion();

  }

  private ControladorVistaDTO seleccionarTipoTablaAmortizacion() throws Exception {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada =  consola.obtenerDatosEntrada();

    int opcion = consola.seleccionarTipoAmortizacion();

    try {
      switch (opcion) {
        case 1:
          return reporteNuevaTablaAmortizacionAleman();
        case 2:
          return reporteNuevaTablaAmortizacionAmericano();
        case 3:
          return reporteNuevaTablaAmortizacionFrances();
        default:
          break;
      }
    } catch (Exception e) {
      throw e;
    }
    throw new RuntimeException("Operación cancelada");
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionAleman() throws Exception {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada = consola.obtenerDatosEntrada();

    try {
      ControladorVistaDTO resultado = super.reporteNuevaTablaAmortizacionAleman(entrada);
      consola.mostrarResultado(resultado);
      return resultado;
    } catch (Exception e){
      return null;
    }
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionAmericano() throws Exception {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada = consola.obtenerDatosEntrada();

    try {
      return super.reporteNuevaTablaAmortizacionAmericano(entrada);
    } catch (Exception e){
      return null;
    }
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionFrances() throws Exception {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada = consola.obtenerDatosEntrada();

    try {
      return super.reporteNuevaTablaAmortizacionFrances(entrada);
    } catch (Exception e){
      return null;
    }
  }
}
