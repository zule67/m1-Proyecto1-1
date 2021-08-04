package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Combustion;

public interface CombustionService {
	Integer count();

	Combustion findOne(Long id);

	Combustion save(Combustion combustion);

	boolean delete(Long id);

	void deleteAll();
	
	List<Combustion> findAll();
	
	List<Combustion> findByColour(String color);
	
	List<Combustion> findByNum_puertas(int num_puertas);
	
	List<Combustion> findByMarca(String marca);
	
	List<Combustion> findByType(String type);
}
