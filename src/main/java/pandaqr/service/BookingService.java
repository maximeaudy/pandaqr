package pandaqr.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pandaqr.modele.Booking;
import pandaqr.modele.Participant;
import pandaqr.repository.BookingRepository;
import pandaqr.repository.RoomRepository;
import pandaqr.repository.UserRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = FormatParticipantsEmailException.class)
    public Booking book(BookingDto bookingDto, String userEmail, String roomCode) throws FormatParticipantsEmailException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Booking booking = new Booking(
                formatter.parse(bookingDto.getStart_date() + " " + bookingDto.getStart_time()),
                formatter.parse(bookingDto.getEnd_date() + " " + bookingDto.getEnd_time()),
                bookingDto.getName(),
                bookingDto.getDescription());
        booking.setRoom(roomRepository.find(roomCode));
        booking.setUser(userRepository.find(userEmail));
        String[] list_participants = bookingDto.getParticipants().split(";");
        for (String email : list_participants) {
            if (!email.contains("@")) {
                throw new FormatParticipantsEmailException("Format exigé : [adresse mail];[adresse mail]; ...");
            }
            booking.getParticipants().add(new Participant(email, booking));
        }
        bookingRepository.save(booking);
        return booking;
    }

}
