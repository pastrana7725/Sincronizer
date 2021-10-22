/**  
 * @Title:  ProjectsService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   18/10/2021 9:08:02 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.Projects;
import co.edu.usbcali.sincronizer.dto.ProjectsDTO;

/**   
 * @ClassName:  ProjectsService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   18/10/2021 9:08:02 a. m.      
 * @Copyright:  USB
 */
public interface ProjectsService {

	//BUSCAMOS NUESTRO PROYECTO POR ID
	public Projects findById(String idProject) throws Exception;
	
	//BUSCAMOS LOS PROYECTOS POR STATUS
	public List <Projects> findByStatus(String status) throws Exception;
	
	//BUSCAMOS EL PROYECTO POR NOMBRE y STATUS
	public List <Projects> findByNameIgnoreCaseAndStatus(String name, String status) throws Exception;
	
	//GUARDAMOS
	public Projects guardarProject(ProjectsDTO projectDTO) throws Exception;
	
	//ACTUALIZAMOS
	public Projects actualizarProject(ProjectsDTO projectDTO) throws Exception;
	
	//ELIMINAMOS
	public void eliminarProjects(String id) throws Exception;
}
