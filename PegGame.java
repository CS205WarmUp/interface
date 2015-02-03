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
          
            // calling method for playing triangle peg game 
            triangleGame();  
          
          
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
    
   
   }//end of main
   
   
   public static void triangleGame(){
   
      //variables 
      String input1,
             input2;
     char fromHole,
            toHole; 
             
      boolean legal; 
      
      
      //calling to the board class to create instance to create array for board game 
      Board15 game = new Board15();
      
      //call instructions for triangle peg game method 
      //game.instructions(); 
      while(true){
      // showing user the board
      game.displayBoard(); 
      
      boolean moveIsLegal = false;
      while(!moveIsLegal){
         //creating scanner for asking player what moves they want to make. 
         
         Scanner keyboard = new Scanner(System.in);
         //try
         //{
            System.out.println("Select a hole with a peg that you want to move? : ");
            
            input1 = keyboard.nextLine(); 
            fromHole = input1.charAt(0);
         //}//end of try
         // catch( InputMismatchException e)
         //{
         //System.out.println("Invalid input type: Program terminating");
         //}// end of catch
         
         //while(!( game.holes[letterToHole(fromHole)].isEmpty() == true && letterToHole(fromHole)>=0 && letterToHole(fromHole)<=15)){
            //System.out.println("Select a hole with a peg that you want to move? : ");
         
            //input1 = keyboard.nextLine(); 
            //fromHole = input1.charAt(0);
         //}//end of while 
         
         System.out.println("Which hole would you like to move that peg to? : ");
         
         input2 = keyboard.nextLine(); 
         toHole = input2.charAt(0);
         
         // make a move 
         System.out.println("from hole: "+letterToHole(fromHole));
         System.out.println("to hole: "+letterToHole(toHole));
         
         moveIsLegal = game.move(game.holes[letterToHole(fromHole)], game.holes[letterToHole(toHole)]); 
     }//end while loop
     }//end of game while 
      
      
      
      
      
      
   
   }//end of triangleGame()
   
   public static int letterToHole(char letter){
   
   int arrayLocation = -1; 
   
   switch(letter) {
         case 'a': 
         case 'A':arrayLocation = 0; break;
         case 'b': 
         case 'B':arrayLocation = 1; break;
         case 'c': 
         case 'C':arrayLocation = 2; break;
         case 'd': 
         case 'D':arrayLocation = 3; break;
         case 'e': 
         case 'E':arrayLocation = 4; break;
         case 'f': 
         case 'F':arrayLocation = 5; break;
         case 'g': 
         case 'G':arrayLocation = 6; break;
         case 'h': 
         case 'H':arrayLocation = 7; break;
         case 'i': 
         case 'I':arrayLocation = 8; break;
         case 'j': 
         case 'J':arrayLocation = 9; break;
         case 'k': 
         case 'K':arrayLocation = 10; break;
         case 'l': 
         case 'L':arrayLocation = 11; break;
         case 'm': 
         case 'M':arrayLocation = 12; break;
         case 'n': 
         case 'N':arrayLocation = 13; break;
         case 'o': 
         case 'O':arrayLocation = 14; break;
         default: break;
         
         }//end of switch
         
         return arrayLocation; 
    
   
   }//end of letterToHole
   
 }//end of pegGame 
   
   
   
   
    
