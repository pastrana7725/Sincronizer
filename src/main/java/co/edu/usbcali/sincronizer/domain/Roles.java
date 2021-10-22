/**  
 * @Title:  Roles.java   
 * @Package    
 * @Description: description   
 * @author: Valentina Prado Marin     
 * @date:   7/10/2021 12:23:17 p.�m.   
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
 * @ClassName:  Roles   
  * @Description: TODO   
 * @author: Valentina Prado Marin     
 * @date:   7/10/2021 12:23:17 p.�m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="roles",schema = "public")

public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rol_id")
	public long id;
		
	@Column(name="rol_name",unique=false,nullable=false,length=30)
	public String name;
	
	@Column(name="rol_description",nullable=false,length=300)
	public String description;
		
	@Column(name="rol_status",nullable=false,length=1)
	public String status;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="rol")
	public List <TaskAssignment> aaskAssigment = new ArrayList<>();
}
