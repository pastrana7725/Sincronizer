/**  
 * @Title:  Task_Status.java   
 * @Package co.edu.usbcali.planner.domain   
 * @Description: description   
 * @author: Carlos Garaicoa     
 * @date:   7/10/2021 12:04:12 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Task_Status   
  * @Description: TODO   
 * @author: Carlos Garaicoa     
 * @date:   7/10/2021 12:04:12 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name="task_status",schema = "public")
public class TaskStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tskstt_id")
	public long id;
	
	@Column(name="tskstt_name",nullable=false,length=100)
	public String name;
	
	@Column(name="tskstt_status",nullable=false,length=1)
	public String status;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="status")
	public List <Task> tasks = new ArrayList<>();
	
}
