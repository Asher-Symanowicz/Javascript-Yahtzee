/* Asher Symanowicz
CS110 Final Project
GameDriver for Yahztee game


*/

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Game {

   final int ROUNDS = 13;
   
   // Instance of Dice's
   private DiceRoll dice;
   
   private Dice savedDice;
   
   private Scanner input;
   
   public void Game() {
         ScoreCard player1 = new ScoreCard();
         ScoreCard player2 = new ScoreCard();
         dice = new DiceRoll();
         savedDice = new Dice();
         
         System.out.println("******************************************************************");
         System.out.println("                       Welcome to Yahtzee!                       ");
         System.out.println("******************************************************************");
         
         
         for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Player 1");
            takeTurn(player1);
            System.out.println("Player 2");
            takeTurn(player2);
         }
         
         // compare scores
         if (player1.score() > player2.score())  {
            System.out.printf("PLAYER 1 WINS\n Player 1: %d vs Player 2: %d", player1.score(), player2.score());
         } else if (player1.score() > player2.score()) {
            System.out.printf("PLAYER 2 WINS\n Player 1: %d vs Player 2: %d", player1.score(), player2.score());
         } else {
            System.out.println("After an astonishingly close game from very capable competitors. " +
               "Its a tie.");
         }
         
      }
      
      // Method that has options for moves for each turn 
      // @ param player takes in specific players scorecard
      public void takeTurn(ScoreCard player) {
         
         input = new Scanner(System.in);
         
         System.out.println(player); // Prints Scorecard
                
         int rolls = 0; // Counter for rolls 
         dice.toss(); // initial roll for dice
         String choice = ""; // Initial value for choice to start while loop
         
         while (rolls < 2) {
         
            System.out.println("Dice to reroll: "); // printing dice that can be rerolled
            System.out.println(dice + "\n");
            
            if (savedDice.getNumDice() > 0) {
               System.out.println("Saved dice: ");
               System.out.println(savedDice); 
            }
            
            System.out.println("Save dice with [ ] filled with index values seperated" +
               " by spaces 'roll' to reroll, 'score' to score\n");
            
            choice = input.nextLine().trim();
            while(validResponse(choice) == false) {
               choice = input.nextLine().trim();
            }
            if (choice.equals("score")) {  
               rolls = 2;
            } else if(choice.equals("roll")) {
               rolls++;
               roll();
            } else {
               save(choice);
            }
                    
         }
         score(player);
      }
         
      // Rolls dice for player when prompted
      public void roll() {
         dice.toss(); // Randomize dice
      }
      
      // Allows for user to choose what category they want to score in
      // @ param dice, is taking in the users dice
      // @ param savedDice is taking in the user saved dice
      // @ param player takes in players scorecard to add value to it
      public void score(ScoreCard player) {
         // Adds savedDice back to dice to score 
         if (savedDice.getNumDice() > 0) {
            for (int i = 0; i < savedDice.getNumDice(); i++) {
               dice.addDie(savedDice.getDie(i));
            }
            for (int i = savedDice.getNumDice()-1; i >= 0; i--) {
               savedDice.removeDie(i);
            }
         
         }
         
         System.out.println("Final roll: \n");
         System.out.println(dice); //prints final roll
         System.out.print("\n");
          
         
         String cur = "Select a category that you have not scored in yet: \n ";
                  
         // This is taking away the options that have already been scored
         int i = 1;
         for (CategoryValue cv: CategoryValue.values()) {
         if (!player.checkScored(cv)) {
               cur += String.format("%d: %s, %d points\n", (cv.getValue() + 1), cv, player.getEvaluation(cv, dice));
               
            }
         }
         System.out.println(cur); // printing above loop for possible scoring
         Scanner scan = new Scanner(System.in); // Creating scanner
        
         int scoring = -1;
         try {
            scoring = Integer.parseInt(scan.nextLine());
         }
         catch (Exception e) {
            System.out.println("Invalid response, need a valid integer.");
         }
         
         while (scoring < 1 || scoring > 13) { 
            try {
            scoring = Integer.parseInt(scan.nextLine());
            }
            catch (Exception e) {
               System.out.println("Invalid response, need a valid integer.");
               scan.nextLine();
            } 
         }
         
         CategoryValue CVchoice = null;
         for (CategoryValue cv : CategoryValue.values()) {
            if (scoring - 1 == cv.getValue()) {
               if (!player.checkScored(cv) || player.getCategoryScore(cv) == 50) {
                  player.choose(cv, dice);
                  CVchoice = cv;
                  }
               else 
                  scoring = -1;
               }
         }
         System.out.printf("You score %d in %s", player.getCategoryScore(CVchoice), CVchoice);
         System.out.println("\n\n***************************************************");
      }
      
      // saves dice from user input
      // @ param choice is what the user input is for indices to be taken out of dice to be saved
      public void save(String choice) {   
          
         choice = choice.substring(1, choice.length()-1); // Remove square brackets

         ArrayList<Integer> array= new ArrayList<>(); 
        
         Scanner scan = new Scanner(choice);
         
         while (scan.hasNext()) {
            array.add(scan.nextInt());
         }
         
         Collections.sort(array); 
         Collections.reverse(array); // reverse order
        
         for(int dieLeft : array) { // taking die from dice and adding it to saved die
            int i = dieLeft-1;
            savedDice.addDie(dice.getDie(i)); 
            dice.removeDie(i);
         }
      
   }
   
   
   // Method that makes sure input is roll, score, or [save]
   // @ param choice is user input for action
   public boolean validResponse(String choice) {
      if (choice.equals("roll")) {
         return true;
         
      } else if (choice.equals("score")) {
         return true;
         
      } else if (choice.charAt(0) == '[' && choice.charAt(choice.length()-1) == ']') {
            for (int i = 0; i < choice.length(); i++) {
               char c = choice.charAt(i);
               if(!Character.isDigit(c) && !Character.isWhitespace(c) && c != '[' && c != ']') {
                  return false;
               }
            } return true;
         } 
         else 
            return false;
      } 
}
  



