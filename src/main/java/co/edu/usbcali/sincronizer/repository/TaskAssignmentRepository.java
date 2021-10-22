/**  
 * @Title:  ProjectTaskAssignmentRepository.java   
 * @Package co.edu.usbcali.sincronizer.repository   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:54:16 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import co.edu.usbcali.sincronizer.domain.TaskAssignment;

/**   
 * @ClassName:  ProjectTaskAssignmentRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 7:54:16 a. m.      
 * @Copyright:  USB
 */
public interface TaskAssignmentRepository extends JpaRepository <TaskAssignment, Long> {

	//BUSCAMOS LA ASIGNACION POR ID
	public TaskAssignment findById(long id) throws Exception;
		
	//BUSCAMOS LAS ASIGNACIONES POR EL ID DE UNA TAREA
	public List <TaskAssignment> findByTask_Id(String id) throws Exception;
	
	//BUSCAMOS LAS ASIGNACIONES POR EL ID DEL EMPLEADO AL QUE SE LE ASIGNÓ
	public List <TaskAssignment> findByEmployee_Id(String id) throws Exception;
	
	//BUSCAMOS LAS ASIGNACIONES POR ROL
	public List <TaskAssignment> findByRol_Id(long id) throws Exception;
	
}
