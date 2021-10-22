/**  
 * @Title:  TaskDepositServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 2:49:29 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.TaskDeposit;
import co.edu.usbcali.sincronizer.repository.TaskDepositRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  TaskDepositServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 2:49:29 p. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TaskDepositServiceImpl implements TaskDepositService{

	@Autowired
	private TaskDepositRepository taskDepositRepository;
	
	@Override
	public TaskDeposit findById(Long id) throws Exception {
		
		TaskDeposit taskDeposit;
		
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		
		taskDeposit= taskDepositRepository.findById(id).get();
		return taskDeposit;
	}

	@Override
	public List<TaskDeposit> findByStatus(String status) throws Exception {
		
		List<TaskDeposit> taskDeposit= null;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		taskDeposit=taskDepositRepository.findByStatus(status);
		return taskDeposit;
	}

	@Override
	public TaskDeposit findByNameIgnoreCase(String name) throws Exception {
		TaskDeposit taskDeposit= null;
		
		if(Utilities.isEmpty(name)) {
			throw new Exception("El nombre es obligatorio");
		}
		
		if(Utilities.isLongerThan(name, 100)) {
			throw new Exception("El nombre debe tener máximo 100 carácteres");
		}
		
		if(!Utilities.isOnlyLetters(name)) {
			throw new Exception("El nombre debe contener solamente letras");
		}
		
		taskDeposit=taskDepositRepository.findByNameIgnoreCase(name);
		return taskDeposit;
	}

	
	
}
