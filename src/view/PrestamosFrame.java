package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeffrey on 26/5/2016.
 */
public class PrestamosFrame extends JFrame {
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

    //definir el tamano de ventana
    public static final int WIDTH = 500;
    public static final int HIGHT = 500;

    //constructor
    public PrestamosFrame() {
        setSize(WIDTH, HIGHT); //tamano ventana
        setContentPane(prestamosPanel); // carga el panel base
        setLocationRelativeTo(null);// para centrar la ventana
    }

    //getters
    public JLabel getLbl_nombre() {
        return lbl_nombre;
    }

    public JLabel getLbl_monto() {
        return lbl_monto;
    }

    public JLabel getLbl_plazo() {
        return lbl_plazo;
    }

    public JLabel getLbl_sistemaAmortizacion() {
        return lbl_sistemaAmortizacion;
    }

    public JLabel getLbl_moneda() {
        return lbl_moneda;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public JTextField getTxt_monto() {
        return txt_monto;
    }

    public JTextField getTxt_plazo() {
        return txt_plazo;
    }

    public JComboBox getComBox_sistemaAmortizacion() {
        return comBox_sistemaAmortizacion;
    }

    public JComboBox getComBox_moneda() {
        return comBox_moneda;
    }
}
