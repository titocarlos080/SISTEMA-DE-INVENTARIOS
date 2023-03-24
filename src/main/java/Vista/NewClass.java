package Vista;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.OutputStreamCounter;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
 
import java.io.IOException;
 

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author hp
 */
public class NewClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(new File("").getCanonicalPath() + "/excel.xlsx");
        XSSFWorkbook libro = new XSSFWorkbook(fis);

        XSSFSheet hoja = libro.getSheetAt(0);
        int f = hoja.getLastRowNum();
        for (int i = 0; i < f; i++) {

            XSSFRow fila = hoja.getRow(i);
            int col = fila.getLastCellNum();
            for (int j = 0; j < col; j++) {
                System.out.print(fila.getCell(j).toString() + "  ");
            }
            System.out.println("");

        }

//        
//         int col= fila.getLastCellNum();
//        
//        
//        try {
//
//            Document document = new Document();
//            String ruta = System.getProperty("user.home");
//            OutputStream outputStream
//                    = new FileOutputStream(new File(ruta + "/Desktop/prueba.pdf"));
//
//            PdfWriter.getInstance(document, outputStream);
//            //Open the document
//            document.open();
//            document.add(new Paragraph("Hello world "));
//
//            document.add(Image.getInstance(ClassLoader.getSystemResource("images/imagen_header_fondo.jpg").toString()));
//            document.addAuthor("Tito");
//            System.out.println(new File("").getCanonicalPath());
//            //Close document and outputStream.
//            document.close();
//            outputStream.close();
//
//            System.out.println("Pdf created successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
