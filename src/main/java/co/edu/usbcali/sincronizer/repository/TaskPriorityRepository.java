/**  
 * @Title:  TaskPriorityRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:56:01 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.TaskPriority;

/**   
 * @ClassName:  TaskPriorityRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:56:01 a. m.      
 * @Copyright:  USB
 */
public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long>{

	//CONSULTAMOS POR ID
	public TaskPriority findById(long id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<TaskPriority> findByStatus(String Status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskPriority findByNameIgnoreCase(String name) throws Exception;
	
}
