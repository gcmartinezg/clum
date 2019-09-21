package co.edu.usbcali.clum.utility;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFManagement {

	private PDFManagement() {throw new AssertionError("prohibido");}
	
	public static <T> ByteArrayOutputStream crearPDF(List<T> lista, String nombre) throws DocumentException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter.getInstance(document, baos);
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
		document.addTitle(nombre);
		Chunk chunk = new Chunk(nombre, font);
		document.add(chunk);
		
		PdfPTable table = new PdfPTable(lista.get(0).getClass().getDeclaredFields().length);
		addTableHeader(table, lista);
		addRows(table, lista);
		document.add(table);
		
		document.close();
		
		return baos;
	}
	
	private static <T> void addTableHeader(PdfPTable table, List<T> lista) {
		List<String> fieldNames = Utilities.getFieldNames(lista.get(0));
	    fieldNames.forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(1);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private static <T> void addRows(PdfPTable table, List<T> lista) {
	    for(T element: lista) {
	    	Field[] fields = element.getClass().getDeclaredFields();
	    	for(Field field : fields) {	
	    		try {
	    			field.setAccessible(true);
					table.addCell(String.valueOf(field.get(element)));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    	
	    }
	    
	}

}
