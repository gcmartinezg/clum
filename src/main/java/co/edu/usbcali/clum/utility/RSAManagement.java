package co.edu.usbcali.clum.utility;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAManagement {
	
	private static final int N = 8;
	
	private RSAManagement() {
		throw new AssertionError("prohibido");
	}
	
	/**
	 * IMPORTANTE! la clave para que funcione toda esta clase para cifrar es
	 * mantener en secreto el numero N el cual se le aplica potencia
	 */
	private static int primo(int n) {
		return (2 * (n ^ 2) + 11);
	}

	/**
	 * Este metodo se llama de primero para despues pasarle 
	 * el string cifrado al metodo de RSAManagement
	 * */
	public static String cifrarMensajeCesar(String mensaje) {
		char array[] = mensaje.toCharArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = (char) (array[i] + (char) primo(N));
		}
		String mensajeCifrado = String.valueOf(array);
		return mensajeCifrado;
	}

	/**
	 * METODO OPCIONAL
	 * */
	public static String descifrarMensajeCesar(String cifrado) {
		char array[] = cifrado.toCharArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = (char) (array[i] - (char) primo(N));
		}
		String mensaje = String.valueOf(array);
		return mensaje;
	}

	public static KeyPair getRSAKeys() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		return keyPair;
	}

	/**
	 * METODO OPCIONAL
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 **/
	// Decrypt using RSAManagement public key
	public static String descifrarMensajeRSA(String mensajeCifrado, PublicKey clavePublica) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
			IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, clavePublica);
		return new String(cipher.doFinal(Base64.getDecoder().decode(mensajeCifrado)));
	}

	// Encrypt using RSAManagement private key
	public static String cifrarMensajeRSA(String textoPlano, PrivateKey clavePrivada) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
			IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, clavePrivada);
		return Base64.getEncoder().encodeToString(cipher.doFinal(textoPlano.getBytes()));
	}

}
