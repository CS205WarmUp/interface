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