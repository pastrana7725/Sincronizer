/**  
 * @Title:  TaksLogsTest.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 3:23:24 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.sincronizer.dto.TasksLogsDTO;
import co.edu.usbcali.sincronizer.service.TaskLogsService;

@SpringBootTest
@Rollback(false)
public class TaksLogsTest {

	@Autowired
	private TaskLogsService taskLogsService;
	
	
	@Test
	@Transactional
	void debeGuardarTaskLog() {
		
		try {
			TasksLogsDTO taskLogsDTO=new TasksLogsDTO();
			
			taskLogsDTO.setId_task("tYZzsioH6kSgdBQwSXl60GUADr9i");
			taskLogsDTO.setId_lgs(1L);
			
			taskLogsService.guardarTaskLogs(taskLogsDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test
	@Transactional
	void debeActualizarTaskLogs() {
		
		try {
			TasksLogsDTO taskLogsDTO=new TasksLogsDTO();
			
			taskLogsDTO.setId(4L);
			taskLogsDTO.setId_task("tYZzsioH6kSgdBQwSXl60GUADr9i");
			taskLogsDTO.setId_lgs(3L);
			
			taskLogsService.actualizarTaskLogs(taskLogsDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeEliminarTaskLogs() {
		
		try {
			
			taskLogsService.eliminarTaskLogs(4L);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
