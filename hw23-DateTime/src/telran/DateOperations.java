package telran;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class DateOperations {
	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static final DateTimeFormatter dtfISO = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final DateTimeFormatter hm = DateTimeFormatter.ofPattern("HH:mm");

	/**
	 * 
	 * @param dates
	 * @return sorted array of strings in the ascending order of the appropriate
	 *         dates String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12",
	 *         "2010-10-05" };
	 */
	public static String[] sortStringDates(String[] dates) {
		return Arrays.stream(dates).sorted((str1, str2) -> 
		parseToLocalDate(str1).compareTo(parseToLocalDate(str2))
		).toArray(String[]::new);


	}

	private static LocalDate parseToLocalDate(String str) {
		try {
			return LocalDate.parse(str, dtfISO);
		} catch (DateTimeParseException e) {
			return LocalDate.parse(str, dtf);
		}
	}

	/**
	 * 
	 * @param birthDate
	 * @param currentDate
	 * @return full age in the years relatively the given current date if
	 *         currentDate is null the LocalDate.now() is applied
	 *     
	 *     String birthDate = "12/04/1961";
		String currentDate = "11/11/2018";
		assertEquals(57, DateOperations.getAge(birthDate, currentDate));
	 */
	public static int getAge(String birthDate, String currentDate) {
		LocalDate bDate = parseToLocalDate(birthDate);
		LocalDate curDate = parseToLocalDate(currentDate);
		
		if(currentDate == null)
			curDate = LocalDate.now();
		return (int) ChronoUnit.YEARS.between(bDate, curDate);

	}

	/**
	 * print current time in format HH:MM (hours:minutes) for all time zones
	 * containing zoneSubstring one printed line should contain full zone name and
	 * time in the above format
	 * 
	 * @param zoneSubstring
	 */
	public static void printCurrentTime(String zoneSubstring) {

		Set<String> timeZones = ZoneId.getAvailableZoneIds();
		
		//LocalTime.parse(tz, hm)
		
		timeZones.stream()
		.filter(tz -> tz.contains(zoneSubstring))
		.forEach(tz -> {
			LocalTime time = LocalTime.now(ZoneId.of(tz));
			System.out.println("zone name containing " + tz + " - " + time.format(hm));
		});
		
		
	}
}
