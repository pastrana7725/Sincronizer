/**  
 * @Title:  RolesService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 2:34:41 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;


import co.edu.usbcali.sincronizer.domain.Roles;

public interface RolesService {

	//CONSULTAMOS UN ROL POR ID
	public Roles findById(Long id) throws Exception;
	
	//CONSULTAMOS LOS ROLES POR STATUS
	public List<Roles> findByStatus(String status) throws Exception;
	
	//CONSULTAMOS UN ROL POR NOMBRE
	public Roles findByNameIgnoreCase(String name) throws Exception;
	
}
