/**  
 * @Title:  Task.java   
 * @Package co.edu.usbcali.sincronizer.domain   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:45:57 a. m.   
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
 * @ClassName:  Task   
  * @Description: ESTA CLASE ES EL DOMAIN DE LA TABLA TASK   
 * @author: Diego Pastrana     
 * @date:   7/10/2021 9:45:57 a. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name="tasks",schema = "public")
public class Task {

	@Id
	@Column(name="tsk_id", length=100)
	private String id;
	
	@Column(name="tsk_notes", unique=false, nullable=true, length=255)
	private String notes;
	
	@Column(name="tsk_name", unique=false, nullable=false, length=100)
	private String name;
	
	@Column(name="tsk_comments", unique=false, nullable=true, length=500)
	private String comments;
	
	@Column(name="tsk_start_date", unique=false, nullable=false)
	private Date startDate;
	
	@Column(name="tsk_due_date", unique=false, nullable=false)
	private Date dueDate;
	
	@Column(name="tsk_checklist", unique=false, nullable=true, length=100)
	private String checklist;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="task")
	private List <TaskAssignment> taskAssignment = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsk_dpt_id",nullable=false)
	public TaskDeposit deposit;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsk_lbl_id",nullable=false)
	public TaskLabels label;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsk_prt_id",nullable=false)
	public TaskPriority priority;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsk_prjt_id",nullable=false)
	public Projects project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tsk_stt_id",nullable=false)
	public TaskStatus status;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="task")
	private List<TasksLogs> tasksLogs = new ArrayList<>();
	
	
}
