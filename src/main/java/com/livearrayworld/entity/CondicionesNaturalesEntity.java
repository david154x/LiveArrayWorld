package com.livearrayworld.entity;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionesNaturalesEntity {
	
	@NotNull
	private String estadoCondicionalHumano;
	
	@NotNull
	private Integer barrilAgua;
	
	@NotNull
	private Integer cajasComida;
	
	@NotNull
	private Integer calidadTraje;
	
	@NotNull
	private Integer diasExpedicion;
	
	@NotNull
	private Integer alimentarseXHora;
	
	@NotNull
	private Integer beberAguaXHora;
	
	@NotNull
	private Integer tiempoDormir;
	
	@NotNull
	private Integer dormirDespuesDe;
	
	@NotNull
	private Integer horaDeInforme;
	
}
