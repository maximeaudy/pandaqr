package pandaqr.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import pandaqr.modele.Booking;
import pandaqr.modele.Email;
import pandaqr.modele.Room;
import pandaqr.service.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/rooms")
	public String showRooms(Model model) {
		model.addAttribute("rooms", roomService.getRooms());
		return "booking-rooms";
	}

	@GetMapping("/booking/{roomCode}")
	public String showForms(BookingDto bookingDto, @PathVariable String roomCode, Model model) {
		model.addAttribute("roomCode", roomCode);
		return "booking-forms";
	}

	@PostMapping("/booking")
	public String book(@Validated BookingDto bookingDto, @RequestParam String roomCode, BindingResult bindingResult, Model model, HttpServletRequest httpRequest) {
		String email = httpRequest.getUserPrincipal().getName();
		if (bindingResult.hasErrors()) {
            model.addAttribute("booking", bookingDto);
			return "booking-forms";
		}
		try {
			Booking booking = bookingService.book(bookingDto, email, roomCode);
			model.addAttribute("booking", booking);

			emailService.send(bookingDto,"pandaqr1@gmail.com",roomCode);
			return "booking-summary";
		} catch (FormatParticipantsEmailException | ParseException | DateNotFreeException e) {
			bindingResult.addError(new FieldError("bookingDto", "participants", e.getMessage()));
			return "booking-forms";
		}
	}
}
