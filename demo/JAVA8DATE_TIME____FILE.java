
public class JAVA8DATE_TIME____FILE {

	public static void main(String[] args) throws IOException {

		//		Not thread safe : Unlike old java.util.Date which is not thread safe the new date-time API is immutable and doesn’t have setter methods.
		//		Less operations : In old API there are only few date operations but the new API provides us with many date operations.


		//		Java 8 under the package java.time introduced a new date-time API, most important classes among them are :  
		//
		//		Local : Simplified date-time API with no complexity of timezone handling.
		//		Zoned : Specialized date-time API to deal with various timezones.

		//		    Period and Duration classes : 
		//			Period   : It deals with date based amount of time. 
		//			Duration : It deals with time based amount of time.

		// the current date
		LocalDate date = LocalDate.now();
		System.out.println("the current date is "+date);


		// the current time
		LocalTime time = LocalTime.now();
		System.out.println("the current time is "+time);


		// will give us the current time and date
		LocalDateTime current = LocalDateTime.now();
		System.out.println("current date and time : "+
				current);


		// printing months days and seconds
		Month month = current.getMonth();
		int day = current.getDayOfMonth();
		int seconds = current.getSecond();
		System.out.println("Month : "+month+" day : "+
				day+" seconds : "+seconds);

		// to get the current zone
		ZonedDateTime currentZone = ZonedDateTime.now();
		ZoneId tokyo = ZoneId.of("Asia/Tokyo");

		LocalTime time1 = LocalTime.now();
		System.out.println("the current time is " + time1);

		

		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 12);
		
		Period gap = Period.between(date2, date1);
		
		
		Duration fiveHours = Duration.ofHours(5);

		// adding five hours to the current
		// time and storing it in time2
		LocalTime time2 = time1.plus(fiveHours);

		Duration gap = Duration.between(time2, time1);

		************************************************************************************************************************************
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		***************************************************************************************************************************************



		////  BEFORE  JAVA 8  FILE  HANDLING

		String fileLocation = "/Users/workspace/CoreJava/src/main/java/com/javaprogramto/files/read/student.csv";

		FileReader fileReader = new FileReader(fileLocation);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String csvLine;
		int index = 1;
		String header = bufferedReader.readLine();

		System.out.println("CSV header : "+header);
		while ((csvLine = bufferedReader.readLine()) != null) {
			System.out.println("csv line " + index + " : " + csvLine);
			index++;
		}


		//////  AFTER  JAVA 8  FILE  HANDLING

		Path filePath = Path.of(
				"/Users/workspace/CoreJava/src/main/java/com/javaprogramto/files/read/student.csv");

		Stream<String> stream = null;
		try {
			stream = Files.lines(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		stream.forEach(System.out::println);
	}
}
