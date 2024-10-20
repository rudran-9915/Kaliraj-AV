package Problems;
import java.util.*;
public class knapSack {
    public static void main(String[] args){
        int wt[] = {3, 4, 6, 5};
        int val[] = {2, 3, 1, 4};
        int c =8;
        int n = wt.length;
        System.out.println(knapSackUtil(wt,val,c,n));

    }

    public static int knapSackUtil(int wt[],int val[],int c,int n){
        int dp[][] = new int[n][c+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return knapSackUtil2(wt, val, c, n-1,dp);
    }

    public static int knapSackUtil2(int wt[],int val[],int c,int n,int[][]dp){
        if(n==0){
            if(wt[0]<=c){
                return val[0];
            }
            else{
                return 0;
            }
        }

        if(dp[n][c]!=-1){
            return dp[n][c];
        }

        int notTaken = 0+knapSackUtil2(wt, val, c, n-1, dp);
        int taken = Integer.MIN_VALUE;
        if(wt[n]<=c){
            taken = val[n]+knapSackUtil2(wt, val, c-wt[n], n-1, dp);
        }
        dp[n][c] = Math.max(taken,notTaken);
        return dp[n][c];
    }
}
