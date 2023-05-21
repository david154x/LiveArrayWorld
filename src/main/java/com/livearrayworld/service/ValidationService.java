package com.livearrayworld.service;

import java.util.Map;

public interface ValidationService {
	
	public Map<String, Object> validarDatosEnviados(Map<String, Object> respuesta);
	
	public Boolean validacionOk(Map<String, Object> respuesta);

}
