
public class animals_challenges {

	public static void main(String[] args) {
		// method 1:
				String[] animals = new String[5];
				animals[0] = "dog";
				animals[1] = "cat";
				animals[2] = "horse";
				animals[3] = "elephant";
				animals[4] = "lion";
		// method 2:
				String[] animals1 =   {"dog", "cat", "horse", "elephant", "lion"};
		//System.out.println(animals[2]);

				/*for(int i = 0; i<animals.length; i++) {
					System.out.println(animals[i]);
						}*/
				
				int[] numbers = new int[100];
				for(int i=0; i<100; i++){
					numbers[i] = i+100;
					i = i+100;
				}
				
				for(int j=0; j<100; j++){
					System.out.println("numbers[" +j+ "] =" +numbers[j]);
					
				}
				
				String[] words = new String[20];
				for(int w = 0; w<20; w++){
					System.out.println("words[" +w+ "] =" + " this is a string");
				}
			

	}

}
