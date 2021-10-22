/**  
 * @Title:  TaskLog.java   
 * @Package co.edu.usbcali.sincronizer.domain   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   11/10/2021 7:49:07 a. m.   
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
 * @ClassName:  TaskLog   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   11/10/2021 7:49:07 a. m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="tasks_logs",schema = "public")
public class TasksLogs {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tsklgs_id", unique=true, nullable=false)
	public long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsklgs_task", nullable=false)
	public Task task;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsklgs_lgs", nullable=false)
	public Logs logs;
	
}
