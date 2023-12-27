/* Asher Symanowicz 
Yahtzee
THREE OF A KIND: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */

public class ThreeOfAKind extends Category {
   
   public int evaluate(Dice d) {
       for (int i = 0; i < 6; i++){
         if(d.count(i) == 3)
            return d.sum(); // Return total score
       }
      return 0;
    
   }
}
