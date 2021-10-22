/**  
 * @Title:  LogsRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   13/10/2021 2:48:28 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.Logs;

/**   
 * @ClassName:  LogsRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   13/10/2021 2:48:28 p. m.      
 * @Copyright:  USB
 */
public interface LogsRepository extends JpaRepository<Logs,Long>{

	//CONSULTAMOS POR ID
	public Logs findById(long id) throws Exception;
	
}
