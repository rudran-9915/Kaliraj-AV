package GFG;
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); // Read number of test cases
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine()); // Read each test case value
            Solution ob = new Solution(); // Create an instance of Solution class
            System.out.println(ob.evenlyDivides(N)); // Invoke evenlyDivides method and print result
        }
    }
}


class Solution {
    static int evenlyDivides(int N) {
        int dup = N;
        int count = 0;
        while (N > 0) {
            int Dig = N % 10;
            if (Dig != 0 && dup % Dig == 0) {
                count++;
            }
            N = N / 10;
        }
        return (int)count;
    }
}
