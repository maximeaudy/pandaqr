package pandaqr.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pandaqr.modele.Booking;
import pandaqr.modele.Participant;
import pandaqr.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	@Transactional(rollbackFor = FormatParticipantsEmailException.class)
	public Booking book(BookingDto bookingDto) throws FormatParticipantsEmailException {
		List<String> list_participants = Arrays.asList(bookingDto.getParticipants().split(";"));
		boolean badFormat = false;
		while (badFormat == false) {
			for (String participant : list_participants) {
				if (!participant.contains("@")) {
					badFormat = true;
				}
			}
		}
		if (badFormat == true) {
			throw new FormatParticipantsEmailException("Format exigé : [adresse mail];[adresse mail]; ...");
		}
		Booking booking = new Booking(bookingDto.getStart_time(), bookingDto.getEnd_time(), bookingDto.getName(),
				bookingDto.getDescription());
		bookingRepository.save(booking);
		return booking;
	}

}
