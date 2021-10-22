/**  
 * @Title:  TasksDTO.java   
 * @Package co.edu.usbcali.sincronizer.dto   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 1:23:43 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**   
 * @ClassName:  TasksDTO   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 1:23:43 p. m.      
 * @Copyright:  USB
 */
@Data
public class TaskDTO implements Serializable {

	
	private String id;
	private String notes;
	private String name;
	private String comments;
	private Date startDate;
	private Date dueDate;
	private String checklist;	
	public long depositId;
	public long labelId;
	public long priorityId;
	public String projectId;
	public long statusId;
	
	
}
