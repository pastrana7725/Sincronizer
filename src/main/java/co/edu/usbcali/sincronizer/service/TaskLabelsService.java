/**  
 * @Title:  TaskLabelsService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 3:11:06 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.TaskLabels;

public interface TaskLabelsService {

	//CONSULTAMOS POR ID
	public TaskLabels findById(Long id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<TaskLabels> findByStatus(String status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskLabels findByNameIgnoreCase(String name) throws Exception;
		
	
}
