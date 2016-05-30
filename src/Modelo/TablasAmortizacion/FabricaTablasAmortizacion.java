package Modelo.TablasAmortizacion;

import Controladores.ControladorModeloDTO;

/**
 * Created by Esteban on 28/5/2016.
 */
public interface FabricaTablasAmortizacion {
  TablaAmortizacionDTO generarInfoNuevaTablaAmortizacion(ControladorModeloDTO datos)
      throws Exception;
}
