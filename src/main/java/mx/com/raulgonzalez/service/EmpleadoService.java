package mx.com.raulgonzalez.service;

import java.util.List;

import mx.com.raulgonzalez.model.Response;

public interface EmpleadoService<E> {
	
	 /**
     * Decripción: Método para guardar un empleado.
     *
     * @param empleado a guardar
     * @return respuesta genérica con el empleado guardado
     */
	Response<E> guarda(E empleado);
	
	/**
     * Decripción: Método para consultar un empleado por su ID.
     *
     * @param id del empleado
     * @return respuesta genérica con el empleado consultado
     */
	Response<E> consulta(Long id);
	
	/**
     * Decripción: Método para obtener todos los empleados.
     *
     * @return respuesta genérica con la lista de los empleados consultados
     */
	Response<List<E>> lista();
	
	/**
     * Decripción: Método para actualizar un empleado.
     *
     * @param id del empleado a actualizar
     * @param empleado a actualizar
     * @return respuesta genérica con el empleado actualizado
     */
	Response<E> actualiza(Long id, E empleado);
	
	/**
     * Decripción: Método para guardar un empleado.
     *
     * @param id del empleado a eliminar
     */
	Response<Void> elimina(Long id);

}
