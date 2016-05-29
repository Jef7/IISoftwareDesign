package Vistas;

import javax.swing.*;
/**
 * Created by Jeffrey on 26/5/2016.
 *
 */
public class PrestamosFrameController {
    private PrestamosFrame prestamosFrame; //referencia de la vista
    private JPanel prestamosPanel; //panel es la base

    //paneles
    private JPanel mainPanel; //panel es la base
    private JPanel registroPanel; //panel hijo
    private JPanel resultadosPanel; //panel hijo

    //REGISTRO
    //labels
    private JLabel lbl_nombre;
    private JLabel lbl_monto;
    private JLabel lbl_plazo;
    private JLabel lbl_interes;
    private JLabel lbl_sistemaAmortizacion;
    private JLabel lbl_moneda;
    //text fields
    private JTextField txt_nombre;
    private JTextField txt_monto;
    private JTextField txt_plazo;
    private JTextField txt_interes;
    //combo box
    private JComboBox comBox_sistemaAmortizacion;
    private JComboBox comBox_moneda;
    //botones
    private JButton btn_registrar;

    //RESULTADOS
    //labels
    private JLabel lbl_fechaHora;
    private JLabel lbl_tipoCambio;
    private JLabel lbl_infoCliente;
    private JLabel lbl_tabla;
    //text fields
    private JTextField txt_fechaHora;
    private JTextField txt_tipoCambio;
    private JTextArea text_info;
    //tabla
    private JTable table_amortizacion;
    //botones
    private JButton btn_ok;
    //fondo
    private JPanel fondoPanel;
    private JLabel lbl_fondo;

    //constructor
    public PrestamosFrameController() {
        initComponents();
    }

    //muestra la ventana
    public void showPrestamosFrame(){
        prestamosFrame.setVisible(true);

        prestamosFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);//para poner la venta en FULLSCREEN
    }

    //carga los componentes del frame
    private void initComponents() {
        prestamosFrame = new PrestamosFrame();
        //obtener getters de componentes
    }

    //listerner de los componentes
}
