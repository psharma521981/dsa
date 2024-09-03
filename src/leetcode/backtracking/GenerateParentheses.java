package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] s){
        int len =3;
        List<String> output =new ArrayList<>();
        char[] input = new char[2];
            input[0] = '{';
            input[1] = '}';
        generateParenthisis(input,0,len,output,"");
    }

    private static void generateParenthisis(char[] input,int len, List<String> output,String temp) {

        if(temp.length() == len && isValidPattern(temp)) {
            output.add(new String(temp));
        }
            temp = temp+input[0];
            generateParenthisis(input,len,output,temp);
            temp = temp.substring(0,temp.length()-1);
            temp = temp+input[1];
            generateParenthisis(input,len,output,temp);
            temp = temp.substring(0,temp.length()-1);
        }


    }

    private static boolean isValidPattern(String temp) {

    }


}
