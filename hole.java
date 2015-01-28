//joel hernandez 
//cs 205
//warm up project


public class hole{
//variables for the hole object
boolean hole=true;
String name;
 
//constructor that takes in a name and a boolean to check if filled
hole(String Name,boolean empty){

name=Name;
hole=empty;

}

//method that check if hole is empty 
public boolean isEmpty(){
   return hole;
}

//method that gives the user the name of the hole
public String name(){
   return name;   
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
