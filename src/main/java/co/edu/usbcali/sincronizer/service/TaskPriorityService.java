/**  
 * @Title:  TaskPriorityService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 4:47:15 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.TaskPriority;

public interface TaskPriorityService {

	//CONSULTAMOS POR ID
	public TaskPriority findById(Long id) throws Exception;
		
	//CONSULTAMOS POR STATUS
	public List<TaskPriority> findByStatus(String status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskPriority findByNameIgnoreCase(String name) throws Exception;

}
