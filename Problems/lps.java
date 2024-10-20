package Problems;
import java.util.*;
public class lps {
    public static void main(String [] args){
        String s1 = "bbabcbcab";
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for(int [] row : dp){
            Arrays.fill(row,0);
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
