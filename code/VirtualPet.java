// Kailey Bergeron 
// October 16th, 2021
// Virtual Pet

// import class scanner
import java.util.Scanner;
// class VirtualPet begins 
public class VirtualPet{
	// initialize variable string outside of while loop to use in other methods. 
	static String name;
	// main method begins
	public static void main(String[] args){
		// create Scanner for user input
		Scanner input = new Scanner(System.in);
		// Declare variabeles for pet attributes.
		int currentHunger = 0;
		int currentDirtiness = 0;
		int currentBoredom = 0;
		int hungerRate = 100;
		int dirtinessRate = 100;
		int boredomRate = 100;
		int runAway = 0;
		boolean atHome = true;
		int age = 0;

		// Create a pet to give the player
		// prompt user to enter name of pet
		System.out.println("While walking in the woods, you hear a cry, as you walk over you see a puppy. The puppy needs your help.");
		System.out.println("First you need to give the puppy a name. What would you like to name the puppy?");
		// user input gets stored in variable name.
		name = input.nextLine();

		// begin while loop, loop will continue as long as true
		while (atHome == true){
			System.out.println("----------------------------------");
			// Let the player decide how to interact with the pet.
			System.out.println("What would you like to do?");
			System.out.printf("1) Feed%n2) Clean%n3) Play%n");
			
			int option = input.nextInt();
		
			System.out.println("----------CURRENT STATS----------");
			// let the user know how the puppy is doing.
			// take information from the methods :
			BoredomDescription(boredomRate);
			DirtinessDescription(dirtinessRate);
			HungerDescription(hungerRate);

			// introduce trade-offs -- if one action is done another one will be affected.
			if (option == 1){
				System.out.println("You feed " + name + " but it makes a mess.");
				// value of hungerRate increases, while dirtinessRate and boredomRate decreases
				hungerRate += 5;
				dirtinessRate -= 10;
				boredomRate -= 10;
			}

			if (option == 2){
				System.out.println(name + " is all clean and wants to play now.");
				// value of dirtinessRate increases, while boredomRate and hungerRate decreases.
				boredomRate -= 10;
				dirtinessRate += 5;
				hungerRate -= 10;
			}

			if (option == 3){
				System.out.println("All that playing made " + name + " hungry and stinky.");
				// value of boredomRate increases, while hungerRate and dirtinessRate decreases.
				boredomRate += 5;
				hungerRate -= 10;
				dirtinessRate -= 10;
			}

			// Increase the age of the pet, making it more difficult to manage.
			age += 1;
			//  if age is divisible by 3, the puppy will need to be fed more often.
			if (age % 3 == 0){
				hungerRate -= 2;
				System.out.println("----------BIRTHDAY UPDATE----------");
				System.out.println(name + " is now " + age + " days old");
				System.out.println(name + " will get hungrier faster!.");
			}
			// if the age is divisible by 7, the puppy will need to be washed more often.
			if (age % 7 == 0){
				dirtinessRate -= 2;
				System.out.println("----------BIRTHDAY UPDATE----------");
				System.out.println(name + " is now " + age + " days old");
				System.out.println(name + " will get dirtier faster.");
			}
			// if the age is divisible by 11, the puppy will need to play more.
			if (age % 11 == 0){
				boredomRate -= 2;
				System.out.println("----------BIRTHDAY UPDATE----------");
				System.out.println(name + " is now " + age + " days old");
				System.out.println(name + " is going to need more attention.");
			}
			
			// check to see if the pet has ran away
			// if the hungerRate is below 15 the puppy will run away
			if (hungerRate <= 15){
				System.out.println(name + " has ran away due to starvation.");
				// set equal to false to end loop 
				atHome = false;
			}
			// if the boredomRate is below 15 the puppy will run away
			if (boredomRate <= 15){
				System.out.println(name + " has ran away due to a lack of attention.");
				atHome = false;
			}
			// if the dirtenessRate is below 15 the puppy will run away
			if (dirtinessRate <= 15){
				System.out.println(name + " has ran away due to poor hygiene.");
				atHome = false;
			}
			// let the player know how they did
			// the more days that they kept the pet the better.
			System.out.println("You survided " + age + " days");

			if (age <= 10 ){
				System.out.println("You should not get another pet.");
			}
			else if (age <= 20 && age > 10){
				System.out.println("You need more training before becoming a pet owner.");
			}
			else if (age <= 30 && age > 20){
				System.out.println("You are a good pet owner!");
			}
		} // end of while loop.

	} // end main method

	// create methods to display how the puppy is doing
	// use void because there will not be any information returned
	public static void HungerDescription(int hungerRate){
		if (hungerRate >= 70){
			System.out.println("Hunger rate: " + name + " is satified");
		}
		else if (hungerRate >= 55){
			System.out.println("Hunger rate: " + name + " could eat more.");
		}
		else if (hungerRate >= 30){
			System.out.println("Hunger rate: " + name + " needs to eat !!!");
		}
	} // end of method HungerDescription
	public static void BoredomDescription(int boredomRate){
		if (boredomRate >= 70){
			System.out.println("Boredom rate: " + name + " is satified");
		}
		else if (boredomRate >= 55){
			System.out.println("Boredom rate: " + name + " wants to play more.");
		}
		else if (boredomRate >= 30){
			System.out.println("Boredom rate: " + name + " needs attention ASAP !!!");
		}
	}
	public static void DirtinessDescription(int dirtinessRate){
		if (dirtinessRate >=70){
			System.out.println("Dirtiness rate: " + name + " is clean!");
		}
		else if (dirtinessRate >= 55){
			System.out.println("Dirtiness rate: " + name + " is not too dirty");
		}
		else if (dirtinessRate >= 30){
			System.out.println("Dirtiness rate: " + name + " super dirty MUST CLEAN!!!");
		}
	}


} // end of class
