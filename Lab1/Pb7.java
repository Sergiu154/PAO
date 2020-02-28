
/**
 * Write a description of class Pb7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pb7
{
    
    public static int factPrim(int n){
        
        int d = 2;
        
        while(n!=1){
            
            int p = 0;
            while(n%d ==0){
                n/=d;
                p++;
            }
            d++;
        }
        return d - 1;
        
    }
    public static void main(String []args){
        
        System.out.println(factPrim(20));
    
    }
}
