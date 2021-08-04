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

import com.example.demo.domain.Combustion;
import com.example.demo.service.CombustionService;

@Path("/combustion")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class CombustionController {

	private CombustionService combustionService;

	public CombustionController(CombustionService combustionService) {
		this.combustionService = combustionService;
	}

	/**
	 * GET http://localhost:8080/api/combustion
	 */
	@GET
	public List<Combustion> findAll() {
		return combustionService.findAll();
	}

	/**
	 * GET 
	 * http://localhost:8080/api/combustion/1
	 * http://localhost:8080/api/combustion/2 
	 * http://localhost:8080/api/combustion/3
	 */
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		Combustion coche = combustionService.findOne(id);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}

	/**
	 * POST http://localhost:8080/api/combustion
	 */
	@POST // CREAR NUEVO
	public Response create(Combustion coche) {
		if (coche.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
			return Response.status(Response.Status.BAD_REQUEST).build();

		Combustion result = combustionService.save(coche);
		return Response.ok(result).build();
	}

	/**
	 * PUT http://localhost:8080/api/combustion
	 */
	@PUT // ACTUALIZAR
	public Response update(Combustion coche) {
		if (coche.getId() == null || coche.getId() == 0) // si no tiene id quiere decir que es una creación no
															// actualización
			return Response.status(Response.Status.BAD_REQUEST).build();

		Combustion result = combustionService.save(coche);
		return Response.ok(result).build();
	}

	/**
	 * DELETE 
	 * http://localhost:8080/api/combustion/1
	 * http://localhost:8080/api/combustion/2
	 * http://localhost:8080/api/combustion/3
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!combustionService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();
	}

	/**
	 * DELETE http://localhost:8080/api/combustion
	 */
	@DELETE
	public Response deleteAll() {
		combustionService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/combustion/colores
	 */
	@GET
	@Path ("/colores/{color}")
	public Response findByColour(@PathParam("color") String color) {
		List<Combustion> coche = combustionService.findByColour(color);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/combustion/marca
	 */
	@GET
	@Path("/marca/{marca}")
	public Response findByMarca(@PathParam("marca") String marca) {
		List<Combustion> coche = combustionService.findByMarca(marca);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/combustion/puertas
	 */
	@GET
	@Path("/puertas/{num_puertas}")
	public Response findByNum_puertas(@PathParam("num_puertas") int num_puertas) {
		List<Combustion> coche = combustionService.findByNum_puertas(num_puertas);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
	
	/**
	 * GET 
	 * http://localhost:8080/api/combustion/tipo
	 */
	@GET
	@Path("/tipo/{tipo_vehiculo}")
	public Response findByType(@PathParam("tipo_vehiculo") String tipo_vehiculo) {
		List<Combustion> coche = combustionService.findByType(tipo_vehiculo);
		if (coche == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(coche).build();
	}
}
	

