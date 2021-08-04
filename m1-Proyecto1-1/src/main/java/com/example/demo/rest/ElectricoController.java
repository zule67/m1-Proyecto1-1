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

import com.example.demo.domain.Electrico;
import com.example.demo.service.ElectricoService;

@Path("/electrico")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class ElectricoController {

	private ElectricoService electricoService;

	public ElectricoController(ElectricoService electricoService) {
		this.electricoService = electricoService;
	}

	/**
	 * GET http://localhost:8080/api/electrico
	 */
	@GET
	public List<Electrico> findAll() {
		return electricoService.findAll();
	}

	/**
	 * GET 
	 * http://localhost:8080/api/electrico/1
	 * http://localhost:8080/api/electrico/2 
	 * http://localhost:8080/api/electrico/3
	 */
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		Electrico coche = electricoService.findOne(id);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}

	/**
	 * POST http://localhost:8080/api/electrico
	 */
	@POST // CREAR NUEVO
	public Response create(Electrico coche) {
		if ((coche.getId() == 0L || coche.getId() == null)) {  // si ya tiene id quiere decir que es una actualización no creación
			Electrico result = electricoService.save(coche);
			return Response.ok(result).build();
		}

		return Response.status(Response.Status.BAD_REQUEST).build();
	}

	/**
	 * PUT http://localhost:8080/api/electrico
	 */
	@PUT // ACTUALIZAR
	public Response update(Electrico coche) {
		if (coche.getId() == null || coche.getId() == 0) // si no tiene id quiere decir que es una creación no
															// actualización
			return Response.status(Response.Status.BAD_REQUEST).build();

		Electrico result = electricoService.save(coche);
		return Response.ok(result).build();
	}

	/**
	 * DELETE 
	 * http://localhost:8080/api/electrico/1
	 * http://localhost:8080/api/electrico/2
	 * http://localhost:8080/api/electrico/3
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!electricoService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();
	}

	/**
	 * DELETE http://localhost:8080/api/electrico
	 */
	@DELETE
	public Response deleteAll() {
		electricoService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/electrico/colores
	 */
	@GET
	@Path ("/colores/{color}")
	public Response findByColour(@PathParam("color") String color) {
		List<Electrico> coche = electricoService.findByColour(color);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/electrico/marca
	 */
	@GET
	@Path("/marca/{marca}")
	public Response findByMarca(@PathParam("marca") String marca) {
		List<Electrico> coche = electricoService.findByMarca(marca);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/electrico/puertas
	 */
	@GET
	@Path("/puertas/{num_puertas}")
	public Response findByNum_puertas(@PathParam("num_puertas") int num_puertas) {
		List<Electrico> coche = electricoService.findByNum_puertas(num_puertas);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/electrico/tipo
	 */
	@GET
	@Path("/tipo/{tipo_vehiculo}")
	public Response findByType(@PathParam("tipo_vehiculo") String tipo_vehiculo) {
		List<Electrico> coche = electricoService.findByType(tipo_vehiculo);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}

}
