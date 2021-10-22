/**  
 * @Title:  RolesRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:54:33 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.Roles;

/**   
 * @ClassName:  RolesRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:54:33 a. m.      
 * @Copyright:  USB
 */
public interface RolesRepository extends JpaRepository<Roles, Long> {

	//CONSULTAMOS UN ROL POR ID
	public Optional<Roles> findById(Long id);
	
	//CONSULTAMOS LOS ROLES POR STATUS
	public List<Roles> findByStatus(String Status) throws Exception;
	
	//CONSULTAMOS UN ROL POR NOMBRE
	public Roles findByNameIgnoreCase(String name) throws Exception;
}
