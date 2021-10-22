/**  
 * @Title:  TaskDepositRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:55:27 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.TaskDeposit;

/**   
 * @ClassName:  TaskDepositRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:55:27 a. m.      
 * @Copyright:  USB
 */
public interface TaskDepositRepository extends JpaRepository<TaskDeposit, Long> {

	//CONSULTAMOS POR ID
	public TaskDeposit findById(long id) throws Exception;
	
	//CONSULTAMOS POR STATUS
	public List<TaskDeposit> findByStatus(String Status) throws Exception;
	
	//CONSULTAMOS POR NOMBRE
	public TaskDeposit findByNameIgnoreCase(String name) throws Exception;
	
}
