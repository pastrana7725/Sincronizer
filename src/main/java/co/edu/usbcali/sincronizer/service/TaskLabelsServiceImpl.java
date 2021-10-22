/**  
 * @Title:  TaskLabelsServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 3:11:27 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.TaskLabels;
import co.edu.usbcali.sincronizer.repository.TaskLabelsRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  TaskLabelsServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 3:11:27 p. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TaskLabelsServiceImpl implements TaskLabelsService {

	@Autowired
	private TaskLabelsRepository taskLabelsRepository;
	
	@Override
	public TaskLabels findById(Long id) throws Exception {
		TaskLabels taskLabels;
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		
		taskLabels=taskLabelsRepository.findById(id).get();
		return taskLabels;
		
	}

	@Override
	public List<TaskLabels> findByStatus(String status) throws Exception {
		List<TaskLabels> taskLabels;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		taskLabels=taskLabelsRepository.findByStatus(status);
		return taskLabels;
	}

	@Override
	public TaskLabels findByNameIgnoreCase(String name) throws Exception {
		
		TaskLabels taskLabels;
		
		if(Utilities.isEmpty(name)) {
			throw new Exception("El nombre es obligatorio");
		}
		
		if(Utilities.isLongerThan(name, 100)) {
			throw new Exception("El nombre debe tener máximo 100 carácteres");
		}
		
		if(!Utilities.isOnlyLetters(name)) {
			throw new Exception("El nombre debe contener solamente letras");
		}
		
		taskLabels=taskLabelsRepository.findByNameIgnoreCase(name);
		return taskLabels;
	}

}
