/**  
 * @Title:  TaskRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:54:45 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.Task;

/**   
 * @ClassName:  TaskRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:54:45 a. m.      
 * @Copyright:  USB
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

	
	//CONSULTAMOS POR ID
	public Task findById(String id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<Task> findByStatus(String Status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public List<Task> findByNameIgnoreCase(String name) throws Exception;
	

	
}
