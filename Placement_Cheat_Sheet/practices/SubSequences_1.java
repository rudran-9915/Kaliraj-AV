package practices;
import java.util.*;

public class SubSequences_1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findSubSequences(arr,0,new ArrayList<>(),target,res);
        for(ArrayList<Integer> y : res){
            System.out.println(y);
        }
        System.out.println(res.size());
        sc.close();
    }
    
    public static void findSubSequences(ArrayList<Integer> arr,int index,ArrayList<Integer> currentList,int target,ArrayList<ArrayList<Integer>> res){
        if(index>=arr.size()){
            int sum=0;
            for(int x : currentList){
                sum+=x;
            }
            if(target==sum){
                res.add(new ArrayList<>(currentList));
            }
             return;
        }
        
        currentList.add(arr.get(index));
        findSubSequences(arr,index+1,currentList,target,res);
        currentList.remove(currentList.size()-1);
        findSubSequences(arr,index+1,currentList,target,res);
    }
}