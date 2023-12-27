/* Asher Symanowicz 
Yahtzee
LARGE STRAIGHT: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */



public class LgStraight extends Category {
   
   // @ param d is a collection of dice
   public int evaluate(Dice d) {
      if (d.contains(2) && d.contains(3) && d.contains(4) 
         && d.contains(5)) 
         return 40;
      else
         return 0;     
   }
}
