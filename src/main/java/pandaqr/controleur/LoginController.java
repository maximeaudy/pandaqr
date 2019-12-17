package pandaqr.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping({"/", "/connection"})
    @PostMapping("/j_security_check")
    public String login() {
        return "connection";
    }
}
