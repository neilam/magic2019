
public class Road {
	int lane;
	private String city;
	private String name;
	private String Landmark;
	int minutes; 
	public long destinationTime; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Road ( String nme, int ln, String cy, String Landmark, int minutes){
		this.name = nme;
		this.lane= ln;
		this.city = cy;
		this.Landmark = Landmark;
		this.minutes = minutes;
		
	}
	
	public void driveVehicle(Vehicle vh) {
		
	  // System.out.println( driver.name + " is driving the " + vh.brand + " to " + rd.city);
       	
	}
	public void calculateDestinationTime() {
		long ms = (int)(this.minutes*60000);
		this.destinationTime =  System.currentTimeMillis() + ms;
	}
	
	public String getName( ) {
		return name;
	}
	
	public String getCity( ) {
		return city;
	}
	
	public String getLandmark( ){
		return Landmark; 
	}
	
	public int getminutes( ){
		return minutes;
	}
	
	public long getdestinationTime( ){
		return destinationTime; 
	}
	
	

}
