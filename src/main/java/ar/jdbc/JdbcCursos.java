package ar.jdbc;

import java.util.List;

import ar.model.Curso;

import ar.servicios.Cursos;


public class JdbcCursos implements Cursos {

 @Override
 public List<Curso> cursos() {
  return List.of(new Curso("Objetos 1"), new Curso("Seminario del lenguaje"),
    new Curso("React"), new Curso("Angular")); 
 }

}
