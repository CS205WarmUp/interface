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

}