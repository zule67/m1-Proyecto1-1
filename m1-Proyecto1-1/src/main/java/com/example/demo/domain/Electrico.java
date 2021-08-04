package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

public class Electrico extends Vehiculo {
	
	private float num_kw;
	private boolean acumulador;
	
	public Electrico() {
		super();
	}

	
	public Electrico(Long id, String marca, String modelo, String color, int num_puertas, String tipo_vehiculo,
			AireAcon aireAcon, Bateria bateria, Motor motor, float num_kw, boolean acumulador) {
		super(id, marca, modelo, color, num_puertas, tipo_vehiculo, aireAcon, bateria, motor);
		this.num_kw = num_kw;
		this.acumulador = acumulador;
	}


	public float getNum_kw() {
		return num_kw;
	}

	public void setNum_kw(float num_kw) {
		this.num_kw = num_kw;
	}

	public boolean isAcumulador() {
		return acumulador;
	}

	public void setAcumulador(boolean acumulador) {
		this.acumulador = acumulador;
	}

	@Override
	public String toString() {
		return "Electrico [num_kw=" + num_kw + ", acumulador=" + acumulador + ", getId()=" + getId() + ", getMarca()="
				+ getMarca() + ", getModelo()=" + getModelo() + ", getColor()=" + getColor() + ", getNum_puertas()="
				+ getNum_puertas() + ", getTipo_vehiculo()=" + getTipo_vehiculo() + ", getAireAcon()=" + getAireAcon()
				+ ", getBateria()=" + getBateria() + ", getMotor()=" + getMotor() + "]";
	}
	
	
	
	
	
	
}
