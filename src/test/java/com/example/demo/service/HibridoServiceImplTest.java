package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.demo.domain.Hibrido;
import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HibridoServiceImplTest {

	AireAcon aire = new AireAcon(false);
	Bateria bateria = new Bateria(2L, 2.0, false);
	Motor motor = new Motor(false, "Toyota");
	
	HibridoServiceImpl resultado = new HibridoServiceImpl();
	
	
	@Test
	@Order(1)
	@DisplayName("Método para contar vehículos híbridos")
	void testCount() {
		assertEquals(3, resultado.count());
	}

	@Test
	@Order(2)
	@DisplayName("Método para encontrar toda la lista de vehículos híbridos")
	void testFindAll() {
		assertEquals(3, resultado.findAll().size());
	}

	@Test
	@Order(3)
	@DisplayName("Método que encuentra un vehículo híbrido por el ID")
	void testFindOneForId() {
		Long id = 1L;
		assertEquals(1L, resultado.findOne(id).getId());
	}

	@Test
	@Order(4)
	@DisplayName("Método para guardar vehículos híbridos general")
	void testSave() {
		
		Hibrido esperado = new Hibrido (2L, "BMW", "3.20", "negro", 3, "descapotable", aire, bateria, motor, "acido", 600L);
		assertEquals(esperado, resultado.save(esperado));
	}
	
	@Test
	@Order(5)
	@DisplayName("Método para guardar vehículos híbridos con Id=null")
	void testSaveIdNull() {
		
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(2L, 2.0, false);
		Motor motor = new Motor(false, "bmw");
		
		Hibrido esperado = new Hibrido (null, "BMW", "3.20", "negro", 3, "descapotable", aire, bateria, motor, "acido", 3000L);
	
		assertEquals(esperado, resultado.save(esperado));
	}
	
	@Test
	@Order(6)
	@DisplayName("Método para guardar vehículos híbridos con Id=Zero")
	void testSaveIdIsZero() {
		
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(2L, 2.0, false);
		Motor motor = new Motor(false, "bmw");
		
		Hibrido esperado = new Hibrido (0L, "Kia", "3.20", "negro", 3, "descapotable", aire, bateria, motor, "mixta", 2000L);
	
		assertEquals(esperado, resultado.save(esperado));
	}
	
	@Test
	@Order(16)
	@DisplayName("Método para modificar vehículos híbridos sin Id")
	void testGetMaxCombustionIdEmptyList() {
		resultado.deleteAll();;
		assertEquals(0L, resultado.getMaxHibridoId());
	}

	@Test
	@Order(12)
	@DisplayName("Método para borrar vehículos híbridos")
	void testDelete() {
		assertEquals(5, resultado.count());
		assertEquals(true, resultado.delete(1L));
		
	}
	
	@Test
	@Order(13)
	@DisplayName("Método para borrar vehículos híbridos con Id nulo")
	void testDeleteWithIdNull() {
		boolean esperado = false;
		assertEquals(esperado, resultado.delete(null));
	}

	@Test
	@Order(14)
	@DisplayName("Método para borrar vehículos híbridos que no existe")
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
	@DisplayName("Método para buscar vehículos híbridos por color")
	void testFindByColour() {
		assertEquals(0, resultado.findByColour("azul").size());
	}

	@Test
	@Order(9)
	@DisplayName("Método para buscar vehículos híbridos por número de puertas")
	void testFindByNum_puertas() {
		assertEquals(0, resultado.findByNum_puertas(4).size());
	}

	@Test
	@Order(10)
	@DisplayName("Método para buscar vehículos híbridos por marca")
	void testFindByMarca() {
		assertEquals(0, resultado.findByMarca("Toyota").size());
	}

	@Test
	@Order(11)
	@DisplayName("Método para buscar vehículos híbridos por tipo de vehículo")
	void testFindByType() {
		assertEquals(1, resultado.findByType("nuevo").size());
	}
}
