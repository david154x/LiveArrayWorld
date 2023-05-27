package com.livearrayworld.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livearrayworld.dto.SondaDTO;
import com.livearrayworld.entity.Humano;
import com.livearrayworld.entity.Planeta;
import com.livearrayworld.service.HumanFactoryService;
import com.livearrayworld.service.PlanetFactoryService;
import com.livearrayworld.service.SondaService;
import com.livearrayworld.service.ValidationService;

@Service
public class SondaServiceImpl implements SondaService {
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private PlanetFactoryService planetFactoryService;
	
	@Autowired
	private HumanFactoryService humanFactoryService;
	
	private Map<String, Object> respuesta;
	private StringBuilder log;
	private Map<String, Object> planDeSupervivencia;

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
		SondaDTO sondaDTO = (SondaDTO) respuesta.get("SondaDTO");
		StringBuilder stBuild = null;
		try {
			
			stBuild = new StringBuilder();
			stBuild.append(pintarNave(planeta));
			stBuild.append(darInformeDeEstado(planeta));
			stBuild.append(darInformeDeProvisiones());
			stBuild.append(definirPrimerDiaTranscurrido(planeta));
			stBuild.append(darInformeDiagnosticoVital(planeta));
			stBuild.append(inicioInvestigacionSupervivencia(sondaDTO));
			
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
	
	private String definirPrimerDiaTranscurrido(Planeta planeta) {
		StringBuilder stBuild = null;
		SondaDTO sondaDTO = null;
		BigDecimal horasDiaPlanetaSeleccionado = null;
		Integer horasTierra = 24;
		Integer horasDiferencia = null;
		BigDecimal horasDiferenciaTierra = null;
		BigDecimal horasXDia = null;
		try {
			sondaDTO = (SondaDTO) respuesta.get("SondaDTO");
			
			if(sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion() != null) {
				// Se multiplica la cantidad de dias que se van hacer de expedicion, por las horas que tiene un planeta
				horasDiaPlanetaSeleccionado = new BigDecimal(planeta.getDiaEnHoras()).multiply(new BigDecimal(sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion()));
			}
			
			stBuild = new StringBuilder();
			stBuild.append("Informe General \n")
				   .append(" \n");
			
			if(planeta.getDiaEnHoras() > horasTierra) {
				
				horasDiferencia = horasTierra * sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion();
				horasDiferenciaTierra = horasDiaPlanetaSeleccionado.subtract(new BigDecimal(horasDiferencia));
				horasXDia = horasDiferenciaTierra.divide(new BigDecimal(sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion()));
				
				stBuild.append("Se identifica que existe diferencia de tiempo en comparacion a la Tierra \n");
			
				if(horasXDia.compareTo(new BigDecimal(1)) == 0) {
					stBuild.append("El promedio calibrado de tiempo es de: "+horasXDia+" hora de diferencia por dia  \n");
				} else {
					stBuild.append("El promedio calibrado de tiempo es de: "+horasXDia+" horas de diferencia por dia  \n");
				}
			}
			
			stBuild.append(" \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String inicioInvestigacionSupervivencia(SondaDTO sondaDTO) {
		StringBuilder stBuild = null;
		Integer consumoRacion = 0;
		Integer consumoAgua = 0;
		
		Integer racionXCaja = 0;
		Integer botellaXBarril = 0;
		
		Integer consumoTotalRacionXDia = 0;
		Integer consumoTotalAguaXDia = 0;
		Humano humano = null;
		Double desgasteVital = 0.95;
		Double desgasteSaludFisica = 0.01;
		Double desgasteSaludMental = 0.01;
		Double desgasteConcentracion = 0.04;
		BigDecimal tiempoDeDescanso = new BigDecimal("0");
		BigDecimal tiempoEjercicio = new BigDecimal("0");
		Integer restaDeSalud = 0;
		try {
			consumoRacion = (Integer) planDeSupervivencia.get("racion");
			consumoAgua= (Integer) planDeSupervivencia.get("agua");
			humano = (Humano) respuesta.get("Humano");
			
			racionXCaja = sondaDTO.getCondicionesNaturalesEntity().getCajasComida() * 25;
			botellaXBarril = sondaDTO.getCondicionesNaturalesEntity().getBarrilAgua() * 50;
			
			Integer[] racionesRestantes = new Integer[racionXCaja];
			Integer[] aguaRestante = new Integer[botellaXBarril];
			
			stBuild = new StringBuilder();
			stBuild.append("Resultados \n")
				   .append("\n");
			
			for(Integer dia = 1; dia <= sondaDTO.getCondicionesNaturalesEntity().getDiasExpedicion(); dia++) {
				
				consumoTotalRacionXDia = racionXCaja - consumoRacion * 1;
				racionXCaja = consumoTotalRacionXDia;
				
				consumoTotalAguaXDia = botellaXBarril - consumoAgua * 1;
				botellaXBarril = consumoTotalAguaXDia;
				
				racionesRestantes[dia] = consumoTotalRacionXDia;
	            aguaRestante[dia] = consumoTotalAguaXDia;
	            
	            Integer factorVital = (int) (humano.getEstadoVital() * desgasteVital);
	            factorVital = humano.getEstadoVital() - factorVital; 
	            humano.setEstadoVital(humano.getEstadoVital() - factorVital);
	            
	            Integer factorSaludFisica = (int) (humano.getSaludFisica() * desgasteSaludFisica);
	            factorSaludFisica = humano.getSaludFisica() - factorSaludFisica;
	            restaDeSalud = humano.getSaludFisica() - factorSaludFisica;
	            humano.setSaludFisica(humano.getSaludFisica() - restaDeSalud);
	            
	            Integer factorSaludMental = (int) (humano.getSaludMental() * desgasteSaludMental);
	            factorSaludMental = humano.getSaludMental() - factorSaludMental;
	            
	            humano.setSaludMental(factorSaludMental);
	            
	            Integer factorConcentracion = (int) (humano.getConcentracion() * desgasteConcentracion);
	            factorConcentracion = humano.getConcentracion() - factorConcentracion;
	            humano.setConcentracion(factorConcentracion);
	            
	            tiempoDeDescanso = tiempoDeDescanso.add(new BigDecimal(humano.getTiempoDeDescanso()));
	            tiempoEjercicio = tiempoDeDescanso.add(new BigDecimal(humano.getTiempoEjercicio()));
	            
	            stBuild.append("Día ")
	            	   .append(dia)
	            	   .append(": ")
	            	   .append("Raciones restantes: ")
	            	   .append(racionesRestantes[dia])
	            	   .append(", Agua restante: ")
	            	   .append(aguaRestante[dia])
	            	   .append("\n")
	            	   .append("Se ha producido cambio en el estado vital: "+humano.getEstadoVital()+"% \n")
	            	   .append("Se identifica cambio en salud: "+humano.getSaludFisica()+"% \n")
	            	   .append("Se identifica cambio en salud mental: "+humano.getSaludMental()+"% \n")
	            	   .append("La concentracion se visto afectada: "+humano.getConcentracion()+"% \n")
	            	   .append("Tiempo de descanso o sueño total: "+tiempoDeDescanso.toString()+" horas \n")
	            	   .append("Tiempo de ejercicio fisico realizado "+tiempoEjercicio.toString()+" horas \n")
	            	   .append("\n");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String darInformeDiagnosticoVital(Planeta planeta) {
		StringBuilder stBuild = null;
		SondaDTO sondaDTO = null;
		Humano humano = null;
		try {
			stBuild = new StringBuilder();
			sondaDTO = (SondaDTO) respuesta.get("SondaDTO");
			humano = humanFactoryService.createHuman(sondaDTO.getCondicionesNaturalesEntity().getEstadoCondicionalHumano());
			respuesta.put("Humano", humano);
			
			stBuild = new StringBuilder();
			stBuild.append("Informe de bienestar \n")
				   .append("\n")
				   .append("Estado vital: "+humano.getEstadoVital()+"% \n")
				   .append("Salud fisica: "+humano.getSaludFisica()+"% \n")
				   .append("Salud mental: "+humano.getSaludMental()+"% \n")
				   .append("Temperatura actual: "+humano.getTemperaturaInterna()+"% \n")
				   .append(" \n");
			
			if(humano.getEstadoVital() > 80 && 
					sondaDTO.getCondicionesNaturalesEntity().getCalidadTraje() > 85
					&& planeta.getGravedad().compareTo(new BigDecimal(20)) <= 0) {
				stBuild.append("Las condiciones humanas y el traje soportan la gravedad \n")
					   .append("es posible realizar expedicion e investigacion \n");
			} else {
				stBuild.append("Se identifica que la gravedad del planeta es demasiado fuerte para explorar, \n")
					   .append("Se descarta la opcion de expedicion e investigacion \n");
			}
			
			stBuild.append("\n");
			stBuild.append(definirPlan(sondaDTO, planeta, humano));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String definirPlan(SondaDTO sondaDTO, Planeta planeta, Humano humano) {
		StringBuilder stBuild = null;
		try {
			
			planDeSupervivencia = new TreeMap<>();
			
			stBuild = new StringBuilder();
			stBuild.append("Se ha realizado estudio de consumo de provisiones \n")
				   .append(consumoRaciones(humano))
				   .append(consumoAgua(humano));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String consumoRaciones(Humano humano) {
		StringBuilder stBuild = null;
		try {
			stBuild = new StringBuilder();
			if(humano.getEstadoVital() >= 85) {
				planDeSupervivencia.put("racion", 3);
				stBuild.append("La cantidad de raciones a consumir por dia es de: 3 por dia \n");
			}
							
			if(humano.getEstadoVital() <= 70) {
				planDeSupervivencia.put("racion", 4);
				stBuild.append("La cantidad de raciones a consumir por dia es de: 4 por dia \n");
			}
			
			if(humano.getEstadoVital() <= 50) {
				planDeSupervivencia.put("racion", 5);
				stBuild.append("La cantidad de raciones a consumir por dia es de: 5 por dia \n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
	private String consumoAgua(Humano humano) {
		StringBuilder stBuild = null;
		try {
			
			stBuild = new StringBuilder();
			if(humano.getEstadoVital() >= 85) {
				planDeSupervivencia.put("agua", 2);
				stBuild.append("La cantidad de agua a consumir por dia es de: 2 botellas por dia \n");
			}
							
			if(humano.getEstadoVital() <= 70) {
				planDeSupervivencia.put("agua", 3);
				stBuild.append("La cantidad de agua a consumir por dia es de: 3 botellas por dia \n");
			}
			
			if(humano.getEstadoVital() <= 50) {
				planDeSupervivencia.put("agua", 5);
				stBuild.append("La cantidad de agua a consumir por dia es de: 5 botellas por dia \n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stBuild.toString();
	}
	
}
