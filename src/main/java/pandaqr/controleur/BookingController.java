package pandaqr.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pandaqr.modele.Booking;
import pandaqr.service.BookingDto;
import pandaqr.service.BookingService;
import pandaqr.service.FormatParticipantsEmailException;

@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking")
	public String showForms(BookingDto bookingDto) {
		return "booking-forms";
	}

	@PostMapping("/booking")
	public String book(@Validated @ModelAttribute BookingDto bookingDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			this.showForms(bookingDto);
		}
		try {
			Booking booking = bookingService.book(bookingDto);
			model.addAttribute("booking", booking);
			return "booking-summary";
		} catch (FormatParticipantsEmailException e) {
			bindingResult.addError(new FieldError("bookingDto", "participants", e.getMessage()));
			return "formulaire-inscription";
		}
	}
}
