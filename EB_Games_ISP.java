// The "EB_Games_ISP" class.
//Peter Paul Nkonge Kungania.
//ISP-Project.
//ICS4U-S1
//27 April 2015

import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EB_Games_ISP
{
    public static void main (String[] args) throws IOException
    {

	_Main ();

	JOptionPane.showMessageDialog (null, "*********************************"
		+ "\n Thank You for Being With Us"
		+ "\n  We Hope to See You Again"
		+ "\n*********************************");


    }


    public static void _Main () throws IOException
    {
	int s = Welcome (); //Opens the first class that welcomes the user
	Status (s); //Takes the Status value to Status()
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This method displays the Welcome Method and
     returns the status value*/
    public static int Welcome ()
    {
	int status = 0; //Shows whether the user is customer or employee
	int num = 0; //Starts the while loop

	//First Message to User
	JOptionPane.showMessageDialog (null, "****************************" +
		"\n  Welcome to EB Games" +
		"\n****************************");

	//User states whether they are employee or customer
	while (num == 0)
	{
	    String name = JOptionPane.showInputDialog (null, "Please enter the number that best describes you."
		    + "\n1. I am a Customer"
		    + "\n2. I am an Employee"
		    + "\n3. I want to see Promotions"
		    + "\n4. I want to End Session");
	    status = Integer.parseInt (name);

	    //User Verification
	    while (status != 1 && status != 2 && status != 3 && status != 4)
	    {
		name = JOptionPane.showInputDialog (null, "Please enter EITHER the number 1 or 2 to select."
			+ "\n1. I am a Customer"
			+ "\n2. I am an Employee"
			+ "\n3. I want to see Promotions"
			+ "\n4. I want to End Session");
		status = Integer.parseInt (name);
	    }

	    name = JOptionPane.showInputDialog (null, "Are you sure"
		    + "\n1. Yes"
		    + "\n0. No");
	    num = Integer.parseInt (name);
	    //Verifies the input in "Are You Sure"
	    while (num != 1 && num != 0)
	    {
		name = JOptionPane.showInputDialog (null, "Are you sure"
			+ "\n1. Yes"
			+ "\n0. No");
		num = Integer.parseInt (name);
	    }
	}
	return status; //Returns the value that states whether the user is an employee or a customer
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This method runs either the Method Customer()
    or Employee() depending on the value of Status*/
    public static void Status (int s) throws IOException
    {
	if (s == 1)
	{
	    Customer ();
	}
	else if (s == 2)
	{
	    Employee ();
	}
	else if (s == 3)
	{
	    Promotions ();
	}
	else if (s == 4)
	{
	}
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This method displays the promotions to the Customer or Employee*/
    public static void Promotions () throws IOException
    {
	JOptionPane.showMessageDialog (null, "All employees get a 30% discount on games"
		+ "\nBuy 3 or More games to get 10% off your next purchase");
	_Main ();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This runs the Customer method
    This gives the customer the choice to either
    Buy, Sell or Search for a Game*/
    public static void Customer () throws IOException
    {
	String num = JOptionPane.showInputDialog (null, "What would you like to do with us today."
		+ "\n1. Buy Games"
		+ "\n2. Sell Game"
		+ "\n3. See Available Games"
		+ "\n0. Go Back");
	int option = Integer.parseInt (num);

	//User Validation
	while (option != 1 && option != 2 && option != 3 && option != 0)
	{
	    num = JOptionPane.showInputDialog (null, "Please select ONE of the values below."
		    + "\n1. Buy Games"
		    + "\n2. Sell Game"
		    + "\n3. See Available Games"
		    + "\n0. Go Back");
	    option = Integer.parseInt (num);
	}

	//What each value does
	if (option == 0)
	{
	    _Main (); //Goes back to the beginning
	}
	else if (option == 1)
	{
	    buy_Games (); //Opens the buy_Games method
	}
	else if (option == 2)
	{
	    sell_Games (); //Opens the sell_Games method
	}
	else if (option == 3)
	{
	    search_Games (); //Opens the Search Game Method
	}

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This runs the Employee method.
    This gives the employee the choice to either
    Buy, Add or Search for a Game*/
    public static void Employee () throws IOException
    {
	String num = JOptionPane.showInputDialog (null, "Please select an option to continue."
		+ "\n1. Buy Games"
		+ "\n2. Add Customers Game"
		+ "\n3. See Available Games"
		+ "\n0. Go Back");
	int option = Integer.parseInt (num);

	//User Validation
	while (option != 1 && option != 2 && option != 3 && option != 0)
	{
	    num = JOptionPane.showInputDialog (null, "Please select ONE of the values below."
		    + "\n1. Buy Games"
		    + "\n2. Add Customers Game"
		    + "\n3. See Available Games"
		    + "\n0. Go Back");
	    option = Integer.parseInt (num);
	}

	//Variable Declaration
	String code, passcode = "EBGames2K15";

	//What each value does
	if (option == 0)
	{
	    _Main (); //Goes back to the beginning
	}
	else if (option == 1)
	{
	    buy_Games (); //Opens the buy_Games method
	}
	else if (option == 2)
	{
	    code = JOptionPane.showInputDialog (null, "To Confirm Your Selection Enter the Passcode");
	    if (code.equalsIgnoreCase (passcode))
	    {
		add_Games ();      //Opens the add_Games method
	    }
	    else
	    {
		_Main ();
	    }
	}
	else if (option == 3)
	{
	    search_Games (); //Opens the Search Game Method
	}

    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This runs the buy_Games method.
    This lets the Customer or the Employee
    to buy a game*/

    public static void buy_Games () throws IOException
    {

	String filename = "all_Games.txt";

	//User Input
	String value = JOptionPane.showInputDialog (null, "Please select an option below"
		+ "\n1. All New Games"
		+ "\n2. See all Games by Genre"
		+ "\n3. See Games by console"
		+ "\n4. Used Games"
		+ "\n5. Refurbished Games"
		+ "\n0. Go Back.");
	int option = Integer.parseInt (value);

	//User Validation
	while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 0)
	{
	    value = JOptionPane.showInputDialog (null, "Please select ONE of the options below"
		    + "\n1. All New Games"
		    + "\n2. See all Games by Genre"
		    + "\n3. See Games by console"
		    + "\n4. Used Games"
		    + "\n5. Refurbished Games"
		    + "\n0. Go Back.");
	    option = Integer.parseInt (value);
	}

	//Variable declaration: Price of Game
	double price = 0;


	//What each value does
	if (option != 0)
	{

	    if (option == 1)
	    {
		filename = "all_Games.txt";  //Diplays all New games
		price = 69.99;
	    }
	    else if (option == 2)
	    {
		filename = "Games_Genre.txt";     //Displays games by genre
		price = 69.99;
	    }
	    else if (option == 3)
	    {
		filename = "Games_Console.txt";  //Displays games by console
		price = 69.99;
	    }
	    else if (option == 4)
	    {
		filename = "UsedGames.txt";  //Diplays all used games
		price = 19.99;
	    }
	    else if (option == 5)
	    {
		filename = "Refurbished.txt";  //Diplays all Refurbished games
		price = 39.99;
	    }

	    //Open the file.
	    File file = new File (filename);
	    Scanner inputFile = new Scanner (file);
	    String[] games = new String [500];   //The list of games
	    //The number array
	    int num = 0;
	    //Read the first line from the file.
	    while (inputFile.hasNext ())
	    {
		games [num] = inputFile.nextLine ();
		num++;
	    }
	    //Close the file.
	    inputFile.close ();
	    //Display the line.
	    int game = 0, val = 0;
	    String[] game_List = new String [500];
	    JOptionPane.showMessageDialog (null, "To Select a Game, Type in its Number."
		    + "\nTo Leave the Session Enter '-1'");
	    while (game != -1 && val != 40)
	    {
		String input = JOptionPane.showInputDialog (null, games);
		game = Integer.parseInt (input);
		if (game >= 0)
		    game_List [val] = games [game];
		val++;
	    }

	    //Displays What Is Being Bought
	    JOptionPane.showMessageDialog (null, "These are the Games You Have Selected");
	    JOptionPane.showMessageDialog (null, game_List);

	    //Calculating the price
	    double price_Before = 0.0;
	    Buy_Games_Class total = new Buy_Games_Class (price);
	    total.st_GameLth ((val - 1));
	    double prices = total.t_Price ();

	    String status = JOptionPane.showInputDialog (null, "a. If You're a customer enter the passcode"
		    + "\nb. If you have a coupon enter the number"
		    + "\nc. Otherwise Enter Any Key");

	    if (status.equalsIgnoreCase ("EBGames2K15"))
	    {
		price_Before = total.setEmployee (prices);
		total.employee (prices);
	    }
	    else if (status.equalsIgnoreCase ("EBrocks1997"))
	    {
		price_Before = total.setCoupon (prices);
		total.coupon (prices);
	    }
	    else if (!status.equalsIgnoreCase ("EBGames2K15") && !status.equalsIgnoreCase ("EBrocks1997"))
	    {
		price_Before = prices;
	    }



	    total.after_Tax (price_Before);
	}
	else if (option == 0)
	{
	    _Main ();
	}

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This runs the search_Games method.
    This lets the Customer or the Employee
    to search for a game*/

    public static void search_Games () throws IOException
    {
	String filename = "all_Games.txt";

	//User Input
	String value = JOptionPane.showInputDialog (null, "Please select an option below"
		+ "\n1. View all New Games"
		+ "\n2. View all Games by Genre"
		+ "\n3. View Games by console"
		+ "\n4. View Used Games"
		+ "\n5. View Refurbished Games"
		+ "\n0. Go Back.");
	int option = Integer.parseInt (value);

	//User Validation
	while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 0)
	{
	    value = JOptionPane.showInputDialog (null, "Please select ONE of the options below"
		    + "\n1. View all New Games"
		    + "\n2. View all Games by Genre"
		    + "\n3. View Games by console"
		    + "\n4. View Used Games"
		    + "\n5. View Refurbished Games"
		    + "\n0. Go Back.");
	    option = Integer.parseInt (value);
	}


	//What each value does
	if (option != 0)
	{
	    if (option == 1)
	    {
		filename = "all_Games.txt";  //Diplays all games
	    }
	    else if (option == 2)
	    {
		filename = "Games_Genre.txt";     //Displays games by genre
	    }
	    else if (option == 3)
	    {
		filename = "Games_Console.txt";  //Displays games by console
	    }
	    else if (option == 4)
	    {
		filename = "UsedGames.txt";  //Diplays all used games
	    }
	    else if (option == 5)
	    {
		filename = "Refurbished.txt";  //Diplays all NEW games
	    }

	    //Open the file.
	    File file = new File (filename);
	    Scanner inputFile = new Scanner (file);
	    String[] games = new String [500];   //The list of games
	    //The number array
	    int num = 0;
	    //Read the first line from the file.
	    while (inputFile.hasNext ())
	    {
		games [num] = inputFile.nextLine ();
		num++;
	    }
	    //Close the file.
	    inputFile.close ();

	    //Display the line.
	    JOptionPane.showMessageDialog (null, "These are the Available Games: ");
	    JOptionPane.showMessageDialog (null, games); //Displays the Type of Games Selected

	    //Gives the user the option to end the program or restart it
	    String input = JOptionPane.showInputDialog (null, "1. Return to Start"
		    + "\n0. End Session");
	    int val = Integer.parseInt (input); //Converts JOption input into an Int
	    //Input Verification
	    while (val != 0 && val != 1)
	    {
		input = JOptionPane.showInputDialog (null, "1. Return to Start"
			+ "\n0. End Session");
		val = Integer.parseInt (input);
	    }

	    if (val == 1)
	    {
		_Main (); //Return to the Start
	    }
	    else if (val == 0)
	    {
		/*Blank if-Statement that lets the Method end*/
	    }
	}
	else if (option == 0)
	{
	    _Main (); //Goes back to the beginning
	}

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This runs the sell_Games method.
    This lets the Customer
    to sell their games*/

    public static void sell_Games () throws IOException
    {
	//Variable declaration
	int value = 0;
	int sum = 0;
	int s = 0;
	String condition = "NULL";
	//Begins while loop
	while (value != 1)
	{
	    JOptionPane.showMessageDialog (null, "Dear Customers,"
		    + "\nWe do not accept damaged or stolen game."
		    + "\nWe buy New games @ $30 & Used games @ $15"
		    + "\n\t\t\tFrom Management");


	    int num = -1; //Variable Declaration
	    //Input
	    while (num < 0)
	    {
		//User Enter's number of games they want to sell
		String input = JOptionPane.showInputDialog (null, "Enter the number of games you want to sell"
			+ "\nEnter 0 to Return to Start");
		num = Integer.parseInt (input); //Converts JOption input into an Int
	    }

	    //Takes the User back to the beginning if there are no games to be sold
	    if (num == 0)
		_Main ();

	    //Declaring a new String Array
	    String[] games = new String [num]; //This holds the name of the Games

	    //User Enter's the Name of the Game as well as its Condition
	    for (int count = 0 ; count < num ; count++)
	    {
		s++;
		String game = JOptionPane.showInputDialog ((count + 1) + ". Enter the Name of the Game Your Selling");
		games [count] = game;
		condition = JOptionPane.showInputDialog ((count + 1) + ". Please Describe Condition of Your Game."
			+ "\nType in one of the Following: 'New' or 'Used'");

		//Value Verification
		while (!condition.equalsIgnoreCase ("New") && !condition.equalsIgnoreCase ("Used"))
		{
		    condition = JOptionPane.showInputDialog ((count + 1) + ". Please Describe Condition of Your Game."
			    + "\nType in one of the Following: 'New' or 'Used'");
		}
		if (condition.equalsIgnoreCase ("New"))
		    sum += 30;
		else if (condition.equalsIgnoreCase ("Used"))
		    sum += 15;
	    }
	    value = confirm (games);
	}

	JOptionPane.showMessageDialog (null, "Return to Customer");
	JOptionPane.showMessageDialog (null, "Your games are valid for sale");
	JOptionPane.showMessageDialog (null, "You recieve $" + sum + " for the games you're selling");
	if (s >= 3)
	{
	    JOptionPane.showMessageDialog (null, "\tCONGRATULATIONS!!!"
		    + "\nDear Customer,"
		    + "\nFor selling 3 or More Games You Get a 10% Discount Coupon"
		    + "\nYour Coupon Code is: EBrocks1997"
		    + "\nPlease Save This Coupoun Code and Use it Next Time You Come Along");
	}

    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This runs the add_Games method.
    This lets the Employee
    add a game to the stock*/

    public static void add_Games () throws IOException
    {
	String input = JOptionPane.showInputDialog (null, "How Many Games Are You Adding");
	int num = Integer.parseInt (input); //Converts JOption input into an Int num

	//Variable Verification
	while (num < 0)
	{
	    input = JOptionPane.showInputDialog (null, "How Many Games Are You Adding");
	    num = Integer.parseInt (input); //Converts JOption input into an Int nun
	}


	//Variable Declaration
	PrintWriter outputFile;
	FileWriter fwriter;

	//For Loop for Each Game
	for (int count = 0 ; count < num ; count++)
	{
	    //User Inputs
	    input = JOptionPane.showInputDialog (null, (count + 1) + ". What kind of Game Do You Want to Add"
		    + "\n1. New Games"
		    + "\n2. Used Games"
		    + "\n3. Refurbished Games");
	    int option = Integer.parseInt (input);

	    //User Validation
	    while (option != 1 && option != 2 && option != 3)
	    {
		input = JOptionPane.showInputDialog (null, (count + 1) + ".What kind of Game Do You Want to Add"
			+ "\n1. New Games"
			+ "\n2. Used Games"
			+ "\n3. Refurbished Games");
		option = Integer.parseInt (input);
	    }

	    //What each value does
	    String filename = "all_Games.txt";
	    if (option == 1)
	    {
		filename = "all_Games.txt";  //Diplays New games
	    }

	    else if (option == 2)
	    {
		filename = "UsedGames.txt";  //Diplays all used games
	    }
	    else if (option == 3)
	    {
		filename = "Refurbished.txt";  //Diplays all NEW games
	    }

	    //Adding Data to a File
	    fwriter = new FileWriter (filename, true);
	    outputFile = new PrintWriter (fwriter);

	    //Ask User to Enter the Name of The Game
	    input = JOptionPane.showInputDialog ("Enter the Name of Game " + (count + 1));
	    outputFile.println (input);

	    outputFile.close ();

	}
	JOptionPane.showMessageDialog (null, "Games Have Been Added Successfully!!!");

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*This lets the Employee confirm that they are an Employee
    The code is - EBGames2K15*/

    public static int confirm (String[] games)
    {
	String password = "EBGames2K15"; //Password
	//Variable Declaration
	int num = 3;
	JOptionPane.showMessageDialog (null, "Dear Customer,"
		+ "\nTo verify the games you want to sell,"
		+ "\nplease show screen to an employee");

	JOptionPane.showMessageDialog (null, "Dear Employee,"
		+ "\nPlease Look at the following games.");
	JOptionPane.showMessageDialog (null, games);
	while (num != 1 && num != 0)
	{
	    String input = JOptionPane.showInputDialog (null, "The Previous Games Are:"
		    + "\n1. Acceptable"
		    + "\n0. Not Acceptable");
	    num = Integer.parseInt (input); //Converts input to an integer
	}

	//Variable declaration
	String code = "WRONG";
	int val = 0;

	while (val == 0)
	{
	    code = JOptionPane.showInputDialog (null, "To Confirm Your Selection Enter the Passcode");
	    String sum = JOptionPane.showInputDialog (null, "Are You Sure"
		    + "\n1. Yes"
		    + "\n0. No");
	    val = Integer.parseInt (sum);
	    while (val != 0 && val != 1)
	    {
		sum = JOptionPane.showInputDialog (null, "Are You Sure"
			+ "\n1. Yes"
			+ "\n0. No");
		val = Integer.parseInt (sum);
	    }


	}

	if (code.equalsIgnoreCase (password))
	{
	    num = num;
	}
	else
	{
	    num = 0;
	}
	return num;
    }



} // EB_Games_ISP class
