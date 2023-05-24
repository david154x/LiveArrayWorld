package com.livearrayworld.service.impl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.livearrayworld.entity.Planeta;
import com.livearrayworld.service.PlanetFactoryService;

@Service
public class PlanetFactoryServiceImpl implements PlanetFactoryService {
	
	private Map<String, Object> lstPlanetas;

	@Override
	public Planeta createPlanet(String namePlanet) {
		String nombreMinuscula = null;
		try {
			crearPlanetas();
			nombreMinuscula = namePlanet.toLowerCase();
			
			if (lstPlanetas.containsKey(nombreMinuscula))
	            return (Planeta) lstPlanetas.get(nombreMinuscula);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void crearPlanetas() {
		try {
			lstPlanetas = new TreeMap<String, Object>();
			
			crearMercurio();
			crearVenus();
			crearTierra();
			crearMarte();
			crearJupiter();
			crearSaturno();
			crearUrano();
			crearNeptuno();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void crearMercurio() {
		Planeta mercurio = new Planeta();
		
		mercurio.setNombrePlaneta("Mercurio");
		mercurio.setGravedad(new BigDecimal("3.7"));
		mercurio.setPresionAtmosferica(new BigDecimal("0.000000001"));
		
		// Se representa en grados celcius
		mercurio.setTemperatura(new BigDecimal("440"));
		mercurio.setDiaEnHoras(1408);
		
		// 0 a 2 es baja
		// 3 a 5 es moderada
		// 6 a 10 alta
		mercurio.setRadiacionSolar("Alta");
		
		mercurio.setViento(new BigDecimal("0"));
		mercurio.setHumedad(15);
		mercurio.setLuz(67);
		
		mercurio.setEcosistema(false);
		
		mercurio.setMasaRocosa(new BigDecimal("330.11"));
		mercurio.setMasaBlanda(new BigDecimal("0.055"));
		
		lstPlanetas.put("mercurio", mercurio);
	}
	
	private void crearVenus() {
		Planeta venus = new Planeta();
		
		venus.setNombrePlaneta("Venus");
		venus.setGravedad(new BigDecimal("8.87"));
		venus.setPresionAtmosferica(new BigDecimal("92"));
		venus.setTemperatura(new BigDecimal("737"));
		venus.setDiaEnHoras(5832);
		venus.setRadiacionSolar("Alta");
		venus.setAgua(new BigDecimal("0.01"));
		venus.setViento(new BigDecimal("1.8"));
		venus.setHumedad(85);
		venus.setEcosistema(false);
		venus.setLuz(70);
		venus.setMasaRocosa(new BigDecimal("486.75"));
		venus.setMasaBlanda(new BigDecimal("0.815"));
		
		lstPlanetas.put("venus", venus);
	}
	
	private void crearTierra() {
		Planeta tierra = new Planeta();
		
		tierra.setNombrePlaneta("Tierra");
		tierra.setGravedad(new BigDecimal("9.8"));
		tierra.setPresionAtmosferica(new BigDecimal("101.325"));
		tierra.setTemperatura(new BigDecimal("15"));
		tierra.setDiaEnHoras(24);
		tierra.setRadiacionSolar("Moderada");
		tierra.setAgua(new BigDecimal("0.71"));
		tierra.setViento(new BigDecimal("29.6"));
		tierra.setHumedad(50);
		tierra.setEcosistema(false);
		tierra.setLuz(100);
		tierra.setMasaRocosa(new BigDecimal("597.24"));
		tierra.setMasaBlanda(new BigDecimal("1.0"));
		
		lstPlanetas.put("tierra", tierra);
	}
	
	private void crearMarte() {
		Planeta marte = new Planeta();
		
		marte.setNombrePlaneta("Marte");
		marte.setGravedad(new BigDecimal("3.71"));
		marte.setPresionAtmosferica(new BigDecimal("0.006"));
		marte.setTemperatura(new BigDecimal("-80"));
		marte.setDiaEnHoras(25);
		marte.setRadiacionSolar("baja");
		marte.setAgua(new BigDecimal("0.005"));
		marte.setViento(new BigDecimal("6.92"));
		marte.setHumedad(10);
		marte.setEcosistema(false);
		marte.setLuz(58);
		marte.setMasaRocosa(new BigDecimal("641.71"));
		marte.setMasaBlanda(new BigDecimal("0.107"));
		
		lstPlanetas.put("marte", marte);
	}
	
	private void crearJupiter() {
		Planeta jupiter = new Planeta();
		
		jupiter.setNombrePlaneta("Jupiter");
		jupiter.setGravedad(new BigDecimal("24.79"));
		jupiter.setPresionAtmosferica(new BigDecimal("2000"));
		jupiter.setTemperatura(new BigDecimal("-150"));
		jupiter.setDiaEnHoras(10);
		jupiter.setRadiacionSolar("baja");
		jupiter.setAgua(new BigDecimal("0.50"));
		jupiter.setViento(new BigDecimal("27.0"));
		jupiter.setHumedad(90);
		jupiter.setEcosistema(false);
		jupiter.setLuz(44);
		jupiter.setMasaRocosa(new BigDecimal("1898.2"));
		jupiter.setMasaBlanda(new BigDecimal("317.8"));
		
		lstPlanetas.put("jupiter", jupiter);
	}
	
	private void crearSaturno() {
		Planeta saturno = new Planeta();
		
		saturno.setNombrePlaneta("Saturno");
		saturno.setGravedad(new BigDecimal("10.44"));
		saturno.setPresionAtmosferica(new BigDecimal("1000"));
		saturno.setTemperatura(new BigDecimal("-180"));
		saturno.setDiaEnHoras(11);
		saturno.setRadiacionSolar("baja");
		saturno.setAgua(new BigDecimal("0.40"));
		saturno.setViento(new BigDecimal("45.0"));
		saturno.setHumedad(80);
		saturno.setEcosistema(false);
		saturno.setLuz(33);
		saturno.setMasaRocosa(new BigDecimal("568.34"));
		saturno.setMasaBlanda(new BigDecimal("95.16"));
		
		lstPlanetas.put("saturno", saturno);
	}
	
	private void crearUrano() {
		Planeta urano = new Planeta();
		
		urano.setNombrePlaneta("Urano");
		urano.setGravedad(new BigDecimal("8.69"));
		urano.setPresionAtmosferica(new BigDecimal("1300"));
		urano.setTemperatura(new BigDecimal("-210"));
		urano.setDiaEnHoras(17);
		urano.setRadiacionSolar("baja");
		urano.setAgua(new BigDecimal("0.15"));
		urano.setViento(new BigDecimal("21.3"));
		urano.setHumedad(20);
		urano.setEcosistema(false);
		urano.setLuz(27);
		urano.setMasaRocosa(new BigDecimal("868.1"));
		urano.setMasaBlanda(new BigDecimal("14.54"));
		
		lstPlanetas.put("urano", urano);
	}
	
	private void crearNeptuno() {
		Planeta neptuno = new Planeta();
		
		neptuno.setNombrePlaneta("Neptuno");
		neptuno.setGravedad(new BigDecimal("11.15"));
		neptuno.setPresionAtmosferica(new BigDecimal("1000"));
		neptuno.setTemperatura(new BigDecimal("-220"));
		neptuno.setDiaEnHoras(16);
		neptuno.setRadiacionSolar("baja");
		neptuno.setAgua(new BigDecimal("0.80"));
		neptuno.setViento(new BigDecimal("20.0"));
		neptuno.setHumedad(95);
		neptuno.setEcosistema(false);
		neptuno.setLuz(25);
		neptuno.setMasaRocosa(new BigDecimal("1024.13"));
		neptuno.setMasaBlanda(new BigDecimal("17.15"));
		
		lstPlanetas.put("neptuno", neptuno);
	}

}
