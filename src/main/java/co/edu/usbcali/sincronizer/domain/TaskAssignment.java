/**  
 * @Title:  Project_task_assignment.java   
 * @Package co.edu.usbcali.sincronizer.domain   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:46:34 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
/**  
 * @Title:  Project_Task_Assignment.java   
 * @Package co.edu.usbcali.planner.domain   
 * @Description: description   
 * @author: Carlos Garaicoa     
 * @date:   7/10/2021 12:03:29 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**   
 * @ClassName:  Project_Task_Assignment   
  * @Description: TODO   
 * @author: Carlos Garaicoa     
 * @date:   7/10/2021 12:03:29 p. m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="task_assignment",schema = "public")
public class TaskAssignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="assgn_id")
	public long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assgn_employee_id",nullable=false)
	public Employees employee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assgn_role_id",nullable=false)
	public Roles rol;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assgn_task_id",nullable=false)
	public Task task;
}
