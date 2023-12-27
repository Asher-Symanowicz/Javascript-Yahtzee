/* Asher Symanowicz 
Yahtzee
THREES: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */

public class Threes extends Category {
   
   // @ param d is a collection of dice
   public int evaluate(Dice d) {
      return d.count(3) * 3;
   }
}