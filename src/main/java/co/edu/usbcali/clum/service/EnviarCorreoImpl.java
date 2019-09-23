package co.edu.usbcali.clum.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class EnviarCorreoImpl implements EnviarCorreoService {

	@Autowired
	private JavaMailSender  mailsender;
	
	@Override
	public String enviaCorreo(String correo, String clave, String usuario) throws Exception {
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper =  new MimeMessageHelper(message, true);
		helper.setTo(correo);
		helper.setSubject("Actualizacion de clave de cuenta bancaria");
		//helper.setText("Esto es una prueba de correo");
		helper.setText("<html> <body> <h2>La nueva clave de la cuenta "+usuario+" es: "+clave+"</h2>\r\n" + 
				"\r\n" + 
				"<p>Por favor no comparta su clave con nadie </p>", true);
		this.mailsender.send(message); 
		return "";
	}

	@Override
	public String correoCreacion(String correo, String clave, String usuario) throws Exception {
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper =  new MimeMessageHelper(message, true);
		helper.setTo(correo);
		helper.setSubject("Creacion de usuario");
		//helper.setText("Esto es una prueba de correo");
		helper.setText("<html> <body> <h2>Su nueva usuario es: "+usuario+" Y su respectiva clave es: "+clave+"</h2>\r\n" + 
				"\r\n" + 
				"<p>Por favor no comparta su clave con nadie </p>", true);
		this.mailsender.send(message); 
		return "";
	}

}
