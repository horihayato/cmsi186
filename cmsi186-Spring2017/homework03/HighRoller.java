
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-23
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class HighRoll{

   public static void main( String args[] ) {
      int save;
      DiceSet ds;
      System.out.println( "\n   Welcome to HighRoll!\n" );
      System.out.println( "     Enter the number of die you want to play with, and the number of sides you want for the die. Eg. (3 5)" );
      
      // Reads input and constructs new DiceSet based on input

      Scanner reader = new Scanner(System.in);
      System.out.println("Enter two numbers: ");
      String read = reader.nextLine();    // get the entire line after the prompt 

      // If user does not input anything, ask them to try again.
      if (read.isEmpty()) {
         System.out.println("Nothing was entered. Please try again");
         return;
      }

      String[] numbers = read.split(" ");
      if (numbers.length == 1) {
         throw new IllegalArgumentException("Please enter two numbers");
      }
      int numOne = Integer.parseInt(numbers[0]);
      int numTwo = Integer.parseInt(numbers[1]);

      // Creates DiceSet according to User Input
      ds = new DiceSet(numOne, numTwo);

      System.out.println( "     Press the '1' key to roll all the dice" );
      System.out.println( "     Press the '2' key to roll a single die" );
      System.out.println( "     Press the '3' key to calculate the score for this set" );
      System.out.println( "     Press the '4' key to save this score as High Score" );
      System.out.println( "     Press the '5' key to Display the High Score" );
      System.out.println( "     Press the 'q' key to quit the program" );

      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         String input2Line = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
            }
            System.out.println( "   You typed: " + inputLine );

            if ('1' == inputLine.charAt(0)) {
               ds.roll();
            }

            if ('2' == inputLine.charAt(0)) {
               System.out.println("Which die do you want to roll?");
               Scanner scan = new Scanner(System.in);
               System.out.println("Input Dice Index: ");
               String reading = scan.nextLine();
               if (reading.isEmpty()) {
                  System.out.println("Nothing was entered. Please try again");
                  return;
               }

               String[] numbs = reading.split(" ");
               int userInput = Integer.parseInt(numbs[0]);
               ds.rollIndividual(userInput);
               System.out.println("Your new roll for this die is: "+ ds.getIndividual(userInput));
            }

            if ('3' == inputLine.charAt(0)) {
               System.out.println(ds.sum());
            }

            if ('4' == inputLine.charAt(0)) {
               save = ds.sum();
               System.out.println("Your total score " + save + " has been saved!");
            }

            if ('5' == inputLine.charAt(0)) {
               save = ds.sum();
               System.out.println("Here is your saved HighScore " + save + "");
            }

            if( 'q' == inputLine.charAt(0) ) {
               break;
            }         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
