package pandaqr.service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Service;
import pandaqr.modele.Room;
import pandaqr.repository.RoomRepository;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRooms() {
        return roomRepository.getRooms();
    }

    public OutputStream getPdf(List<String> roomIds) throws FileNotFoundException, MalformedURLException {
        List<Room> rooms = new ArrayList<>();
        for (String roomId: roomIds) {
            rooms.add(this.roomRepository.find(Long.parseLong(roomId)));
        }
        return this.createPdf(rooms);
    }

    private OutputStream createPdf(List<Room> rooms) throws FileNotFoundException, MalformedURLException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);

        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Adding a new page
        pdfDoc.addNewPage();

        // Creating a Document
        Document document = new Document(pdfDoc);
        for (Room room : rooms) {
            Paragraph para = new Paragraph();
            para.setVerticalAlignment(VerticalAlignment.MIDDLE);
            para.setHorizontalAlignment(HorizontalAlignment.CENTER);
            para.setBorder(new SolidBorder(3));
            String para1 = "Salle " + room.getCode();
            para.add(para1);
            // Creating an ImageData object
            String imFile = "https://api.qrserver.com/v1/create-qr-code/?data=http://localhost:8085/pandaqr/booking/" + room.getCode() + "&size=100x100&color=c54f4f&format=jpg";
            ImageData data = ImageDataFactory.create(imFile);

            // Creating an Image object
            Image image = new Image(data);

            // Adding image to the document
            para.add(image);
            // Adding paragraphs to document
            document.add(para);
        }

        // Closing the document
        document.close();
        return baos;
    }

    public Room findRoom(String id) {
        return roomRepository.find(Long.parseLong(id));
    }
    public Room findRoom(String id, Date day) {
        return roomRepository.find(Long.parseLong(id), day);
    }
}
