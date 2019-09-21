package co.edu.usbcali.clum.utility;

import java.io.ByteArrayOutputStream;
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
	
	public static <T> void crearPDF(List<T> lista) throws DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new ByteArrayOutputStream());
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Documento de Prueba", font);
		document.add(chunk);
		
		PdfPTable table = new PdfPTable(3);
		addTableHeader(table, lista);
		addRows(table);
		
		document.close();
	}
	
	private static <T> void addTableHeader(PdfPTable table, List<T> lista) {
		List<String> fieldNames = Utilities.getFieldNames(lista.get(0));
	    fieldNames.forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private static  void addRows(PdfPTable table) {
	    table.addCell("row 1, col 1");
	    table.addCell("row 1, col 2");
	    table.addCell("row 1, col 3");
	}

}
