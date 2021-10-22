/**  
 * @Title:  TaskStatusServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   13/10/2021 8:53:47 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.TaskStatus;
import co.edu.usbcali.sincronizer.repository.TaskStatusRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  TaskStatusServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   13/10/2021 8:53:47 a. m.      
 * @Copyright:  USB
 */

@Scope("singleton")
@Service
public class TaskStatusServiceImpl implements TaskStatusService {

	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Override
	public TaskStatus findById(Long id) throws Exception {
		TaskStatus taskStatus=null;
		
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		if(id < 0) {
			throw new Exception("El id no puede ser negativo");
		}
		
		taskStatus= taskStatusRepository.findById(id).get();
		return taskStatus;
	}

	@Override
	public List<TaskStatus> findByStatus(String status) throws Exception {
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		return null;
	}

	@Override
	public TaskStatus findByNameIgnoreCase(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
