package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Hibrido;

public interface HibridoService {
	Integer count();

	List<Hibrido> findAll();

	Hibrido findOne(Long id);

	Hibrido save(Hibrido hibrido);

	boolean delete(Long id);

	void deleteAll();
	
	List<Hibrido> findByColour(String color);
	
	List<Hibrido> findByNum_puertas(int num_puertas);
	
	List<Hibrido> findByMarca(String marca);
	
	List<Hibrido> findByType(String type);
}
