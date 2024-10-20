package practices;

import java.util.*;

public class ms {
    public static void main(String[] args) {
        int arr[] = {8,7,6,5,4,3,2,1,0};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;

        int left[] = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }

    public static int[] merge(int [] first,int [] second){
        int i=0;
        int j=0;
        int k=0;
        int mix[] = new int[first.length+second.length];

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }

        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<first.length){
            mix[k]=second[j];
            j++;
            k++;
        }

        return mix;
    }
}
