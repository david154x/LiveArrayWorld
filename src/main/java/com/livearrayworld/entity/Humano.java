package com.livearrayworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Humano {
	
	private Integer estadoVital;
	private Integer temperaturaInterna;
	
	private Integer saludFisica;
	private Integer saludMental;
	private Integer concentracion;
	
	private Integer tiempoDeDescanso;
	private Integer irAlBanio;
	private Integer tiempoEjercicio;
	
}
