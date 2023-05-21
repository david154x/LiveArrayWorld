package com.livearrayworld.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livearrayworld.dto.SondaDTO;
import com.livearrayworld.entity.Planeta;
import com.livearrayworld.service.PlanetFactoryService;
import com.livearrayworld.service.SondaService;
import com.livearrayworld.service.ValidationService;

@Service
public class SondaServiceImpl implements SondaService {
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private PlanetFactoryService planetFactoryService;
	
	private Map<String, Object> respuesta;
	private StringBuilder log;

	@Override
	public Map<String, Object> lanzarSondaInvestigacion(SondaDTO sondaDTO) {
		
		try {
			respuesta = new HashMap<>();
			respuesta.put("SondaDTO", sondaDTO);
			
			// 1. Validamos los datos de entrada
			respuesta = validationService.validarDatosEnviados(respuesta);
			
			if(!validationService.validacionOk(respuesta))
				return respuesta;
			
			// 2. Segun el planeta escrito o seleccionado se construye y se agrega
			crearPlanetaDeEleccion(sondaDTO.getPlaneta());
			
			log = new StringBuilder();
			
			// 3. Damos informe de aterrizaje
			crearInformeDeLanzamientoYAterrizaje();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
	private void crearPlanetaDeEleccion(String nombrePlaneta) {
		Planeta planeta = null;
		try {
			planeta = planetFactoryService.createPlanet(nombrePlaneta);
			
			if(planeta != null && !Objects.isNull(planeta)) {
				respuesta.put("planeta", planeta);
			} else {
				System.out.println("El planeta: "+nombrePlaneta+" no se encuentra registrado");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void crearInformeDeLanzamientoYAterrizaje() {
		Planeta planeta = (Planeta) respuesta.get("planeta");
		StringBuilder stBuild = null;
		try {
			stBuild = new StringBuilder();
			stBuild.append(pintarNave(planeta));
			stBuild.append(darInformeDeEstado(planeta));
			stBuild.append(darInformeDeProvisiones());
			stBuild.append(definirPrimerDiaTranscurrido(planeta));
//			stBuild.append(inicioInvestigacionSupervivencia());
			
			log.append(stBuild.toString());
			System.out.println(log);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String pintarNave(Planeta planeta) {
		StringBuilder stBuild = null;
		try {
			stBuild = new StringBuilder();
			stBuild.append("Se ha situado la nave principal sobre el planeta: "+planeta.getNombrePlaneta()+" \n")
				   .append("Abriendo compartimiento de lanzamiento \n")
				   .append("Se ha realizado el lanzamiento de la nave con rumbo al planeta "+planeta.getNombrePlaneta()+" \n")
				   .append("\n              ----- ¡Lanzamiento exitoso! -----                  \n")
				   .append(" \n")
				   .append(" \n")
				   .append("--------------------- |||||||||||||||||||||| --------------------- \n")
				   .append("--------------------- |||||||||||||||||||||| --------------------- \n")
				   .append("--------------------- |||||||||||||||||||||| --------------------- \n")
				   .append("--------------------- |||||||||||||||||||||| --------------------- \n")
				   .append("--------------------- |||||||||||||||||||||| --------------------- \n")
				   .append(" \n")
				   .append(" \n")
				   .append("                             |      |                             "+" \n")
				   .append("                             |      |                             "+" \n")
				   .append("                             |______|                             "+" \n")
				   .append("                            |________|                            "+" \n")
				   .append("                           |__________|                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           ||________||                           "+" \n")
				   .append("                           | ________ |                             "+" \n")
				   .append("                            |________|                             "+" \n")
				   .append("                             /______\\                             "+" \n")
				   .append("                              /    \\                             "+" \n")
				   .append("                               /  \\                             "+" \n")
				   .append("                                /\\                             "+" \n")
				   .append(" \n")
				   .append(" \n")
				   .append("\n              ----- ¡Aterrizaje exitoso! -----                  \n")
				   .append(" \n")
				   .append(" \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String darInformeDeEstado(Planeta planeta) {
		StringBuilder stBuild = null;
		try {
			stBuild = new StringBuilder();
			stBuild.append("Informe de condiciones naturales y ambientales actuales \n")
				   .append(" \n")
				   .append("------------------------------------------------------- \n")
				   .append("------------------------------------------------------- \n")
				   .append(" \n")
				   .append("Gravedad: "+planeta.getGravedad().toString()+ " \n")
				   .append("Presion Atmosferica: "+planeta.getPresionAtmosferica()+" \n")
				   .append("Temperatura: "+planeta.getTemperatura()+"°C \n")
				   .append("Humedad: "+planeta.getHumedad()+"% \n")
				   .append("Luz: "+planeta.getLuz()+"% \n")
				   .append(" \n")
				   .append("------------------------------------------------------- \n")
				   .append("------------------------------------------------------- \n")
				   .append(" \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String darInformeDeProvisiones() {
		StringBuilder stBuild = null;
		SondaDTO sondaDTO = null;
		try {
			sondaDTO = (SondaDTO) respuesta.get("SondaDTO");
			
			stBuild = new StringBuilder();
			stBuild.append("Informe de provisiones \n")
				   .append(" \n")
				   .append("------------------------------------------------------- \n")
				   .append("------------------------------------------------------- \n")
				   .append(" \n")
				   .append("Barriles de agua: "+sondaDTO.getCondicionesNaturalesEntity().getBarrilAgua()+ " \n")
				   .append("Cajas de comida: "+sondaDTO.getCondicionesNaturalesEntity().getCajasComida()+" \n")
				   .append("Estado vital: "+sondaDTO.getCondicionesNaturalesEntity().getEstadoCondicionalHumano()+" \n")
				   .append(" \n")
				   .append("------------------------------------------------------- \n")
				   .append("------------------------------------------------------- \n")
				   .append(" \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String inicioInvestigacionSupervivencia() {
		StringBuilder stBuild = null;
		try {
//			stBuild = new StringBuilder();
//			stBuild.append("Informe de provisiones \n")
//				   .append(" \n")
//				   .append("------------------------------------------------------- \n")
//				   .append("------------------------------------------------------- \n")
//				   .append(" \n")
//				   .append("Barriles de agua: "+sondaDTO.getCondicionesNaturalesEntity().getBarrilAgua()+ " \n")
//				   .append("Cajas de comida: "+sondaDTO.getCondicionesNaturalesEntity().getCajasComida()+" \n")
//				   .append("Estado vital: "+sondaDTO.getCondicionesNaturalesEntity().getEstadoCondicionalHumano()+" \n")
//				   .append(" \n")
//				   .append("------------------------------------------------------- \n")
//				   .append("------------------------------------------------------- \n")
//				   .append(" \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String definirPrimerDiaTranscurrido(Planeta planeta) {
		StringBuilder stBuild = null;
		SondaDTO sondaDTO = null;
		BigDecimal horasDiaPlaneta = null;
		try {
			sondaDTO = (SondaDTO) respuesta.get("SondaDTO");
			
			if(sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion() != null) {
				// Se multiplica la cantidad de dias que se van hacer de expedicion, por las horas que tiene un planeta
				horasDiaPlaneta = new BigDecimal(planeta.getDiaEnHoras()).multiply(new BigDecimal(sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion()));
				
				
				
				System.out.println("Esto que seria?? xd : "+horasDiaPlaneta.toString());
			}
			
			
			
			
			
			
			stBuild = new StringBuilder();
			stBuild.append("Informe n° 0 - Primer dia dentro de la nave \n")
				   .append(" \n")
				   .append("------------------------------------------------------- \n")
				   .append("------------------------------------------------------- \n")
				   .append(" \n");
			if(!planeta.getNombrePlaneta().toLowerCase().equals("tierra")) {
				stBuild.append("Se identifica que existe diferencia de tiempo en comparacion a la Tierra \n")
					   .append(" \n")
					   .append(" \n")
					   .append(" \n")
					   .append(" \n")
					   .append(" \n");
			}
				   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
}
