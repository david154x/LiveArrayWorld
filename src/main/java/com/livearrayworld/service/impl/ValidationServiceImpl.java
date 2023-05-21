package com.livearrayworld.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.livearrayworld.dto.SondaDTO;
import com.livearrayworld.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

	public Map<String, Object> validarDatosEnviados(Map<String, Object> respuesta) {
		SondaDTO sondaDTO = null;
		String values = null;
		try {
			sondaDTO = (SondaDTO) respuesta.get("SondaDTO");

			values = validarDatos(sondaDTO.getComposicionAtmosferica());

			if (values != null && !values.isEmpty()) {
				if (respuesta.size() > 0)
					respuesta.clear();

				respuesta.put("codePrimary", -1);
				respuesta.put("statusCode", HttpStatus.BAD_REQUEST);
				respuesta.put("detail", "Porfavor verifique los campos que se estan enviando en: " + values.toString());
				respuesta.put("codeProcess", 1);
				return respuesta;
			}

			values = validarDatos(sondaDTO.getCondicionesNaturalesEntity());

			if (values != null && !values.isEmpty()) {
				if (respuesta.size() > 0)
					respuesta.clear();

				respuesta.put("codePrimary", -1);
				respuesta.put("statusCode", HttpStatus.BAD_REQUEST);
				respuesta.put("detail", "Porfavor verifique los campos que se estan enviando en: " + values.toString());
				respuesta.put("codeProcess", 1);
				return respuesta;
			}

			values = validarDatos(sondaDTO.getCondicionesAmbientales());

			if (values != null && !values.isEmpty()) {
				if (respuesta.size() > 0)
					respuesta.clear();

				respuesta.put("codePrimary", -1);
				respuesta.put("statusCode", HttpStatus.BAD_REQUEST);
				respuesta.put("detail", "Porfavor verifique los campos que se estan enviando en: " + values.toString());
				respuesta.put("codeProcess", 1);
				return respuesta;
			}

			values = validarDatos(sondaDTO);

			if (values != null && !values.isEmpty()) {
				if (respuesta.size() > 0)
					respuesta.clear();

				respuesta.put("codePrimary", -1);
				respuesta.put("statusCode", HttpStatus.BAD_REQUEST);
				respuesta.put("detail", "Porfavor verifique los campos que se estan enviando en: " + values.toString());
				respuesta.put("codeProcess", 1);
				return respuesta;
			}

			respuesta.put("codePrimary", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	private String validarDatos(Object obj) {
		ValidatorFactory validatorFactory = null;
		Validator validator = null;
		Integer count = 0;
		Integer longValues = 0;
		StringBuilder stBuild = null;
		String repeatValue = null;
		List<String> lstRepeatValues = null;
		try {

			validatorFactory = Validation.buildDefaultValidatorFactory();
			validator = validatorFactory.getValidator();
			Set<ConstraintViolation<Object>> violations = validator.validate(obj);

			if (!violations.isEmpty()) {
				stBuild = new StringBuilder();
				lstRepeatValues = new ArrayList<>();
				for (ConstraintViolation<Object> v : violations) {
					repeatValue = v.getPropertyPath().toString();
					if (!lstRepeatValues.contains(repeatValue)) {
						lstRepeatValues.add(repeatValue);
					}
				}

				if (lstRepeatValues != null && !lstRepeatValues.isEmpty()) {
					longValues = lstRepeatValues.size();
					for (String value : lstRepeatValues) {
						stBuild.append(value);
						count++;
						if (!count.equals(longValues))
							stBuild.append(", ");
					}
				}
			}

			if (stBuild != null && !stBuild.isEmpty())
				return stBuild.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean validacionOk(Map<String, Object> respuesta) {
		
		if (respuesta.get("codePrimary").equals(0))
			return true;
		
		return false;
	}

}
