/**  
 * @Title:  TaskTest.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 2:28:52 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.sincronizer.dto.TaskDTO;
import co.edu.usbcali.sincronizer.service.TaskService;

@SpringBootTest
@Rollback(false)
public class TaskTest {

	@Autowired
	private TaskService taskService;
	
	@Test
	@Transactional
	void debeGuardarTarea() {
		
		try {
			TaskDTO taskDTO = new TaskDTO();
			
			taskDTO.setId("tYZzsioH6kSgdBQwSXl90GUADr9i");
			taskDTO.setNotes("Esta es una nota de prueba");
			taskDTO.setName("ir a la tienda");
			taskDTO.setStartDate(new Date());
			taskDTO.setDueDate(new Date());
			taskDTO.setComments("Comentario de prueba");
			taskDTO.setChecklist("CheckList de prueba");
			taskDTO.setDepositId(1);
			taskDTO.setLabelId(1);
			taskDTO.setPriorityId(2);
			taskDTO.setProjectId("IBNeAZ3WxEOROqSzmeO3XWUABYXE");
			taskDTO.setStatusId(3);
			taskService.guardarTask(taskDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeActualizarTarea() {
		
		try {
			TaskDTO taskDTO = new TaskDTO();
			
			taskDTO.setId("tYZzsioH6kSgdBQwSXl90GUADr9i");
			taskDTO.setNotes("Esta es una nota de prueba actualizada");
			taskDTO.setName("ir a la tienda");
			taskDTO.setStartDate(new Date());
			taskDTO.setDueDate(new Date());
			taskDTO.setComments("Comentario de prueba");
			taskDTO.setChecklist("CheckList de prueba");
			taskDTO.setDepositId(1);
			taskDTO.setLabelId(1);
			taskDTO.setPriorityId(2);
			taskDTO.setProjectId("IBNeAZ3WxEOROqSzmeO3XWUABYXE");
			taskDTO.setStatusId(3);
			taskService.actualizarTask(taskDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void eliminarTarea() {
		try {
			taskService.eliminarTask("tYZzsioH6kSgdBQwSXl90GUADr9i");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
