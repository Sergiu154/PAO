
/**
 * Write a description of class Pb3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Pb3
{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number:");
        
        int n = Integer.parseInt(scanner.nextLine());
        
        long sum = 0;
        
        for( int i = 1; i <=n;i++){
            
            if( i%3 == 0 && i%5 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
        
    }
}
