/**  
 * @Title:  EmployeesService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 8:04:12 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.dto.EmployeesDTO;

/**   
 * @ClassName:  EmployeesService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 8:04:12 a. m.      
 * @Copyright:  USB
 */
public interface EmployeesService {

	//Buscamos un empleado por su id
	public Employees findById(String id) throws Exception;
	
	//Buscamos los empleados por su estado
	public List<Employees> findByStatus(String status) throws Exception;
	
	//guardamos
	public Employees guardarEmpleado(EmployeesDTO employeeDTO) throws Exception;
	
	//actualizamos
	public Employees actualizarEmpleado(EmployeesDTO employeeDTO) throws Exception;
	
	//eliminamos
	public void eliminarEmpleado(String emp_id)throws Exception;
}
