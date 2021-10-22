/**  
 * @Title:  EmployeesServiceImp.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 8:04:41 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.dto.EmployeesDTO;
import co.edu.usbcali.sincronizer.repository.EmployeesRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  EmployeesServiceImp   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 8:04:41 a. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Override
	public Employees findById(String id) throws Exception {
		Employees employee=null;
		
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		
		employee=employeesRepository.findById(id);
		
		return employee;
	}

	
	@Override
	public List<Employees> findByStatus(String status) throws Exception {
		List<Employees> employees= null;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		employees= employeesRepository.findByStatus(status);
		
		return employees;
	}
	
public Employees guardarEmpleado(EmployeesDTO employeeDTO) throws Exception{
		
		
		Employees employee =new Employees();
		
		
		//VALIDACIONES DE CODIGO
		if(Utilities.isLongerThan(employeeDTO.getId(), 100)) {
			throw new Exception("El codigo del empleado no puede pasar los 100 caracteres ");
		}
		
		if(Utilities.isEmpty(employeeDTO.getId())) {
			throw new Exception("El codigo del empleado es obligatorio ");
		}
		employee.setId(employeeDTO.getId());
		
		//VALIDACIONES DE NOMBRE
		
		if(Utilities.isEmpty(employeeDTO.getName())) {
			throw new Exception("El Nombre del empleado no puede quedar vacio ");
		}
		
		if(!Utilities.isOnlyLetters(employeeDTO.getName())) {
			throw new Exception("El Nombre del empleado debe contener solo letras ");
		}
		
		if(Utilities.isLongerThan(employeeDTO.getName(),100)) {
			throw new Exception("El Nombre del empleado no puede pasar los 100 caracteres ");
		}
		employee.setName(employeeDTO.getName());
		
		//VALIDACIONES DE LASTNAME
		if(!Utilities.isOnlyLetters(employeeDTO.getLastName())) {
			throw new Exception("El Apellido del empleado debe contener solo letras ");
		}
		if(Utilities.isEmpty(employeeDTO.getLastName())) {
			throw new Exception("El Apellido del empleado no puede quedar vacio ");
		}
		if(Utilities.isLongerThan(employeeDTO.getLastName(),100)) {
			throw new Exception("El Apellido del empleado no puede pasar los 100 caracteres ");
		}
		employee.setLastName(employeeDTO.getLastName());
		
		//VALIDACIONES DE EMAIL
		
		if(!Utilities.isValidEmail(employeeDTO.getEmail())) {
			throw new Exception("El Correo no tiene un formato adecuado ");
		}
		if(Utilities.isEmpty(employeeDTO.getEmail())) {
			throw new Exception("El Correo no puede quedar vacio ");
		}
		employee.setEmail(employeeDTO.getEmail());
		
		
		//VALIDACIONES DE STATUS
		
		if(Utilities.isEmpty(employeeDTO.getStatus())) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(employeeDTO.getStatus(), 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!employeeDTO.getStatus().equals(Constantes.ACTIVO) && !employeeDTO.getStatus().equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		employee.setStatus(employeeDTO.getStatus());
		
		employeesRepository.save(employee);
		return employee;
	
		
	}
	

	public Employees actualizarEmpleado(EmployeesDTO employeeDTO) throws Exception{
		
		
		Employees employee= new Employees();
		
		//VALIDACIONES DE CODIGO
		if(Utilities.isLongerThan(employeeDTO.getId(), 100)) {
			throw new Exception("El codigo del empleado no puede pasar los 100 caracteres ");
		}
		
		if(Utilities.isEmpty(employeeDTO.getId())) {
			throw new Exception("El codigo del empleado es obligatorio ");
		}
		employee.setId(employeeDTO.getId());
		
		//VALIDACIONES DE NOMBRE
		
		if(Utilities.isEmpty(employeeDTO.getName())) {
			throw new Exception("El Nombre del empleado no puede quedar vacio ");
		}
		
		if(!Utilities.isOnlyLetters(employeeDTO.getName())) {
			throw new Exception("El Nombre del empleado debe contener solo letras ");
		}
		
		if(Utilities.isLongerThan(employeeDTO.getName(),100)) {
			throw new Exception("El Nombre del empleado no puede pasar los 100 caracteres ");
		}
		employee.setName(employeeDTO.getName());
		
		//VALIDACIONES DE LASTNAME
		if(!Utilities.isOnlyLetters(employeeDTO.getLastName())) {
			throw new Exception("El Apellido del empleado debe contener solo letras ");
		}
		if(Utilities.isEmpty(employeeDTO.getLastName())) {
			throw new Exception("El Apellido del empleado no puede quedar vacio ");
		}
		if(Utilities.isLongerThan(employeeDTO.getLastName(),100)) {
			throw new Exception("El Apellido del empleado no puede pasar los 100 caracteres ");
		}
		employee.setLastName(employeeDTO.getLastName());
		
		//VALIDACIONES DE EMAIL
		
		if(!Utilities.isValidEmail(employeeDTO.getEmail())) {
			throw new Exception("El Correo no tiene un formato adecuado ");
		}
		if(Utilities.isEmpty(employeeDTO.getEmail())) {
			throw new Exception("El Correo no puede quedar vacio ");
		}
		employee.setEmail(employeeDTO.getEmail());
		
		
		//VALIDACIONES DE STATUS
		
		if(Utilities.isEmpty(employeeDTO.getStatus())) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(employeeDTO.getStatus(), 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!employeeDTO.getStatus().equals(Constantes.ACTIVO) && !employeeDTO.getStatus().equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		employee.setStatus(employeeDTO.getStatus());
		
		employeesRepository.save(employee);
		return employee;
		
	}
	
	public void eliminarEmpleado(String emp_id)throws Exception {
		
		if(emp_id==null) {
			throw new Exception("El id del empleado es oblugatorio");
			
		}
		Employees employeeBD=employeesRepository.findById(emp_id);
		
		if(employeeBD!=null) {
			employeesRepository.delete(employeeBD);
			
		}else {
			throw new Exception("El empleado no se encontro");
		}
		
	}


}
