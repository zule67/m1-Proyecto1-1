package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcon;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Motor;

public abstract class Vehiculo {
	
	private Long id;
	private String marca;
	private String modelo;
	private String color;
	private int num_puertas;
	private String tipo_vehiculo;
	private AireAcon aireAcon;
	private Bateria bateria;
	private Motor motor;
	
	protected Vehiculo() {
		super();
	}

	protected Vehiculo(Long id, String marca, String modelo, String color, int num_puertas, String tipo_vehiculo,
			AireAcon aireAcon, Bateria bateria, Motor motor) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.num_puertas = num_puertas;
		this.tipo_vehiculo = tipo_vehiculo;
		this.aireAcon = aireAcon;
		this.bateria = bateria;
		this.motor = motor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public AireAcon getAireAcon() {
		return aireAcon;
	}

	public void setAireAcon(AireAcon aireAcon) {
		this.aireAcon = aireAcon;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", num_puertas="
				+ num_puertas + ", tipo_vehiculo=" + tipo_vehiculo + ", aireAcon=" + aireAcon + ", bateria=" + bateria
				+ ", motor=" + motor + "]";
	}
	
	
}
