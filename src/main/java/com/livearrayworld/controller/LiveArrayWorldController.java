package com.livearrayworld.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livearrayworld.dto.SondaDTO;
import com.livearrayworld.service.SondaService;

@RestController
@RequestMapping("/Core")
public class LiveArrayWorldController {
	
	@Autowired
	private SondaService sondeService;
	
	@GetMapping(value = "/PrepareProbe")
	public String status() {
		System.out.println("Preparando Sonda");
		return "Se ha preparado el lanzamiento";
	}
	
	@GetMapping(value = "/LaunchProbe")
	public ResponseEntity<?> lanzarSonda(@RequestBody SondaDTO sondaDTO) {
		Map<String, Object> respuesta = null;
		try {
			respuesta = sondeService.lanzarSondaInvestigacion(sondaDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(respuesta);
	}

}
