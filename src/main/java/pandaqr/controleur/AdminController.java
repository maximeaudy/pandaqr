package pandaqr.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pandaqr.service.RoomService;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private RoomService roomService;

    @GetMapping({"/admin"})
    public String index(Model model) {
        model.addAttribute("rooms", roomService.getRooms());
        return "admin-index";
    }
    @PostMapping({"/admin"})
    public String createPdf(@RequestParam("room-items") List<String> roomIds, Model model) {
        try {
            roomService.getPdf(roomIds);
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
        return "admin-index";
    }
}
