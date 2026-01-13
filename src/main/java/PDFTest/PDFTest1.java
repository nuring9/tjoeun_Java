package PDFTest;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.HashMap;

public class PDFTest1 {
    static void main() throws IOException {
        HashMap<String, String>bookInfo = new HashMap<>();

        bookInfo.put("title", "한글자바");
        bookInfo.put("author", "홍길동");
        bookInfo.put("publisher", "한글 출판사");
        bookInfo.put("year", String.valueOf(Year.now().getValue()));
        bookInfo.put("price", "25000");
        bookInfo.put("pages", "400");

        PdfWriter writer = new PdfWriter(new FileOutputStream("book.pdf"));
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont("나눔손글씨 행복한 도비.ttf", PdfEncodings.IDENTITY_H);
        document.setFont(font);
        // Set -> Iterater 빼서 while
        // for Each문 사용
        // Set은 키값이 중복이 허용하지 않음. (값은 허용가능)
        for(String key : bookInfo.keySet()) {
          Paragraph paragraph = new Paragraph(key + ":" + bookInfo.get(key));
            document.add(paragraph);
        }

        document.close();
        System.out.println("pdf 파일 생성되었습니다.");
    }
}
