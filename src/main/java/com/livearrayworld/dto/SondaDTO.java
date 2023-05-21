package com.livearrayworld.dto;

import javax.validation.constraints.NotNull;

import com.livearrayworld.entity.ComposicionAtmosfericaEntity;
import com.livearrayworld.entity.CondicionesAmbientalesEntity;
import com.livearrayworld.entity.CondicionesNaturalesEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SondaDTO {
	
	@NotNull
	private String planeta;
	
	// Se definen las condiciones del individuo que realizara la expedicion
	@NotNull
	private CondicionesNaturalesEntity condicionesNaturalesEntity;
	
	// Definimos si el individuo encuentra unas condiciones es decir recursos, como se va priorizar
	@NotNull
	private ComposicionAtmosfericaEntity composicionAtmosferica;
	
	// Definimos los posibles peligros que existan en el planeta 
	@NotNull
	private CondicionesAmbientalesEntity condicionesAmbientales;
	
	@NotNull
	private Boolean huirEnCasoDePeligro;

}
