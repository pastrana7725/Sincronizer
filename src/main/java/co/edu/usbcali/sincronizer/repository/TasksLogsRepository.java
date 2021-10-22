/**  
 * @Title:  LogsRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 8:43:18 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.sincronizer.domain.TasksLogs;

/**   
 * @ClassName:  LogsRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 8:43:18 a. m.      
 * @Copyright:  USB
 */
public interface TasksLogsRepository extends JpaRepository<TasksLogs, Long> {
	
	//BUSCAMOS UN REGISTRO POR ID
	
	public TasksLogs findById(long id) throws Exception;

	//BUSCAMOS LOS REGISTROS QUE SE REALIZARON EN UNA FECHA
	
	public List<TasksLogs> findByLogs_CreationDate(Date fecha) throws Exception;
	
	//BUSCAMOS LOS REGISTROS QUE SE REALIZARON ENTRE 2 FECHAS
	
	public List<TasksLogs> findByLogs_CreationDateBetween(Date fechaInicial, Date fechaFinal) throws Exception;
	
	//BUSCAMOS LOS REGISTROS SEGÚN EL ID DE UNA TAREA
	
	public List<TasksLogs> findByTask_Id(String idTask) throws Exception;
	
	//BUSCAMOS LOS REGISTROS POR EL NOMBRE DE UNA TAREA
	
	public List<TasksLogs> findByTask_NameIgnoreCase(String nombre) throws Exception;
	
	//BUSCAMOS LOS REGISTROS QUE REALIZÓ UN EMPLEADO BUSCANDO POR ID
	
	public List<TasksLogs> findByLogs_EmployeeRegistrador(String idEmpleado) throws Exception;
	
	
	
}
