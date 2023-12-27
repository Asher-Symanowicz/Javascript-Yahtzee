/* Asher Symanowicz 
Yahtzee
YAHTZEE: Evaluates Die in Dice object and returns a score that would 
be achieved for this category */



public class FiveOfAKind extends Category {
   final int SCORE = 50;
   // @ param d is a collection of dice
   public int evaluate(Dice d) {
      Die firstDieValue = d.getDie(0);
      for(int i = 0; i < d.getNumDice(); i++) {
         if (d.getDie(i) != firstDieValue) {
            return 0;
         }
      }
      return SCORE;
   }
}
