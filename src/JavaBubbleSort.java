//JavaBubbleSort, Version 4.0 by Sarib Kashif, April 06, 2018.
import java.util.*; //This imports all the utilities including scanner for usage in this program.
public class JavaBubbleSort {

	static Scanner myScanner = new Scanner(System.in); 

	static int ask(String prompt, int returnType) { //This is the ask function for a double. It has a string which contains a message and has a double variable which is given a value each time the function is called.
		System.out.println(prompt); //This line says the message being given
		int value = returnType; //Creates a double called value and gives it the value of the returnType.
		while (value == returnType) { //A While statement which allows the code within it to be run multiple times until the 'value' variable is given a new number
			try {  //Try and Catch Statement

				value = myScanner.nextInt(); //Try to obtain a double from the user
				if(value<=0) {
					System.out.println("No negative numbers or zeroes, try again."); //Does not allow user to give negative values.
					value = returnType; //Makes value the same as returnType variable
				} //end of if
				else if(value>100000) { //If the value is too high, the program will stop the user and ask to input a different value.
					System.out.println("That value is too high, try again.");
					value = returnType;
				}//end of else if
			} //end of try
			catch(Exception e){ //Catch all exceptions
				System.out.println("That input was invalid! Try putting a number like 4"); //Say this message if there is an error
				myScanner.next(); //Clears the error
			}// end of catch
		}//end of while
		return value; //Return the value that the user gives

	} //end of ask function

	public static long startTime; //Creates a long 

	public static long timeDuration; //Creates a long

	public static void startTimer(){ //Function for starting the time
		startTime = System.currentTimeMillis(); 
	}

	public static long getTimeElapsed(){ //This function gets the time it took 
		timeDuration = System.currentTimeMillis() - startTime; //Subtract the current time from the time when it started to get the real time it took
		return timeDuration; //Give the value back.
	}

	public static void makeRandomValues(int[] _values, int min, int max) { //This function is for making random values. The min and max values that were chosen in a different function are sent here.
		for (int i = 0; i < _values.length; i++) { 
			_values[i] = (int)(Math.random()*(max+1-min))+min; //Makes the values that are randomly generated to range from the minimum value to the maximum value.
		} //End of for statement		
	} //End of makeRandomValues() function

	public static void bubbleSortMethod(int[] _val, int numberVal) { //This function is for actually sorting the values
		startTimer(); //starts the timer
		int temp = 0; //temporary variable
		boolean sorted = false; //Makes a boolean stating that the values have not been sorted
		while(!sorted) { //While loop which will play as long as the values are not sorted
			sorted = true;
			for (int i = 0; i < _val.length - 1; i++) { //for loop
				if(_val[i]>_val[i+1]) {//compare a value on the left to the value on the right side
					//swap them
					temp = _val[i]; //Puts the value in the temporary variable
					_val[i] = _val[i+1]; //Switches the two values
					_val[i+1] = temp; //Puts the second value in the temp variable
					sorted = false; //Makes sorted false
				}			//end of if
			} //end of for
		} //end of while
		System.out.println("It took " + getTimeElapsed() + " milliseconds to sort " + numberVal + " values."); //Displays the time it took and the number of values that were used
		System.out.println(" ");
	} //end of bubbleSortMethod() function

	public static void main(String[] args) { //Main function
		int min = ask("Choose your minimum value", -99); //Asks for the minimum values
		int max = ask("Choose your maximum value", -99); //Asks for the maximum values
		for(int a = ask("How many random values would you like to generate?", -99); a <=10000000; a = a*10) { //For loop that asks for the number of values and each time, it multiplies by 10.
			int numValues = a; //Assigns variable a to numValues
			int [] values = new int[numValues]; //Makes an array for the values and puts the number of values inside
			makeRandomValues(values, min, max); //Starts the makeRandomValues and sends the value array, minimum value, and maximum value
			bubbleSortMethod(values, numValues); //Starts the bubbleSortMethod and sends the values array and the value for the numValues int
		} //End of for loop
	} //End of main function
}
