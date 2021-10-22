
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.Task;
import co.edu.usbcali.sincronizer.dto.TaskDTO;

/**
 * 
 * @ClassName:  TaskService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 6:20:50 p. m.      
 * @Copyright:  USB
 */
public interface TaskService {

	//CONSULTAMOS POR ID
	public Task findById(String id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<Task> findByStatus(String status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public List<Task> findByNameIgnoreCase(String name) throws Exception;
	
	//GUARDAMOS
	public Task guardarTask (TaskDTO taskDTO) throws Exception;
	
	//ACTUALIZAMOS
	public Task actualizarTask (TaskDTO taskDTO) throws Exception;
	
	//ELIMINAMOS
	public void eliminarTask(String id) throws Exception;
}
