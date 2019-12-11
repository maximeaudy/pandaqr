package pandaqr.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ICalendarAttachment {
	// Constants for the ICalendar methods.
	public static final String METHOD_CANCEL = "CANCEL";
	public static final String METHOD_PUBLISH = "PUBLISH";
	public static final String METHOD_REQUEST = "REQUEST";
	// Constant for unique IDs. This can be made more unique, actually :).
	private static final String UID_PREFIX = "pandaqr-";
	// Apply this organizer, if no organizer is given.
	private static final String DEFAULT_ORGANIZER = "pandaqr1@gmail.com";
	// Common ICalendar fields.
	private String method;
	private Date beginDate;
	private Date endDate;
	private String location;
	private int uid;
	private String description;
	private String subject;
	private String organizer;

	/**
	 * Produces the string in proper format for an .ics attachment from the set
	 * instance data.
	 * 
	 * @return VCalendar/.ics formatted string that can be used as attachment
	 *         content.
	 */
	@Override
	public String toString() {
		// Create the proper date format string required by the ICalendar spec.
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		final String stringBeginDate = formatter.format(beginDate);
		final String stringEndDate = formatter.format(endDate);
		// Encode the description => mark new lines.
		final String encodedDescription = description.replaceAll("\r\n", "\\\\n");
		// Use the default organizer if none is given.
		if (this.organizer == null) {
			this.organizer = DEFAULT_ORGANIZER;
		}
		// Content string as array.
		String[] contents = { "BEGIN:VCALENDAR", "METHOD:" + method, "BEGIN:VEVENT", "UID:" + UID_PREFIX + uid,
				"DTSTART:" + stringBeginDate, "DTEND:" + stringEndDate, "LOCATION:" + location,
				"DESCRIPTION:" + encodedDescription, "ORGANIZER:" + organizer, "SUMMARY:" + subject, "END:VEVENT",
				"END:VCALENDAR" };
		// Build a well-formatted string from the array.
		StringBuilder sb = new StringBuilder();
		for (String line : contents) {
			if (sb.length() > 0) {
				sb.append("\n");
			}
			sb.append(line);
		}
		// Return the well-formatter ICalendar string.
		return sb.toString();
	}
	
}