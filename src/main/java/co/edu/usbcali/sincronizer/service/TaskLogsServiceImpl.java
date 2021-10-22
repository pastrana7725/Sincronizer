/**  
 * @Title:  TaskLogsServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 9:07:56 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.Logs;
import co.edu.usbcali.sincronizer.domain.Task;
import co.edu.usbcali.sincronizer.domain.TasksLogs;
import co.edu.usbcali.sincronizer.dto.TasksLogsDTO;
import co.edu.usbcali.sincronizer.repository.LogsRepository;
import co.edu.usbcali.sincronizer.repository.TaskRepository;
import co.edu.usbcali.sincronizer.repository.TasksLogsRepository;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  TaskLogsServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 9:07:56 a. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TaskLogsServiceImpl implements TaskLogsService {
	
	@Autowired
	private TasksLogsRepository tasksLogsRepository;
	
	@Autowired
	private TaskRepository tasksRepository;
	
	@Autowired
	private LogsRepository logsRepository;
	
	@Override
	public TasksLogs findById(Long id) throws Exception {
		
		TasksLogs taskLog;
		
		if(id==null) {
			throw new Exception ("El id no puede ser nulo");
		}
		if(id<0) {
			throw new Exception("El id no puede ser negativo");
		}
		
		taskLog=tasksLogsRepository.findById(id).get();
		
		return taskLog;
	}

	
	@Override
	public List<TasksLogs> findByLogs_CreationDate(Date fecha) throws Exception {
		
		List<TasksLogs> tasksLogs;
		if(fecha==null) {
			throw new Exception ("La fecha no puede ser nula");
		}
		//FALTA COMPLETAR
		tasksLogs=tasksLogsRepository.findByLogs_CreationDate(fecha);
		return tasksLogs;
	}


	@Override
	public List<TasksLogs> findByLogs_CreationDateBetween(Date fechaInicial, Date fechaFinal) throws Exception {
		
		List<TasksLogs> tasksLogs;
		if(fechaInicial==null) {
			throw new Exception ("La fecha inicial no puede ser nula");
		}
		if(fechaFinal==null) {
			throw new Exception ("La fecha final no puede ser nula");
		}
		//FALTA COMPLETAR
		tasksLogs=tasksLogsRepository.findByLogs_CreationDateBetween(fechaInicial, fechaFinal);
		return tasksLogs;
	
	}

	@Override
	public List<TasksLogs> findByTask_Id(String idTask) throws Exception {
		
		List <TasksLogs> tasksLogs;
		
		if(idTask==null) {
			throw new Exception ("El id no puede ser nulo");
		}
		
		tasksLogs=tasksLogsRepository.findByTask_Id(idTask);
		return tasksLogs;
	}

	
	@Override
	public List<TasksLogs> findByTask_NameIgnoreCase(String nombre) throws Exception {
		
		List <TasksLogs> tasksLogs;
		
		if(nombre==null) {
			throw new Exception ("El nombre no puede ser nulo");
		}
		if(Utilities.isLongerThan(nombre, 100)){
			throw new Exception ("El nombre no puede sobre pasar los 100 carácteres");
		}
		if(!Utilities.isOnlyLetters(nombre)) {
			throw new Exception("El nombre solo puede contener letras");
		}
		tasksLogs=tasksLogsRepository.findByTask_NameIgnoreCase(nombre);
		
		return tasksLogs;
	}

	
	@Override
	public List<TasksLogs> findByLogs_EmployeeRegistrador(String idEmpleado) throws Exception {
		
		List <TasksLogs> tasksLogs;
		
		if(idEmpleado==null) {
			throw new Exception ("El id no puede ser nulo");
		}
		
		tasksLogs=tasksLogsRepository.findByLogs_EmployeeRegistrador(idEmpleado);
		return tasksLogs;
		
	}
	
	@Override
	public TasksLogs guardarTaskLogs(TasksLogsDTO taskLogsDTO)throws Exception{
		
		
		TasksLogs tasksLogs=new TasksLogs();
		Task task =new Task();
		Logs logs =new Logs();
	
		task=tasksRepository.findById(taskLogsDTO.getId_task());
		
		if(task==null) {
			throw new Exception("El id de task no existe");
		}
		
		tasksLogs.setTask(task);
		
		logs=logsRepository.findById(taskLogsDTO.getId_lgs());
		
		if(logs==null) {
			throw new Exception("El logs de task no existe");
		}
	
		tasksLogs.setLogs(logs);
		tasksLogsRepository.save(tasksLogs);
		
		
		return tasksLogs;
	}
	
	public TasksLogs actualizarTaskLogs(TasksLogsDTO taskLogsDTO) throws Exception{
		
		TasksLogs tasksLogs=null;
		Task task =null;
		Logs logs =null;
	
		tasksLogs=tasksLogsRepository.findById(taskLogsDTO.getId());
		
		task=tasksRepository.findById(taskLogsDTO.getId_task());
		if(task==null) {
			throw new Exception("El id de task no existe");
		}
		
		tasksLogs.setTask(task);
		
		logs=logsRepository.findById(taskLogsDTO.getId_lgs());
		
		if(logs==null) {
			throw new Exception("El logs de task no existe");
		}
	
		tasksLogs.setLogs(logs);
		tasksLogsRepository.save(tasksLogs);
		
		return tasksLogs;
		
	}
	
	@Override
	public void eliminarTaskLogs(Long id)throws Exception{
		
		if(id==null) {
			throw new Exception("El id es obligatorio");
			
		}
		
		Optional<TasksLogs> taskLogsDB=tasksLogsRepository.findById(id);
		
		if(taskLogsDB.isPresent()) {
			tasksLogsRepository.delete(taskLogsDB.get());
			
		}else {
			throw new Exception("El TaskLogs no se encontro");
		}
		
		
	}

}
