package mx.com.raulgonzalez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.raulgonzalez.model.Empleado;
import mx.com.raulgonzalez.model.Response;
import mx.com.raulgonzalez.service.EmpleadoService;


/**
 * Descripción: Controlador REST exponer los servicios del CRUD de empleados
 */
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
	
	private EmpleadoService<Empleado> empleadoService;
	
	@Autowired
	public EmpleadoController(EmpleadoService<Empleado> empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Empleado> guarda(@RequestBody Empleado empleado) {
		return empleadoService.guarda(empleado);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Empleado> actualiza(@PathVariable  Long id, @RequestBody Empleado empleado) {
		return empleadoService.actualiza(id, empleado);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Empleado> consulta(@PathVariable  Long id) {
		return empleadoService.consulta(id);
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<Empleado>> lista() {
		return empleadoService.lista();
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Void> elimina(@PathVariable  Long id) {
		return empleadoService.elimina(id);
	}


}
