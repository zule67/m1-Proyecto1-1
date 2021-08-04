package com.example.demo.service;



import com.example.demo.domain.Combustion;
import com.example.demo.domain.Electrico;
import com.example.demo.domain.Hibrido;
import com.example.demo.domain.Vehiculo;
import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

public class VehiculoFacade {
	
	private VehiculoFacade() {}

	public static Vehiculo createVehiculoElectrico() {
		//Piezas generales
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(1L, 5.0, false);
		Motor motor = new Motor(false, "tesla");
		//Constructor con piezas generales + específicas
		Electrico electrico = new Electrico(1L, "Tesla", "m500", "blanco", 5, "deportivo", aire, bateria, motor, 8, true);
		aire.start();
		bateria.start();
		motor.start();
		return electrico;
	}

	public static Vehiculo createVehiculoCombustion() {
		// Piezas generales
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(2L, 2.0, false);
		Motor motor = new Motor(false, "bmw");
		// Constructor con piezas generales + específicas
		Combustion combustion = new Combustion(2L, "BMW", "3.20", "negro", 3, "descapotable", aire, bateria, motor, 6, "gasolina");
		aire.start();
		bateria.start();
		motor.start();
		return combustion;
	}

	public static Vehiculo createVehiculoHibrido() {
		// Piezas generales
		AireAcon aire = new AireAcon(false);
		Bateria bateria = new Bateria(3L, 2.0, false);
		Motor motor = new Motor(false, "prius");
		// Constructor con piezas generales + específicas
		Hibrido hibrido = new Hibrido(3L, "toyota", "Prius", "azul", 5, "familiar", aire, bateria, motor, "hibrida", 600L);
		aire.start();
		bateria.start();
		motor.start();
		return hibrido;
	}

}
