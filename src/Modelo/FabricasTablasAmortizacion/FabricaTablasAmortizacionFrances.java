package Modelo.FabricasTablasAmortizacion;

import Controladores.ClienteDTO;
import Modelo.TablasAmortizacion.TablaAmortizacion;
import Modelo.TablasAmortizacion.TablaAmortizacionAleman;

/**
 * Created by Esteban on 28/5/2016.
 */
public class FabricaTablasAmortizacionFrances extends FabricaTablasAmortizacion {

  public FabricaTablasAmortizacionFrances() {}

  @Override
  public TablaAmortizacion generarTablaAmortizacion(ClienteDTO consultaCliente) {
    return new TablaAmortizacionAleman(consultaCliente.getNombreCliente(),
        consultaCliente.getPlazoPrestamo(), consultaCliente.getMontoPrestamo(),
        consultaCliente.getTasaInteres());
  }
}