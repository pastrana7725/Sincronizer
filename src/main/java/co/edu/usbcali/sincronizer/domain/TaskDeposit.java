/**  
 * @Title:  TaskDeposit.java   
 * @Package co.edu.usbcali.ingesoftdos.domain   
 * @Description: description   
 * @author: Valentina Prado Marin     
 * @date:   7/10/2021 12:55:35 p.�m.   
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
 * @ClassName:  TaskDeposit   
  * @Description: TODO   
 * @author: Valentina Prado Marin     
 * @date:   7/10/2021 12:55:35 p.�m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="task_deposit",schema = "public")

public class TaskDeposit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tskdpt_id")
	public long id;
		
	@Column(name="tskdpt_name",unique=false,nullable=false,length=100)
	public String name;
	
	@Column(name="tskdpt_status",nullable=false,length=1)
	public String status;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="deposit")
	public List <Task> tasks = new ArrayList<>();
}
