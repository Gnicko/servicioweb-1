package ar.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.model.Persona;
import ar.servicios.Personas;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class WebAPI {

 private Personas personas;
 private int webPort;

 public WebAPI(Personas personas, int webPort) {
  this.personas = personas;
  this.webPort = webPort;
 }

 public void start() {
  Javalin app = Javalin.create(config -> {
   config.enableCorsForAllOrigins();
  }).start(this.webPort);
  app.get("/personas", traerPersonas());
  app.post("/personas", crearPersona());

  app.exception(Exception.class, (e, ctx) -> {
   ctx.json(Map.of("result", "error", "message", e.getMessage()));
   // log error in a stream...
  });
 }

 private Handler crearPersona() {
  return ctx -> {
   PersonaDto dto = ctx.bodyAsClass(PersonaDto.class);
   this.personas.crearPersona(dto.getNombre(), dto.getApellido(),
     dto.getDireccion(), dto.getTelefonos());
   ctx.json(Map.of("result", "success"));
  };
 }

 private Handler traerPersonas() {
  return ctx -> {
   String apellido = ctx.queryParam("apellido");
   List<Persona> personas = this.personas.personas(apellido);

   var list = new ArrayList<Map<String, Object>>();

   for (Persona p : personas) {
    list.add(p.toMap());
   }

   ctx.json(Map.of("result", "success", "personas", list));

  };
 }
}
