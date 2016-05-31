package Vistas.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controladores.Controlador;
import Controladores.ControladorGUI;
import Controladores.ControladorVistaDTO;
import Validaciones.Validacion;
import Validaciones.ValidacionTablasAmortizacion;
import Vistas.Vista;
import Vistas.VistaControladorDTO;

/**
 * Created by Jeffrey on 26/5/2016.
 */
public class PrestamosFrame extends JFrame implements Vista  {
  //definir el tamano de ventana
  public static final int WIDTH = 1600;
  public static final int HIGHT = 900;
  //paneles
  private JPanel mainPanel; //panel es la base
  private JPanel registroPanel; //panel hijo
  private JPanel resultadosPanel; //panel hijo

  // Etiquetas
  private JLabel lbl_nombre;
  private JLabel lbl_monto;
  private JLabel lbl_plazo;
  private JLabel lbl_interes;
  private JLabel lbl_sistemaAmortizacion;
  private JLabel lbl_moneda;

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

  // --- Resultados ---
  // Etiquetas
  private JLabel lbl_fechaHora;
  private JLabel lbl_tipoCambio;
  private JLabel lbl_infoCliente;
  private JLabel lbl_tabla;

  // Campos de texto
  private JTextField txt_fechaHora;
  private JTextField txt_tipoCambio;
  private JTextArea text_info;

  // Tabla
  private JTable table_amortizacion;

  // Botones
  private JButton btn_ok;

  // Fondo
  private JPanel fondoPanel;
  private JLabel lbl_fondo;
  private JPanel contenedorPanel;
  private JButton btn_nuevo;
  private JTextArea text_tabla;

    Validacion validacion;
    Controlador controlador;


  // Constructor
  public PrestamosFrame(Controlador controlador) {
      validacion = new ValidacionTablasAmortizacion();
      this.controlador = controlador;

      //setSize(WIDTH, HIGHT); //tamano ventana, pero en el Controller la ponemos en fullscreen
      setContentPane(mainPanel); // carga el panel base
//        mainPanel.add(registroPanel);
//        mainPanel.add(resultadosPanel);
      setLocationRelativeTo(null);// para centrar la ventana

      this.initComponents();
      this.initListeners();
  }



    @Override
    public VistaControladorDTO obtenerDatosEntrada() {
        VistaControladorDTO consulta = new VistaControladorDTO();

        String nuevoNombreCliente = ingresarNombre();
        String tipoMoneda = comBox_moneda.getSelectedItem().toString();////////////////////////////////
        double nuevoMontoCliente = ingresarMonto();
        int nuevoPlazoPrestamo = ingresarPlazo();
        double nuevaTasaInteres = ingresarInteres();
        int tipoAmortizacion = seleccionarTipoAmortizacion();

        consulta.setNombreCliente(nuevoNombreCliente);
        consulta.setNombreMoneda(tipoMoneda);
        consulta.setMontoPrestamo(nuevoMontoCliente);
        consulta.setPlazoPrestamo(nuevoPlazoPrestamo);
        consulta.setTasaInteres(nuevaTasaInteres);
        consulta.setTipoAmortizacion(tipoAmortizacion);

        return consulta;
    }

    @Override
    public void mostrarResultado(ControladorVistaDTO consulta) {
        txt_fechaHora.setText("");
        txt_tipoCambio.setText("");
        text_info.setText(  "Cliente: "+consulta.getNombreCliente()+"\n"+
                "Monto Otorgado: "+consulta.getMontoPrestamo()+" "+
                "de " +consulta.getNombreMoneda()+"\n"+
                "Plazo del Préstamo: "+consulta.getPlazoPrestamo()+"\n"+
                "Intéres Anual: "+consulta.getTasaInteres()+ "%" + "\n"+
                "Sistema Amortización: "+consulta.getTipoAmortizacion()
        );

        String tabla = "Numero Cuota\tDeuda Actual\tCuota Amortización\tCuota Interés\tTotal Cuota\n";
        for (String[] cuota : consulta.getTablaCuotas()) {
            for (int cuenta = 0; cuenta < cuota.length; cuenta++) {
                tabla  += cuota[cuenta] + (((cuenta + 1) < cuota.length) ? "\t\t\t" : "\n");
            }
        }
        //System.out.println(tabla);
        text_tabla.setText(tabla);
    }


    //carga los componentes del frame
    private void initComponents() {

        //prestamosFrame = new PrestamosFrame();
        //obtener getters de componentes
        //registrar
        PrestamosFrame prestamosFrame = this;
        txt_nombre = prestamosFrame.getTxt_nombre();
        comBox_moneda = prestamosFrame.getComBox_moneda();
        txt_monto = prestamosFrame.getTxt_monto();
        txt_plazo = prestamosFrame.getTxt_plazo();
        txt_interes = prestamosFrame.getTxt_interes();
        comBox_sistemaAmortizacion = prestamosFrame.getComBox_sistemaAmortizacion();
        btn_registrar = prestamosFrame.getBtn_registrar();
        //resultados
        btn_nuevo = prestamosFrame.getBtn_nuevo();
        txt_fechaHora = prestamosFrame.getTxt_fechaHora();
        txt_tipoCambio = prestamosFrame.getTxt_tipoCambio();
        text_info = prestamosFrame.getText_info();
        text_tabla = prestamosFrame.getText_tabla();
    }

    //listerner de los componentes
    private void initListeners() {
        btn_registrar.addActionListener(new Btn_registrarListener());
    }

    //alt + enter para implemetarlo
    //listener del boton
    private class Btn_registrarListener extends Component implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            obtenerDatosEntrada();



//            String s = ingresarNombre();
//            text_info.setText(s);
//            JOptionPane.showMessageDialog(this, s);
        }
    }


    //nombre cliente
    private String ingresarNombre() {
        String nombre = txt_nombre.getText();
        if (!validacion.contieneSoloLetras(nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre ingresado sólo puede contener letras.");
        }
        return nombre;
    }

    //nombre moneda
    private int ingresarMoneda() {
        int opcion = comBox_moneda.getSelectedIndex();

        if (!validacion.validarOpcion(opcion, 2)) {
            JOptionPane.showMessageDialog(this, "La opción seleccionada no es válida.");
        }
        return opcion;
    }

    //monto
    private Double ingresarMonto() {
        String sMonto =  txt_nombre.getText().trim();
        double monto = Double.parseDouble(sMonto);

        if (!validacion.validarMonto(monto, 1000)) {
            JOptionPane.showMessageDialog(this, "El monto ingresado es menor al mínimo.");
        }
        return monto;
    }

    //plazo
    private int ingresarPlazo() {
        String sPlazo = txt_plazo.getText();
        int plazo = Integer.parseInt(sPlazo);

        if (!validacion.validarPlazo(plazo)) {
            JOptionPane.showMessageDialog(this,"El plazo del préstamo está por debajo del mínimo.");
        }
        return plazo;
    }

    //interes
    private double ingresarInteres() {
        String sInteres = txt_plazo.getText();
        double interes = Double.parseDouble(sInteres);

        if (!validacion.validarDoublePositivo(interes)) {
            JOptionPane.showMessageDialog(this,"El interés ingresado debe ser positivo.");
        }
        return interes / 100.0;
    }

    //tipo amortizacion
    @Override
    public int seleccionarTipoAmortizacion() {
        int opcion = comBox_sistemaAmortizacion.getSelectedIndex();

        if (!validacion.validarOpcion(opcion, 3)) {
            JOptionPane.showMessageDialog(this, "La opción seleccionada no es válida.");
        }
        return opcion;
    }

    //limpia campos del formulario registro
    public void limpiarRegistro() {
        txt_nombre.setText("");
        comBox_moneda.setSelectedIndex(0);
        txt_monto.setText("");
        txt_plazo.setText("");
        txt_interes.setText("");
        comBox_sistemaAmortizacion.setSelectedIndex(0);
    }

    //limpia campos de resultados
    public void limpiarResultadors(){
        txt_fechaHora.setText("");
        txt_tipoCambio.setText("");
        text_info.setText("");
        text_tabla.setText("");
    }

    //  getters
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

    public JPanel getFondoPanel() {
        return fondoPanel;
    }

    public JLabel getLbl_fondo() {
        return lbl_fondo;
    }

    public JPanel getContenedorPanel() {
        return contenedorPanel;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public JTextArea getText_tabla() {
        return text_tabla;
    }
}
