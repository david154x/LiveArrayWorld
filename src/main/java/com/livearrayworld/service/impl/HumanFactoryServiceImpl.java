package com.livearrayworld.service.impl;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.livearrayworld.entity.Humano;
import com.livearrayworld.service.HumanFactoryService;

@Service
public class HumanFactoryServiceImpl implements HumanFactoryService {

	private Map<String, Object> lstHumano;
	
	@Override
	public Humano createHuman(String typeOfHuman) {
		String nombreMinuscula = null;
		try {
			crearHumano();
			nombreMinuscula = typeOfHuman.toLowerCase();
			
			if (lstHumano.containsKey(nombreMinuscula))
	            return (Humano) lstHumano.get(nombreMinuscula);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void crearHumano() {
		try {
			lstHumano = new TreeMap<String, Object>();
			
			estadoExcelente();
			estadoModerado();
			estadoNormal();
			estadoDeficiente();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void estadoExcelente() {
		Humano humanoExcelente = new Humano();
		
		humanoExcelente.setEstadoVital(100);
		humanoExcelente.setTemperaturaInterna(37);
		humanoExcelente.setSaludFisica(100);
		humanoExcelente.setSaludMental(100);
		humanoExcelente.setConcentracion(100);
		humanoExcelente.setTiempoDeDescanso(8);
		humanoExcelente.setIrAlBanio(6);
		humanoExcelente.setTiempoEjercicio(36);
		
		lstHumano.put("excelente", humanoExcelente);
	}
	
	private void estadoModerado() {
		Humano humanoModerado = new Humano();
		
		humanoModerado.setEstadoVital(85);
		humanoModerado.setTemperaturaInterna(36);
		humanoModerado.setSaludFisica(80);
		humanoModerado.setSaludMental(80);
		humanoModerado.setConcentracion(80);
		humanoModerado.setTiempoDeDescanso(9);
		humanoModerado.setIrAlBanio(4);
		humanoModerado.setTiempoEjercicio(48);
		
		lstHumano.put("moderada", humanoModerado);
		lstHumano.put("moderado", humanoModerado);
	}
	
	private void estadoNormal() {
		Humano humanoNormal = new Humano();
		
		humanoNormal.setEstadoVital(70);
		humanoNormal.setTemperaturaInterna(35);
		humanoNormal.setSaludFisica(60);
		humanoNormal.setSaludMental(60);
		humanoNormal.setConcentracion(60);
		humanoNormal.setTiempoDeDescanso(10);
		humanoNormal.setIrAlBanio(3);
		humanoNormal.setTiempoEjercicio(120);
		
		lstHumano.put("normal", humanoNormal);
	}
	
	private void estadoDeficiente() {
		Humano humanoDeficiente = new Humano();
		
		humanoDeficiente.setEstadoVital(50);
		humanoDeficiente.setTemperaturaInterna(34);
		humanoDeficiente.setSaludFisica(50);
		humanoDeficiente.setSaludMental(50);
		humanoDeficiente.setConcentracion(45);
		humanoDeficiente.setTiempoDeDescanso(12);
		humanoDeficiente.setIrAlBanio(2);
		humanoDeficiente.setTiempoEjercicio(240);
		
		lstHumano.put("deficiente", humanoDeficiente);
		lstHumano.put("malo", humanoDeficiente);
		lstHumano.put("precario", humanoDeficiente);
	}

}
