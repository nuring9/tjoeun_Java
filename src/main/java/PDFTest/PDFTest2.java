package PDFTest;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class PDFTest2 {
    static void main(String[] args) throws MalformedURLException, IOException {
        String dest = "book_table.pdf";
        new PDFTest2().createPdf(dest);
    }

    private void createPdf(String dest) throws IOException {
        List<Map<String, String>> books = createDummyData();

// PDF 생성
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);

// Font Set
        PdfFont headerFont = null;
        PdfFont bodyFont = null;

        headerFont = PdfFontFactory.createFont("나눔손글씨 행복한 도비.ttf", "Identity-H");
        bodyFont = PdfFontFactory.createFont("나눔손글씨 행복한 도비.ttf", "Identity-H");

// 실수 배열 생성 -> 테이블 생성
        float[] columnWidths = {1, 2, 2, 2, 2, 2};
        Table table = new Table(UnitValue.createPercentArray(columnWidths));
        table.setWidth(UnitValue.createPercentValue(100));

        Cell hCell1 = new Cell().add(new Paragraph("순번")).setFont(headerFont);
        Cell hCell2 = new Cell().add(new Paragraph("제목")).setFont(headerFont);
        Cell hCell3 = new Cell().add(new Paragraph("저자")).setFont(headerFont);
        Cell hCell4 = new Cell().add(new Paragraph("출판사")).setFont(headerFont);
        Cell hCell5 = new Cell().add(new Paragraph("출판일")).setFont(headerFont);
        Cell hCell6 = new Cell().add(new Paragraph("이미지")).setFont(headerFont);

        table.addHeaderCell(hCell1);
        table.addHeaderCell(hCell2);
        table.addHeaderCell(hCell3);
        table.addHeaderCell(hCell4);
        table.addHeaderCell(hCell5);
        table.addHeaderCell(hCell6);

        // 테이블 본문에 값 넣기
        int rowNum = 1;
        for(Map<String, String> book : books) {
            String title = book.get("title");
            String authors = book.get("authors");
            String publisher = book.get("publisher");
            String publishedDate = book.get("publishedDate");
            String thumbnail = book.get("thumbnail");

            Cell rowNumCell = new Cell().add(new Paragraph(String.valueOf(rowNum))).setFont(bodyFont);
            table.addCell(rowNumCell);
            Cell titleCell = new Cell().add(new Paragraph(title)).setFont(bodyFont);
            table.addCell(titleCell);
            Cell authorsCell = new Cell().add(new Paragraph(authors)).setFont(bodyFont);
            table.addCell(authorsCell);
            Cell publisherCell = new Cell().add(new Paragraph(publisher)).setFont(bodyFont);
            table.addCell(publisherCell);
            Cell publishedDateCell = new Cell().add(new Paragraph(publishedDate)).setFont(bodyFont);
            table.addCell(publishedDateCell);

          //  ImageData imageData = ImageDataFactory.create(new File(thumbnail).toURI().toURL());
            // URL로 이미지 넣기.
            ImageData imageData = ImageDataFactory.create(new URL(thumbnail));
            Image img = new Image(imageData);
            Cell imageCell = new Cell().add(img.setAutoScale(true));
            table.addCell(imageCell);
            rowNum++;
        }
        document.add(table);
        document.close();
    }


// 테이블 헤더 -> 행
    private List<Map<String, String>> createDummyData() {
         List<Map<String, String>> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("책 개수를 입력하세요: ");
        int bookCount = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i <= bookCount; i++){
            Map<String , String> book = new HashMap<>();
            System.out.printf("\n[ %d번째 책 정보 입력]\n", i);
            System.out.print("제목 : ");
            book.put("title", scanner.nextLine());
            System.out.print("저자 : ");
            book.put("authors", scanner.nextLine());
            System.out.print("출판사 : ");
            book.put("publisher", scanner.nextLine());
            System.out.print("출판일(YYY-MM-DD) : ");
            book.put("publishedDate", scanner.nextLine());
            System.out.print("썸네일 URL : ");
            book.put("thumbnail", scanner.nextLine());
            books.add(book);
        }
        scanner.close();
        return  books;
    }


}
