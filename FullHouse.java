/* Asher Symanowicz 
Yahtzee
FULL HOUSE: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */

public class FullHouse extends Category {
   
   public int evaluate(Dice d) {
      final int SCORE = 25;
      for (int i = 0; i < 6; i++){
         if(d.count(i) >= 3)
           // checking if other 2 die are the same (if count == 2 for other die)
           for(int x = 0; x < 6; x++) {
               if(d.count(x) >= 2)
                  return SCORE;
           } 
       }
      return 0;
   }
   
}
