/**  
 * @Title:  RolesServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 2:35:06 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.Roles;
import co.edu.usbcali.sincronizer.repository.RolesRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  RolesServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 2:35:06 p. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public Roles findById(Long id) throws Exception {
		
		Roles rol;
		
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		
		rol= rolesRepository.findById(id).get();
		return rol;
	}

	@Override
	public List<Roles> findByStatus(String status) throws Exception {
		List<Roles> roles= null;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		roles= rolesRepository.findByStatus(status);
		return roles;
	}

	@Override
	public Roles findByNameIgnoreCase(String name) throws Exception {
		Roles rol = null;
		
		if(Utilities.isEmpty(name)) {
			throw new Exception("El nombre es obligatorio");
		}
		
		if(Utilities.isLongerThan(name, 100)) {
			throw new Exception("El nombre debe tener máximo 100 carácteres");
		}
		
		if(!Utilities.isOnlyLetters(name)) {
			throw new Exception("El nombre debe contener solamente letras");
		}
		rol=rolesRepository.findByNameIgnoreCase(name);
		return rol;
	}

}
