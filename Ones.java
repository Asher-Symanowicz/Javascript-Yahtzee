/* Asher Symanowicz 
Yahtzee
ONES: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */

public class Ones extends Category {
   
   // @ param d is a collection of dice
   public int evaluate(Dice d) {
      return d.count(1);
   }
}