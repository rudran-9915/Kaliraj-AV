package Problems;

public class EditDis {
    public static void main(String[] args){
        String s ="horse";
        String t ="ros";
        int m = s.length();
        int n = t.length();

        int dp[][]= new int[m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0]=i;
        for(int j=0;j<=n;j++) dp[0][j]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                   int top = dp[i-1][j];
                   int topLeft = dp[i-1][j-1];
                   int left = dp[i][j-1];
                   dp[i][j]=Math.min(top,Math.min(topLeft,left))+1;
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
