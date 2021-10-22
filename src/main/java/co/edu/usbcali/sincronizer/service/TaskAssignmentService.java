/**  
 * @Title:  TaskAssignmentService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   20/10/2021 5:03:09 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;

import co.edu.usbcali.sincronizer.domain.TaskAssignment;
import co.edu.usbcali.sincronizer.dto.TaskAssignmentDTO;

public interface TaskAssignmentService {

	//BUSCAMOS LA ASIGNACION POR ID
	public TaskAssignment findById(Long id) throws Exception;
	
	//BUSCAMOS LAS ASIGNACIONES POR EL ID DE UNA TAREA
	public List <TaskAssignment> findByTask_Id(String id) throws Exception;
	
	//BUSCAMOS LAS ASIGNACIONES POR EL ID DEL EMPLEADO AL QUE SE LE ASIGNÓ
	public List <TaskAssignment> findByEmployee_Id(String id) throws Exception;
	
	//BUSCAMOS LAS ASIGNACIONES POR ROL
	public List <TaskAssignment> findByRol_Id(Long id) throws Exception;
	
	public TaskAssignment guardarTaskAssignment(TaskAssignmentDTO taskAssignmentDTO) throws Exception;

	public TaskAssignment actualizarTaskAssignment(TaskAssignmentDTO taskAssignmentDTO) throws Exception;

	public void eliminarTaskAssignment(Long id) throws Exception;
}
