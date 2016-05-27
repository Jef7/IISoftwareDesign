package view;

import javax.swing.*;

/**
 * Created by Jeffrey on 26/5/2016.
 */
public class PrestamosFrame extends JFrame {
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
    private JPanel contenedorPanel;


    //definir el tamano de ventana
    public static final int WIDTH = 1920;
    public static final int HIGHT = 1080;

    //constructor
    public PrestamosFrame() {
        //setSize(WIDTH, HIGHT); //tamano ventana, pero en el Controller la ponemos en fullscreen
        setContentPane(mainPanel); // carga el panel base
//        mainPanel.add(registroPanel);
//        mainPanel.add(resultadosPanel);
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

    public JLabel getLbl_interes() {
        return lbl_interes;
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

    public JTextField getTxt_interes() {
        return txt_interes;
    }

    public JComboBox getComBox_sistemaAmortizacion() {
        return comBox_sistemaAmortizacion;
    }

    public JComboBox getComBox_moneda() {
        return comBox_moneda;
    }

    public JButton getBtn_registrar() {
        return btn_registrar;
    }

    public JLabel getLbl_fechaHora() {
        return lbl_fechaHora;
    }

    public JLabel getLbl_tipoCambio() {
        return lbl_tipoCambio;
    }

    public JLabel getLbl_infoCliente() {
        return lbl_infoCliente;
    }

    public JLabel getLbl_tabla() {
        return lbl_tabla;
    }

    public JTextField getTxt_fechaHora() {
        return txt_fechaHora;
    }

    public JTextField getTxt_tipoCambio() {
        return txt_tipoCambio;
    }

    public JTextArea getText_info() {
        return text_info;
    }

    public JTable getTable_amortizacion() {
        return table_amortizacion;
    }

    public JButton getBtn_ok() {
        return btn_ok;
    }
}
