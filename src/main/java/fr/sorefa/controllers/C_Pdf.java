package fr.sorefa.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

// @WebServlet(name= "C_Pdf" , urlPatterns = "/pdf")
public class C_Pdf /** extends HttpServlet */
{

        @FXML
        void pdf(ActionEvent event) throws DocumentException, MalformedURLException, IOException {
                // doPost();

                Document document = new Document();
                // @SuppressWarnings("unused")
                PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("./doc/pdf/HelloWorld.pdf"));
                document.open();

                Phrase phrase = new Phrase();
                Phrase sphrase = new Phrase();

                Phrase Otherphrase = new Phrase();
                Paragraph paragraph = new Paragraph();
                Paragraph paragraph1 = new Paragraph();
                Paragraph paragraph2 = new Paragraph();
                /**
                 * text font-familly
                 */
                Font timesRomanfont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLDITALIC);
                Chunk timesRomanChunk = new Chunk("PROJET SOREFA / gestion des devis", timesRomanfont);
                phrase.add(timesRomanChunk);
                phrase.add(Chunk.NEWLINE);

                Font underlineFont = new Font(Font.FontFamily.HELVETICA, 20, Font.UNDERLINE);
                phrase.add(Chunk.NEWLINE);

                phrase.add(Chunk.NEWLINE);
                Chunk underlineChunk = new Chunk("PROJET SOREFA / gestion des devis", underlineFont);
                phrase.add(timesRomanChunk);
                phrase.add(Chunk.NEWLINE);

                phrase.add(underlineChunk);

                // tableau
                paragraph.add("Projet SOREFA !");
                Paragraph otherParagraph = new Paragraph();
                otherParagraph.add("I am a test! ");
                otherParagraph.add(" ");
                otherParagraph.add("Je suis test !");

                Otherphrase.add("Sorefa Sarl, entreprise spécialisé sur la renovation des façades et du bâti.");
                otherParagraph.setAlignment(Element.ALIGN_CENTER);
                /**
                 * test text position
                 */
                paragraph1.add("Le premier paragraphe");
                paragraph1.add(Chunk.NEWLINE);
                paragraph2.add("Le deuxième paragraphe");
                paragraph2.add(Chunk.NEWLINE);
                paragraph1.setIndentationLeft(80);
                // paragraph1.setIndentationRight(80);
                paragraph1.setAlignment(Element.ALIGN_CENTER);
                paragraph1.setSpacingAfter(15);
                paragraph2.setSpacingBefore(15);
                paragraph2.setAlignment(Element.ALIGN_LEFT);

                // Phrase phrase = new Phrase("This is a large sentence.");

                // paragraph.add(timesRomanChunk);
                // paragraph.add(Chunk.NEWLINE);

                // content.addImage(background);
                sphrase.add("*");
                for (int count = 0; count < 100; count++) {
                        paragraph1.add(sphrase);
                        paragraph2.add(sphrase);
                }

                document.add(paragraph1);
                document.add(Chunk.NEWLINE);
                document.add(paragraph2);
                document.add(Chunk.NEWLINE);
                document.add(paragraph);
                document.add(Chunk.NEWLINE);
                document.add(otherParagraph);
                document.add(Chunk.NEWLINE);
                document.add(phrase);
                document.add(Chunk.NEWLINE);
                document.add(Otherphrase);
                // pdfAdd();
                // onTopPage(pdfWriter, document);
                onEndPage(pdfWriter, document);
                document.close();
                // try
                // {
                // PdfReader pdfReader = new PdfReader("./doc/pdf/WaterMarked.pdf");
                // PdfStamper pdfStamper = new PdfStamper(pdfReader, new
                // FileOutputStream("HelloWorldModified1.pdf"));
                // PdfContentByte content = pdfStamper.getUnderContent(1);

                // Image background = Image.getInstance("doc\\img\\logo_sorefa.png");

                // background.setAbsolutePosition(150f, 650f);
                // content.addImage(background);

                // pdfStamper.close();
                // pdfReader.close();
                // }
                // catch (IOException e)
                // {
                // e.printStackTrace();
                // }
                // catch (DocumentException e)
                // {
                // e.printStackTrace();
                // }

        }

        void pdfAdd() {
                /**
                 * try {
                 * 
                 * PdfReader pdfReader = new PdfReader("./doc/pdf/HelloWorlds.pdf");
                 * PdfStamper pdfStamper = new PdfStamper(pdfReader, new
                 * FileOutputStream("./doc/pdf/HelloWorld2.pdf"));
                 * PdfContentByte content = pdfStamper.getUnderContent(1);
                 * 
                 * Image background = Image.getInstance("./doc/img/logo_sorefa.png");
                 * background.setAbsolutePosition(150f, 650f);
                 * content.addImage(background);
                 * 
                 * pdfStamper.close();
                 * pdfReader.close();
                 * } catch (Exception e) {
                 * System.out.println("n'a pas pus générer l'image");
                 * }
                 * Image img = new Image(); ne peut etre instancier
                 */
                // PdfContentByte content = pdfStamper.getUnderContent(1);
        }

        public void onEndPage(PdfWriter writer, Document document) {
                try {
                        Image background = Image.getInstance("doc\\img\\logo_sorefa.png");
                        float width = background.getWidth();
                        float height = background.getHeight();
                        writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);
                } catch (BadElementException e) {
                        e.printStackTrace();
                } catch (MalformedURLException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (DocumentException e) {
                        e.printStackTrace();
                }
        }

        public void onTopPage(PdfWriter writer, Document document) {
                try {

                        // float width = background.getWidth();
                        // float height = background.getHeight();
                        // // writer.getDirectContentUnder().addImage(background, width, 0, 0, height,
                        // 0, 0);
                        // writer.getDirectContent().addImage(background, width, 0, 0, height, 0, 0);

                        // PdfReader pdfReader = new PdfReader("./doc/pdf/WaterMarked.pdf");
                        PdfReader pdfReader = new PdfReader("doc\\pdf\\HelloWord.pdf");

                        PdfStamper pdfStamper = new PdfStamper(pdfReader,
                                        new FileOutputStream("doc\\pdf\\HelloWords.pdf"));
                        PdfContentByte content = pdfStamper.getUnderContent(1);
                        Image background = Image.getInstance("doc\\img\\f.png");

                        background.setAbsolutePosition(150f, 650f);
                        content.addImage(background);

                        pdfStamper.close();
                        pdfReader.close();
                } catch (BadElementException e) {
                        e.printStackTrace();
                } catch (MalformedURLException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (DocumentException e) {
                        e.printStackTrace();
                }
        }

        // public static void doPost() throws FileNotFoundException, DocumentException {
        // // test pdf debut
        // Document document = new Document();
        // @SuppressWarnings("unused")
        // PdfWriter pdfWriter = PdfWriter.getInstance(document, new
        // FileOutputStream("./doc/pdf/HelloWorld.pdf"));
        // document.open();

        // Phrase phrase = new Phrase();
        // Paragraph paragraph = new Paragraph();
        // Paragraph otherParagraph = new Paragraph();

        // Font timesRomanfont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
        // Font.BOLDITALIC);
        // Chunk timesRomanChunk = new Chunk("PROJET SOREFA ", timesRomanfont);
        // phrase.add(timesRomanChunk);
        // phrase.add(Chunk.NEWLINE);
        // // Image img = new Image(); ne peut etre instancier
        // paragraph.add("Hello World!");
        // otherParagraph.add("I am a test! ");
        // otherParagraph.add(" ");
        // otherParagraph.add("Je suis un test !");
        // otherParagraph.setAlignment(Element.ALIGN_CENTER);

        // // paragraph.add(timesRomanChunk);
        // // paragraph.add(Chunk.NEWLINE);

        // document.add(paragraph);
        // document.add(otherParagraph);
        // document.add(phrase);
        // document.close();

        // Document document = new Document();

        // @SuppressWarnings("unused")
        // PdfWriter pdfWriter = PdfWriter.getInstance(document, new
        // FileOutputStream("./doc/pdf/HelloWorld.pdf"));

        // //______________________________debut
        // Document document = new Document();
        // @SuppressWarnings("unused")
        // PdfWriter pdfWriter = PdfWriter.getInstance(document, new
        // FileOutputStream("HelloWorld.pdf"));
        // document.open();

        // Paragraph paragraph = new Paragraph();
        // paragraph.add("Hello World!");

        // document.add(paragraph);
        // document.close();
        // //_________________________________fin
        // }

}
