package Modelo.FabricasTablasAmortizacion;

import Modelo.TablasAmortizacion.TablaAmortizacion;
import Modelo.TablasAmortizacion.TablaAmortizacionDTO;
import Modelo.TablasAmortizacion.TablaAmortizacionFrances;

/**
 * Created by Esteban on 28/5/2016.
 */
public class FabricaTablasAmortizacionFrances implements FabricaTablasAmortizacion {

  @Override
  public TablaAmortizacionDTO generarInfoNuevaTablaAmortizacion
      (Controladores.ControladorModeloDTO datos) throws Exception {
    try {
      TablaAmortizacion nuevaTabla = new TablaAmortizacionFrances(datos);
      return nuevaTabla.generarInforme();
    } catch (Exception e){
      throw e;
    }
  }
}
