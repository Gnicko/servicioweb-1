package ar.jdbc;

import java.util.List;
import java.util.stream.Collectors;

import ar.model.Curso;
import ar.model.Estudiante;
import ar.servicios.Estudiantes;

public class JdbcEstudiantes implements Estudiantes {

 //constructor con dependencias
 
 @Override
 public List<Estudiante> estudiantes(String apellido) {
  Estudiante e1 = new Estudiante("Nicolas", "Gomez-Tolosa");
  Estudiante e2 = new Estudiante("Juan", "Hernandez");
  Estudiante e3 = new Estudiante("Ricky", "Ford");
  
  
  e1.addCurso("React");
  e1.addCurso("Seminario del lenguaje");
  e2.addCurso("Orientacion a objetos");
  e3.addCurso("Angular");
  e3.addCurso("React");
  
  var estudiante = List.of(e1, e2, e3);
  
  if (apellido == null || apellido.isEmpty())
   return estudiante;
  
  return estudiante.stream().filter((e) -> {
   return e.containsApellido(apellido);
  }).collect(Collectors.toList());
 }

 @Override
 public void crearEstudiante(String nombre, String apellido,
   String[] cursos) {

  Estudiante e = new Estudiante(nombre, apellido,cursos);
  
  
  System.out.println(e.toString());
  System.out.println(cursos);
 }
}
