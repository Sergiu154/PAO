
/**
 * Write a description of class Pb6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pb6
{
    public static int fib(int n){
        
        int k = 2;
        int a = 1, b = 1,c = 0;
        if( n == 1 ||  n == 2){
            return 1;
        }
        else{
            while( k <n ){
            
                c = a +b;
                a = b;
                b = c;
                k+=1;
            }
            return c;
        }
        
        
    }
    public static void main(String[]args){
        
        System.out.println(fib(6));
    
    }
}
