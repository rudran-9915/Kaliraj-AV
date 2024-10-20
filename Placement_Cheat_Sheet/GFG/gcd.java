package GFG;
import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int res = gcd(a, b); 
        System.out.println(res);
        
        sc.close();
    }
    
    public static int gcd(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int temp2 = b;
            b = a % b;
            a = temp2;
        }
        return a;
    }
}
