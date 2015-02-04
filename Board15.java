public class Board15{

public Hole[] holes;
   
public Board15(){
      //Creates an array of holes, then constructs each hole with row/column (1,1 then 2,1 then 2,2 then 3,1...) pairs and sets them all to occupied
      this.holes = new Hole[15];
      for(int i = 0; i < 15; i++){
         for(int j = 1; j <= 5; j++){
            for( int k = 1; k<=j; k++){
               holes[i] = new Hole(j,k,true);
               i++;
            }
         }
      } 
      //Make the middle hole empty
      holes[4].changeHole(); 
   }
   
   //Counts the remaining pegs on the board
   public int countPegs(){
      int count = 0;
      for(Hole hole : holes){
         if(!hole.isEmpty()){
            count++;
         }
      }
      return count;
   }
   
   
   //Move peg from fromHole to toHole
   public boolean move(Hole fromHole, Hole toHole){
      if(!isMoveLegal(fromHole, toHole)){
         System.out.println("Move is not legal");
         return false;
      }
      else{
         //change the states of each involved hole
         fromHole.changeHole();
         toHole.changeHole();
         findMiddleHole(fromHole,toHole).changeHole();
         return true;
      }
   }
   
   
   
   //Checks if the move is allowed
   private boolean isMoveLegal(Hole fromHole, Hole toHole){
      return (isHoleTwoAway(fromHole, toHole) && (findMiddleHole(fromHole, toHole).isEmpty()));
   }
   
   //Finds the hole that is between two holes
   private Hole findMiddleHole(Hole h1, Hole h2){
      //initialized to dummy hole 
      Hole middleHole = new Hole(0,0,false);
      
      int middleHoleRow = (h1.row + h2.row)/2;
      int middleHoleColumn = (h1.column + h2.column)/2;
      //  search board array for hole with this coordinate
      for(Hole h: holes){
         if(h.row == middleHoleRow && h.column == middleHoleColumn){
            middleHole = h;
         }
      }
      
      return middleHole;
   }
   
   private boolean isHoleTwoAway(Hole h1, Hole h2){
      // Difference between holes must be 2 or 4, with either row distance or column distance being 2
      int diffRow = h1.row() - h2.row();
      int diffCol = h1.column() - h2.column();
      System.out.println("Diffrow ="+diffRow);
      System.out.println("Diffcol ="+diffCol);
      return (
         ((Math.abs(diffRow + diffCol) == 2)
         || (Math.abs(diffRow + diffCol) ==4))
         &&
         (Math.abs(diffRow) == 2 || Math.abs(diffCol) == 2)
         );
   }
   

   public void instructions(){
      System.out.println("This is triangle peg solitaire\n" +
                          "The goal of the game is to remove all but one peg from the board\n"+
                          "We represent holes with pegs with capital letters, and empty spaces with lower case letter\n"+
                          "To remove a peg, you jump over it with a neighboring peg to an empty hole.\n"+
                          "You can jump laterally on a line, or on a diagonal\n"+
                          "First, enter which peg you want to move. Then enter with hole you want to move to.\n"+
                          "For example, you first move might be:\n"+
                          ">L\n"+
                          ">E\n"+
                          "\n"+
                          "Have fun!\n");
     System.out.println("");
     System.out.println("Press enter to continue... ");
   }
   
    public void displayBoard()
   {
      System.out.println("     /\\     ");
      
      if(holes[0].isEmpty() == true){
         System.out.println("    /A \\    ");
      }//end of if 
      else{
         System.out.println("    /a \\     ");
      }//end of else 
      
      System.out.print("   /");
      if(holes[1].isEmpty() == true){
         System.out.print("B ");
      }
      else{
         System.out.print("b ");
      }
      
      if(holes[2].isEmpty() == true){
         System.out.print("C ");
      }
      else{
         System.out.print("c ");
      }
      
      System.out.print("\\\n");
      System.out.print("  /");
      
      if(holes[3].isEmpty() == true){
         System.out.print("D ");
      }
      else{
         System.out.print("d ");
      }
      
      if(holes[4].isEmpty() == true){
         System.out.print("E ");
      }
      else{
         System.out.print("e ");
      }
      
      if(holes[5].isEmpty() == true){
         System.out.print("F ");
      }
      else{
         System.out.print("f ");
      }
      
      System.out.print("\\\n");
      System.out.print(" /");
      
      if(holes[6].isEmpty() == true){
         System.out.print("G ");
      }
      else{
         System.out.print("g ");
      }
      if(holes[7].isEmpty() == true){
         System.out.print("H ");
      }
      else{
         System.out.print("h ");
      }
      if(holes[8].isEmpty() == true){
         System.out.print("I ");
      }
      else{
         System.out.print("i ");
      }
      if(holes[9].isEmpty() == true){
         System.out.print("J ");
      }
      else{
         System.out.print("j ");
      }
      
      System.out.print("\\\n");
      System.out.print("/");
      
      if(holes[10].isEmpty() == true){
         System.out.print("K ");
      }
      else{
         System.out.print("k ");
      }
      if(holes[11].isEmpty() == true){
         System.out.print("L ");
      }
      else{
         System.out.print("l ");
      }
      if(holes[12].isEmpty() == true){
         System.out.print("M ");
      }
      else{
         System.out.print("m ");
      }
      if(holes[13].isEmpty() == true){
         System.out.print("N ");
      }
      else{
         System.out.print("n ");
      }
      if(holes[14].isEmpty() == true){
         System.out.print("O ");
      }
      else{
         System.out.print("o ");
      }
      
      System.out.print("\\\n");
      System.out.print("------------\n");
      
      }

   
   

   public boolean anyMovesLeft(){
      //For each hole:
      //-------v this peg can jump-----v This peg to ----------v This hole OR over -----v This peg to ------v this hole
      if(holes[0].isEmpty() && ((holes[1].isEmpty() && !holes[3].isEmpty()) || holes[2].isEmpty() && !holes[5].isEmpty())){
         return true;

      }
      if(holes[1].isEmpty() && (holes[3].isEmpty() && !holes[6].isEmpty() || holes[4].isEmpty() && !holes[8].isEmpty())){
         return true;
      }
      if(holes[2].isEmpty() && (holes[4].isEmpty() && !holes[7].isEmpty() || holes[5].isEmpty() && !holes[9].isEmpty())){
         return true;
      }
      if(holes[3].isEmpty() && (holes[6].isEmpty() && !holes[10].isEmpty() || holes[7].isEmpty() && !holes[12].isEmpty())){
         return true;
      }
      if(holes[4].isEmpty() && (holes[7].isEmpty() && !holes[11].isEmpty() || holes[8].isEmpty() && !holes[13].isEmpty())){
         return true;
      }
      if(holes[5].isEmpty() && (holes[8].isEmpty() && !holes[12].isEmpty() || holes[9].isEmpty() && !holes[14].isEmpty())){
         return true;
      }
      if(holes[6].isEmpty() && (holes[7].isEmpty() && !holes[8].isEmpty())){
         return true;
      }
      if(holes[7].isEmpty() && (holes[8].isEmpty() && !holes[9].isEmpty())){
         return true;
      }
      if(holes[8].isEmpty() && (holes[7].isEmpty() && !holes[6].isEmpty())){
         return true;
      }
      if(holes[9].isEmpty() && (holes[8].isEmpty() && !holes[7].isEmpty())){
         return true;
      }
      if(holes[10].isEmpty() && (holes[6].isEmpty() && !holes[3].isEmpty() || holes[11].isEmpty() && !holes[12].isEmpty())){
         return true;
      }
      if(holes[11].isEmpty() && (holes[7].isEmpty() && !holes[4].isEmpty() || holes[12].isEmpty() && !holes[13].isEmpty())){
         return true;
      }
      if(holes[12].isEmpty() && (holes[7].isEmpty() && !holes[3].isEmpty() || holes[8].isEmpty() && !holes[5].isEmpty())){
         return true;
      }
      if(holes[13].isEmpty() && (holes[8].isEmpty() && !holes[4].isEmpty() || holes[12].isEmpty() && !holes[11].isEmpty())){
         return true;
      }
      if(holes[14].isEmpty() && (holes[9].isEmpty() && !holes[5].isEmpty() || holes[13].isEmpty() && !holes[12].isEmpty())){
         return true;
      }
      return false;
      }
   }

   
   
   

