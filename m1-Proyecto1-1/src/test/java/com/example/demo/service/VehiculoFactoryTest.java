package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Combustion;
import com.example.demo.domain.Electrico;
import com.example.demo.domain.Hibrido;
import com.example.demo.domain.Vehiculo;


public class VehiculoFactoryTest {

	@Test
	@DisplayName("Método para crear coches eléctricos")
	void testCreateByTypeElectric() {
		Vehiculo electrico = VehiculoFactory.createByType("electrico");
		
		assertNotNull(electrico);
		assertTrue(electrico instanceof Electrico);
		assertEquals("Tesla", electrico.getMarca());
		assertEquals(1L, electrico.getId());
	}
	
	@Test
	@DisplayName("Método para crear coches de combustión")
	void testCreateByTypeCombustion() {
		Vehiculo combustion = VehiculoFactory.createByType("combustion");
		
		assertNotNull(combustion);
		assertTrue(combustion instanceof Combustion);
		assertEquals("BMW", combustion.getMarca());
		assertEquals(2L, combustion.getId());
	}
	@Test
	@DisplayName("Método para crear coches híbridos")
	void testCreateByTypeHybrid() {
		Vehiculo hibrido = VehiculoFactory.createByType("hibrido");;
		
		assertNotNull(hibrido);
		assertTrue(hibrido instanceof Hibrido);
		assertEquals("toyota", hibrido.getMarca());
		assertEquals(3L, hibrido.getId());
	}
	
	
	
	@Test
	@DisplayName("Método que comprueba que no es ninguno de los 3 coches posibles")
	void testDefaultInstance() {
		
		Exception exception = assertThrows(
				IllegalArgumentException.class, 
				() -> VehiculoFactory.createByType("notexists")
				);
		
		assertEquals("No existe ese tipo de coche", exception.getMessage());

	}
}
