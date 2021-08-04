package com.example.demo.domain.piezas;

public class Motor {

	private boolean estado = false;
	private String marca;

	public Motor(boolean estado) {
		super();
		this.estado = estado;
	}

	public Motor(boolean estado, String marca) {
		super();
		this.estado = estado;
		this.marca = marca;
	}

	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Motor [estado=" + estado + ", marca=" + marca + "]";
	}
	
	public void start() {
		this.estado = true;
	}


}
