/**  
 * @Title:  TaskLabelsRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:55:44 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.TaskLabels;

/**   
 * @ClassName:  TaskLabelsRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:55:44 a. m.      
 * @Copyright:  USB
 */
public interface TaskLabelsRepository extends JpaRepository<TaskLabels, Long> {

	//CONSULTAMOS POR ID
	public TaskLabels findById(long id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<TaskLabels> findByStatus(String Status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskLabels findByNameIgnoreCase(String name) throws Exception;
	
}
