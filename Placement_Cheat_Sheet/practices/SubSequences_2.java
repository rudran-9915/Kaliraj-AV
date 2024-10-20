package practices;
import java.util.*;

public class SubSequences_2 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        findSubSeq(str,0,sb);
        sc.close();

    }

    public static void findSubSeq(String str,int index,StringBuilder current){
        if(index==str.length()){
            System.out.println(current.toString());
            return;
        }
        current.append(str.charAt(index));
        findSubSeq(str, index+1, current);
        current.deleteCharAt(current.length()-1);
        findSubSeq(str, index+1, current);

    }
}
