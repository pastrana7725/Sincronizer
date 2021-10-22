/**  
 * @Title:  TaskLogsService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 9:07:42 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.Date;
import java.util.List;

import co.edu.usbcali.sincronizer.domain.TasksLogs;
import co.edu.usbcali.sincronizer.dto.TasksLogsDTO;

/**   
 * @ClassName:  TaskLogsService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 9:07:42 a. m.      
 * @Copyright:  USB
 */
public interface TaskLogsService {

	//BUSCAMOS UN REGISTRO POR ID
	
	public TasksLogs findById(Long id) throws Exception;

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
	
	public TasksLogs guardarTaskLogs(TasksLogsDTO taskLogsDTO)throws Exception;
	
	public TasksLogs actualizarTaskLogs(TasksLogsDTO taskLogsDTO) throws Exception;
	
	public void eliminarTaskLogs(Long id)throws Exception;
	
}
