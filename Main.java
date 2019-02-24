import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

	static Road rd1 = new Road("El Camino", 2, "Los Altos", "hospital", 5);
	static Road rd2 = new Road("Middlefield", 2, "Palo Alto", "school", 15);
	static Road rd3 = new Road("Rinconada Court", 2, "Los Altos", "home", 0);

	//static Road rd61 = new Road(); // default constructor provided by java when we don't create one

public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in); 
	
	while (true)
	{
	
	
	System.out.println("where would you like to go?");
		String Landmark = sc.next();
		if ( Landmark.equals("exit"))
			System.exit(0);

		Road rd = getRoad (Landmark);
		rd.calculateDestinationTime();
		long time = rd.getdestinationTime( );
		
		Date date = new Date(Long.parseLong(Long.toString(time) ));
        DateFormat format = new SimpleDateFormat("hh:mm:ss aa");
        String formatted = format.format(date);
        
		System.out.println( "use road: " + rd.getName() + ". You will arrive at " + formatted + "." );
		
	}

}

public static Road getRoad( String location) {

	//hospital
	if ( rd1.getLandmark().equals(location)){
		return rd1;
	}
	//school
	else if ( rd2.getLandmark().equals(location)){
		return rd2;
	}
	//home
	else if ( rd3.getLandmark().equals(location)){
		return rd3;
	}
	else{
		return null; 
	}
}

}
