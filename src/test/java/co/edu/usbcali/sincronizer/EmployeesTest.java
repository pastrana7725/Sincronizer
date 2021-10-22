/**  
 * @Title:  EmployeesTest.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 8:20:58 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.dto.EmployeesDTO;
import co.edu.usbcali.sincronizer.service.EmployeesService;
import co.edu.usbcali.sincronizer.service.EmployeesServiceImpl;
import co.edu.usbcali.sincronizer.utils.Constantes;

/**   
 * @ClassName:  EmployeesTest   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 8:20:58 a. m.      
 * @Copyright:  USB
 */
@Rollback(false)
@SpringBootTest
public class EmployeesTest {

	@Autowired
	private EmployeesService employeesService;
	
	@Test
	void debeRetornarUnEpleadoPorId() {
		
		Employees employee=null;
		try {
			employee= employeesService.findById("baa3d012-31a9-4cd7-9b03-b3f01b1dc21");
			System.out.println(employee.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void debeRetornarEmpleadosPorStatus() {
		
		List<Employees> employees=null;
		try {
			employees= employeesService.findByStatus("A");
			
			for (Employees employee : employees) {
				System.out.println(employee.getId());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeGuardarEmpleado() {
		try {
			EmployeesDTO employeeDTO =new EmployeesDTO();
				
			employeeDTO.setId("baa3d012-31a9-4cd7-9b03-b3f03b1dcb22");
			employeeDTO.setName("Carlos");
			employeeDTO.setLastName("Mario");
			employeeDTO.setEmail("garaicoa7658@gmail.com");
			employeeDTO.setStatus(Constantes.ACTIVO);
			
			employeesService.guardarEmpleado(employeeDTO);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test
	@Transactional
	void debeActualizarEmpleado() {
		try {
			
			
			EmployeesDTO employeeDTO =new EmployeesDTO();
			
			
			employeeDTO.setId("baa3d012-31a9-4cd7-9b03-b3f03b1dcb22");
			employeeDTO.setName("Carlos");
			employeeDTO.setLastName("marito");
			employeeDTO.setEmail("garaicoa76758@gmail.com");
			employeeDTO.setStatus(Constantes.ACTIVO);
			
			employeesService.actualizarEmpleado(employeeDTO);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	
	@Test
	@Transactional
	void debeEliminarEmpleado() {
		
		try {
			
			employeesService.eliminarEmpleado("baa3d012-31a9-4cd7-9b03-b3f01b1dcb22");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
