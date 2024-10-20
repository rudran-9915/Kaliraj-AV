package Problems;

import java.util.*;
public class lcs{
    public static void main(String[] args){
        String s = "ABC";
        String t = "CBA";
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m+1][n+1];

        for(int[] row:dp ){
            Arrays.fill(row,0);
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}