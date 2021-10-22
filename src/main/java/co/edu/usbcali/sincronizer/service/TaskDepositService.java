/**  
 * @Title:  TaskDepositService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 2:49:09 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.TaskDeposit;

public interface TaskDepositService {

	//CONSULTAMOS POR ID
	public TaskDeposit findById(Long id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<TaskDeposit> findByStatus(String status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskDeposit findByNameIgnoreCase(String name) throws Exception;
	
}
