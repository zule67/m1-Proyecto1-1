package com.example.demo.domain.piezas;

public class Bateria {

	private Long id;
	private Double capacidad; // mAh capacity
	private boolean estado;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Bateria(Long id, Double capacidad, boolean estado) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Bateria [id=" + id + ", capacidad=" + capacidad + ", estado=" + estado + "]";
	}
	
	public void start() {
		this.estado = true;
	}
	

}
