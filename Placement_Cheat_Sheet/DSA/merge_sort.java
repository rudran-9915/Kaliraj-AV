package DSA;

import java.util.Arrays;
public class merge_sort {
    public static void main(String[] args) {
        int arr[] = {5,9,1,2,3,45,6,7,-1,0};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));  
    }
    public static int[] mergeSort(int arr[]){ //divide
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int left[]=mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int right[]=mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);

    }
    public static int[] merge(int first[],int second[]){ //merge
        int i=0;
        int j=0;
        int k=0;
        int mix[] = new int[first.length+second.length];

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k++]=first[i++];
            }                                            //2,3,4
                                                         //9,10,11,9
            else{
            mix[k++]=second[j++];
            }
            
        }
        while(i<first.length){
            mix[k++]=first[i++];
            
        }
        while(j<second.length){
            mix[k++]=second[j++];
        }
        return mix;

    }
}
