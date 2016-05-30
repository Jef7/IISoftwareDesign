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

  protected ControladorConsola(Validacion validadorEntradas) {
    super(validadorEntradas);
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionAleman() {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada = consola.obtenerDatosEntrada();

    try {
      ControladorVistaDTO resultado = super.reporteNuevaTablaAmortizacionAleman(entrada);
      return resultado;
    } catch (Exception e){
      return null;
    }
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionAmericano() {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada = consola.obtenerDatosEntrada();

    try {
      return super.reporteNuevaTablaAmortizacionAmericano(entrada);
    } catch (Exception e){
      return null;
    }
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionFrances() {
    Vista consola = new Consola(new ValidacionTablasAmortizacion());
    VistaControladorDTO entrada = consola.obtenerDatosEntrada();

    try {
      return super.reporteNuevaTablaAmortizacionFrances(entrada);
    } catch (Exception e){
      return null;
    }
  }
}
