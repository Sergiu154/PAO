
/**
 * Write a description of class Pb5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pb5
{
    public static boolean prim(int n){
        
        if( n <=1) return false;
        if( n == 2) return true;
        if( n %2 == 0) return false;
       for(int i =3;i*i<=n;i+=2){
            
                if( n%i == 0){
                return false;
            }
        } 
        return true;
    }
    
    public static void main(String[]args){
        
        System.out.println(prim(11));
    
    }
    
}
