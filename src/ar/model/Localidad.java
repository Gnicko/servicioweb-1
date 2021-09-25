package ar.model;

import java.util.Map;

public class Localidad {

 private Long id;
 private String nombre;
 
 public Localidad(String nombre) {
  var check = new NotNullNotEmpty("localidad", nombre);
  check.throwOnError();
  
  this.nombre = nombre;  
  long leftLimit = 1L;
  long rightLimit = 1000L;
  this.id = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
 }

 public Map<String, Object> toMap() {
  return Map.of("id", id, "localidad", nombre);
 }
 
 @Override
 public String toString() {
  return "Localidad [nombre=" + nombre + "]";
 }
}
