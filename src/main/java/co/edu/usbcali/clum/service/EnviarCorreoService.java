package co.edu.usbcali.clum.service;

public interface EnviarCorreoService {
	
	public String enviaCorreo(String correo, String clave,String usuario) throws Exception;

	public String correoCreacion(String correo, String clave,String usuario) throws Exception;

}
