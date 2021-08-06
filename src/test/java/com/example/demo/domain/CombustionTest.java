package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;
import com.example.demo.service.CombustionServiceImpl;

class CombustionTest {
	
	AireAcon aire = new AireAcon(false);
	Bateria bateria = new Bateria(2L, 2.0, false);
	Motor motor = new Motor(false, "bmw");
	
	@Test
	@DisplayName("Método para probar el contructor vacio, getters y setters")
	void testPrueba() {
		Combustion combustion = new Combustion();
		combustion.setId(2L);
		combustion.setMarca("BMW");
		combustion.setModelo("3.20");
		combustion.setColor("negro");
		combustion.setNum_puertas(3);
		combustion.setTipo_vehiculo("nuevo");
		combustion.setNum_cilindros(6);
		combustion.setTipo_comb("Gasoil");
		
		assertEquals(2L, combustion.getId());
		assertEquals("BMW", combustion.getMarca());
		assertEquals("3.20", combustion.getModelo());
		assertEquals("negro", combustion.getColor());
		assertEquals(3, combustion.getNum_puertas());
		assertEquals("nuevo", combustion.getTipo_vehiculo());
		assertEquals(6, combustion.getNum_cilindros());
		assertEquals("Gasoil", combustion.getTipo_comb());
		assertNotNull(combustion.toString());
	}
	
	@Test
	@DisplayName("Método para comprobar el constructor completo")
	void testPrueba2() {
		
		CombustionServiceImpl resultado = new CombustionServiceImpl();
		
		Combustion esperado = new Combustion (1L, "BMW", "3.20", "negro", 3, "descapotable", aire, bateria, motor, 6, "gasolina");
	
		assertEquals(esperado, resultado.save(esperado));
	}
}
