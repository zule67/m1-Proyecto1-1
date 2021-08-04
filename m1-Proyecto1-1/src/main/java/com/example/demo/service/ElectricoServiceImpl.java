package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Electrico;
import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

@Service
public class ElectricoServiceImpl implements ElectricoService {
	
	private static final Map<Long, Electrico> electricos = new HashMap<>();
	
	static {
		Electrico electrico1 = new Electrico(1L, "Tesla", "500", "rojo", 3, "nuevo", new AireAcon(true), new Bateria(1L, 5.0, true), new Motor(true), 4, true);
		Electrico electrico2 = new Electrico(2L, "Audi", "A4", "gris", 5, "seminuevo", new AireAcon(true), new Bateria(2L, 8.0, true), new Motor(true), 6, true);
		Electrico electrico3 = new Electrico(3L, "Kia", "ceed", "negro", 3, "nuevo", new AireAcon(true), new Bateria(3L, 6.0, true), new Motor(true), 8, false);
		
		electricos.put(1L, electrico1);
		electricos.put(2L, electrico2);
		electricos.put(3L, electrico3);
	}
	@Override
	public Integer count() {
		return electricos.keySet().size();
	}

	@Override
	public List<Electrico> findAll() {
		return new ArrayList<>(electricos.values());
	}

	@Override
	public Electrico findOne(Long id) {
		return electricos.get(id);
	}

	@Override
	public Electrico save(Electrico electrico) {
		// asignar un id
        if (electrico.getId() == null || electrico.getId() == 0L) // nuevo coche electrico
            electrico.setId(getMaxElectricoId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        electricos.remove(electrico.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el coche electrico en el mapa
        electricos.put(electrico.getId(), electrico);
        return electrico;
	}

	public Long getMaxElectricoId() {
		if (electricos.isEmpty())
			return 0L;

        return Collections.max(electricos.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !electricos.containsKey(id))
            return false;
        electricos.remove(id);
        return true;
	}

	@Override
	public void deleteAll() {
		if (!electricos.isEmpty())
            electricos.clear();
	}

	@Override
	public List<Electrico> findByColour(String color) {
		List<Electrico> results = new ArrayList<>();
		for(Electrico coche : electricos.values())
			if(coche.getColor().equals(color))
				results.add(coche);
			return results;
	}

	@Override
	public List<Electrico> findByNum_puertas(int num_puertas) {
		List<Electrico> results = new ArrayList<>();
		for(Electrico coche : electricos.values())
			if(coche.getNum_puertas() == num_puertas)
				results.add(coche);
			return results;
	}


	@Override
	public List<Electrico> findByMarca(String marca) {
		List<Electrico> results = new ArrayList<>();
		for(Electrico coche : electricos.values())
			if(coche.getMarca().equals(marca))
				results.add(coche);
			return results;
	}
	
	@Override
	public List<Electrico> findByType(String type) {
		List<Electrico> results = new ArrayList<>();
		for(Electrico coche : electricos.values())
			if(coche.getTipo_vehiculo().equals(type))
				results.add(coche);
			return results;
	}

}
