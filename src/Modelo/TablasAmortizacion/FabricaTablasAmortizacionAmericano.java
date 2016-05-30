package Modelo.TablasAmortizacion;

import Validaciones.ValidacionTablasAmortizacion;

/**
 * Created by Esteban on 28/5/2016.
 */
public class FabricaTablasAmortizacionAmericano implements FabricaTablasAmortizacion {

  @Override
  public TablaAmortizacionDTO generarInfoNuevaTablaAmortizacion
      (Controladores.ControladorModeloDTO datos) throws Exception {
    try {
      TablaAmortizacion nuevaTabla = new TablaAmortizacionAmericano
          (datos, new ValidacionTablasAmortizacion());
      return nuevaTabla.generarInforme(datos);
    } catch (Exception e) {
      throw e;
    }
  }
}
