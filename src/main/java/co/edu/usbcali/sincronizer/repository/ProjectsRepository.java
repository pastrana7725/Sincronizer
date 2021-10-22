/**  
 * @Title:  ProjectsRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:53:38 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.Projects;

/**   
 * @ClassName:  ProjectsRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:53:38 a. m.      
 * @Copyright:  USB
 */
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

	//BUSCAMOS NUESTRO PROYECTO POR ID
	public Projects findById(String idProject) throws Exception;
	
	//BUSCAMOS LOS PROYECTOS POR STATUS
	public List <Projects> findByStatus(String status) throws Exception;
	
	//BUSCAMOS EL PROYECTO POR NOMBRE y STATUS
	public List <Projects> findByNameIgnoreCaseAndStatus(String name, String status) throws Exception;
	
}
