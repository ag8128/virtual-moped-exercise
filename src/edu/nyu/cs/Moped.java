package edu.nyu.cs;



import java.util.Arrays;

import java.util.Random;





/**

 * A virtual moped, roaming the streets of New York.

 * The signatures of a few methods are given and must be completed and used as indicated.

 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.

 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.

 * The rest is up to you.

 */

public class Moped {

	

	// Create Constructor

	public Moped() {}

	

	// Create second constructor for Drunk Driver

	public Moped(String dir, int stre, int aven) {

		this.orient = dir;

		this.st = stre;

		this.ave = aven;

		this.gas = 1000000;

	}



    /**

     * Sets the orientation of the moped to a particular cardinal direction.

     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".

     */

    public void setOrientation(String orientation) {

    	this.orient = orientation;



    }



    /**

     * Returns the current orientation of the moped, as a lowercase String.

     * E.g. "north", "south", "east", or "west".

     * @return The current orientation of the moped, as a lowercase String.

     */

    public String getOrientation() {

        return this.orient;      

    }



    /**

     * Prints the current location, by default exactly following the format:

     *      Now at 12th St. and 5th Ave, facing South.

     *

     * If the current location is associated with location-based advertising, this method should print exactly following format:

     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?

     * 

     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.

     */

    public void printLocation() {

    	int[] location = getLocation();

    	int street = location[0];

    	int avenue = location[1];

    	String streetSuffix = "";

    	String avenueSuffix = "";

    	String ad = "";

    	

    	switch (street) {

		case 1:

			streetSuffix = "st";

		case 2:

			streetSuffix = "nd";

		case 3:

			streetSuffix=  "rd";

		default:

			streetSuffix = "th";

    	}

    	

    	switch (avenue) {

		case 1:

			avenueSuffix = "st";

		case 2:

			avenueSuffix = "nd";

		case 3:

			avenueSuffix = "rd";

		default:

			avenueSuffix = "th";	

		}

    	

    	if (street == 79 && avenue == 8) {

    		ad = "Did you know that the American Museum of Natural History is in this area?";

    	} else if (street ==74 && ave ==1) {

    		ad = "You have reached one of the finest hospitals - Memorial Sloan Kettering.";

    	} else if (street == 56 && ave == 3) {

    		ad = "Did you know about the fried plantains at Tina's Cuban Cuisine restaurant?";

    	} else if (street == 12 && ave == 4) {

    		ad = "Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?";

    	}

    	

    	System.out.println("Now at "+ street + streetSuffix +  " St. and " + avenue + avenueSuffix + " Ave., " + "facing " + this.orient + ". " + ad);

    	



    }



    /**

     * Handles the command, `go left`.

     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.

     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.

     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.

     * This method must not print anything.

     */

    public void goLeft() {

    	

    	if(isGasEmpty()) {

    		System.out.println("We have run out of gas.  Bye bye!");

    		return;

    	}

    	    	

    	switch (this.orient) {

		case "north":

			this.setAvenue(ave+1);

			this.setDirection("west");

			this.reduceGasLevel();

			break;

		case "south":

			this.setAvenue(ave-1);

			this.setDirection("east");

			this.reduceGasLevel();

			break;

		case "east":

			this.setStreet(st+1);

			this.setDirection("north");

			this.reduceGasLevel();

			break;

		case "west":

			this.setStreet(st-1);

			this.setDirection("south");

			this.reduceGasLevel();

			break;

		}



    }



    /**

     * Handles the command, `go right`.

     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.

     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.

     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.

     * This method must not print anything.

     */

    public void goRight() {

    	

    	if(isGasEmpty()) {

    		System.out.println("We have run out of gas.  Bye bye!");

    		return;

    	}

    	

    	switch (this.orient) {

		case "south":

			this.setAvenue(ave+1);

			this.setDirection("west");

			this.reduceGasLevel();

			break;

		case "north":

			this.setAvenue(ave-1);

			this.setDirection("east");

			this.reduceGasLevel();

			break;

		case "west":

			this.setStreet(st+1);

			this.setDirection("north");

			this.reduceGasLevel();

			break;

		case "east":

			this.setStreet(st-1);

			this.setDirection("south");

			this.reduceGasLevel();

			break;

		}



    }



    /**

     * Handles the command,`straight on`.

     * Moves the moped one block straight ahead.

     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.

     * This method must not print anything.

     */

    public void goStraight() {

    	

    	if(isGasEmpty()) {

    		System.out.println("We have run out of gas.  Bye bye!");

    		return;

    	}

    	

    	switch (this.orient) {

		case "south":

			this.setStreet(st-1);

			this.setDirection("south");

			this.reduceGasLevel();

			break;

		case "north":

			this.setStreet(st+1);

			this.setDirection("north");

			this.reduceGasLevel();

			break;

		case "west":

			this.setAvenue(ave+1);

			this.setDirection("west");

			this.reduceGasLevel();

			break;

		case "east":

			this.setAvenue(ave-1);

			this.setDirection("east");

			this.reduceGasLevel();

			break;

		}



    }



    /**

     * Handles the command,`back up`.

     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.

     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.

     * This method must not print anything.

     */

    public void goBackwards() {

    	

    	if(isGasEmpty()) {

    		System.out.println("We have run out of gas. Bye bye!");

    		return;

    	}

    	

    	switch (this.orient) {

		case "south":

			this.setStreet(st+1);

			this.reduceGasLevel();

			break;

		case "north":

			this.setStreet(st-1);

			this.reduceGasLevel();

			break;

		case "west":

			this.setAvenue(ave-1);

			this.reduceGasLevel();

			break;

		case "east":

			this.setAvenue(ave+1);

			this.reduceGasLevel();

			break;

		}



    }



    /**

     * Handles the command,`how we doin'?`.

     * This method must not print anything.

     * @return The current gas level, as an integer from 0 to 100.

     */

    public int getGasLevel() {

        return this.gas;

    }

    

    public boolean isGasEmpty() {

    	

    	if (this.gas == 0) return true;

    	return false;

    }



    /**

     * Prints the current gas level, by default exactly following the format:

     *      The gas tank is currently 85% full.

     *

     * If the moped is out of gas, this method should print exactly following format:

     *      We have run out of gas.  Bye bye!

     */

    public void printGasLevel() {

    	

    	//System.out.println(" Insie =de printGasLevel Value of Gas = " + gas);

    	//float percent = (gas/100)*100;

    	if (gas == 0) {

    		System.out.println("We have run out of gas.  Bye bye!");

    	} else {

    		System.out.println("The gas tank is currently " + gas +"% " + "full");

    	}



    }



    /**

     * Handles the command, `fill it up`.

     * This method must not print anything.

     * Fills the gas level to the maximum.

     */

    public void fillGas() {

    	this.gas = 100;



    }

    

    /**

     * Handles the command, `reduceGasLevel`.

     * This method must not print anything.

     * Reduces gas level by 1/20th.

     */

    public void reduceGasLevel() {

    	gas = gas -5;;



    }



    /**

     * Handles the command, `park`.

     * This causes the program to quit.  

     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 

     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).

     */

    public void park() {

    	this.isPark = true;

    	System.out.println("We have parked");

    	System.exit(0);



    }



    /**

     * Handles the command, `go to Xi'an Famous Foods`

     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.

     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.

     */

    public void goToXianFamousFoods() {

    	

    	while ((this.getStreet()!=15 || this.getAvenue()!=8)&& !this.isGasEmpty()) {

    		

			

			if (this.getAvenue()>8) {

				this.setAvenue(ave-1);

				this.setDirection("east");

				this.reduceGasLevel();

				this.printLocation();

				if (this.isGasEmpty())fillGas();



			}

			else if (this.getAvenue()<8) {

				this.setAvenue(ave+1);

				this.setDirection("west");

				this.reduceGasLevel();

				this.printLocation();

				if (this.isGasEmpty())fillGas();





			} else if(this.getStreet()>15) {

				this.setStreet(st-1);

				this.setDirection("south");

				this.reduceGasLevel();

				this.printLocation();

				if (this.isGasEmpty())fillGas();





			}

			else if (this.getStreet()<15) {

				this.setStreet(st+1);

				this.setDirection("north");

				this.reduceGasLevel();

				this.printLocation();

				if (this.isGasEmpty())fillGas();





			}

			

		}

		System.out.println("We have reached Xi'an Famous Foods.  Enjoy your noodles.");





    }



    /**

     * Generates a string, containing a list of all the user commands that the program understands.

     * @return String containing commands that the user can type to control the moped.

     */

    public String getHelp() {

    	

    	String helpStr = "go left: moped should go left\n"

				+ "go right: moped should go right\n"

				+ "straight on: moped should go straight\n"

				+ "back up: moped should go back\n"

				+ "how we doin'?: Moped should return remaining gas left\n"

				+ "fill it up: moped's gas tank should be full at 100\n"

				+ "park: Park moped and quit session\n"

				+ "go to Xi'an Famous Foods: autodrive to Xi'an Famous Foods\n"

				+ "help: display commands\n";

    	return helpStr;

    	

    }



    /**

     * Sets the current location of the moped.

     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.

     */

    public void setLocation(int[] location) {

    	this.st = location[0];

    	this.ave = location[1];



    }



    /**

     * Gets the current Avenue of the moped.

     * @return The current location of the moped, as an int array in the order {street, avenue}.

     */

    public int[] getLocation() {

    	

        int[] location = {0, 0}; // an example array at 3rd st and 4th Ave.... placeholder only... delete this!

        location[0] = this.st;

        location[1] = this.ave;

        return location;

    }

    

    /**

     * Sets the current Avenue of the moped.

     * @param an integer

     */

    public void setAvenue(int myAve) {

    	if ( myAve>=1 && myAve<=10) {

			this.ave = myAve;

		}

		else {

			System.out.println("You are going off track outside the 200 x 10 grid");

		}



    }



    /**

     * Gets the current Avenue of the moped.

     * @return The current Avenue of the moped, as an int

     */

    public int getAvenue() {

        return this.ave;

    }

    

    /**

     * Sets the current Street of the moped.

     * @param an integer

     */

    public void setStreet(int mySt) {

    	if ( mySt>=1 && mySt<=200) {

			this.st = mySt;

		}

		else {

			System.out.println("You are going off track outside the 200 x 10 grid");

		}



    }



    /**

     * Gets the current Street of the moped.

     * @return The current Street of the moped, as an int

     */

    public int getStreet() {

        return this.st;

    }

    

    /**

     * Sets the current Street of the moped.

     * @param an integer

     */

    public void setDirection(String myDirection) {

			this.orient = myDirection;



    }



    /**

     * Gets the current Street of the moped.

     * @return The current Street of the moped, as an int

     */

    public String getDirection() {

        return this.orient;

    }

    

    // Setter and Getter for park

    public void setPark(boolean myPark) {

    	this.isPark = myPark;

    }

    

    public boolean getPark() {

    	return this.isPark;

    }

    

    /**

     * Handles the command,`drunkDriver`.

     * Drunk Drivers 1 and 2 start riding through the streets

     * This method must not print anything.

     */

    public void drunkDriver() {

    	Random rand1 = new Random();

    	Random rand2 = new Random();

    	int direct = rand1.nextInt(4);// South = 0, North = 1, East = 2, West = 3

    	int way = rand2.nextInt(4); // 0 = straight, 1 = backup, 2 = left, 3 = right

    	

    	switch (way) {

    	case 0:

    		if (direct == 0)this.setDirection("south");

    		if (direct == 1)this.setDirection("north");

    		if (direct == 2)this.setDirection("east");

    		if (direct == 3)this.setDirection("west");

    		this.goStraight();

    		break;

    	case 1:

    		if (direct == 0)this.setDirection("south");

    		if (direct == 1)this.setDirection("north");

    		if (direct == 2)this.setDirection("east");

    		if (direct == 3)this.setDirection("west");

    		this.goBackwards();

    		break;

    	case 2:

    		if (direct == 0)this.setDirection("south");

    		if (direct == 1)this.setDirection("north");

    		if (direct == 2)this.setDirection("east");

    		if (direct == 3)this.setDirection("west");

    		this.goLeft();

    		break;

    	case 3:

    		if (direct == 0)this.setDirection("south");

    		if (direct == 1)this.setDirection("north");

    		if (direct == 2)this.setDirection("east");

    		if (direct == 3)this.setDirection("west");

    		this.goRight();

    		break;

    			

    	}

    		

    	

    }

    

    // Declare all private class specific variables here

    private int ave = 5; // Default starting point

    private int st = 10; // Default starting point

    private int gas = 100; // 1 Gallon of Gas. Every step reduces gas by 5

    private boolean isPark = false; // Moped is current running when instantiated

    private String orient = "south"; // Default, facing south





}
