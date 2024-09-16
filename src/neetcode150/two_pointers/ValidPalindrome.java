package src.neetcode150.two_pointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }

        char[] palindromeCharArray = s.toCharArray();
        int last = palindromeCharArray.length -1;
        int start = 0;
        while(start < last) {

            while(start < last && !Character.isLetterOrDigit(palindromeCharArray[start]))
                start++;

            while(start < last && !Character.isLetterOrDigit(palindromeCharArray[last]))
                last--;

            if(Character.toLowerCase(palindromeCharArray[start]) != Character.toLowerCase(palindromeCharArray[last]))
                return false;

            start++;
            last--;

        }
        return true;
    }
}
