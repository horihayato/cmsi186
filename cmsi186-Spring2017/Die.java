/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Hayato Hori
 *  Date          :  2017-02-21
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getSides()                      // get the number of sides on this die     
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int dots;
   private int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param sides int value containing THIS card's rank
   * @throws      IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
      if (nSides < MINIMUM_SIDES || nSides > 120) {
         System.out.println("Invalid number of sides");
      }
      this.sides = nSides;
      this.dots = 1;
   }

  /**
   * Roll the die and return the result
   * @return  integer value of the result of the roll, whatever would be on top, randomly selected
   * @throws  IllegalArgumentException
   */
   public int roll() {
      dots = (int) (Math.random() * sides) + 1;
      return dots;
   }

  /**
   * @return the side count of THIS die instance
   */
   public int getSides() {
       return this.sides;
   }

  /**
   * @return the pip count of THIS die instance; whatever is on top when the die stops rolling
   */
   public int getValue() {
      return this.dots;
   }

   public int setValue(int dieValue) {
      return this.dots = dieValue;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public int setSides( int sides ) {
      if (sides < MINIMUM_SIDES) {
         throw new IllegalArgumentException("Please choose valid number of sides");
      }
      return this.sides = sides;
   }

  /**
   * @return Public Instance method that returns a String representation of THIS die instance
   * @throws UnsupportedOperationException
   */
   public String toString() {
      if (this.sides < 0) {
         throw new UnsupportedOperationException();
      }
      String toString = Integer.toString(this.sides);
      return toString;
   }

  /**
   * @return Class-wide method that returns a String representation of THIS die instance
   */
   public static String toString( Die c ) {
      String toString = Integer.toString(c.sides);
      return toString;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      Die d = new Die( 5 );
      Die c = new Die( 8 ); 
      System.out.println( "Your roll is " + d.roll());
      System.out.println( "Your dice has " + d.getSides() + " sides");
      System.out.println( "You got " + d.getValue() + " on your roll");
      System.out.println( "You changed the number of sides to " + d.setSides(4));
      System.out.println( "Your Die now has " + d.toString() + " sides." + " Your previous roll was: " + d.getValue());
      System.out.println( "Your Die now has " + toString(c) + " sides." + " Your previous roll was: " + c.getValue());
   }

}
