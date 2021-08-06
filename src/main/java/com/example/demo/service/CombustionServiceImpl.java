package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Combustion;
import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

@Service
public class CombustionServiceImpl implements CombustionService {

	private static final Map<Long, Combustion> combustiones = new HashMap<>();
	
	static {
		Combustion combustion1 = new Combustion(1L, "opel", "corsa", "rojo", 4, "nuevo", new AireAcon(true), new Bateria(1L, 5.0, true), new Motor(true), 4, "gasolina");
		Combustion combustion2 = new Combustion(2L, "VW", "golf", "gris", 5, "seminuevo", new AireAcon(true), new Bateria(2L, 8.0, true), new Motor(true), 6, "gasoil");
		Combustion combustion3 = new Combustion(3L, "mercedes", "c500", "negro", 3, "nuevo", new AireAcon(true), new Bateria(3L, 6.0, true), new Motor(true), 8, "gasolina");
		
		combustiones.put(1L, combustion1);
		combustiones.put(2L, combustion2);
		combustiones.put(3L, combustion3);
	}
	
	@Override
	public Integer count() {
		return combustiones.keySet().size();
	}

	@Override
	public List<Combustion> findAll() {
		return new ArrayList<>(combustiones.values());
	}

	@Override
	public Combustion findOne(Long id) {
		return combustiones.get(id);
	}

	@Override
	public Combustion save(Combustion combustion) {
		// asignar un id
        if (combustion.getId() == null || combustion.getId() == 0L) // nuevo coche de combustion
            combustion.setId(getMaxCombustionId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        combustiones.remove(combustion.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el coche de combustion en el mapa
        combustiones.put(combustion.getId(), combustion);
        return combustion;
	}
	
	/**
     * Devuelve el id más alto del mapa de coches de combustion
     * @return
     */
    public Long getMaxCombustionId() {
    	if (combustiones.isEmpty())
    	  return 0L;

        return Collections.max(combustiones.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
    
	@Override
	public boolean delete(Long id) {
		if (id == null || !combustiones.containsKey(id))
            return false;
        combustiones.remove(id);
        return true;
	}

	@Override
	public void deleteAll() {
		if (!combustiones.isEmpty())
            combustiones.clear();
	}

	@Override
	public List<Combustion> findByColour(String color) {
		List<Combustion> results = new ArrayList<>();
		for(Combustion coche : combustiones.values())
			if(coche.getColor().equals(color))
				results.add(coche);
			return results;
	}

	@Override
	public List<Combustion> findByNum_puertas(int num_puertas) {
		List<Combustion> results = new ArrayList<>();
		for(Combustion coche : combustiones.values())
			if(coche.getNum_puertas() == num_puertas)
				results.add(coche);
			return results;
	}


	@Override
	public List<Combustion> findByMarca(String marca) {
		List<Combustion> results = new ArrayList<>();
		for(Combustion coche : combustiones.values())
			if(coche.getMarca().equals(marca))
				results.add(coche);
			return results;
	}
	
	@Override
	public List<Combustion> findByType(String type) {
		List<Combustion> results = new ArrayList<>();
		for(Combustion coche : combustiones.values())
			if(coche.getTipo_vehiculo().equals(type))
				results.add(coche);
			return results;
	}


}
