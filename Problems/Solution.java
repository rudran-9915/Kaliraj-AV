package Problems;

public class Solution {
    public static void main(String [] args)
    {
        System.out.println(gcd(10,5));
    }
    public static int gcd(int a, int b) {
        while(b!=0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
   