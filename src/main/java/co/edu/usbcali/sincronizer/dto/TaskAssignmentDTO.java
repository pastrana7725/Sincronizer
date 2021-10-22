/**  
 * @Title:  TaskAssignmentDTO.java   
 * @Package co.edu.usbcali.sincronizer.dto   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 3:08:26 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TaskAssignmentDTO implements Serializable {

	/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = -1576916818922356700L;
	public long id;
	public String employeeId;
	public long rolId;
	public String taskId;
	
}
