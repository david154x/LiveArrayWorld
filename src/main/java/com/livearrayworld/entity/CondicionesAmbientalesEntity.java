package com.livearrayworld.entity;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionesAmbientalesEntity {
	
	@NotNull
	private Boolean vidaDentroDelPlaneta;
	
	@NotNull
	private Boolean depredadores;
	
	@NotNull
	private Boolean cambiosBruscosTemperatura;
	
}
