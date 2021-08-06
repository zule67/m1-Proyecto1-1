package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

class VehiculoTest {
	
	@Test
	@DisplayName("Método para probar el contructor completo")
	void testComprobar() {
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(2L, 2.0, false);
		Motor motor = new Motor(false, "bmw");
		
		Vehiculo coche = new Vehiculo() {};
		coche.setId(2L);
		coche.setMarca("Toyota");
		coche.setModelo("Prius");
		coche.setColor("rojo");
		coche.setNum_puertas(3);
		coche.setTipo_vehiculo("nuevo");
		coche.setAireAcon(aire);
		coche.setBateria(bateria);
		coche.setMotor(motor);
		
		assertEquals(2L, coche.getId());
		assertEquals("Toyota", coche.getMarca());
		assertEquals("Prius", coche.getModelo());
		assertEquals("rojo", coche.getColor());
		assertEquals(3, coche.getNum_puertas());
		assertEquals("nuevo", coche.getTipo_vehiculo());
		assertEquals(aire, coche.getAireAcon());
		assertEquals(bateria, coche.getBateria());
		assertEquals(motor, coche.getMotor());
		assertNotNull(coche.toString());
	}

}
