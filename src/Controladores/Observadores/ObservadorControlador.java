package Controladores.Observadores;

import java.io.IOException;
import java.util.ArrayList;

import Controladores.Controlador;
import Modelo.Registros.Registro;

/**
 * Created by Esteban on 29/5/2016.
 */
public class ObservadorControlador implements Observador {
  private Registro registro;
  private Controlador controlador;


  public ObservadorControlador(Controlador controlador, Registro registro) {
    this.controlador = controlador;
    this.registro = registro;
  }

  @Override
  public void actualizar() throws Exception {
    try {
      ArrayList<String> ultimaEntrada = controlador.getUltimaOperacion();
      registro.registrarEntrada(ultimaEntrada);

    } catch (IOException e) {
      System.out.println("Error al escribir en registro.");
      throw e;
    }
  }
}
