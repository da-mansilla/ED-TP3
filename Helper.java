import java.util.Scanner;
import java.util.Random;

public class Helper{
    private static Scanner scanner = new Scanner(System.in);
   public Helper(){
   }
   public static int generateRandomNumber(int number) {
      Random rdm = new Random();
      int numberGenerated = rdm.nextInt(number)+1;
      return numberGenerated;
   }   
   public static int generateRandomNumber(int min, int max) {
      Random rdm = new Random();
      int numberGenerated = (rdm.nextInt(max-min)+1)+min;
      return numberGenerated;
   }   
   public static char generateRandomCharacter(){
      Random rdm = new Random();
      char c = (char)(Helper.generateRandomNumber(97,122));
      return c;
   }

	public static int selectOption(int min, int max) {
	    while (true) {
        	
	        try { 	
        		int number;
	        	do {
	        		number = scanner.nextInt();
	        	}while(!(number >= min) || !(number <= max));
	        	return number;	
	        }	  	
	        catch (Exception e) {
	        	System.out.println("Entrada no valida");
	            scanner.nextLine();
	        }
	    }
	}
	public static int inputNumber() {
	    while (true) {   	
	        try { 	
        		int number = scanner.nextInt();
	        	return number;	
	        }	  	
	        catch (Exception e) {
	        	System.out.println("Entrada no valida");
	            scanner.nextLine();
	        }
	    }
	}
	public static int inputPositiveNumber() {
	    while (true) {   	
	        try { 	
            int number;
            do{
                number = scanner.nextInt();
            }while(number < 0);
            return number;	
	        }	  	
	        catch (Exception e) {
	        	System.out.println("Entrada no valida");
	            scanner.nextLine();
	        }
	    }
	}
	public static double inputDouble() {
	    while (true) {   	
	        try { 	
	        	double number = scanner.nextDouble();
	        	return number;	
	        }	  	
	        catch (Exception e) {
	        	System.out.println("Entrada no valida");
	            scanner.nextLine();
	        }
	    }
	}
	public static String inputString() {
	    while (true) {   	
	        try { 	
        		String string= scanner.next();
	        	return string;	
	        }	  	
	        catch (Exception e) {
	        	System.out.println("Entrada no valida");
	            scanner.nextLine();
	        }
	    }
    }
	public static char inputChar() {
	    while (true) {   	
	        try { 	
        		char character= scanner.next().charAt(0);
	        	return character;	
	        }	  	
	        catch (Exception e) {
	        	System.out.println("Entrada no valida");
	            scanner.nextLine();
	        }
	    }
    }
	


}
