/**  
 * @Title:  Projects.java   
 * @Package co.edu.usbcali.sincronizer.domain   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:44:06 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Projects   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:44:06 a. m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="projects",schema = "public")
public class Projects {

	@Id
	@Column(name="prjt_id", length=100)
	public String id;
	
	@Column(name="prjt_name", unique=false, nullable=false, length=100)
	public String name;
	
	@Column(name="prjt_owner", unique=false, nullable=true, length=500)
	public String owner;
	
	@Column(name="prjt_creation_date", unique=false, nullable=false)
	public Date creationDate;
	
	@Column(name="prjt_status", unique=false, nullable=false, length=1)
	public String status;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="project")
	public List <Task> task = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prjt_created_by",nullable=false)
	public Employees createdBy;
	
}
