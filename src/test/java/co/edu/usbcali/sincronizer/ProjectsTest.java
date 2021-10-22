/**  
 * @Title:  ProjectsTest.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 10:40:46 a. m.   
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

import co.edu.usbcali.sincronizer.dto.ProjectsDTO;
import co.edu.usbcali.sincronizer.service.ProjectsService;
import co.edu.usbcali.sincronizer.utils.Constantes;

/**   
 * @ClassName:  ProjectsTest   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 10:40:46 a. m.      
 * @Copyright:  USB
 */
@SpringBootTest
@Rollback(false)
public class ProjectsTest {

	@Autowired
	private ProjectsService projectsService;
	
	@Test
	@Transactional
	void debeGuardarProjecto() {
		
		try {
			ProjectsDTO projectsDTO= new ProjectsDTO();
			
			projectsDTO.setId("IBNeAZ3WxEOROqSzmeO3XRUABYXE");
			projectsDTO.setName("PRUEBAAAAA");
			projectsDTO.setOwner("Esta es la descripcion de la pruebaa");
			projectsDTO.setStatus(Constantes.ACTIVO);
			projectsDTO.setCreationDate(new Date());
			projectsDTO.setEmployeeId("baa3d012-31a9-4cd7-9b03-b3f01b1dcb21");
			
			projectsService.guardarProject(projectsDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeActualizarProjecto() {
		
		try {
			ProjectsDTO projectsDTO= new ProjectsDTO();
			
			projectsDTO.setId("IBNeAZ3WxEOROqSzmeO3XRUABYXE");
			projectsDTO.setName("PRUEBA ACTUALIZADA");
			projectsDTO.setOwner("Esta es la descripcion de la pruebaa");
			projectsDTO.setStatus(Constantes.ACTIVO);
			projectsDTO.setCreationDate(new Date());
			projectsDTO.setEmployeeId("baa3d012-31a9-4cd7-9b03-b3f01b1dcb21");
			
			projectsService.actualizarProject(projectsDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeEliminarProjecto() {
		
		try {
			projectsService.eliminarProjects("IBNeAZ3WxEOROqSzmeO3XRUABYXE");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
