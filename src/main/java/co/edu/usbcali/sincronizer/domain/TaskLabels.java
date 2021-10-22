/**  
 * @Title:  TaskLabels.java   
 * @Package co.edu.usbcali.ingesoftdos.domain   
 * @Description: description   
 * @author: Valentina Prado Marin     
 * @date:   7/10/2021 1:00:36 p.�m.   
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
 * @ClassName:  TaskLabels   
  * @Description: TODO   
 * @author: Valentina Prado Marin     
 * @date:   7/10/2021 1:00:36 p.�m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="task_labels",schema = "public")

public class TaskLabels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tsklbl_id")
	public long id;
		
	@Column(name="tsklbl_name",unique=false,nullable=false,length=100)
	public String name ;
	
	@Column(name="tsklbl_status",nullable=false,length=1)
	public String status;
	
	@Column(name="tsklbl_color", unique=false, nullable=false, length=7)
	public String color;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="label")
	public List <Task> tasks = new ArrayList<>();
}

