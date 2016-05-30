package Vistas;

import Controladores.ControladorVistaDTO;

/**
 * Created by Esteban on 29/5/2016.
 */
public interface Vista {
  VistaControladorDTO obtenerDatosEntrada();
  void mostrarResultado(ControladorVistaDTO resultado);
}
