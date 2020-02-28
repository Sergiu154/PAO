    
    /**
     * Write a description of class Pb2 here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    import java.util.Scanner;
    
    public class Pb2
    {
       public static void main(String[] args){
           
           Scanner scanner = new Scanner(System.in);
           
           System.out.println("First number:");
           String X = scanner.nextLine();
           int x  = Integer.parseInt(X);
           
           System.out.println("Second number:");
           String Y = scanner.nextLine();
           int y  = Integer.parseInt(Y);
           
           if( x < y){
               
               System.out.println( X + "<" + Y);
            }
            else if (x == y){
                
                System.out.println(X + "==" + Y);
            }
            else{
                System.out.println( X + ">" + Y);

            
        }
       
       

    
       
    }
}
