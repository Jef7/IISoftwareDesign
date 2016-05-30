package Controladores;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import Controladores.Observadores.Observador;
import Modelo.FabricasTablasAmortizacion.FabricaTablasAmortizacion;
import Modelo.FabricasTablasAmortizacion.FabricaTablasAmortizacionAleman;
import Modelo.FabricasTablasAmortizacion.FabricaTablasAmortizacionAmericano;
import Modelo.FabricasTablasAmortizacion.FabricaTablasAmortizacionFrances;
import Modelo.TablasAmortizacion.TablaAmortizacionDTO;
import Validaciones.Validacion;
import Vistas.VistaControladorDTO;

/**
 * Created by Esteban on 29/5/2016.
 */
public abstract class Controlador {
  ArrayList<Observador> observadores;
  Validacion validadorEntradas;
  String[] ultimaOperacion;

  protected Controlador(Validacion validadorEntradas) {
    observadores = new ArrayList<>();
    this.validadorEntradas = validadorEntradas;
    this.ultimaOperacion = null;
  }

  protected void agregarObservador(Observador observador) {
    if (!observadores.contains(observador)) {
      observadores.add(observador);
    }
  }

  protected void notificarObservadores() throws Exception {
    for (Observador observador : observadores) {
      observador.actualizar();
    }
  }

  public String[] getUltimaOperacion() {
    return ultimaOperacion;
  }

  protected ControladorModeloDTO generarConsultaHaciaModelo
      (VistaControladorDTO consultaCliente) throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO nuevaConsultaModelo = new ControladorModeloDTO();

    nuevaConsultaModelo.nombreCliente = consultaCliente.getNombreCliente();
    nuevaConsultaModelo.montoPrestamo = consultaCliente.getMontoPrestamo();
    nuevaConsultaModelo.plazoPrestamo = consultaCliente.getPlazoPrestamo();
    nuevaConsultaModelo.tasaInteres = consultaCliente.getTasaInteres();

    return nuevaConsultaModelo;
  }

  protected void validarEntradas(VistaControladorDTO entrada) throws Exception {
    if (!validadorEntradas.contieneSoloLetras(entrada.getNombreCliente())) {
      throw new InvalidParameterException("El nombre del cliente sólo puede tener letras");
    }
    if (!validadorEntradas.validarPlazo(entrada.getPlazoPrestamo())) {
      throw new InvalidParameterException("El plazo del préstamo debe ser al menos un año");
    }
    if (!validadorEntradas.validarMonto(entrada.getMontoPrestamo(), 1000)) {
      throw new InvalidParameterException("El monto mínimo del prestamo es de 1000 colones");
    }
    if (!validadorEntradas.validarDoublePositivo(entrada.getTasaInteres())) {
      throw new InvalidParameterException("La tasa de interés debe ser un valor positivo");
    }
  }

  ControladorVistaDTO generarReporteVista(TablaAmortizacionDTO datosNuevaTabla)
      throws Exception {
    // TODO Completar cuando se haya implementado adaptadores y web services.
    ControladorVistaDTO respuesta = new ControladorVistaDTO();
    respuesta.nombreCliente = datosNuevaTabla.getNombreCliente();
    respuesta.montoPrestamo = String.format("%.2f", datosNuevaTabla.getMontoPrestamo());
    respuesta.plazoPrestamo = Integer.toString(datosNuevaTabla.getPlazoPrestamo()) + " años";
    respuesta.tasaInteres = String.format("%.2f", (datosNuevaTabla.getTasaInteres() * 100)) + "%";
    respuesta.tablaCuotas.addAll(datosNuevaTabla.getTablaCuotas());

    //respuesta.fechaHora = ;
    //respuesta.tipoCambio = ;

    return respuesta;
  }

  TablaAmortizacionDTO generarInfoNuevaTablaAmortizacion(FabricaTablasAmortizacion fabricante,
                                                         ControladorModeloDTO consulta)
      throws Exception {
    return fabricante.generarInfoNuevaTablaAmortizacion(consulta);
  }

  protected ControladorVistaDTO reporteNuevaTablaAmortizacionAleman
      (VistaControladorDTO consultaCliente)
      throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO consultaValida = generarConsultaHaciaModelo(consultaCliente);
    FabricaTablasAmortizacion fabricanteTabla = new FabricaTablasAmortizacionAleman();

    TablaAmortizacionDTO infoTabla = generarInfoNuevaTablaAmortizacion
        (fabricanteTabla, consultaValida);
    return generarReporteVista(infoTabla);
  }

  protected ControladorVistaDTO reporteNuevaTablaAmortizacionAmericano
      (VistaControladorDTO consultaCliente)
      throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO consultaValida = generarConsultaHaciaModelo(consultaCliente);
    FabricaTablasAmortizacion fabricanteTabla = new FabricaTablasAmortizacionAmericano();

    TablaAmortizacionDTO infoTabla = generarInfoNuevaTablaAmortizacion
        (fabricanteTabla, consultaValida);
    return generarReporteVista(infoTabla);
  }

  protected ControladorVistaDTO reporteNuevaTablaAmortizacionFrances
      (VistaControladorDTO consultaCliente)
      throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO consultaValida = generarConsultaHaciaModelo(consultaCliente);
    FabricaTablasAmortizacion fabricanteTabla = new FabricaTablasAmortizacionFrances();

    TablaAmortizacionDTO infoTabla = generarInfoNuevaTablaAmortizacion
        (fabricanteTabla, consultaValida);
    return generarReporteVista(infoTabla);
  }

  public abstract ControladorVistaDTO reporteNuevaTablaAmortizacionAleman();
  public abstract ControladorVistaDTO reporteNuevaTablaAmortizacionAmericano();
  public abstract ControladorVistaDTO reporteNuevaTablaAmortizacionFrances();


  //TODO Capa adaptador
//  public FechaHoraDTO consultarFechaHora(){
//
//  }
//
//  public TipoCambioDTO consultarTipoCambio(){
//
//  }
}
