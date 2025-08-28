package src.neetcode150.array_and_hashing.prectice;

import java.util.ArrayList;
import java.util.List;

//check for validation
//check for each string, count lenght, add prefix & suffix
public class Encode_Decode_String {
    public String encode(List<String> strs) {

        if(strs == null)
            return null;

        StringBuilder sb = new StringBuilder();
        for(String str:strs) {

            int len = str.length();
            sb.append(len).append("_").append(str).append("##");
        }
        return sb.toString();

    }

    public List<String> decode(String str) {


        int start = 0;

        List<String> output = new ArrayList<>();
        int len = str.length(); ;
        while(len > 0) {
            String st = str.substring(0,str.indexOf("_"));
            int part_length = str.indexOf("_") + 1 + Integer.valueOf(st);
            String part = str.substring(str.indexOf("_") + 1, part_length);
            output.add(part);
            str = str.substring( part_length +"##".length(),str.length());
            len = str.length();
        }
        return output;
    }
    public static void main(String s[]) {
        Encode_Decode_String test = new Encode_Decode_String();
        List<String> input = new ArrayList<>();
        input.add("pankaj");
        input.add("mankaj");
        input.add("dunkajpankajpankaj");

        String encode = test.encode(input);
        input = test.decode(encode);

        for(String in:input) {
            System.out.println(in);
        }
    }
}
