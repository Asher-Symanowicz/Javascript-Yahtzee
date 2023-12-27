/* Asher Symanowicz
Yahtzee
DIE class: represents a single die in Yathzee */

import java.util.Random;

public class Die {

   
   // value on the die
   private int value;
   
   // Number of sides on the die
   private final static int SIDES = 6;
   
   // Random number generator for all die to share
   private static Random r = new Random();
   
   // Initializes value to a random number between 1-6
   public Die(){
      this.value = r.nextInt(SIDES) + 1;
   }
   
   // Change value on the die to a random value 1-6
   public void roll(){
      value = r.nextInt(SIDES) + 1;
   }
   
   // @ return value on die
   public int getValue(){
      return value;
   }
   
   public String toString(){
      return String.format("value %d", value);
   }
   
 
}