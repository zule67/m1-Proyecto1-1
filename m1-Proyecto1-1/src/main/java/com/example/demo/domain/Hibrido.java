package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

public class Hibrido extends Vehiculo {
	
	private String tipo_bateria;
	private Long autonomia;
	
	public Hibrido() {
		super();
	}

	public Hibrido(Long id, String marca, String modelo, String color, int num_puertas, String tipo_vehiculo,
			AireAcon aireAcon, Bateria bateria, Motor motor, String tipo_bateria, Long autonomia) {
		super(id, marca, modelo, color, num_puertas, tipo_vehiculo, aireAcon, bateria, motor);
		this.tipo_bateria = tipo_bateria;
		this.autonomia = autonomia;
	}

	public String getTipo_bateria() {
		return tipo_bateria;
	}

	public void setTipo_bateria(String tipo_bateria) {
		this.tipo_bateria = tipo_bateria;
	}

	public Long getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Long autonomia) {
		this.autonomia = autonomia;
	}

	@Override
	public String toString() {
		return "Hibrido [tipo_bateria=" + tipo_bateria + ", autonomia=" + autonomia + ", getId()=" + getId()
				+ ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getColor()=" + getColor()
				+ ", getNum_puertas()=" + getNum_puertas() + ", getTipo_vehiculo()=" + getTipo_vehiculo()
				+ ", getAireAcon()=" + getAireAcon() + ", getBateria()=" + getBateria() + ", getMotor()=" + getMotor()
				+ "]";
	}
	
	
	
}
