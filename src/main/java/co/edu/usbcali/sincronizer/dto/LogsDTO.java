/**  
 * @Title:  LogsDTO.java   
 * @Package co.edu.usbcali.sincronizer.dto   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 12:22:22 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**   
 * @ClassName:  LogsDTO   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 12:22:22 p. m.      
 * @Copyright:  USB
 */
@Data
public class LogsDTO implements Serializable {/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = -4998543972161528560L;
	
	public Long id;	
	public Date creationDate;
	public String description;
	public String employeeRegistradorId;
	
}
