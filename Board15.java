public class Board15(){
   private Hole[] holes;
   
   public Board15(){
      this.holes = new Hole[15];
      for(Hole hole : holes){
         hole.empty = false;
      } 
      holes[5].empty = true; 
   }
   
   //Counts the remaining pegs on the board
   public int countPegs(){
      int count = 0;
      for(Hole hole : holes){
         if(!hole.isEmpty()){
            count++;
         }
      }
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
         // ?? Need a method in Hole to update these ??
         fromHole.empty = true
         toHole.empty = false
         findMiddleHole(fromHole,toHole).empty = true
      }
   }
   
   
   
   //Checks if the move is allowed
   private boolean isMoveLegal(Hole fromHole, toHole){
      return (isHoleTwoAway() && !findMiddleHole.isEmpty());
   }
   
   //Finds the hole that is between two holes
   private Hole findMiddleHole(Hole h1, Hole h2){
      Hole middleHole;
      
      int middleHoleRow = (h1.row + h2.row)/2;
      int middleHoleColumn = (h1.column + h2.column)/2
      //  search board array for hole with this coordinate
      for(Hole h: holes){
         if(h.row == middleHoleRow && h.column == middleHoleColumn){
            middleHole = h;
         }
      }
      
      return middleHole;
   }
   
   private boolean isHoleTwoAway(Hole h1, Hole h2){
      //check if hole is two rows away OR two "columns" away AND that the distance between either is 0 or 2
      return (
         (Math.abs(h1.row - h2.row) == 2 && Math.abs(h1.column - h2.column) == 0)
         || (Math.abs(h1.row - h2.row) == 0 && Math.abs(h1.column - h2.column) == 2)
         || (Math.abs(h1.row - h2.row) == 2 && Math.abs(h1.column - h2.column) == 2)
         )
   }

}