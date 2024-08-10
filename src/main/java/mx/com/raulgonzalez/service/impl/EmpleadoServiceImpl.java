package mx.com.raulgonzalez.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.raulgonzalez.model.Empleado;
import mx.com.raulgonzalez.model.Response;
import mx.com.raulgonzalez.repository.EmpleadoRepository;
import mx.com.raulgonzalez.service.EmpleadoService;

/**
 * Descripción: Implementación del servicio para el CRUD de empleados.
 */

@Service
public class EmpleadoServiceImpl implements EmpleadoService<Empleado> {

	private static final Logger LOGGER = LogManager.getLogger(EmpleadoServiceImpl.class);

	private EmpleadoRepository empleadoRepository;

	@Autowired
	public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	

	@Override
	public Response<Empleado> guarda(Empleado empleado) {
		LOGGER.info(empleado);
		Response<Empleado> response = new Response<>();
		try {
			Empleado empleadoNuevo = empleadoRepository.save(empleado);
			response.setCodigoRespuesta(0);
			response.setMensaje("Ok");
			response.setRespuesta(empleadoNuevo);
			LOGGER.info(response);
			return response;
		} catch (ConstraintViolationException e) {
			response.setCodigoRespuesta(1005);
			response.setMensaje(e.getConstraintViolations().stream().findFirst().get().getMessage());
			LOGGER.info(response);
			return response;
		}
	}
	

	@Override
	public Response<Empleado> consulta(Long id) {
		LOGGER.info(id);
		Response<Empleado> response = new Response<>();
		Optional<Empleado> empleado = empleadoRepository.findById(id);
		if (empleado.isPresent()) {
			response.setCodigoRespuesta(0);
			response.setMensaje("Ok");
			response.setRespuesta(empleado.get());
		} else {
			response.setCodigoRespuesta(1001);
			response.setMensaje("No se encontró el empleado con el id: " + id);
		}
		LOGGER.info(response);
		return response;
	}
	

	@Override
	public Response<List<Empleado>> lista() {
		Response<List<Empleado>> response = new Response<>();
		List<Empleado> empleados = empleadoRepository.findAll();
		LOGGER.info(empleados);
		if (empleados.isEmpty()) {
			response.setCodigoRespuesta(1000);
			response.setMensaje("No se encontraron empleados.");
			LOGGER.info(response);
			return response;
		} else {
			response.setCodigoRespuesta(0);
			response.setMensaje("Ok");
			response.setRespuesta(empleados);
			LOGGER.info(response);
			return response;
		}

	}

	@Override
	public Response<Empleado> actualiza(Long id, Empleado empleado) {
		LOGGER.info(id);
		LOGGER.info(empleado);
		Response<Empleado> response = new Response<>();
		try {
			Optional<Empleado> empleadoConsulta = empleadoRepository.findById(id);
			if (empleadoConsulta.isPresent()) {
				empleado.setId(id);
				Empleado empleadoActualizado = empleadoRepository.save(empleado);
				response.setCodigoRespuesta(0);
				response.setMensaje("Ok");
				response.setRespuesta(empleadoActualizado);
				LOGGER.info(response);
				return response;
			} else {
				response.setCodigoRespuesta(1002);
				response.setMensaje("No fue posible actualizar el empleado, no existe el ID: " + id);
				LOGGER.info(response);
				return response;
			}
		} catch (ConstraintViolationException e) {
			response.setCodigoRespuesta(1005);
			response.setMensaje(e.getConstraintViolations().stream().findFirst().get().getMessage());
			LOGGER.info(response);
			return response;
		}

	}

	@Override
	public Response<Void> elimina(Long id) {
		Response<Void> response = new Response<>();
		Optional<Empleado> empleadoConsulta = empleadoRepository.findById(id);
		if (empleadoConsulta.isPresent()) {
			empleadoConsulta.get().setId(id);
			empleadoRepository.delete(empleadoConsulta.get());
			response.setCodigoRespuesta(0);
			response.setMensaje("Ok");
			LOGGER.info(response);
			return response;
		} else {
			response.setCodigoRespuesta(1002);
			response.setMensaje("No fue posible eliminar el empleado, no existe el ID: " + id);
			LOGGER.info(response);
			return response;
		}

	}

}
