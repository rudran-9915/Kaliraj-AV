package Problems;
import java.util.*;
public class longestCommonSubstring {
    public static void main(String[] args){
        String s1 = "peace";
        String s2 = "race";

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for(int[] row:dp){
            Arrays.fill(row,0);
        }

        int ans =0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    int val = 1+dp[i-1][j-1];
                    dp[i][j] = val;
                    ans = Math.max(ans,val);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        System.out.println(ans);
    }
}
