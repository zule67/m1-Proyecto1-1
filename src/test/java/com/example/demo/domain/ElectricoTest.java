package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;
import com.example.demo.service.ElectricoServiceImpl;

class ElectricoTest {

	AireAcon aire = new AireAcon(false);
	Bateria bateria = new Bateria(2L, 2.0, false);
	Motor motor = new Motor(false, "Tesla");
	
	@Test
	@DisplayName("Método para probar el contructor vacio, getters y setters")
	void testPrueba() {
		Electrico electrico = new Electrico();
		electrico.setId(2L);
		electrico.setMarca("Tesla");
		electrico.setModelo("5.20");
		electrico.setColor("rojo");
		electrico.setNum_puertas(3);
		electrico.setTipo_vehiculo("nuevo");
		electrico.setNum_kw(200);
		electrico.setAcumulador(true);
		
		assertEquals(2L, electrico.getId());
		assertEquals("Tesla", electrico.getMarca());
		assertEquals("5.20", electrico.getModelo());
		assertEquals("rojo", electrico.getColor());
		assertEquals(3, electrico.getNum_puertas());
		assertEquals("nuevo", electrico.getTipo_vehiculo());
		assertEquals(200, electrico.getNum_kw());
		assertEquals(true, electrico.isAcumulador());
		assertNotNull(electrico.toString());
	}
	
	@Test
	@DisplayName("Método para comprobar el constructor completo")
	void testPrueba2() {
		
		ElectricoServiceImpl resultado = new ElectricoServiceImpl();
		
		Electrico esperado = new Electrico (1L, "Tesla", "5.20", "rojo", 3, "descapotable", aire, bateria, motor, 200, true);
	
		assertEquals(esperado, resultado.save(esperado));
	}

}
