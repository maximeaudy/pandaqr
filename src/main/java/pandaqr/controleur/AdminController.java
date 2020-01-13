package pandaqr.controleur;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pandaqr.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("rooms", roomService.getRooms());
        return "admin-index";
    }
    @PostMapping("/")
    protected void createPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam("room-items") List<String> roomIds)
            throws ServletException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) roomService.getPdf(roomIds);
        // setting some response headers
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType("application/pdf");
        // the contentlength
        response.setContentLength(byteArrayOutputStream.size());
        // write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = response.getOutputStream();
        byteArrayOutputStream.writeTo(os);
        os.flush();
        os.close();
    }
    @PostMapping("/{id}")
    public String infoByDate(@RequestParam("day") String day, @PathVariable String id, Model model) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", new Locale("fr", "FR"));
        model.addAttribute("room", roomService.findRoom(id, formatter.parse(day)));
        return "admin-room-info";
    }

    @GetMapping("/{id}")
    public String index(Model model, @PathVariable String id) {
        model.addAttribute("room", roomService.findRoom(id));
        return "admin-room-info";
    }
}
