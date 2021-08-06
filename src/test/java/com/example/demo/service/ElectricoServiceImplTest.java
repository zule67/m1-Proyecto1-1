package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.demo.domain.Electrico;
import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElectricoServiceImplTest {

	AireAcon aire = new AireAcon(false);
	Bateria bateria = new Bateria(2L, 2.0, false);
	Motor motor = new Motor(false, "Toyota");
	
	ElectricoServiceImpl resultado = new ElectricoServiceImpl();
	
	
	@Test
	@Order(1)
	@DisplayName("Método para contar vehículos eléctricos")
	void testCount() {
		assertEquals(3, resultado.count());
	}

	@Test
	@Order(2)
	@DisplayName("Método para encontrar toda la lista de vehículos eléctricos")
	void testFindAll() {
		assertEquals(3, resultado.findAll().size());
	}

	@Test
	@Order(3)
	@DisplayName("Método que encuentra un vehículo eléctrico por el ID")
	void testFindOneForId() {
		Long id = 1L;
		assertEquals(1L, resultado.findOne(id).getId());
	}

	@Test
	@Order(4)
	@DisplayName("Método para guardar vehículos eléctricos general")
	void testSave() {
		
		Electrico esperado = new Electrico (2L, "BMW", "3.20", "negro", 5, "descapotable", aire, bateria, motor, 6, true);
		assertEquals(esperado, resultado.save(esperado));
	}
	
	@Test
	@Order(5)
	@DisplayName("Método para guardar vehículos eléctricos con Id=null")
	void testSaveIdNull() {
		
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(2L, 2.0, false);
		Motor motor = new Motor(false, "bmw");
		
		Electrico esperado = new Electrico (null, "BMW", "3.20", "negro", 5, "descapotable", aire, bateria, motor, 4, true);
	
		assertEquals(esperado, resultado.save(esperado));
	}
	
	@Test
	@Order(6)
	@DisplayName("Método para guardar vehículos eléctricos con Id=Zero")
	void testSaveIdIsZero() {
		
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(2L, 2.0, false);
		Motor motor = new Motor(false, "bmw");
		
		Electrico esperado = new Electrico (0L, "Kia", "3.20", "negro", 5, "descapotable", aire, bateria, motor, 8, true);
	
		assertEquals(esperado, resultado.save(esperado));
	}
	
	@Test
	@Order(16)
	@DisplayName("Método para modificar vehículos eléctricos sin Id")
	void testGetMaxElectricoIdEmptyList() {
		resultado.deleteAll();;
		assertEquals(0L, resultado.getMaxElectricoId());
	}

	@Test
	@Order(12)
	@DisplayName("Método para borrar vehículos eléctricos")
	void testDelete() {
		assertEquals(5, resultado.count());
		assertEquals(true, resultado.delete(1L));
		
	}
	
	@Test
	@Order(13)
	@DisplayName("Método para borrar vehículos eléctricos con Id nulo")
	void testDeleteWithIdNull() {
		boolean esperado = false;
		assertEquals(esperado, resultado.delete(null));
	}

	@Test
	@Order(14)
	@DisplayName("Método para borrar vehículos eléctricos que no existe")
	void testDeleteWithIdNotExist() {
		boolean esperado = false;
		assertEquals(esperado, resultado.delete(8L));
	}

	@Test
	@Order(15)
	@DisplayName("Método para borrar todos los vehículos")
	void testDeleteAll() {
		resultado.deleteAll();
		assertEquals(0, resultado.count());
	}

	@Test
	@Order(8)
	@DisplayName("Método para buscar vehículos eléctricos por color")
	void testFindByColour() {
		assertEquals(1, resultado.findByColour("rojo").size());
	}

	@Test
	@Order(9)
	@DisplayName("Método para buscar vehículos eléctricos por número de puertas")
	void testFindByNum_puertas() {
		assertEquals(2, resultado.findByNum_puertas(3).size());
	}

	@Test
	@Order(10)
	@DisplayName("Método para buscar vehículos eléctricos por marca")
	void testFindByMarca() {
		assertEquals(1, resultado.findByMarca("Tesla").size());
	}

	@Test
	@Order(11)
	@DisplayName("Método para buscar vehículos eléctricos por tipo de vehículo")
	void testFindByType() {
		assertEquals(1, resultado.findByType("nuevo").size());
	}
}
