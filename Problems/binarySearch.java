package Problems;

import java.util.*;
public class binarySearch {
    public static void main(String[] args){
        int[] arr ={5,8,9,2,12,3,4,66};
        int k = 55 ;
        Arrays.sort(arr);
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>k){
                high = mid-1;
            }
            else if(arr[mid]<k){
                low=mid+1;
            }
            else{
                System.out.println("Found");
                System.exit(1);
            }       
         }
         System.out.println("Not found");
    }
}
