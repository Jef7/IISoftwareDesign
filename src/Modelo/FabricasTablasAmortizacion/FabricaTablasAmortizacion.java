package Modelo.FabricasTablasAmortizacion;

import Controladores.ClienteDTO;
import Modelo.TablasAmortizacion.TablaAmortizacion;
import Modelo.TablasAmortizacion.TablaAmortizacionDTO;

/**
 * Created by Esteban on 28/5/2016.
 */
public abstract class FabricaTablasAmortizacion {
  public abstract TablaAmortizacion generarTablaAmortizacion(ClienteDTO consultaCliente);
  public TablaAmortizacionDTO generarInformeTablaAmortizacion(TablaAmortizacion tabla) {
    return tabla.generarInforme();
  }
}
