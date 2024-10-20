package Problems;
import java.util.*;
public class lis {
    public static void main(String[] args) {
        int arr[] = {3,4,56,7,8,9,1,2,34};
        int n = arr.length;
        int ans[] = new int[n];

        Arrays.fill(ans,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(ans[j]+1>ans[i]){
                    ans[i]=1+ans[j];
                    }
                }
            }
        }

        int max =0;
        for(int i=0;i<n;i++){
            if(ans[i]>ans[max]){
                max=i;
            }
        }
        System.out.println(ans[max]);
    }
}
