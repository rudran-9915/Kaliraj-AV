package GFG;
import java.io.*;


class odd_even
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            oddEvenC ob = new oddEvenC();
            System.out.println(ob.oddEven(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class oddEvenC{
    String oddEven(int N){ //static method
        if(N%2 ==0){
            return "even";
        }
        else {
            return "odd";
        }
    }
}