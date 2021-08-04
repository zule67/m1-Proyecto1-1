package com.example.demo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Hibrido;
import com.example.demo.service.HibridoService;

@Path("/hibrido")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class HibridoController {

	private HibridoService hibridoService;

	public HibridoController(HibridoService hibridoService) {
		this.hibridoService = hibridoService;
	}

	/**
	 * GET http://localhost:8080/api/hibrido
	 */
	@GET
	public List<Hibrido> findAll() {
		return hibridoService.findAll();
	}

	/**
	 * GET 
	 * http://localhost:8080/api/hibrido/1
	 * http://localhost:8080/api/hibrido/2 
	 * http://localhost:8080/api/hibrido/3
	 */
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		Hibrido coche = hibridoService.findOne(id);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}

	/**
	 * POST http://localhost:8080/api/hibrido
	 */
	@POST // CREAR NUEVO
	public Response create(Hibrido coche) {
		if (coche.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
			return Response.status(Response.Status.BAD_REQUEST).build();

		Hibrido result = hibridoService.save(coche);
		return Response.ok(result).build();
	}

	/**
	 * PUT http://localhost:8080/api/hibrido
	 */
	@PUT // ACTUALIZAR
	public Response update(Hibrido coche) {
		if (coche.getId() == null || coche.getId() == 0) // si no tiene id quiere decir que es una creación no
															// actualización
			return Response.status(Response.Status.BAD_REQUEST).build();

		Hibrido result = hibridoService.save(coche);
		return Response.ok(result).build();
	}

	/**
	 * DELETE 
	 * http://localhost:8080/api/hibrido/1
	 * http://localhost:8080/api/hibrido/2
	 * http://localhost:8080/api/hibrido/3
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!hibridoService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();
	}

	/**
	 * DELETE http://localhost:8080/api/hibrido
	 */
	@DELETE
	public Response deleteAll() {
		hibridoService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/hibrido/colores
	 */
	@GET
	@Path ("/colores/{color}")
	public Response findByColour(@PathParam("color") String color) {
		List<Hibrido> coche = hibridoService.findByColour(color);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/hibrido/marca
	 */
	@GET
	@Path("/marca/{marca}")
	public Response findByMarca(@PathParam("marca") String marca) {
		List<Hibrido> coche = hibridoService.findByMarca(marca);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/hibrido/puertas
	 */
	@GET
	@Path("/puertas/{num_puertas}")
	public Response findByNum_puertas(@PathParam("num_puertas") int num_puertas) {
		List<Hibrido> coche = hibridoService.findByNum_puertas(num_puertas);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/hibrido/tipo
	 */
	@GET
	@Path("/tipo/{tipo_vehiculo}")
	public Response findByType(@PathParam("tipo_vehiculo") String tipo_vehiculo) {
		List<Hibrido> coche = hibridoService.findByType(tipo_vehiculo);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}

}
