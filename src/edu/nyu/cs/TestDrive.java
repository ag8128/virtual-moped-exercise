package edu.nyu.cs;



import java.util.Scanner;



public class TestDrive {



  /**

   * The main function is automatically called first in a Java program.

   * It should instantiate a Moped and contain the main logic of the program, following the instructions.

   * 

   * @param args An array of any command-line arguments.

   */

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);

    Moped m = new Moped();

    Moped m1 = new Moped("north", 10, 8);

    Moped m2 = new Moped("south", 15, 5);



    // solution

    System.out.println("Thanks for jumping on the moped.  We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave, facing South.  May I say your teeth look very clean.");

    System.out.println("What would you like to do?  At any time, say \"help\" for assistance.");



  

    String response = "";

    while (!response.equals("park")) {

      response = scn.nextLine();

        switch (response) {

            case "go left":

                m.goLeft();

                m.printLocation();

                break;

            case "go right":

                m.goRight();

                m.printLocation();

                break;

            case "straight on":

                m.goStraight();

                m.printLocation();

                break;

            case "back up":

                m.goBackwards();

                m.printLocation();

                break;

            case "fill it up":

                m.fillGas();

                break;

            case "how we doin'?":

                m.printGasLevel();

                break;

            case "park":

                m.park();

                break;

            case "go to Xi'an Famous Foods":

            	m.goToXianFamousFoods();

            	break;   	

            case "help":

                System.out.println(m.getHelp());

                break;

            case "drunk":

            	boolean crash = false;

            	int [] manual = m.getLocation();

            	int [] d1 = m1.getLocation();

            	int [] d2 = m2. getLocation();

            	while (!crash) {

            		m1.drunkDriver();

            		m2.drunkDriver();

            		if ((manual[0]== d1[0] && manual[1] == d1[1]) ||

                    		(manual[0] == d2[0] && manual[1] == d2[1])){

                    		// Crash condition with manual moped

                    		crash = true;

                    		System.exit(0);

                    		

                    	}

            	}

            	

            	break;

            default:

                System.out.println("I'm sorry, I don't understand that command. Type 'help' for a list of commands");

        }      

    }

  }



}