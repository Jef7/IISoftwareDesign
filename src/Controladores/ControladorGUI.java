package Controladores;

import javax.swing.*;

import Validaciones.Validacion;
import Validaciones.ValidacionTablasAmortizacion;
import Vistas.Consola.Consola;
import Vistas.GUI.PrestamosFrame;
import Vistas.Vista;
import Vistas.VistaControladorDTO;

/**
 * Created by Esteban on 30/5/2016.
 */
public class ControladorGUI extends Controlador {

    private PrestamosFrame prestamosFrame; //referencia de la vista

    // Campos de texto
    private JTextField txt_nombre;
    private JTextField txt_monto;
    private JTextField txt_plazo;
    private JTextField txt_interes;

    // Campos de selección
    private JComboBox comBox_sistemaAmortizacion;
    private JComboBox comBox_moneda;

    // Botones
    private JButton btn_registrar;

    // Campos de texto
    private JTextField txt_fechaHora;
    private JTextField txt_tipoCambio;
    private JTextArea text_info;
    private JTextArea text_tabla;

  public ControladorGUI() {
    super(new ValidacionTablasAmortizacion());
    this.prestamosFrame = new PrestamosFrame(this);
    this.mostrarPantalla();
  }


    //muestra la ventana
    private void showPrestamosFrame(){
        prestamosFrame.setVisible(true);
        prestamosFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);//para poner la venta en FULLSCREEN
    }

  private void mostrarPantalla() {
      prestamosFrame.setVisible(true);
      prestamosFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

    @Override
    public void generarNuevaTablaAmortizacion() throws Exception {

    }
}
