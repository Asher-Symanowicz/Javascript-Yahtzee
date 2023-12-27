/* Asher Symanowicz
Yahtzee
SCORECARD: The collection of categories, as well as scores of 
top/bottom and total */

import java.util.ArrayList;

public class ScoreCard {
   
   // Collection of Category objects
   private ArrayList<Category> scorecard;
   
   // Additional score for each Yahtzee beyond the first (100 points)
   private int yahtzeeBonus = 100;
   
   // Number of categories 13
   private static final int NUM_CATS = 13;
   
   // create all category objects and add to ArrayList
   public ScoreCard() {
      scorecard = new ArrayList<>();
      scorecard.add(new Ones());
      scorecard.add(new Twos());
      scorecard.add(new Threes());
      scorecard.add(new Fours());
      scorecard.add(new Fives());
      scorecard.add(new Sixes());
      scorecard.add(new ThreeOfAKind());
      scorecard.add(new FourOfAKind());
      scorecard.add(new FullHouse());
      scorecard.add(new SmStraight());
      scorecard.add(new LgStraight());
      scorecard.add(new FiveOfAKind());
      scorecard.add(new Chance());
   }
   
   // Get appropriate Category and score that category
   // Set appropraite element to true showing its been used
   // @ param cv is the category being checked
   // @ param d is a dice object 
   public void choose(CategoryValue cv, Dice d) {
   
      if (cv == CategoryValue.YAHTZEE && getCategoryScore(CategoryValue.YAHTZEE) == yahtzeeBonus) {
         yahtzeeBonus += yahtzeeBonus;
      } else {
         Category check = scorecard.get(cv.getValue()); 
         check.addValue(d);
      }
      
   } 
   
   // Return score that would be achieved in this category with provided dice objects
   // @ param cv is the category being checked
   // @ param d is a dice object 
   // @ return score of category
   public int getEvaluation(CategoryValue cv, Dice d) {
     Category check = scorecard.get(cv.getValue()); 
     return check.evaluate(d);
     
   }
   
   // Return true if Category has been used, false if not
   // @ param cv is the category being checked
   // @ return if category has been used
   public boolean checkScored(CategoryValue cv) {
      if (scorecard.get(cv.getValue()).getUsed() == false)
         return false;
      else
         return true;
   }
   
   
   // Return current score for the specified category
   // @ param cv is the category being checked
   // @ return current score for specified category
   public int getCategoryScore(CategoryValue cv) {
     return scorecard.get(cv.getValue()).getScore();
   }
   
   // Return the total score for the top of the scorecard
   // @ return total score from Ones - Sixes
   public int scoreTop() {
      final int BONUS = 35;
      final int TOP_RANGE = 6;
      int sum = 0;
      int i = 0; 
      while (i < TOP_RANGE)
      {
         sum += scorecard.get(i).getScore();
         i++;
      }
      
      if (sum > 63) // Bonus for over 63 points
         sum += BONUS;
      return sum;
   }
   
   // Return the total score for the bottom of the scorecard
   // @ return total score from ThreeOfAKind - Chance
   public int scoreBottom() { 
     final int BOTTOM_RANGE = 13;
     int sum = 0;
     int i = 6;
     while(i < BOTTOM_RANGE){
      sum += scorecard.get(i).getScore();
      i++;
      }
      
      // YAHTZEE BONUS HOW 
      return sum;
   }
   
   
   // Return the total score for the scorecard 
   // @ return sum of all the scores
   public int score() {
      int sum = 0;
      sum += scoreTop() + scoreBottom();
      return sum;
   }
   
   
   public String toString() {
      int width = 16;
      String cur = "Current Scorecard:\n";
     
      for(CategoryValue cv : CategoryValue.values()) {
          cur += String.format("%" + width + "s: " + "%d\n", cv, getCategoryScore(cv));
         }

      cur += String.format("%" + width + "s: %d\n","Upper Total", scoreTop());
      cur += String.format("%" + width + "s: %d\n", "Lower Total", scoreBottom());
      cur += String.format("%" + width + "s: %d\n","Score", score());  
      
      return cur;
   }
   
}