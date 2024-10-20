package DSA;

import java.util.*;

public class bubble_sort {
    public static void main(String[] args){ // In-place algo , stable algo , B.C - O(n) , W.C - O(n^2)
        int arr[] = {1,2,3,4,5,6,7};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int arr[]){
        for(int i=0;i<arr.length;i++){
            boolean swap=false;
            for(int j=1;j<=arr.length-i-1;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
}
