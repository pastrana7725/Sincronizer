/**  
 * @Title:  TasksLogsDTO.java   
 * @Package co.edu.usbcali.sincronizer.dto   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 3:10:13 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.dto;

import java.io.Serializable;

import lombok.Data;

/**   
 * @ClassName:  TasksLogsDTO   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 3:10:13 p. m.      
 * @Copyright:  USB
 */
@Data
public class TasksLogsDTO implements Serializable {/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = -3289381795402643857L;
	
	public long id;
	public String id_task;
	public long id_lgs;

}
