package DSA;

import java.util.*;

public class insertion_sort {
    public static void main(String[] args) { //BC = O(N) , WC(N^2)
        int arr[] = {-3,18,-19,0,38562,2922};
        insertion(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void insertion(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
    }
}
