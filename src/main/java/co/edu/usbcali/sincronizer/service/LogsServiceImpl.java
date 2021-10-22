/**  
 * @Title:  LogsServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 8:54:08 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import co.edu.usbcali.sincronizer.utils.Utilities;
import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.domain.Logs;
import co.edu.usbcali.sincronizer.dto.LogsDTO;
import co.edu.usbcali.sincronizer.repository.EmployeesRepository;
import co.edu.usbcali.sincronizer.repository.LogsRepository;

/**   
 * @ClassName:  LogsServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 8:54:08 a. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class LogsServiceImpl implements LogsService{
	
	@Autowired
	private LogsRepository logsRepository;
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Override
	public Logs findById(Long id) throws Exception {
		
		Logs log;
		
		if(id==null) {
			throw new Exception ("El id no puede ser nulo");
		}
		if(id<0) {
			throw new Exception("El id no puede ser negativo");
		}
		
		log= logsRepository.findById(id).get();
		
		return log;
	}
	
	public Logs guardarLogs(LogsDTO logsDTO) throws Exception {

		Logs log = new Logs();
		Employees employee = new Employees();

		// VALIDACION DE LA CREACION DE LA FECHA
		if (logsDTO.getCreationDate() == null) {
			throw new Exception("la fecha de creacion no puede ser nula");
		}
		log.setCreationDate(logsDTO.getCreationDate());

		// VALIDACION DE LA DESCRIPCION
		if (logsDTO.getDescription() == null || Utilities.isEmpty(logsDTO.getDescription())) {
			throw new Exception("La descripcion del logs es obligatoria");

		}
		if (Utilities.isLongerThan(logsDTO.getDescription(), 500)) {
			throw new Exception("El texto de la descripcion no puede pasar de 500 caracteres");
		}
		log.setDescription(logsDTO.getDescription());

		// VALIDACION DEL EMPLEADO
		employee = employeesRepository.findById(logsDTO.getEmployeeRegistradorId());

		if (employee == null) {
			throw new Exception("El empleado no existe");
		}
		log.setEmployeeRegistrador(employee);

		logsRepository.save(log);
		return log;
	}
	
	public Logs actualizarLogs(LogsDTO logsDTO) throws Exception {

		Logs log = null;
		Employees employee = null;
		log = logsRepository.findById(logsDTO.getId()).get();

		// VALIDACION DEL ID
		log.setId(logsDTO.getId());

		// VALIDACION DE LA CREACION DE LA FECHA
		if (logsDTO.getCreationDate() == null) {
			throw new Exception("la fecha de creacion no puede ser nula");
		}
		log.setCreationDate(logsDTO.getCreationDate());

		// VALIDACION DE LA DESCRIPCION
		if (logsDTO.getDescription() == null || Utilities.isEmpty(logsDTO.getDescription())) {
			throw new Exception("La descripcion del logs es obligatoria");

		}
		if (Utilities.isLongerThan(logsDTO.getDescription(), 500)) {
			throw new Exception("El texto de la descripcion no puede pasar de 500 caracteres");
		}
		log.setDescription(logsDTO.getDescription());

		// VALIDACION DEL EMPLEADO
		employee = employeesRepository.findById(logsDTO.getEmployeeRegistradorId());

		if (employee == null) {
			throw new Exception("El empleado no existe");
		}
		log.setEmployeeRegistrador(employee);

		logsRepository.save(log);
		return log;
	}
	
	@Override
	public void eliminarLogs(Long id) throws Exception {
		if (id == null) {
			throw new Exception("El id destino es obligatorio");

		}
		Optional<Logs> logsBD = logsRepository.findById(id);

		if (logsBD.isPresent()) {
			logsRepository.delete(logsBD.get());

		} else {
			throw new Exception("El log no se encontro");
		}

	}

}
