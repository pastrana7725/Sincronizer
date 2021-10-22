/**  
 * @Title:  TaskServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 6:19:41 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.Projects;
import co.edu.usbcali.sincronizer.domain.Task;
import co.edu.usbcali.sincronizer.domain.TaskDeposit;
import co.edu.usbcali.sincronizer.domain.TaskLabels;
import co.edu.usbcali.sincronizer.domain.TaskPriority;
import co.edu.usbcali.sincronizer.domain.TaskStatus;
import co.edu.usbcali.sincronizer.dto.TaskDTO;
import co.edu.usbcali.sincronizer.repository.ProjectsRepository;
import co.edu.usbcali.sincronizer.repository.TaskDepositRepository;
import co.edu.usbcali.sincronizer.repository.TaskLabelsRepository;
import co.edu.usbcali.sincronizer.repository.TaskPriorityRepository;
import co.edu.usbcali.sincronizer.repository.TaskRepository;
import co.edu.usbcali.sincronizer.repository.TaskStatusRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  TaskServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 6:19:41 p. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskDepositRepository taskDepositRepository;
	@Autowired
	private TaskLabelsRepository taskLabelsRepository;
	@Autowired
	private ProjectsRepository projectsRepository;
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	@Autowired
	private TaskPriorityRepository taskPriorityRepository;
	
	@Override
	public Task findById(String id) throws Exception {
		Task task;
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		task=taskRepository.findById(id);
		return task;
	}

	@Override
	public List<Task> findByStatus(String status) throws Exception {
		List<Task> task;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		task=taskRepository.findByStatus(status);
		
		return task;
	}

	@Override
	public List<Task> findByNameIgnoreCase(String name) throws Exception {
		
		List<Task> task;
		
		if(Utilities.isEmpty(name)) {
			throw new Exception("El nombre es obligatorio");
		}
		
		if(Utilities.isLongerThan(name, 100)) {
			throw new Exception("El nombre debe tener máximo 100 carácteres");
		}
		
		if(!Utilities.isOnlyLetters(name)) {
			throw new Exception("El nombre debe contener solamente letras");
		}
		task=taskRepository.findByNameIgnoreCase(name);
		return task;
	}
	
	public Task guardarTask (TaskDTO taskDTO) throws Exception{
		
		Task task = new Task();
		TaskDeposit taskDeposit = new TaskDeposit();
		TaskLabels taskLabels = new TaskLabels();
		TaskPriority taskPriority = new TaskPriority();
		Projects project = new Projects();
		TaskStatus taskStatus = new TaskStatus();
		
		//VALIDADIONES DEL ID
		if(Utilities.isEmpty(taskDTO.getId())) {
			throw new Exception("El id de la tarea no puede estar vacío");
		}
		if(Utilities.isLongerThan(taskDTO.getId(), 100)) {
			throw new Exception("El id de la tarea debe tener máximo 100 carácteres");
		}
		task.setId(taskDTO.getId());
		
		//VALIDACIONES DEL NOMBRE
		if(Utilities.isEmpty(taskDTO.getName())) {
			throw new Exception("El nombre de la tarea no puede estar vacío");
		}
		if(Utilities.isLongerThan(taskDTO.getName(), 100)) {
			throw new Exception("El nombre de la tarea debe tener máximo 100 carácteres");
		}
		task.setName(taskDTO.getName());
		
		//VALIDACIONES DEL LAS NOTAS
		if(taskDTO.getNotes()!=null) {
			if(Utilities.isLongerThan(taskDTO.getNotes(), 300)) {
				throw new Exception("Las notas de la tarea deben tener máximo 300 carácteres");
			}
		}
		task.setNotes(taskDTO.getNotes());
		
		//VALIDACIONES DE LOS COMENTARIOS
		if(taskDTO.getComments()!=null) {
			if(Utilities.isLongerThan(taskDTO.getComments(), 500)) {
				throw new Exception("Los comentarios de la tarea deben tener máximo 500 carácteres");
			}
		}
		task.setComments(taskDTO.getComments());
		
		//VALIDACIONES DE LA FECHA DE INICIO
		if(taskDTO.getStartDate()==null) {
			throw new Exception("La fecha de comienzo de la tarea no puede estar vacia");
		}
		task.setStartDate(taskDTO.getStartDate());
		
		//VALIDACIONES DE LA FECHA DE FINALIZACIÓN
		if(taskDTO.getDueDate()==null) {
			throw new Exception("La fecha de fin de la tarea no puede estar vacia");
		}
		task.setDueDate(taskDTO.getDueDate());
		
		//VALIDACIONES DE LAS COMPROBACIONES
		if(taskDTO.getComments()!=null) {
			if(Utilities.isLongerThan(taskDTO.getComments(), 100)) {
				throw new Exception("Las comprobaciones de la tarea deben tener máximo 100 carácteres");
			}
		}
		task.setChecklist(taskDTO.getChecklist());
		
		
		taskDeposit=taskDepositRepository.findById(taskDTO.getDepositId());
		if(taskDeposit==null) {
			throw new Exception("No existe el task deposit ingresado en la base de datos");
		}
		task.setDeposit(taskDeposit);
		
		taskLabels=taskLabelsRepository.findById(taskDTO.getLabelId());
		if(taskLabels==null) {
			throw new Exception("No existe el task label ingresado en la base de datos");
		}
		task.setLabel(taskLabels);
		
		taskPriority=taskPriorityRepository.findById(taskDTO.getPriorityId());
		if(taskPriority==null) {
			throw new Exception("No existe el task priority ingresado en la base de datos");
		}
		task.setPriority(taskPriority);
		
		project=projectsRepository.findById(taskDTO.getProjectId());
		if(project==null) {
			throw new Exception("No existe el proyecto ingresado en la base de datos");
		}
		task.setProject(project);
		
		taskStatus=taskStatusRepository.findById(taskDTO.getStatusId());
		if(taskStatus==null) {
			throw new Exception("No existe el task status ingresado en la base de datos");
		}
		task.setStatus(taskStatus);
		
		taskRepository.save(task);
		
		return task;
		
	}
	
public Task actualizarTask (TaskDTO taskDTO) throws Exception{
		
		Task task = null;
		TaskDeposit taskDeposit = null;
		TaskLabels taskLabels = null;
		TaskPriority taskPriority = null;
		Projects project = null;
		TaskStatus taskStatus = null;
		
		task=taskRepository.findById(taskDTO.getId());
		
		//VALIDADIONES DEL ID
		if(Utilities.isEmpty(taskDTO.getId())) {
			throw new Exception("El id de la tarea no puede estar vacío");
		}
		if(Utilities.isLongerThan(taskDTO.getId(), 100)) {
			throw new Exception("El id de la tarea debe tener máximo 100 carácteres");
		}
		task.setId(taskDTO.getId());
		
		//VALIDACIONES DEL NOMBRE
		if(Utilities.isEmpty(taskDTO.getName())) {
			throw new Exception("El nombre de la tarea no puede estar vacío");
		}
		if(Utilities.isLongerThan(taskDTO.getName(), 100)) {
			throw new Exception("El nombre de la tarea debe tener máximo 100 carácteres");
		}
		task.setName(taskDTO.getName());
		
		//VALIDACIONES DEL LAS NOTAS
		if(taskDTO.getNotes()!=null) {
			if(Utilities.isLongerThan(taskDTO.getNotes(), 300)) {
				throw new Exception("Las notas de la tarea deben tener máximo 300 carácteres");
			}
		}
		task.setNotes(taskDTO.getNotes());
		
		//VALIDACIONES DE LOS COMENTARIOS
		if(taskDTO.getComments()!=null) {
			if(Utilities.isLongerThan(taskDTO.getComments(), 500)) {
				throw new Exception("Los comentarios de la tarea deben tener máximo 500 carácteres");
			}
		}
		task.setComments(taskDTO.getComments());
		
		//VALIDACIONES DE LA FECHA DE INICIO
		if(taskDTO.getStartDate()==null) {
			throw new Exception("La fecha de comienzo de la tarea no puede estar vacia");
		}
		task.setStartDate(taskDTO.getStartDate());
		
		//VALIDACIONES DE LA FECHA DE FINALIZACIÓN
		if(taskDTO.getDueDate()==null) {
			throw new Exception("La fecha de fin de la tarea no puede estar vacia");
		}
		task.setDueDate(taskDTO.getDueDate());
		
		//VALIDACIONES DE LAS COMPROBACIONES
		if(taskDTO.getComments()!=null) {
			if(Utilities.isLongerThan(taskDTO.getComments(), 100)) {
				throw new Exception("Las comprobaciones de la tarea deben tener máximo 100 carácteres");
			}
		}
		task.setChecklist(taskDTO.getChecklist());
		
		taskDeposit=taskDepositRepository.findById(taskDTO.getDepositId());
		if(taskDeposit==null) {
			throw new Exception("No existe el task deposit ingresado en la base de datos");
		}
		task.setDeposit(taskDeposit);
		
		taskLabels=taskLabelsRepository.findById(taskDTO.getLabelId());
		if(taskLabels==null) {
			throw new Exception("No existe el task label ingresado en la base de datos");
		}
		task.setLabel(taskLabels);
		
		taskPriority=taskPriorityRepository.findById(taskDTO.getPriorityId());
		if(taskPriority==null) {
			throw new Exception("No existe el task priority ingresado en la base de datos");
		}
		task.setPriority(taskPriority);
		
		project=projectsRepository.findById(taskDTO.getProjectId());
		if(project==null) {
			throw new Exception("No existe el proyecto ingresado en la base de datos");
		}
		task.setProject(project);
		
		taskStatus=taskStatusRepository.findById(taskDTO.getStatusId());
		if(taskStatus==null) {
			throw new Exception("No existe el task status ingresado en la base de datos");
		}
		task.setStatus(taskStatus);
		
		taskRepository.save(task);
		
		return task;
		
	}

	//@Override
	public void eliminarTask(String id) throws Exception {
		if (id == null) {
			throw new Exception("El id es obligatorio");
		}
		Task taskBD = taskRepository.findById(id);

		if (taskBD!=null) {
			taskRepository.delete(taskBD);

		} else {
			throw new Exception("La tarea no se encontró");
		}

	}

}
