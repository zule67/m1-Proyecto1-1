package com.example.demo.domain.piezas;

public class AireAcon {

	private boolean estado = false;

	public AireAcon(boolean estado) {
		super();
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "AireAcon [estado=" + estado + "]";
	}
	
	public void start() {
		this.estado = true;
	}

	public AireAcon() {
		super();
	}

}
