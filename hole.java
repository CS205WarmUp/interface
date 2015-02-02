//joel hernandez 
//cs 205
//warm up project


public class Hole{
//variables for the hole object
boolean hole;
int row;
int column;
 
//constructor that takes in a name and a boolean to check if filled
Hole(int rowA, int columnB,boolean empty){

row=rowA;
column=columnB;
hole=empty;

}

//method that check if hole is empty 
public boolean isEmpty(){
   return hole;
}

//method that returns the row that the hole is on
public int row(){
   return row;   
}

//method that returns the column that the hole is on
public int column(){
   return column;
}

//changes the hole to empty or filled
public void changeHole()
{
   if (hole==false){
      hole=true;
   }
   else hole=false;
} 

}
