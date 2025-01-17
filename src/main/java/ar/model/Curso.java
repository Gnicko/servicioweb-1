package ar.model;

import java.util.Map;

public class Curso {

 private String nombre;
 private Long id;
 public Curso(String nombre) {
	 
	 var check = new NotNullNotEmpty("curso", nombre);
	  check.throwOnError();
	  this.nombre = nombre;
	  
	  long leftLimit = 1L;
	  long rightLimit = 1000L;
	  this.id = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	 }

 public String numero() {
  return nombre;
 }



 @Override
 public String toString() {
  return "curso [nombre=" + nombre + "]";
 }
 


 public Map<String, Object> toMap() {
  return Map.of("id", id, "curso", nombre);
 }
 

}
