package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Electrico;

public interface ElectricoService {
	Integer count();
	
	List<Electrico> findAll();
	
	Electrico findOne(Long id);
	
	Electrico save(Electrico electrico);
	
	boolean delete(Long id);
	
	void deleteAll();
	
	List<Electrico> findByColour(String color);
	
	List<Electrico> findByNum_puertas(int num_puertas);
	
	List<Electrico> findByMarca(String marca);
	
	List<Electrico> findByType(String type);
}
