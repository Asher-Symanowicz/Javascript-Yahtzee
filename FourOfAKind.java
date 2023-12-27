/* Asher Symanowicz 
Yahtzee
FOUR OF A KIND: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */

public class FourOfAKind extends Category {
   
   public int evaluate(Dice d) {
       for (int i = 0; i < 6; i++){
         if(d.count(i) == 4)
            return d.sum(); // return Total score
       }
   return 0;
   }
}
