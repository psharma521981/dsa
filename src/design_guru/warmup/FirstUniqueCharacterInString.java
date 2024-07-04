package warmup;

public class FirstUniqueCharacterInString {
    //Another approach for this problem is to use String functions like first index and last index of character is same
    //If found something like this then return it or else return -1
    public int firstUniqChar(String s) {

        int[] duplicateArray = new int[26];
        int count = 0;
        int index;
        for(char c: s.toCharArray()) {
            index = c - 'a';
            duplicateArray[index]++;

        }

        for(int c=0;c < s.length();c++) {
            index =   s.charAt(c) - 'a';
            if(duplicateArray[index]==1)
                return c;
        }

        return -1;

    }
}
