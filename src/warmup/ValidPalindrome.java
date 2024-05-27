package warmup;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        //Check for validation
        //Convert the String into Array
        //initialize left or right pointers
        //loop until left not equal to right
        //ignore each character untill it is letter from left
        //repeat same from right and compare left and right letter is same or not
        //if not same not palindrome
        if(s==null)
            return false;

        int start = 0;
        int end = s.length()-1;

        while(start<end) {
            while(!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            while(!Character.isLetterOrDigit(s.charAt(end)))
                end--;

            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
                return false;

            start++;
            end--;

        }
        return true;
    }
    /* Alternative solution
    int start = 0;
    int end = s.length()-1;

    while(start<end) {
       while(!Character.isLetterOrDigit(s.charAt(start)))
       start++;
      while(!Character.isLetterOrDigit(s.charAt(end)))
       end--;

       if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
        return false;

        start++;
        end--;

    }
    return true;
     */
    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        // Test case 1: "A man, a plan, a canal, Panama!"
        // Expected output: true
        System.out.println(sol.isPalindrome("A man, a plan, a canal, Panama!"));

        // Test case 2: "race a car"
        // Expected output: false
        System.out.println(sol.isPalindrome("race a car"));

        // Test case 3: "Was it a car or a cat I saw?"
        // Expected output: true
        System.out.println(sol.isPalindrome("Was it a car or a cat I saw?"));

        // Test case 4: "Madam, in Eden, I'm Adam."
        // Expected output: true
        System.out.println(sol.isPalindrome("Madam, in Eden, I'm Adam."));

        // Test case 5: "empty string"
        // Expected output: true
        System.out.println(sol.isPalindrome(""));
    }
}
