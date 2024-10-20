package DSA;

import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int arr[] = {9,8,2,14,6,22,-1,3,0,99};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quick(int arr[],int low , int high){ //BC -O(nLogn), WC -O(N^2)
        if(low>=high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = arr[m];

        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int t = arr[s];
                arr[s]=arr[e];
                arr[e]=t;
                s++;
                e--;
            }
        }
        quick(arr, low, e);
        quick(arr, s, high);
    }
}
