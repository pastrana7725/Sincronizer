/**  
 * @Title:  API.java   
 * @Package co.edu.usbcali.sincronizer   
 * @Description: description   
 * @author: Diego Pastrana     
 * @date:   17/10/2021 12:28:48 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.sincronizer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import  org.json.JSONObject;  
import  org.json.JSONArray;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


/**   
 * @ClassName:  API   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   17/10/2021 12:28:48 p. m.      
 * @Copyright:  USB
 */
@SpringBootTest
public class API {

	
	//OBTIENE LOS PLANES CON UN GROUP ID Y EL TOKEN
	@Test
	void GETPlans() {
		RestTemplate template = new RestTemplate();
		String groupId="3c8a5365-ce23-4944-b2f0-7ee65aa8c515";
		
		//EL ACCESSTOKEN VARÍA CADA CIERTO TIEMPO
		String accessToken="eyJ0eXAiOiJKV1QiLCJub25jZSI6ImVUNDUtVGdmcEpOVDRIdTRodGt1RGZRdWVCZ21OMFFZT3dYNnJVdmlELVUiLCJhbGciOiJSUzI1NiIsIng1dCI6Imwzc1EtNTBjQ0g0eEJWWkxIVEd3blNSNzY4MCIsImtpZCI6Imwzc1EtNTBjQ0g0eEJWWkxIVEd3blNSNzY4MCJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81ZThiZjRlZS1lMDI5LTRjMzEtOTYyMy1lZmRlNzJkZGY0MTAvIiwiaWF0IjoxNjM0NTY1MTM1LCJuYmYiOjE2MzQ1NjUxMzUsImV4cCI6MTYzNDU2OTAzNSwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFTUUEyLzhUQUFBQWxibzRiUkRsL2hxWWZ6TkhQYkdoazVQRncwS20ydVp6bXplejFGaGdad2s9IiwiYW1yIjpbInB3ZCJdLCJhcHBfZGlzcGxheW5hbWUiOiJHcmFwaCBFeHBsb3JlciIsImFwcGlkIjoiZGU4YmM4YjUtZDlmOS00OGIxLWE4YWQtYjc0OGRhNzI1MDY0IiwiYXBwaWRhY3IiOiIwIiwiZmFtaWx5X25hbWUiOiJJQkFSUkEgUEFTVFJBTkEiLCJnaXZlbl9uYW1lIjoiRElFR08gQVJNQU5ETyIsImlkdHlwIjoidXNlciIsImlwYWRkciI6IjE5MC43MS42NC45OCIsIm5hbWUiOiJESUVHTyBBUk1BTkRPIElCQVJSQSBQQVNUUkFOQSIsIm9pZCI6ImJhYTNkMDEyLTMxYTktNGNkNy05YjAzLWIzZjAxYjFkY2IyMSIsInBsYXRmIjoiNSIsInB1aWQiOiIxMDAzMjAwMDc0QTU5MEU4IiwicmgiOiIwLkFUUUE3dlNMWGluZ01VeVdJLV9lY3QzMEVMWElpOTc1MmJGSXFLMjNTTnB5VUdRMEFLcy4iLCJzY3AiOiJvcGVuaWQgcHJvZmlsZSBUYXNrcy5SZWFkIFRhc2tzLlJlYWRXcml0ZSBVc2VyLlJlYWQgZW1haWwiLCJzaWduaW5fc3RhdGUiOlsia21zaSJdLCJzdWIiOiI0X0xJczdVQUo1RWVjb3psRUowckFIdFNuSjJFMXJNTzloYkk3ZjVVSkRFIiwidGVuYW50X3JlZ2lvbl9zY29wZSI6IlNBIiwidGlkIjoiNWU4YmY0ZWUtZTAyOS00YzMxLTk2MjMtZWZkZTcyZGRmNDEwIiwidW5pcXVlX25hbWUiOiJkYWliYXJyYXBAY29ycmVvLnVzYmNhbGkuZWR1LmNvIiwidXBuIjoiZGFpYmFycmFwQGNvcnJlby51c2JjYWxpLmVkdS5jbyIsInV0aSI6IlZETFpLNTQzUVVHNTRTLTR4UjhoQVEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbImI3OWZiZjRkLTNlZjktNDY4OS04MTQzLTc2YjE5NGU4NTUwOSJdLCJ4bXNfc3QiOnsic3ViIjoicW9KZ2FPbXFhT3U1ZnVEcTd6YjhfN0V0LXFlYlpENEJPWEhLbDMyaGpPdyJ9LCJ4bXNfdGNkdCI6MTM2Nzk1MzQyNH0.fdvN9CbDmK6TBsv4QlA7KHtD3OQEjoNGxz3GFG-pGOXV5l0OsPOCyzFqG6bwh2YIjAhkp2GrYD_TZMGi8Tep-kDXbElNvTqxRuWdor5YUXq63m9kXLTlz_4n9EgSOdFsjRJALoVAIG1K3i55QscY5sPJKw5sMBR8BBlqkyzFc4GPZZPsbC7FwCCbcdaPmIhBNLn6sFQhxYWdF7fv-wC9GUkgVWKOzDhZ-_WGCLItOLSAQzHRYk2SOH79EGnc0-D6y7m_yicFXPP5LEkxxzwkQ7otzukKENc2EYMUIZ_-l_ESsW8lHyHDvUtqlSzM3kXFfErLams54hq6EEQ9xJbUqQ";
		//CONSTRUIMOS NUESTRO URL
		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("https")
		.host("graph.microsoft.com")
		.path("v1.0/groups/"+groupId+"/planner/plans")
		//.queryParam("Authorization",accessToken) //ESTA LINEA SE BORRA SI QUISIERAMOS AGREGAR PARÁMETROS (PUEDEN SER VARIAS QUERYPARAM)
		.build();
		
		//AGREGAMOS EL TOKEN DENTRO DE LOS HEADERS DE LA PETICIÓN
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", accessToken);
		
		/*CREAMOS LA ENTIDAD, DONDE ESTÁ NULL VAN PARÁMETROS, PERO NO ES NECESARIO
		 PORQUE LOS PARÁMETROS LOS ESTAMOS PASANDO EN LA CONSTRUCCIÓN DEL URL.
		 SE LE PASAN DE SEGUNDO LOS HEADERS QUE CREAMOS ANTERIORMENTE*/
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
		try {
		//REALIZAMOS LA PETICIÓN AGREGANDOLE EL URL, EL MÉTODO (GET,POST,UPDATE,DELETE, ETC), LA ENTIDAD
		//QUE CREAMOS ANTERIORMENTE Y FINALMENTE LA INTERFAZ DE NUESTRA RESPUESTA, EN ESTE CASO STRING
		ResponseEntity<String> respEntity=template.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
		
		//CONVERTIMOS LA RESPUESTA STRING A UN OBJETO JSON PARA SER MÁS FÁCIL EL MANEJO DE LA INFORMACIÓN
		JSONObject json = new JSONObject(respEntity.getBody());
		
		//CREAMOS UN ARREGLO DE JSON, DADO QUE PUEDEN SER VARIAS RESPUESTAS DE LA PETICIÓN
		JSONArray jsonArray= new JSONArray(json.get("value").toString());
		
		for(int idx=0;idx<jsonArray.length();idx++) {
			JSONObject object= jsonArray.getJSONObject(idx);
			
			//EN ESTE LUGAR SE VA A MAPEAR LA INFORMACIÓN DE LA RESPUESTA DE LA CONSULTA
			//HACIA NUESTRA BASE DE DATOS
			System.out.println(object.get("title"));
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//OBTIENE LAS TAREAS CON UN PLAN ID Y EL TOKEN
	@Test
	void GETTasks() {
		RestTemplate template = new RestTemplate();
		String planId="IBNeAZ3WxEOROqSzmeO3XWUABYXE";
		
		//EL ACCESSTOKEN VARÍA CADA CIERTO TIEMPO
		String accessToken="eyJ0eXAiOiJKV1QiLCJub25jZSI6Ikg1bVo0U0ZRWDZ2VVhHTVpoTDJmaURvMWhVdFFsUU5BQXBYVS12MGNIN0UiLCJhbGciOiJSUzI1NiIsIng1dCI6Imwzc1EtNTBjQ0g0eEJWWkxIVEd3blNSNzY4MCIsImtpZCI6Imwzc1EtNTBjQ0g0eEJWWkxIVEd3blNSNzY4MCJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81ZThiZjRlZS1lMDI5LTRjMzEtOTYyMy1lZmRlNzJkZGY0MTAvIiwiaWF0IjoxNjM0NTAwNDY0LCJuYmYiOjE2MzQ1MDA0NjQsImV4cCI6MTYzNDUwNDM2NCwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFTUUEyLzhUQUFBQWxzd2t0VFI3N1J0T2tmVFFqL2NDcDNMRzdNZHR4U3lsSGJsTlpvUDBXL2M9IiwiYW1yIjpbInB3ZCJdLCJhcHBfZGlzcGxheW5hbWUiOiJHcmFwaCBFeHBsb3JlciIsImFwcGlkIjoiZGU4YmM4YjUtZDlmOS00OGIxLWE4YWQtYjc0OGRhNzI1MDY0IiwiYXBwaWRhY3IiOiIwIiwiZmFtaWx5X25hbWUiOiJJQkFSUkEgUEFTVFJBTkEiLCJnaXZlbl9uYW1lIjoiRElFR08gQVJNQU5ETyIsImlkdHlwIjoidXNlciIsImlwYWRkciI6IjE5MC43MS42NC45OCIsIm5hbWUiOiJESUVHTyBBUk1BTkRPIElCQVJSQSBQQVNUUkFOQSIsIm9pZCI6ImJhYTNkMDEyLTMxYTktNGNkNy05YjAzLWIzZjAxYjFkY2IyMSIsInBsYXRmIjoiNSIsInB1aWQiOiIxMDAzMjAwMDc0QTU5MEU4IiwicmgiOiIwLkFUUUE3dlNMWGluZ01VeVdJLV9lY3QzMEVMWElpOTc1MmJGSXFLMjNTTnB5VUdRMEFLcy4iLCJzY3AiOiJvcGVuaWQgcHJvZmlsZSBUYXNrcy5SZWFkIFRhc2tzLlJlYWRXcml0ZSBVc2VyLlJlYWQgZW1haWwiLCJzaWduaW5fc3RhdGUiOlsia21zaSJdLCJzdWIiOiI0X0xJczdVQUo1RWVjb3psRUowckFIdFNuSjJFMXJNTzloYkk3ZjVVSkRFIiwidGVuYW50X3JlZ2lvbl9zY29wZSI6IlNBIiwidGlkIjoiNWU4YmY0ZWUtZTAyOS00YzMxLTk2MjMtZWZkZTcyZGRmNDEwIiwidW5pcXVlX25hbWUiOiJkYWliYXJyYXBAY29ycmVvLnVzYmNhbGkuZWR1LmNvIiwidXBuIjoiZGFpYmFycmFwQGNvcnJlby51c2JjYWxpLmVkdS5jbyIsInV0aSI6IjdPZ0kxM0lzRVVPZG9IWnRXYXNBQVEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbImI3OWZiZjRkLTNlZjktNDY4OS04MTQzLTc2YjE5NGU4NTUwOSJdLCJ4bXNfc3QiOnsic3ViIjoicW9KZ2FPbXFhT3U1ZnVEcTd6YjhfN0V0LXFlYlpENEJPWEhLbDMyaGpPdyJ9LCJ4bXNfdGNkdCI6MTM2Nzk1MzQyNH0.aI3O5qzsOSaTrnpEXy7P2Ke_lQxbg47eC74PPSSoi0wdREM8XyzWSfeGLLaHaqoQK3VT4X8QkekZ2CNfAhuOLAfHotITGcHb26F4A2U8EwbjvPOHvgdzmfpnrdM7yaqBIwHzoyo9UQUtriBEchwRjfM3PJXL_porYJ8yeuDFxYZo4rWJBgxbMiEMEo94SUmX-359gdzwCFHZBI3BAeaRnEaRtpmVZ_AWI9XHw5NQ_l17fnWqcdB-ZRZy_Ph_r9ZOqS49bb9t-rtTOoWu1EA6lKrVseYF3_O8LWtLpg1LSh_Vh_RpWsygHEqZiqL3_f4WZl0Vcgrim4W3DjhFEXLQXg";
		
		//CONSTRUIMOS NUESTRO URL
		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("https")
		.host("graph.microsoft.com")
		.path("v1.0/planner/plans/"+planId+"/tasks")
		//.queryParam("Authorization",accessToken) //ESTA LINEA SE BORRA SI QUISIERAMOS AGREGAR PARÁMETROS (PUEDEN SER VARIAS QUERYPARAM)
		.build();
		
		//AGREGAMOS EL TOKEN DENTRO DE LOS HEADERS DE LA PETICIÓN
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", accessToken);
		
		/*CREAMOS LA ENTIDAD, DONDE ESTÁ NULL VAN PARÁMETROS, PERO NO ES NECESARIO
		 PORQUE LOS PARÁMETROS LOS ESTAMOS PASANDO EN LA CONSTRUCCIÓN DEL URL.
		 SE LE PASAN DE SEGUNDO LOS HEADERS QUE CREAMOS ANTERIORMENTE*/
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
		try {
		//REALIZAMOS LA PETICIÓN AGREGANDOLE EL URL, EL MÉTODO (GET,POST,UPDATE,DELETE, ETC), LA ENTIDAD
		//QUE CREAMOS ANTERIORMENTE Y FINALMENTE LA INTERFAZ DE NUESTRA RESPUESTA, EN ESTE CASO STRING
		ResponseEntity<String> respEntity=template.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
		
		//CONVERTIMOS LA RESPUESTA STRING A UN OBJETO JSON PARA SER MÁS FÁCIL EL MANEJO DE LA INFORMACIÓN
		JSONObject json = new JSONObject(respEntity.getBody());
		
		//CREAMOS UN ARREGLO DE JSON, DADO QUE PUEDEN SER VARIAS RESPUESTAS DE LA PETICIÓN
		JSONArray jsonArray= new JSONArray(json.get("value").toString());
		
		for(int idx=0;idx<jsonArray.length();idx++) {
			JSONObject object= jsonArray.getJSONObject(idx);
			
			//EN ESTE LUGAR SE VA A MAPEAR LA INFORMACIÓN DE LA RESPUESTA DE LA CONSULTA
			//HACIA NUESTRA BASE DE DATOS
			System.out.println(object.get("title"));
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//OBTIENE UN USUARIO CON UN USER ID Y EL TOKEN
	@Test
	void GETUSER() {
		RestTemplate template = new RestTemplate();
		String userId="baa3d012-31a9-4cd7-9b03-b3f01b1dcb21";
		
		//EL ACCESSTOKEN VARÍA CADA CIERTO TIEMPO
		String accessToken="eyJ0eXAiOiJKV1QiLCJub25jZSI6IlpnUlRPRnVpTDM5VlBWNHpXWndwbl9YLTVwNzV4OXBZZm1MS1FEX3JGRW8iLCJhbGciOiJSUzI1NiIsIng1dCI6Imwzc1EtNTBjQ0g0eEJWWkxIVEd3blNSNzY4MCIsImtpZCI6Imwzc1EtNTBjQ0g0eEJWWkxIVEd3blNSNzY4MCJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81ZThiZjRlZS1lMDI5LTRjMzEtOTYyMy1lZmRlNzJkZGY0MTAvIiwiaWF0IjoxNjM0NzQzNDUwLCJuYmYiOjE2MzQ3NDM0NTAsImV4cCI6MTYzNDc0NzM1MCwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkUyWmdZRmo4dXJFOEo2QXFMSDM5NUQreEhYekhwZ1ljUGhsOGNmNXJGNWM3cXZLaDJXSUEiLCJhbXIiOlsicHdkIl0sImFwcF9kaXNwbGF5bmFtZSI6IkdyYXBoIEV4cGxvcmVyIiwiYXBwaWQiOiJkZThiYzhiNS1kOWY5LTQ4YjEtYThhZC1iNzQ4ZGE3MjUwNjQiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IklCQVJSQSBQQVNUUkFOQSIsImdpdmVuX25hbWUiOiJESUVHTyBBUk1BTkRPIiwiaWR0eXAiOiJ1c2VyIiwiaXBhZGRyIjoiMTkwLjcxLjY0Ljk4IiwibmFtZSI6IkRJRUdPIEFSTUFORE8gSUJBUlJBIFBBU1RSQU5BIiwib2lkIjoiYmFhM2QwMTItMzFhOS00Y2Q3LTliMDMtYjNmMDFiMWRjYjIxIiwicGxhdGYiOiI1IiwicHVpZCI6IjEwMDMyMDAwNzRBNTkwRTgiLCJyaCI6IjAuQVRRQTd2U0xYaW5nTVV5V0ktX2VjdDMwRUxYSWk5NzUyYkZJcUsyM1NOcHlVR1EwQUtzLiIsInNjcCI6Im9wZW5pZCBwcm9maWxlIFRhc2tzLlJlYWQgVGFza3MuUmVhZFdyaXRlIFVzZXIuUmVhZCBlbWFpbCIsInNpZ25pbl9zdGF0ZSI6WyJrbXNpIl0sInN1YiI6IjRfTElzN1VBSjVFZWNvemxFSjByQUh0U25KMkUxck1POWhiSTdmNVVKREUiLCJ0ZW5hbnRfcmVnaW9uX3Njb3BlIjoiU0EiLCJ0aWQiOiI1ZThiZjRlZS1lMDI5LTRjMzEtOTYyMy1lZmRlNzJkZGY0MTAiLCJ1bmlxdWVfbmFtZSI6ImRhaWJhcnJhcEBjb3JyZW8udXNiY2FsaS5lZHUuY28iLCJ1cG4iOiJkYWliYXJyYXBAY29ycmVvLnVzYmNhbGkuZWR1LmNvIiwidXRpIjoiQnZXbzNrcUs2RS1VUXl6SVljU1RBQSIsInZlciI6IjEuMCIsIndpZHMiOlsiYjc5ZmJmNGQtM2VmOS00Njg5LTgxNDMtNzZiMTk0ZTg1NTA5Il0sInhtc19zdCI6eyJzdWIiOiJxb0pnYU9tcWFPdTVmdURxN3piOF83RXQtcWViWkQ0Qk9YSEtsMzJoak93In0sInhtc190Y2R0IjoxMzY3OTUzNDI0fQ.VG4a-QLgvFD1dY92kz8tRELkON9jn-1iSe8IoiZapXaoCh_eXqoi5ISl-ERohEUtcfPL19HDQ7BilvsaeGQKLqGNj4J6XRjmWN3ntjxHwVrM2FDcYRIwxOo2XIaq3zN7vA7zEnvbW372IPM4xnXEMvpolsIpLQCUtRXj1WR5V_k_YnLaxtHMgEQwsaOpUrppEu4hu91UTtUxcNnI-uGYQ9C0NJvWnWXCT2CwheYRJhpa-M_KnXyYAuVFNGXYVyLvnhqRX9im_DiN4IZmE0h3OEnOPRTQO0iwKgA2_vfvt-XrntV3SjiKI5UKvluBWl6O-Kl_jiwHUwb23w20Hqb4mw";
		//CONSTRUIMOS NUESTRO URL
		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("https")
		.host("graph.microsoft.com")
		.path("v1.0/users/"+userId)
		//.queryParam("Authorization",accessToken) //ESTA LINEA SE BORRA SI QUISIERAMOS AGREGAR PARÁMETROS (PUEDEN SER VARIAS QUERYPARAM)
		.build();
		
		//AGREGAMOS EL TOKEN DENTRO DE LOS HEADERS DE LA PETICIÓN
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", accessToken);
		
		/*CREAMOS LA ENTIDAD, DONDE ESTÁ NULL VAN PARÁMETROS, PERO NO ES NECESARIO
		 PORQUE LOS PARÁMETROS LOS ESTAMOS PASANDO EN LA CONSTRUCCIÓN DEL URL.
		 SE LE PASAN DE SEGUNDO LOS HEADERS QUE CREAMOS ANTERIORMENTE*/
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
		try {
		//REALIZAMOS LA PETICIÓN AGREGANDOLE EL URL, EL MÉTODO (GET,POST,UPDATE,DELETE, ETC), LA ENTIDAD
		//QUE CREAMOS ANTERIORMENTE Y FINALMENTE LA INTERFAZ DE NUESTRA RESPUESTA, EN ESTE CASO STRING
		ResponseEntity<String> respEntity=template.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
		
		//CONVERTIMOS LA RESPUESTA STRING A UN OBJETO JSON PARA SER MÁS FÁCIL EL MANEJO DE LA INFORMACIÓN
		JSONObject json = new JSONObject(respEntity.getBody());
		
		System.out.println(json.get("displayName"));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
		
	
}
