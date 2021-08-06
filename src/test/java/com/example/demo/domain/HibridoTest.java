package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;
import com.example.demo.service.HibridoServiceImpl;

class HibridoTest {
	AireAcon aire = new AireAcon(false);
	Bateria bateria = new Bateria(2L, 2.0, false);
	Motor motor = new Motor(false, "Toyota");
	
	@Test
	@DisplayName("Método para probar el contructor vacio, getters y setters")
	void testPrueba() {
		Hibrido hibrido = new Hibrido();
		hibrido.setId(2L);
		hibrido.setMarca("Toyota");
		hibrido.setModelo("Prius");
		hibrido.setColor("rojo");
		hibrido.setNum_puertas(3);
		hibrido.setTipo_vehiculo("nuevo");
		hibrido.setTipo_bateria("acido");
		hibrido.setAutonomia(500L);
		
		assertEquals(2L, hibrido.getId());
		assertEquals("Toyota", hibrido.getMarca());
		assertEquals("Prius", hibrido.getModelo());
		assertEquals("rojo", hibrido.getColor());
		assertEquals(3, hibrido.getNum_puertas());
		assertEquals("nuevo", hibrido.getTipo_vehiculo());
		assertEquals("acido", hibrido.getTipo_bateria());
		assertEquals(500L, hibrido.getAutonomia());
		assertNotNull(hibrido.toString());
	}
	
	@Test
	@DisplayName("Método para comprobar el constructor completo")
	void testPrueba2() {
		
		HibridoServiceImpl resultado = new HibridoServiceImpl();
		
		Hibrido esperado = new Hibrido (1L, "Tesla", "5.20", "rojo", 3, "descapotable", aire, bateria, motor, "acido", 500L);
	
		assertEquals(esperado, resultado.save(esperado));
	}
}
