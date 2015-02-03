public class Board33{
   Hole[] holes;
   public Board33(){
      
      this.holes = new Hole[33];
      
      int i  = 0;
      for(int j = 1; j <= 2; j++){
         for( int k = 3; k <= 5; k++){
            holes[i] = new Hole(j,k,true);
            i++;
         }
      }
      
      for(int j = 3; j <= 5; j++){
         for( int k = 1; k <= 7; k++){
            holes[i] = new Hole(j,k,true);
            i++;
         }
      }
      
      for(int j = 6; j <= 7; j++){
         for( int k = 3; k <= 5; k++){
            holes[i] = new Hole(j,k,true);
            i++;
         }
      }
         
      //Make the middle hole empty
      holes[16].changeHole(); 
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
   
   //Displays the board in ASCII representation
   public void displayBoard(){
      ;
   }
   
   public void instructions(){
      System.out.println("This is English peg solitaire\n" +
                          "The goal of the game is to remove all but one peg from the board\n"+
                          "We represent holes with pegs with capital letters, and empty spaces with lower case letter\n"+
                          "To remove a peg, you jump over it with a neighboring peg to an empty hole.\n"+
                          "You can jump horizontally or vertically, but not diagonally\n"+
                          "First, enter which peg you want to move. Then enter with hole you want to move to.\n"+
                          "For example, you first move might be:\n"+
                          ">N\n"+
                          ">P\n"+
                          "\n"+
                          "Have fun!\n");
   }
   
   //Move peg from fromHole to toHole
   public void move(Hole fromHole, Hole toHole){
      if(!isMoveLegal(fromHole, toHole)){
         System.out.println("Move is not legal");
      }
      else{
         //change the states of each involved hole
         fromHole.changeHole();
         toHole.changeHole();
         findMiddleHole(fromHole,toHole).changeHole();
      }
   }
   
   
   
   //Checks if the move is allowed
   private boolean isMoveLegal(Hole fromHole, Hole toHole){
      return (isHoleTwoAway(fromHole, toHole) && !(findMiddleHole(fromHole, toHole).isEmpty()));
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
      // Difference between holes must be 2 with either row distance or column distance being 2
      int diffRow = h1.row() - h2.row();
      int diffCol = h1.column() - h2.column();
      return (
         ((Math.abs(diffRow + diffCol) == 2))
         &&
         (diffRow == 2 || diffCol == 2)
         );
   }
   
   public boolean anyMovesLeft(){
      //incomplete
      if(holes[0].isEmpty() && ((holes[1].isEmpty() && !holes[2].isEmpty()) || holes[3].isEmpty() && !holes[8].isEmpty())){
         return true;
      }
      if(holes[1].isEmpty() && ((holes[4].isEmpty() && !holes[9]))){
         return true;
      }
      if(holes[2].isEmpty() && ((holes[1].isEmpty() && !holes[0].isEmpty()) || holes[5].isEmpty() && !holes[10].isEmpty())){
         return true;
      }
      if(holes[3].isEmpty() && ((holes[4].isEmpty() && !holes[5].isEmpty()) || holes[8].isEmpty() && !holes[15].isEmpty())){
         return true;
      }
      if(holes[4].isEmpty() && ((holes[9].isEmpty() && !holes[16].isEmpty()))){
         return true;
      }
      if(holes[5].isEmpty() && ((holes[4].isEmpty() && !holes[3].isEmpty()) || holes[10].isEmpty() && !holes[17].isEmpty())){
         return true;
      }
      if(holes[6].isEmpty() && ((holes[7].isEmpty() && !holes[8].isEmpty()) || holes[13].isEmpty() && !holes[20].isEmpty())){
         return true;
      }
      if(holes[7].isEmpty() && ((holes[8].isEmpty() && !holes[9].isEmpty()) || holes[14].isEmpty() && !holes[21].isEmpty())){
         return true;
      }
      
      
      if(holes[8].isEmpty() && ((holes[3].isEmpty() && !holes[0].isEmpty()) || holes[7].isEmpty() && !holes[6].isEmpty())
                               || holes[9].isEmpty() && !holes[10].isEmpty() || holes[15].isEmpty() && !holes[22].isEmpty()){
         return true;
      }
      if(holes[9].isEmpty() && ((holes[4].isEmpty() && !holes[1].isEmpty()) || holes[8].isEmpty() && !holes[7].isEmpty())
                               || holes[10].isEmpty() && !holes[11].isEmpty() || holes[16].isEmpty() && !holes[23].isEmpty()){
         return true;
      }
      if(holes[10].isEmpty() && ((holes[5].isEmpty() && !holes[2].isEmpty()) || holes[9].isEmpty() && !holes[8].isEmpty())
                               || holes[11].isEmpty() && !holes[12].isEmpty() || holes[18].isEmpty() && !holes[25].isEmpty()){
         return true;
      }
      
      if(holes[11].isEmpty() && ((holes[10].isEmpty() && !holes[9].isEmpty()) || holes[18].isEmpty() && !holes[25].isEmpty())){
         return true;
      }
      if(holes[12].isEmpty() && ((holes[11].isEmpty() && !holes[10].isEmpty()) || holes[19].isEmpty() && !holes[26].isEmpty())){
         return true;
      }
      if(holes[13].isEmpty() && ((holes[14].isEmpty() && !holes[15].isEmpty()))){
         return true;
      }
      if(holes[14].isEmpty() && ((holes[15].isEmpty() && !holes[16].isEmpty()))){
         return true;
      }
      if(holes[15].isEmpty() && ((holes[8].isEmpty() && !holes[3].isEmpty()) || holes[14].isEmpty() && !holes[13].isEmpty())
                               || holes[16].isEmpty() && !holes[17].isEmpty() || holes[22].isEmpty() && !holes[27].isEmpty()){
         return true;
      }
      if(holes[16].isEmpty() && ((holes[9].isEmpty() && !holes[4].isEmpty()) || holes[15].isEmpty() && !holes[14].isEmpty())
                               || holes[17].isEmpty() && !holes[18].isEmpty() || holes[23].isEmpty() && !holes[28].isEmpty()){
         return true;
      }
      if(holes[17].isEmpty() && ((holes[10].isEmpty() && !holes[5].isEmpty()) || holes[16].isEmpty() && !holes[15].isEmpty())
                               || holes[18].isEmpty() && !holes[19].isEmpty() || holes[24].isEmpty() && !holes[29].isEmpty()){
         return true;
      }
      if(holes[18].isEmpty() && ((holes[17].isEmpty() && !holes[16].isEmpty()))){
         return true;
      }
      if(holes[19].isEmpty() && ((holes[18].isEmpty() && !holes[17].isEmpty()))){
         return true;
      }
      if(holes[20].isEmpty() && ((holes[13].isEmpty() && !holes[6].isEmpty()) || holes[21].isEmpty() && !holes[22].isEmpty())){
         return true;
      }
      if(holes[21].isEmpty() && ((holes[14].isEmpty() && !holes[7].isEmpty()) || holes[22].isEmpty() && !holes[23].isEmpty())){
         return true;
      }
      if(holes[22].isEmpty() && ((holes[15].isEmpty() && !holes[8].isEmpty()) || holes[21].isEmpty() && !holes[20].isEmpty())
                               || holes[23].isEmpty() && !holes[24].isEmpty() || holes[27].isEmpty() && !holes[30].isEmpty()){
         return true;
      }
      if(holes[23].isEmpty() && ((holes[16].isEmpty() && !holes[9].isEmpty()) || holes[22].isEmpty() && !holes[21].isEmpty())
                               || holes[24].isEmpty() && !holes[25].isEmpty() || holes[28].isEmpty() && !holes[31].isEmpty()){
         return true;
      }
      if(holes[24].isEmpty() && ((holes[17].isEmpty() && !holes[10].isEmpty()) || holes[23].isEmpty() && !holes[22].isEmpty())
                               || holes[25].isEmpty() && !holes[26].isEmpty() || holes[29].isEmpty() && !holes[32].isEmpty()){
         return true;
      }
      if(holes[25].isEmpty() && ((holes[18].isEmpty() && !holes[11].isEmpty()) || holes[24].isEmpty() && !holes[23].isEmpty())){
         return true;
      }
      if(holes[26].isEmpty() && ((holes[25].isEmpty() && !holes[24].isEmpty()) || holes[19].isEmpty() && !holes[12].isEmpty())){
         return true;
      }
      if(holes[27].isEmpty() && ((holes[22].isEmpty() && !holes[15].isEmpty()) || holes[28].isEmpty() && !holes[29].isEmpty())){
         return true;
      }
      if(holes[28].isEmpty() && ((holes[23].isEmpty() && !holes[16].isEmpty()))){
         return true;
      }
      if(holes[29].isEmpty() && ((holes[24].isEmpty() && !holes[17].isEmpty()) || holes[28].isEmpty() && !holes[27].isEmpty())){
         return true;
      }
      if(holes[30].isEmpty() && ((holes[27].isEmpty() && !holes[22].isEmpty()) || holes[31].isEmpty() && !holes[32].isEmpty())){
         return true;
      }
      if(holes[31].isEmpty() && ((holes[28].isEmpty() && !holes[23].isEmpty()))){
         return true;
      }
      if(holes[32].isEmpty() && ((holes[29].isEmpty() && !holes[24].isEmpty()) || holes[31].isEmpty() && !holes[30].isEmpty())){
         return true;
      }
      return false;
      
   }

}