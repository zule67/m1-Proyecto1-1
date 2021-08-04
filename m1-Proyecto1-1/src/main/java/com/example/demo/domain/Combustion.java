package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

public class Combustion extends Vehiculo {
	private int num_cilindros;
	private String tipo_comb;
	
	public Combustion() {
		super();
	}

	public Combustion(Long id, String marca, String modelo, String color, int num_puertas, String tipo_vehiculo,
			AireAcon aireAcon, Bateria bateria, Motor motor, int num_cilindros, String tipo_comb) {
		super(id, marca, modelo, color, num_puertas, tipo_vehiculo, aireAcon, bateria, motor);
		this.num_cilindros = num_cilindros;
		this.tipo_comb = tipo_comb;
	}

	public int getNum_cilindros() {
		return num_cilindros;
	}

	public void setNum_cilindros(int num_cilindros) {
		this.num_cilindros = num_cilindros;
	}

	public String getTipo_comb() {
		return tipo_comb;
	}

	public void setTipo_comb(String tipo_comb) {
		this.tipo_comb = tipo_comb;
	}

	@Override
	public String toString() {
		return "Combustion [num_cilindros=" + num_cilindros + ", tipo_comb=" + tipo_comb + ", getId()=" + getId()
				+ ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getColor()=" + getColor()
				+ ", getNum_puertas()=" + getNum_puertas() + ", getTipo_vehiculo()=" + getTipo_vehiculo()
				+ ", getAireAcon()=" + getAireAcon() + ", getBateria()=" + getBateria() + ", getMotor()=" + getMotor()
				+ "]";
	}
	
	
	
}
