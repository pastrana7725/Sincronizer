/**  
 * @Title:  EmployeesRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:53:20 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import co.edu.usbcali.sincronizer.domain.Employees;

/**   
 * @ClassName:  EmployeesRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:53:20 a. m.      
 * @Copyright:  USB
 */
public interface EmployeesRepository extends JpaRepository <Employees, Long> {

	//Buscamos un empleado por su id
	public Employees findById(String id) throws Exception;
	
	//Buscamos los empleados por su estado
	public List<Employees> findByStatus(String status) throws Exception;
	
	
}
