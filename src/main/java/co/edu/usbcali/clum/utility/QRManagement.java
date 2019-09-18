package co.edu.usbcali.clum.utility;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRManagement {
	
	private QRManagement () {throw new AssertionError("prohibido");}
	
	/**
	 * 
	 * @param archivo el archivo donde va a ser almacenada la representacion del qr
	 * @param texto el texto a ser cifrado en el qr
	 * @param alto el ancho del codigo generado
	 * @param ancho el ancho del codigo generado
	 * @return el archivo con el qr escrito en el
	 * @throws IOException si ocurre un error en la escritura del archivo
	 * @throws WriterException si ocurre un error en le cifrado del texto
	 */
	public static File generarQR(File archivo, String texto, int alto, int ancho) 
			throws IOException, WriterException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(
        		texto, com.google.zxing.BarcodeFormat.QR_CODE, ancho, alto
        		);

        BufferedImage image = new BufferedImage(
        		matrix.getWidth(), matrix.getHeight(), BufferedImage.TYPE_INT_RGB
        		);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrix.getWidth(), matrix.getHeight());
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
                
            }
            
        }

        ImageIO.write(image, "png", archivo);

        return archivo;
    }
	
	/**
	 * 
	 * @param archivo el archivo que contiene el qr a ser decodificado
	 * @return la representacion del qr como un string
	 * @throws FileNotFoundException si el archivo no existe
	 * @throws IOException si ocurre un error en la lectura del archivo
	 * @throws FormatException si el archivo no contiene un codigo qr
	 * @throws FormatException si el codigo qr no puede ser decodificado
	 * @throws ChecksumException if error correction fails (?)
	 */
    public static String decodificarQR(File archivo) throws FileNotFoundException, 
    		IOException, FormatException, ChecksumException, NotFoundException {
        FileInputStream inputStream = new FileInputStream(archivo);

        BufferedImage image = ImageIO.read(inputStream);

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        // decode the qr
        QRCodeReader reader = new QRCodeReader();
        Result result = reader.decode(bitmap);
        
        return new String(result.getText());
    }
    
}