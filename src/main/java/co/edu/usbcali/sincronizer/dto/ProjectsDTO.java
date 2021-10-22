/**  
 * @Title:  ProjectDTO.java   
 * @Package co.edu.usbcali.sincronizer.dto   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 10:01:40 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.domain.Task;
import lombok.Data;

/**   
 * @ClassName:  ProjectDTO   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 10:01:40 a. m.      
 * @Copyright:  USB
 */
@Data
public class ProjectsDTO implements Serializable{/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = -7913490035881676264L;
	
	
	public String id;
	public String name;
	public String owner;
	public Date creationDate;
	public String status;
	public String employeeId;

}
