
/**
 * Write a description of class Pb4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pb4
{
     public static long factorial(int n){
                    
                 long P = 1L;
                 for(int f = 2; f <= n;f++){
                     P *= f;
                    }
                 System.out.println(P);
                 return P;
            
        }
        
    public static void main(String[] args){
        
        factorial(5);
        
       
    }
    
   
        
}
