/**  
 * @Title:  Employees.java   
 * @Package co.edu.usbcali.sincronizer.domain   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:45:13 a. m.   
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
 * @ClassName:  Employees   
 * @Description: ESTA CLASE ES EL DOMAIN DE LA TABLA EMPLOYEE   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:45:13 a. m.      
 * @Copyright:  USB
 */

@Data
@Entity
@Table(name="employees", schema = "public")

public class Employees {
	
	@Id
	@Column(name="emp_id",length=100, nullable=false)
	public String id;
	
	@Column(name="emp_name", unique=false, nullable=false, length=100)
	public String name;
	
	@Column(name="emp_last_name", unique=false, nullable=false, length=100)
	public String lastName;
	
	@Column(name="emp_email", unique=false, nullable=false, length=100)
	public String email;
	
	@Column(name="emp_status", unique=false, nullable=false, length=1)
	public String status;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="employee")
	public List<TaskAssignment>projectTaskAssignment= new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="employeeRegistrador")
	public List<Logs> logs= new ArrayList<>(); 
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="createdBy")
	public List<Projects> projects= new ArrayList<>();
	
	

}
