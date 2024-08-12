package Practice;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initializing instances of Random and Scanner
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		//Assigning random number to a int Variable
		int number = random.nextInt(100)+1;
		
		//Assigning a bool for the while loop condition
		boolean userChoice = false;
		
		System.out.println("This is a number guessing game. Guess a number from 1 to 100.");
		
		//If !userChoice = true, which will allow this while loop to run until it's false by userChoice becoming true
		while(!userChoice) {
			System.out.print("Your guess: ");
			//Try/Catch to see if a user enters in a int value or not. If they don't it'll give them a message saying they didn't and the loop will re-loop
			try {
				//Getting user input
				int num = scan.nextInt();
				if(num == number) {
					boolean userContinue = false;
					System.out.println("Congrats you guessed the number which was: "+ number);
					System.out.print("Would you like to continue? *Enter Yes or No*: ");
					String answer = scan.next();
					while (!userContinue) {
						if (answer.equalsIgnoreCase("yes")) {
							number = random.nextInt(100)+1;
							System.out.println("\nThanks for playing again! Please choose a number from 1 to 100:");
							userContinue = true;
						}
						else if(answer.equalsIgnoreCase("no")) {
							System.out.println("Alrighty then! Thanks for playing! Goodbye    :)");
							userChoice = true;
							userContinue = true;
						}
						else{
							System.out.print("You didn't enter in yes or no. Please enter in yes or no: ");
							answer = scan.next();
							System.out.println();
						}
					}
					
				}
				else if (num < number) {
					System.out.println("The number you chose is smaller then the number i'm looking for");
				}
				else {
					System.out.println("The number you chose is bigger then the number i'm looking for");
				}
			}
			catch (InputMismatchException e) {
				String bad_input = scan.next();
				System.out.println("Thats not a number. Please try again with a number: ");
				continue;
			}
		}
		
		
		scan.close();
		

	}

}
