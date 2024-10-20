package GFG;
import java.io.*;
import java.math.*;


class last_digit {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int getLastDigit(String a, String b) { // static method
       BigInteger base = new BigInteger(a);
       BigInteger exp = new BigInteger(b);
       BigInteger mod = BigInteger.TEN;

       BigInteger res = base.modPow(exp, mod);
       return res.intValue();
    }
};