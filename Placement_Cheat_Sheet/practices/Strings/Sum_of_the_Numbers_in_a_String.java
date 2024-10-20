package practices.Strings;
import java.util.*;

public class Sum_of_the_Numbers_in_a_String {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String  s = sc.nextLine();
        String temp="0";
        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                temp+=ch;
            }
            else{
                sum += Integer.parseInt(temp);
                temp="0";
            }
        }
        sum+=Integer.parseInt(temp);
        sc.close();
        System.out.println(sum);
    }
}
