package Home;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Gettingdate {

	public static void main(String[] args) {
		
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("HH");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println(date1);
		

	}

}
