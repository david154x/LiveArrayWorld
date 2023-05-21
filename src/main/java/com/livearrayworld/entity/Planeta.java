package com.livearrayworld.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planeta {
	
	private String nombrePlaneta;
	private BigDecimal gravedad;
	private BigDecimal presionAtmosferica;
	private BigDecimal temperatura;
	private Integer diaEnHoras;
	
	private String radiacionSolar;
	
	private BigDecimal agua;
	private BigDecimal viento;
	
	private Integer humedad;
	
	private Boolean ecosistema;
	
	private Integer luz;
	
	private BigDecimal masaRocosa;
	private BigDecimal masaBlanda;
	
}
