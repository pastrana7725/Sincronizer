/**  
 * @Title:  Logs.java   
 * @Package co.edu.usbcali.sincronizer.domain   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 8:17:12 a. m.   
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
 * @ClassName:  Logs   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   10/10/2021 8:17:12 a. m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="logs",schema = "public")
public class Logs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lgs_id")
	public Long id;
	
	@Column(name="lgs_creation_date", unique=false, nullable=false)
	public Date creationDate;
	
	@Column(name="lgs_description", unique=false, nullable=false, length=500)
	public String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lgs_employee", nullable=false)
	public Employees employeeRegistrador;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="logs")
	public List<TasksLogs> tasksLogs = new ArrayList<>();
	
}
