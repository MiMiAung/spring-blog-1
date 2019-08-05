package demo.example.blogspring1.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import demo.example.blogspring1.model.Author;
import demo.example.blogspring1.model.Post;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PostReport {
    public static ByteArrayInputStream postPdfViews(List<Post> postList) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();

        try {

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(80);
            table.setWidths(new int[]{3,3,3,3,2,2,2});


            PdfPCell hcell;
            Font font= FontFactory.getFont(FontFactory.HELVETICA);

            hcell=new PdfPCell(new Phrase("Tag",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell=new PdfPCell(new Phrase("Post Body",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);


            hcell=new PdfPCell(new Phrase("Last Updated",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell=new PdfPCell(new Phrase("Author",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell=new PdfPCell(new Phrase("Details",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell=new PdfPCell(new Phrase("Update",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell=new PdfPCell(new Phrase("Delete",font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);



            for(Post post:postList){
                PdfPCell cell;

                cell=new PdfPCell(new Phrase(post.getTag().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell=new PdfPCell(new Phrase (String.valueOf(post.getBody().toCharArray(),0,10)));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);


                cell=new PdfPCell(new Phrase(post.getLastUpdated().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);


                cell=new PdfPCell(new Phrase(post.getAuthor().getName().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell=new PdfPCell(new Phrase("Details"));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell=new PdfPCell(new Phrase("Update"));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell=new PdfPCell(new Phrase("Delete"));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);



            }

            PdfWriter.getInstance(document,out);
            document.open();

            document.add(table);

            document.close();


        }catch (Exception e){
            e.printStackTrace();
        }




        return new ByteArrayInputStream(out.toByteArray());


    }
}
