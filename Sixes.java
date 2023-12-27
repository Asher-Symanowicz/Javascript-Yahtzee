/* Asher Symanowicz 
Yahtzee
SIXES: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */

public class Sixes extends Category {
   
   // @ param d is a collection of dice
   public int evaluate(Dice d) {
      return d.count(6)*6;
   }
}