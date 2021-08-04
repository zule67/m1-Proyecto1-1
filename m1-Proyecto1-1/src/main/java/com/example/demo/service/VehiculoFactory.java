package com.example.demo.service;

import com.example.demo.domain.Vehiculo;

public class VehiculoFactory {
	
	private static final String ELECTRICO = "electrico";
	private static final String COMBUSTION = "combustion";
	private static final String HIBRIDO = "hibrido";
	
	private VehiculoFactory() {}
	
	public static Vehiculo createByType(String type) {
		return switch(type) {
			case ELECTRICO -> VehiculoFacade.createVehiculoElectrico();
			case COMBUSTION -> VehiculoFacade.createVehiculoCombustion();
			case HIBRIDO -> VehiculoFacade.createVehiculoHibrido();
			default -> throw new IllegalArgumentException("No existe ese tipo de coche");
			};
	}
}
	
