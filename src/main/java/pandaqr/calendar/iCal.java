package pandaqr.calendar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class iCal {
	private static String version = "VERSION:2.0 \n";
	private static String prodid = "PRODID://Elara/lofy/tanare/delp/314sum2015//\n";
	private static String calBegin = "BEGIN:VCALENDAR \n";
	private String calEnd = "END:VCALENDAR \n";
	private String eventBegin = "BEGIN:VEVENT \n";
	private String eventEnd = "END:VEVENT \n";
	static final String NL = "\r\n";

	public iCal() {
	}

	public static void write( String name ){
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(".ics");
		String testExample = "UID:uid1@example.com\nDTSTAMP:19970714T170000Z\nORGANIZER;CN=John Doe:MAILTO:john.doe@example.com\nDTSTART:19970714T170000Z\nDTEND:19970715T035959Z\nSUMMARY:Bastille Day Party\n";
		try {
			File file = new File(builder.toString());
			//if file doesnt exists, then create it
			if (!file.exists()) {
			file.createNewFile();
		}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(calBegin);
			bw.write(version);
			bw.write(prodid);
			bw.write(eventBegin);
			bw.write(testExample);
			bw.write(eventEnd);
			bw.write(calEnd);
			bw.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}