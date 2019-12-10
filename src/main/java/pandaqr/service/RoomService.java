package pandaqr.service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaqr.modele.Room;
import pandaqr.repository.RoomRepository;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRooms() {
        return roomRepository.getRooms();
    }

    public String getPdf(List<String> roomIds) throws FileNotFoundException, MalformedURLException {
        List<Room> rooms = new ArrayList<>();
        for (String roomId: roomIds) {
            rooms.add(this.roomRepository.find(Long.parseLong(roomId)));
        }
        return this.createPdf(rooms);
    }

    private String createPdf(List<Room> rooms) throws FileNotFoundException, MalformedURLException {
        // Creating a PdfWriter
        String dest = "D:\\Nouveau dossier\\Cours\\B3\\JavaEE\\pdf.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Adding a new page
        pdfDoc.addNewPage();

        // Creating a Document
        Document document = new Document(pdfDoc);
        for (Room room : rooms) {
            String para1 = "Salle " + room.getCode();

            // Creating Paragraphs
            Paragraph paragraph1 = new Paragraph(para1);
            // Creating an ImageData object
            String imFile = String.format("https://api.qrserver.com/v1/create-qr-code/?data=http://localhost:8085/pandaqr?room=%d&size=100x100&color=c54f4f&format=jpg", room.getId());
            ImageData data = ImageDataFactory.create(imFile);

            // Creating an Image object
            Image image = new Image(data);

            // Adding image to the document
            document.add(image);
            // Adding paragraphs to document
            document.add(paragraph1);
        }

        // Closing the document
        document.close();
        return "PDF Created";
    }
}
