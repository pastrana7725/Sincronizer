/**  
 * @Title:  ProjectsServiceImpl.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   18/10/2021 9:08:24 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.sincronizer.domain.Employees;
import co.edu.usbcali.sincronizer.domain.Logs;
import co.edu.usbcali.sincronizer.domain.Projects;
import co.edu.usbcali.sincronizer.dto.ProjectsDTO;
import co.edu.usbcali.sincronizer.repository.EmployeesRepository;
import co.edu.usbcali.sincronizer.repository.ProjectsRepository;
import co.edu.usbcali.sincronizer.utils.Constantes;
import co.edu.usbcali.sincronizer.utils.Utilities;

/**   
 * @ClassName:  ProjectsServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   18/10/2021 9:08:24 a. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsRepository projectsRepository;
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Override
	public Projects findById(String idProject) throws Exception {
		Projects project=null;
		
		if(idProject == null) {
			throw new Exception("El id es obligatorio");
		}
		
		project=projectsRepository.findById(idProject);
		
		return project;
	}

	
	@Override
	public List<Projects> findByStatus(String status) throws Exception {
		List<Projects> projects= null;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		projects= projectsRepository.findByStatus(status);
		
		return projects;
	}

	
	@Override
	public List<Projects> findByNameIgnoreCaseAndStatus(String name, String status) throws Exception {
		
		List<Projects> projects= null;
		
		if(Utilities.isEmpty(status)) {
			throw new Exception("El status es obligatorio");
		}
		
		if(Utilities.isLongerThan(status, 1)) {
			throw new Exception("El status debe tener máximo un carácter");
		}
		
		if(!status.equals(Constantes.ACTIVO) && !status.equals(Constantes.INACTIVO)) {
			throw new Exception("El Status debe ser 'A' o 'I'");
		}
		
		if(Utilities.isEmpty(name)) {
			throw new Exception("El nombre es obligatorio");
		}
		
		if(Utilities.isLongerThan(name, 100)) {
			throw new Exception("El nombre debe tener máximo 100 carácteres");
		}
		
		if(!Utilities.isOnlyLetters(name)) {
			throw new Exception("El nombre debe contener solamente letras");
		}
		
		projects= projectsRepository.findByNameIgnoreCaseAndStatus(name, status);
		return projects;
		
	}
	
	public Projects guardarProject(ProjectsDTO projectDTO) throws Exception{
		
		Projects project = new Projects();
		Employees employee = new Employees();
		
		//VALIDADIONES DEL ID
		if(Utilities.isEmpty(projectDTO.getId())) {
			throw new Exception("El id del projecto no puede estar vacío");
		}
		if(Utilities.isLongerThan(projectDTO.getId(), 100)) {
			throw new Exception("El id del proyecto debe tener máximo 100 carácteres");
		}
		project.setId(projectDTO.getId());
		
		//VALIDACIONES DEL NOMBRE
		if(Utilities.isEmpty(projectDTO.getName())) {
			throw new Exception("El nombre del projecto no puede estar vacío");
		}
		if(Utilities.isLongerThan(projectDTO.getName(), 100)) {
			throw new Exception("El nombre del proyecto debe tener máximo 100 carácteres");
		}
		project.setName(projectDTO.getName());
		
		//VALIDACIONES DEL STATUS
		if(Utilities.isEmpty(projectDTO.getStatus())) {
			throw new Exception("El status del projecto no puede estar vacío");
		}
		if(Utilities.isLongerThan(projectDTO.getStatus(), 1)) {
			throw new Exception("El status del proyecto debe tener máximo 1 carácter");
		}
		if(!projectDTO.getStatus().equals("A")&&!projectDTO.getStatus().equals("I")) {
			throw new Exception("El status debe ser A o I");
		}
		project.setStatus(projectDTO.getStatus());
		
		if(Utilities.isEmpty(projectDTO.getOwner())) {
			throw new Exception("La descripción del projecto no puede estar vacía");
		}
		if(Utilities.isLongerThan(projectDTO.getOwner(), 100)) {
			throw new Exception("La descripción del proyecto debe tener máximo 300 carácteres");
		}
		project.setOwner(projectDTO.getOwner());
		
		if(projectDTO.getCreationDate()==null) {
			throw new Exception("La fecha de creación del proyecto no puede estar vacia");
		}
		project.setCreationDate(projectDTO.getCreationDate());
		
		//verificamos que el empleado exista
		employee=employeesRepository.findById(projectDTO.getEmployeeId());
		if(employee==null) {
			throw new Exception("El empleado no existe");
		}
		project.setCreatedBy(employee);
		
		projectsRepository.save(project);
		return project;
	}
	
	public Projects actualizarProject(ProjectsDTO projectDTO) throws Exception{
		
		Projects project=null;
		Employees employee=null;
		
		project=projectsRepository.findById(projectDTO.id);
		//VALIDADIONES DEL ID
		if(Utilities.isEmpty(projectDTO.getId())) {
			throw new Exception("El id del projecto no puede estar vacío");
		}
		if(Utilities.isLongerThan(projectDTO.getId(), 100)) {
			throw new Exception("El id del proyecto debe tener máximo 100 carácteres");
		}
		project.setId(projectDTO.getId());
		
		//VALIDACIONES DEL NOMBRE
		if(Utilities.isEmpty(projectDTO.getName())) {
			throw new Exception("El nombre del projecto no puede estar vacío");
		}
		if(Utilities.isLongerThan(projectDTO.getName(), 100)) {
			throw new Exception("El nombre del proyecto debe tener máximo 100 carácteres");
		}
		project.setName(projectDTO.getName());
		
		//VALIDACIONES DEL STATUS
		if(Utilities.isEmpty(projectDTO.getStatus())) {
			throw new Exception("El status del projecto no puede estar vacío");
		}
		if(Utilities.isLongerThan(projectDTO.getStatus(), 1)) {
			throw new Exception("El status del proyecto debe tener máximo 1 carácter");
		}
		if(!projectDTO.getStatus().equals("A")&&!projectDTO.getStatus().equals("I")) {
			throw new Exception("El status debe ser A o I");
		}
		project.setStatus(projectDTO.getStatus());
		
		if(Utilities.isEmpty(projectDTO.getOwner())) {
			throw new Exception("La descripción del projecto no puede estar vacía");
		}
		if(Utilities.isLongerThan(projectDTO.getOwner(), 100)) {
			throw new Exception("La descripción del proyecto debe tener máximo 300 carácteres");
		}
		project.setOwner(projectDTO.getOwner());
		
		if(projectDTO.getCreationDate()==null) {
			throw new Exception("La fecha de creación del proyecto no puede estar vacia");
		}
		project.setCreationDate(projectDTO.getCreationDate());
		
		//verificamos que el empleado exista
		employee=employeesRepository.findById(projectDTO.getEmployeeId());
		if(employee==null) {
			throw new Exception("El empleado no existe");
		}
		project.setCreatedBy(employee);
		
		projectsRepository.save(project);
		return project;
	}
	
	@Override
	public void eliminarProjects(String id) throws Exception {
		if (id == null) {
			throw new Exception("El id es obligatorio");
		}
		Projects projectBD = projectsRepository.findById(id);

		if (projectBD!=null) {
			projectsRepository.delete(projectBD);

		} else {
			throw new Exception("El Projecto no se encontró");
		}

	}

	
	
}
