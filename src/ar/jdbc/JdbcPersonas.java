package ar.jdbc;

import java.util.List;

import ar.model.Direccion;
import ar.model.Persona;
import ar.model.Telefono;
import ar.servicios.Personas;

public class JdbcPersonas implements Personas {

 //constructor con dependencias
 
 @Override
 public List<Persona> personas() {
  Persona p1 = new Persona("Joaquin", "Garcia");
  Persona p2 = new Persona("Emilio", "Peroz");
  Persona p3 = new Persona("Ernesto", "Perez");
  
  p1.addDireccion("San Martin 123");
  p1.addDireccion("Belgrano 34");
  p1.addDireccion("Bs As 908");
  
  p1.addTelefono("12345678");
  p1.addTelefono("45335678");
  p2.addTelefono("45633334");
  p3.addTelefono("11222356");

  return List.of(p1, p2, p3); 
 }
}
