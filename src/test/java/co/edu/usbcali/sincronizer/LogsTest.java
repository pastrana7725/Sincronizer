/**  
 * @Title:  LogsTest.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 12:31:20 p. m.   
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

import co.edu.usbcali.sincronizer.dto.LogsDTO;
import co.edu.usbcali.sincronizer.service.LogsService;

@Rollback(false)
@SpringBootTest
public class LogsTest {
	
	@Autowired
	private LogsService logsService;
	
	@Test
	@Transactional
	void debeGuardarLogs() {
		try {
			LogsDTO logsDTO = new LogsDTO();

			logsDTO.setDescription("Tarea matutina del mes de septiembre");
			logsDTO.setCreationDate(new Date());
			logsDTO.setEmployeeRegistradorId("baa3d012-31a9-4cd7-9b03-b3f01b1dcb21");
			logsService.guardarLogs(logsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeActualizarLogs() {
		try {
			LogsDTO logsDTO = new LogsDTO();
			logsDTO.setId(4L);
			logsDTO.setDescription("Tarea matuutina del mes de septiembre");
			logsDTO.setCreationDate(new Date());
			logsDTO.setEmployeeRegistradorId("baa3d012-31a9-4cd7-9b03-b3f01b1dcb21");
			logsService.actualizarLogs(logsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void debeEliminarLogs() {

		try {

			logsService.eliminarLogs(5L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
