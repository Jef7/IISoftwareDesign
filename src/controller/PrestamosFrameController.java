package controller;

import view.PrestamosFrame;
import javax.swing.*;
/**
 * Created by Jeffrey on 26/5/2016.
 */
public class PrestamosFrameController {
    private PrestamosFrame prestamosFrame; //referencia de la vista

    private JPanel prestamosPanel; //panel es la base
    private JLabel lbl_nombre;
    private JLabel lbl_monto;
    private JLabel lbl_plazo;
    private JLabel lbl_sistemaAmortizacion;
    private JLabel lbl_moneda;
    private JTextField txt_nombre;
    private JTextField txt_monto;
    private JTextField txt_plazo;
    private JComboBox comBox_sistemaAmortizacion;
    private JComboBox comBox_moneda;

    //constructor
    public PrestamosFrameController() {
        initComponents();
    }

    //muestra la ventana
    public void showPrestamosFrame(){
        prestamosFrame.setVisible(true);
    }

    //carga los componentes del frame
    private void initComponents() {
        prestamosFrame = new PrestamosFrame();
        //obtener getters de componentes
    }

    //listerner de los componentes
}
