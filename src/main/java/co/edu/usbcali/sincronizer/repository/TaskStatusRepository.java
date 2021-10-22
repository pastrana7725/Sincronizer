/**  
 * @Title:  TaskStatusRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:56:19 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.TaskStatus;

/**   
 * @ClassName:  TaskStatusRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:56:19 a. m.      
 * @Copyright:  USB
 */
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {

	//CONSULTAMOS POR ID
	public TaskStatus findById(long id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<TaskStatus> findByStatus(String status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskStatus findByNameIgnoreCase(String name) throws Exception;
	
}
