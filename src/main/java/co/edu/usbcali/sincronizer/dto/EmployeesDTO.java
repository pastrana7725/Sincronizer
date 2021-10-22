/**  
 * @Title:  EmployeesDTO.java   
 * @Package co.edu.usbcali.sincronizer.dto   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 11:31:12 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.dto;

import java.io.Serializable;

import lombok.Data;

/**   
 * @ClassName:  EmployeesDTO   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 11:31:12 a. m.      
 * @Copyright:  USB
 */
@Data
public class EmployeesDTO implements Serializable {
	/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = -1176524996005612419L;
	public String id;
	public String name;
	public String lastName;
	public String email;
	public String status;
	
}
