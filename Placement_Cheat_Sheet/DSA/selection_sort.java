package DSA;

import java.util.*;

public class selection_sort {
    public static void main(String[] args) { //BC,WC - O(N^2)
        int arr[] = {5,9,1,2,3,45,6,7,-1,0};
        selection(arr);
        System.out.println(Arrays.toString(arr));`
    }

    public static void selection(int []arr){
        for(int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int max = getMax(arr,0,last);
            swap(arr,max,last);
        }
    }

    public static void swap(int arr[],int first,int last){
        int temp = arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }

    public static int getMax(int arr[],int start,int end){
        int currMax = start;
        for(int i=start;i<=end;i++){
            if(arr[i]>arr[currMax]){
                currMax=i;
            }
        }
        return currMax;
    }
}
