import java.util.*; 

/**
*Author    Chris Hutchinson
*Date      2015-1-23 
*Version   1.0.0
*CS205 Software Engineering 
*Warm-up Project (interface) 
*/

public class PegGame
{
   public static void main(String [] args) 
   {
   
    //Variabels 
    int gameChoice;
    boolean decision = false;  
    
    // introduction to users 
    System.out.println("Welcome to");
    System.out.println("The Peg Game");
    System.out.println(" ");  
    
    // create a Scanner object for keyboard
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Would you like to play: ");
    System.out.println("1. Traingle Peg Game (15 hole)");
    System.out.println("2. English Peg Solitaire (33 hole)");
    System.out.println("3. Quit Program\n");
    
    System.out.println("Please type the number of the game you would like to play: ");
    try
    {
       gameChoice = keyboard.nextInt();
        
       while( decision == false){
       
          if(gameChoice == 1){
          
          //call class object for traingle peg game 
          
          System.out.println("Triangle Peg Game");
          decision = true; 
          
          }//end of if 
          
          else if(gameChoice == 2){
          
          //call class object for English Peg Solitaire
          
          System.out.println("English Peg Solitaire");
          decision = true; 
          
          }// end of else if 2
          
          else if(gameChoice == 3){
          // Quiting Program 
          
          System.out.println("Quiting Program");
          
          decision = true;
          
          System.exit(0);
          
          }//end of else if 3
          
          else{
          System.out.println("Invalid Choice");
          
          System.out.println("Please choose a valid game number (1 or 2), or 3 to Quit Program.");
          
          gameChoice = keyboard.nextInt();
          }//end of else 
          
        }// end of while
        
       }//end of try
       catch( InputMismatchException e)
       {
         System.out.println("Invalid input type: Program terminating");
       }// end of catch  
    
   
   }
   
}
