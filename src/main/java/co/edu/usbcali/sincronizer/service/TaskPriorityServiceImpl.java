/**  
 * @Title:  TaskPriorityServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 4:47:47 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.TaskPriority;
import co.edu.usbcali.sincronizer.repository.TaskPriorityRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  TaskPriorityServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 4:47:47 p. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TaskPriorityServiceImpl implements TaskPriorityService {
	
	@Autowired
	private TaskPriorityRepository taskPriorityRepository;
	
	@Override
	public TaskPriority findById(Long id) throws Exception {
		
		TaskPriority taskPriority;
		
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		
		taskPriority=taskPriorityRepository.findById(id).get();
		
		return taskPriority;
	}

	@Override
	public List<TaskPriority> findByStatus(String status) throws Exception {
		
		List<TaskPriority> taskPriority;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		taskPriority=taskPriorityRepository.findByStatus(status);
		return taskPriority;
	}

	@Override
	public TaskPriority findByNameIgnoreCase(String name) throws Exception {
		
		TaskPriority taskPriority;
		
		if(Utilities.isEmpty(name)) {
			throw new Exception("El nombre es obligatorio");
		}
		
		if(Utilities.isLongerThan(name, 100)) {
			throw new Exception("El nombre debe tener máximo 100 carácteres");
		}
		
		if(!Utilities.isOnlyLetters(name)) {
			throw new Exception("El nombre debe contener solamente letras");
		}
		
		taskPriority=taskPriorityRepository.findByNameIgnoreCase(name);
		
		return taskPriority;
	}

}
