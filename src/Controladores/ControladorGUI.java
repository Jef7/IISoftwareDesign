package Controladores;

import javax.swing.*;

import Validaciones.ValidacionTablasAmortizacion;
import Vistas.GUI.PrestamosFrame;

/**
 * Created by Esteban on 30/5/2016.
 */
public class ControladorGUI extends Controlador {
  private PrestamosFrame interfazGrafica;

  public ControladorGUI() {
    super(new ValidacionTablasAmortizacion());
    this.interfazGrafica = new PrestamosFrame();
    this.mostrarPantalla();
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionAleman() {
    return null;
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionAmericano() {
    return null;
  }

  @Override
  public ControladorVistaDTO reporteNuevaTablaAmortizacionFrances() {
    return null;
  }

  private void mostrarPantalla() {
    interfazGrafica.setVisible(true);
    interfazGrafica.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
}
