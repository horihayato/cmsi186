/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Hayato Hori
 *  Date          :  2017-02-21
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public void setIndividual( int i, int jValue );  // Sets the ith die in this set to the value of jValue
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int sides;
   private int count; 
   private Die[] dieArray;
   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      dieArray = new Die[count];
        for (int i = 0; i < dieArray.length; i++) {
            dieArray[i] = new Die(sides);
        }  
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
      int sum = 0;
      for (int i = 0; i < dieArray.length; i++) {
         sum += dieArray[i].getValue();
      }
      return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   */
   public void roll() {
      for (int i = 0; i < dieArray.length; i++) {
         System.out.println(dieArray[i].roll());
      }
   }

  /**
   * Randomly rolls a single die of the dice in this set
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public void rollIndividual( int dieIndex ) {
      if (dieIndex > dieArray.length) {
         throw new IllegalArgumentException("Index out of bounds");
      }
      System.out.println(dieArray[dieIndex].roll());
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      if (dieIndex > dieArray.length) {
         throw new IllegalArgumentException("Index out of bounds");
      }
      return dieArray[dieIndex].getValue();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to set the value of
   * @param  dieValue int of the value to set for that die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public void setIndividual( int dieIndex, int dieValue ) {
      if (dieIndex > dieArray.length) {
         throw new IllegalArgumentException("Index out of bounds");
      }

      System.out.println(dieArray[dieIndex].setValue(dieValue));
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      for (int i = 0; i < dieArray.length; i++) {
         result += "[" + dieArray[i].getValue() + "]";
      }  
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      String result = "";
      for (int i = 0; i < ds.dieArray.length; i++) {
         result += "[" + ds.dieArray[i].getValue() + "]";
      }  
      return result;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
      if (dieArray.length == ds.dieArray.length) {
         for (int i = 0; i < dieArray.length; i++) {
            if (ds.dieArray[i].getSides() == dieArray[i].getSides()) {
               return true;
            }
         }
      }
      
      return false;  
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      DiceSet ds = new DiceSet(5, 6);
      DiceSet ds2 = new DiceSet(5, 6);
      DiceSet ds3 = new DiceSet( 7, 8);
      DiceSet ds4 = new DiceSet(5, 8);
      System.out.println( "Comparing if values are the same: " + ds.isIdentical(ds2));
      System.out.println( "Comparing if values are the same: " + ds.isIdentical(ds3));
      System.out.println( "Comparing if values are the same: " + ds.isIdentical(ds4));
      System.out.println( "The sum of your Dice Set is: " + ds.sum());
      System.out.println( "Values of dice after roll: ");
      ds.roll();
      System.out.println( "The sum of your Dice Set after roll: " + ds.sum());
      System.out.println( "Rolling an indiviudal dice based on diceIndex...");
      ds.rollIndividual(3);
      System.out.println( "The sum of your Dice Set after inidividual roll: " + ds.sum());
      System.out.println( "Changing value of an individual die... ");
      ds.setIndividual(3, 9);
      System.out.println( "Returns Individual value in dice set: " + ds.getIndividual(3));
      System.out.println( "String representation of your dice set:" + ds.toString());
      System.out.println( "String representation of your dice set:" + toString(ds));
      System.out.println( "String representation of your dice set:" + toString(ds3));
      System.out.println( "Rolling dice..." );
      ds3.roll();
      System.out.println( "String representation of your dice set:" + toString(ds3));

   }

}
