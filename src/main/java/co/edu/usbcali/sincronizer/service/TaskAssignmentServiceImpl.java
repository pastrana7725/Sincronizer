/**  
 * @Title:  TaskAssignmentServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 5:03:32 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.domain.Roles;
import co.edu.usbcali.sincronizer.domain.Task;
import co.edu.usbcali.sincronizer.domain.TaskAssignment;
import co.edu.usbcali.sincronizer.dto.TaskAssignmentDTO;
import co.edu.usbcali.sincronizer.repository.EmployeesRepository;
import co.edu.usbcali.sincronizer.repository.RolesRepository;
import co.edu.usbcali.sincronizer.repository.TaskAssignmentRepository;
import co.edu.usbcali.sincronizer.repository.TaskRepository;

/**   
 * @ClassName:  TaskAssignmentServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 5:03:32 p. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

	@Autowired
	private TaskAssignmentRepository taskAssignmentRepository;
	@Autowired
	private EmployeesRepository employeesRepository;

	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private TaskRepository taskRepository;
	
	
	@Override
	public TaskAssignment findById(Long id) throws Exception {
		
		TaskAssignment taskAssignment;
		
		if(id == null) {
			throw new Exception("El id es obligatorio");
		}
		
		taskAssignment= taskAssignmentRepository.findById(id).get();
		
		return taskAssignment;
	}

	
	@Override
	public List<TaskAssignment> findByTask_Id(String id) throws Exception {
		
		List<TaskAssignment> taskAssignment;
		
		if(id == null) {
			throw new Exception("El task id es obligatorio");
		}
	
		taskAssignment=taskAssignmentRepository.findByTask_Id(id);
		return taskAssignment;
	}

	
	@Override
	public List<TaskAssignment> findByEmployee_Id(String id) throws Exception {
		List<TaskAssignment> taskAssignment;
		
		if(id == null) {
			throw new Exception("El employee id es obligatorio");
		}
	
		taskAssignment=taskAssignmentRepository.findByEmployee_Id(id);
		return taskAssignment;
	}

	
	@Override
	public List<TaskAssignment> findByRol_Id(Long id) throws Exception {
		
		List<TaskAssignment> taskAssignment;
		
		if(id == null) {
			throw new Exception("El rol id es obligatorio");
		}
	
		taskAssignment=taskAssignmentRepository.findByRol_Id(id);
		return taskAssignment;
		
	}
	
	@Override
	public TaskAssignment guardarTaskAssignment(TaskAssignmentDTO taskAssignmentDTO) throws Exception {

		TaskAssignment taskAssignment = new TaskAssignment();
		Employees employee = new Employees();
		Roles rol = new Roles();
		Task task = new Task();

		// VALIDACION DEL EMPLEADO
		employee = employeesRepository.findById(taskAssignmentDTO.getEmployeeId());

		if (employee == null) {
			throw new Exception("El empleado no existe");
		}
		taskAssignment.setEmployee(employee);

		// VALIDACION DEL ROL
		rol = rolesRepository.findById(taskAssignmentDTO.getRolId()).get();

		if (rol == null) {
			throw new Exception("El rol no existe");
		}
		taskAssignment.setRol(rol);

		// VALIDACION DEL TASK
		task = taskRepository.findById(taskAssignmentDTO.getTaskId());

		if (task == null) {
			throw new Exception("El task no existe");
		}
		taskAssignment.setTask(task);

		taskAssignmentRepository.save(taskAssignment);
		return taskAssignment;
	}

	@Override
	public TaskAssignment actualizarTaskAssignment(TaskAssignmentDTO taskAssignmentDTO) throws Exception {
		
		TaskAssignment taskAssignment = null;
		Employees employee = null;
		Roles rol = null;
		Task task = null;
		
		//VALIDACION DEL ID
		taskAssignment =taskAssignmentRepository.findById(taskAssignmentDTO.getId());
		taskAssignment.setId(taskAssignmentDTO.getId());
		
		// VALIDACION DEL EMPLEADO
		employee = employeesRepository.findById(taskAssignmentDTO.getEmployeeId());

		if (employee == null) {
			throw new Exception("El empleado no existe");
		}
		taskAssignment.setEmployee(employee);

		// VALIDACION DEL ROL
		rol = rolesRepository.findById(taskAssignmentDTO.getRolId()).get();

		if (rol == null) {
			throw new Exception("El rol no existe");
		}
		taskAssignment.setRol(rol);

		// VALIDACION DEL TASK
		task = taskRepository.findById(taskAssignmentDTO.getTaskId());

		if (task == null) {
			throw new Exception("El task no existe");
		}
		taskAssignment.setTask(task);

		taskAssignmentRepository.save(taskAssignment);
		return taskAssignment;
	}

	@Override
	public void eliminarTaskAssignment(Long id) throws Exception {
		if (id == null) {
			throw new Exception("El id taskAssigment es obligatorio");

		}
		Optional<TaskAssignment> taskAssigmentBD = taskAssignmentRepository.findById(id);

		if (taskAssigmentBD.isPresent()) {
			taskAssignmentRepository.delete(taskAssigmentBD.get());

		} else {
			throw new Exception("El taskAssigment no se encontro");
		}

	}

}
