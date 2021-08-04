package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.Vehiculo;

public class VehiculoFacadeTest {

	@Test
	void testCreateVehiculoElectrico() {
		Vehiculo electrico = VehiculoFacade.createVehiculoElectrico();
		assertNotNull(electrico);
		assertTrue(electrico instanceof Vehiculo);
		assertEquals(1L, electrico.getId());
	}

	@Test
	void testCreateVehiculoCombustion() {
		Vehiculo combustion = VehiculoFacade.createVehiculoCombustion();
		assertNotNull(combustion);
		assertTrue(combustion instanceof Vehiculo);
		assertEquals(2L, combustion.getId());
	}

	@Test
	void testCreateVehiculoHibrido() {
		Vehiculo hibrido = VehiculoFacade.createVehiculoHibrido();
		assertNotNull(hibrido);
		assertTrue(hibrido instanceof Vehiculo);
		assertEquals(3L, hibrido.getId());
	}
	
}
