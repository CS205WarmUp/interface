public class Board15{
   private Hole[] holes;
   
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
      // Difference between holes must be 2 or 4, with either row distance or column distance being 2
      int diffRow = h1.row() - h2.row();
      int diffCol = h1.column() - h2.column();
      return (
         ((Math.abs(diffRow + diffCol) == 2)
         || (Math.abs(diffRow + diffCol) ==4))
         &&
         (diffRow == 2 || diffCol == 2)
         );
   }

}