/**  
 * @Title:  LogsService.java   
 * @Package co.edu.usbcali.sincronizer.service   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 8:53:57 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer.service;

import co.edu.usbcali.sincronizer.domain.Logs;
import co.edu.usbcali.sincronizer.dto.LogsDTO;

/**   
 * @ClassName:  LogsService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   21/10/2021 8:53:57 a. m.      
 * @Copyright:  USB
 */
public interface LogsService {

	//CONSULTAMOS POR ID
	public Logs findById(Long id) throws Exception;
	
	//GUARDAR
	public Logs guardarLogs(LogsDTO logsDTO) throws Exception;
	
	//ACTUALIZAR
	public Logs actualizarLogs(LogsDTO logsDTO) throws Exception;
	
	//ELIMINAR
	public void eliminarLogs(Long id) throws Exception;
}
