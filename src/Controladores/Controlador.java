package Controladores;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import Controladores.Observadores.Observador;
import Modelo.TablasAmortizacion.FabricaTablasAmortizacion;
import Modelo.TablasAmortizacion.FabricaTablasAmortizacionAleman;
import Modelo.TablasAmortizacion.FabricaTablasAmortizacionAmericano;
import Modelo.TablasAmortizacion.FabricaTablasAmortizacionFrances;
import Modelo.TablasAmortizacion.TablaAmortizacionDTO;
import Validaciones.Validacion;
import Vistas.Vista;
import Vistas.VistaControladorDTO;

/**
 * Created by Esteban on 29/5/2016.
 */
public abstract class Controlador {
  ArrayList<Observador> observadores;
  Validacion validadorEntradas;
  ArrayList<String> ultimaOperacion;
  Vista vista;

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

  public ArrayList<String> getUltimaOperacion() {
    return ultimaOperacion;
  }

  protected void reportarTablaCreada(ControladorModeloDTO entrada, String tipoTabla)
      throws Exception {
    try {
      ultimaOperacion = new ArrayList<>();

      ultimaOperacion.add("Operación:GenerarTablaAmortizacion");
      ultimaOperacion.add("TipoAmortización:" + tipoTabla);
      ultimaOperacion.add("NombreCliente:" + entrada.nombreMoneda);
      ultimaOperacion.add("MontoPrestamo:" + String.format("%.2f", entrada.montoPrestamo));
      ultimaOperacion.add("PlazoPrestamo:" + Integer.toString(entrada.plazoPrestamo));
      ultimaOperacion.add("TasaInteres:" + String.format("%.2f", entrada.montoPrestamo));

      // TODO Agregar fecha y hora de consulta (Chucky)
//    ultimaOperacion.add("FechaHora:"+"");

      notificarObservadores();
    } catch (Exception e){
      throw new Exception("No se pudo reportar la operación.");
    }
  }

  protected ControladorModeloDTO generarConsultaValidaModelo
      (VistaControladorDTO consultaCliente) throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO nuevaConsultaModelo = new ControladorModeloDTO();

    nuevaConsultaModelo.nombreCliente = consultaCliente.getNombreCliente();
    nuevaConsultaModelo.montoPrestamo = consultaCliente.getMontoPrestamo();
    nuevaConsultaModelo.plazoPrestamo = consultaCliente.getPlazoPrestamo();
    nuevaConsultaModelo.tasaInteres = consultaCliente.getTasaInteres();


    // TODO Incorporar consulta moneda externa.
    if (consultaCliente.getNombreMoneda().contentEquals("Colones")){
      nuevaConsultaModelo.nombreMoneda = "0";
      nuevaConsultaModelo.cambioMoneda = 1;
    } else {
//      nuevaConsultaModelo.nombreMoneda = ...
//      nuevaConsultaModelo.cambioMoneda = ...
    }


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

  ControladorVistaDTO generarReporteVista(TablaAmortizacionDTO datosNuevaTabla, String nombreMoneda)
      throws Exception {
    ControladorVistaDTO respuesta = new ControladorVistaDTO();

    respuesta.nombreCliente = datosNuevaTabla.getNombreCliente();
    respuesta.montoPrestamo = String.format("%.2f", datosNuevaTabla.getMontoPrestamo());
    respuesta.plazoPrestamo = Integer.toString(datosNuevaTabla.getPlazoPrestamo());
    respuesta.tasaInteres = String.format("%.2f", (datosNuevaTabla.getTasaInteres() * 100)) + "%";
    respuesta.tipoAmortizacion = datosNuevaTabla.getTipoAmortizacion();
    respuesta.tablaCuotas.addAll(datosNuevaTabla.getTablaCuotas());

    // TODO Completar cuando se haya implementado adaptadores y web services.
    //respuesta.fechaHora = ;

    if (nombreMoneda.contentEquals("Colones")) {
      // TODO Mostrar tipo de cambio en dólares para colones.
//      respuesta.tipoCambio = ...
//      respuesta.nombreMoneda = ...
    }
    return respuesta;
  }

  TablaAmortizacionDTO generarInfoNuevaTablaAmortizacion(FabricaTablasAmortizacion fabricante,
                                                         ControladorModeloDTO consulta)
      throws Exception {
    // TODO Completar cuando se haya implementado adaptadores y web services.

    // consulta.nombreMoneda = ...
    // consulta.cambioMoneda = ...

    return fabricante.generarInfoNuevaTablaAmortizacion(consulta);
  }


  public abstract void generarNuevaTablaAmortizacion() throws Exception;


  protected ControladorVistaDTO reporteNuevaTablaAmortizacionAleman
      (VistaControladorDTO consultaCliente)
      throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO consultaValida = generarConsultaValidaModelo(consultaCliente);
    FabricaTablasAmortizacion fabricanteTabla = new FabricaTablasAmortizacionAleman();

    TablaAmortizacionDTO infoTabla = generarInfoNuevaTablaAmortizacion
        (fabricanteTabla, consultaValida);

    return generarReporteVista(infoTabla, consultaValida.getNombreMoneda());
  }

  protected ControladorVistaDTO reporteNuevaTablaAmortizacionAmericano
      (VistaControladorDTO consultaCliente)
      throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO consultaValida = generarConsultaValidaModelo(consultaCliente);
    FabricaTablasAmortizacion fabricanteTabla = new FabricaTablasAmortizacionAmericano();

    TablaAmortizacionDTO infoTabla = generarInfoNuevaTablaAmortizacion
        (fabricanteTabla, consultaValida);

    return generarReporteVista(infoTabla, consultaValida.getNombreMoneda());
  }

  protected ControladorVistaDTO reporteNuevaTablaAmortizacionFrances
      (VistaControladorDTO consultaCliente)
      throws Exception {
    validarEntradas(consultaCliente);

    ControladorModeloDTO consultaValida = generarConsultaValidaModelo(consultaCliente);
    FabricaTablasAmortizacion fabricanteTabla = new FabricaTablasAmortizacionFrances();

    TablaAmortizacionDTO infoTabla = generarInfoNuevaTablaAmortizacion
        (fabricanteTabla, consultaValida);

    return generarReporteVista(infoTabla, consultaValida.getNombreMoneda());
  }


  //TODO Capa adaptador y web services
//  public FechaHoraDTO obtenerFechaHora(){
//
//  }
//
//  public TipoCambioDTO obtenerTipoCambio(String nombreMoneda){
//
//  }
}
