/**  
 * @Title:  TaskAssignmentTest.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 3:15:45 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.sincronizer.dto.TaskAssignmentDTO;
import co.edu.usbcali.sincronizer.service.TaskAssignmentService;

@SpringBootTest
@Rollback(false)
public class TaskAssignmentTest {

	@Autowired
	private TaskAssignmentService taskAssignmentService;

	@Test
	@Transactional
	void debeGuardarTaskAssignment() {
		try {
			TaskAssignmentDTO taskAssignmentDTO = new TaskAssignmentDTO();
			
			taskAssignmentDTO.setEmployeeId("baa3d012-31a9-4cd7-9b03-b3f01b1dcb21");
			taskAssignmentDTO.setTaskId("tYZzsioH6kSgdBQwSXl60GUADr9i");
			taskAssignmentDTO.setRolId(1);			
			taskAssignmentService.guardarTaskAssignment(taskAssignmentDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	@Transactional
	void debeActualizarTaskAssignment() {
		try {
			TaskAssignmentDTO taskAssignmentDTO = new TaskAssignmentDTO();
			
			taskAssignmentDTO.setId(4L);
			taskAssignmentDTO.setEmployeeId("baa3d012-31a9-4cd7-9b03-b3f01b1dcb21");
			taskAssignmentDTO.setTaskId("tYZzsioH6kSgdBQwSXl60GUADr9i");
			taskAssignmentDTO.setRolId(3);			
			taskAssignmentService.actualizarTaskAssignment(taskAssignmentDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void debeEliminarTaskAssigment() {

		try {

			taskAssignmentService.eliminarTaskAssignment(4L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
