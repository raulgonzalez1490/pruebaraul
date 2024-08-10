package mx.com.raulgonzalez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.raulgonzalez.model.Empleado;

/**
 * Descripción: Interface que hereda de JpaReposotiry para ejecutar las operaciones
 * del CRUD para la gestión de empleados.
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
