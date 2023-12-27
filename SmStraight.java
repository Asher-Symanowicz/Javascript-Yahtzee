/* Asher Symanowicz 
Yahtzee
SMALL STRAIGHT: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */


public class SmStraight extends Category {
   
   // @ param d is a collection of dice
   public int evaluate(Dice d) { 
      if (d.contains(3) && d.contains(4)) {
         if (d.contains(1) && d.contains(2)){
            return 30;
         }else if(d.contains(5) && d.contains(6)){
            return 30;
         } else if(d.contains(2) && d.contains(5)) {
            return 30;
         }
      }
    return 0; 
   }
}
