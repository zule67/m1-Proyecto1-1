package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Hibrido;
import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

@Service
public class HibridoServiceImpl implements HibridoService {

	private static final Map<Long, Hibrido> hibridos = new HashMap<>();

	static {
		Hibrido hibrido1 = new Hibrido(1L, "Toyota", "prius", "azul", 4, "nuevo", new AireAcon(true),
				new Bateria(1L, 5.0, true), new Motor(true), "hibrida", 600L);
		Hibrido hibrido2 = new Hibrido(2L, "Seat", "leon", "gris", 5, "seminuevo", new AireAcon(true),
				new Bateria(2L, 8.0, true), new Motor(true), "acido", 800L);
		Hibrido hibrido3 = new Hibrido(3L, "Kia", "pikanto", "negro", 3, "nuevo", new AireAcon(true),
				new Bateria(3L, 6.0, true), new Motor(true), "mixta", 1500L);

		hibridos.put(1L, hibrido1);
		hibridos.put(2L, hibrido2);
		hibridos.put(3L, hibrido3);
	}

	@Override
	public Integer count() {
		return hibridos.keySet().size();
	}

	@Override
	public List<Hibrido> findAll() {
		return new ArrayList<>(hibridos.values());
	}

	@Override
	public Hibrido findOne(Long id) {
		return hibridos.get(id);
	}

	@Override
	public Hibrido save(Hibrido hibrido) {
		// asignar un id
        if (hibrido.getId() == null || hibrido.getId() == 0L) // nuevo coche hibrido
            hibrido.setId(getMaxHibridoId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        hibridos.remove(hibrido.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el hibrido en el mapa
        hibridos.put(hibrido.getId(), hibrido);
        return hibrido;
	}

	public Long getMaxHibridoId() {
		if (hibridos.isEmpty())
			return 0L;

        return Collections.max(hibridos.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !hibridos.containsKey(id))
            return false;
        hibridos.remove(id);
        return true;
	}

	@Override
	public void deleteAll() {
		if (!hibridos.isEmpty())
            hibridos.clear();

	}

	@Override
	public List<Hibrido> findByColour(String color) {
		List<Hibrido> results = new ArrayList<>();
		for(Hibrido coche : hibridos.values())
			if(coche.getColor().equals(color))
				results.add(coche);
			return results;
	}

	@Override
	public List<Hibrido> findByNum_puertas(int num_puertas) {
		List<Hibrido> results = new ArrayList<>();
		for(Hibrido coche : hibridos.values())
			if(coche.getNum_puertas() == num_puertas)
				results.add(coche);
			return results;
	}


	@Override
	public List<Hibrido> findByMarca(String marca) {
		List<Hibrido> results = new ArrayList<>();
		for(Hibrido coche : hibridos.values())
			if(coche.getMarca().equals(marca))
				results.add(coche);
			return results;
	}
	
	@Override
	public List<Hibrido> findByType(String type) {
		List<Hibrido> results = new ArrayList<>();
		for(Hibrido coche : hibridos.values())
			if(coche.getTipo_vehiculo().equals(type))
				results.add(coche);
			return results;
	}

}
