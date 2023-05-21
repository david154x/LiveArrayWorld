package com.livearrayworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComposicionAtmosfericaEntity {
	
	private Boolean gasesVenenosos;
	private Boolean tormentas;
	private Boolean terremotos;
	private Boolean erupcionesVolcanicas;
	
}
