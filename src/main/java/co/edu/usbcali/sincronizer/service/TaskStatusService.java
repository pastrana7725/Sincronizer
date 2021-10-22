/**  
 * @Title:  TaskStatusService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   13/10/2021 8:53:26 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.TaskStatus;

/**   
 * @ClassName:  TaskStatusService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   13/10/2021 8:53:26 a. m.      
 * @Copyright:  USB
 */
public interface TaskStatusService {

	//CONSULTAMOS POR ID
	public TaskStatus findById(Long id) throws Exception;
		
	//CONSULTAMOS POR STATUS
	public List<TaskStatus> findByStatus(String status) throws Exception;
		
	//CONSULTAMOS POR NOMBRE
	public TaskStatus findByNameIgnoreCase(String name) throws Exception;
		
}
