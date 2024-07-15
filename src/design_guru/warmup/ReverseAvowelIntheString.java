package warmup;

public class ReverseAvowelIntheString {
    //Validate the input
    //initialize a set with vowel
    //convert string into character array
    //check each character with vowel from left if found then found vowel from right if found then swap
    //loop would be running untill left point does not meet right pointers
    public String reverseVowels(String s) {
        if(s==null || s.length() == 1)
            return s;

        int start = 0;
        int end = s.length()-1;

        char[] reverseVowelsArray = s.toCharArray();
        String vowels = "aeiouAEIOU";

        while(start<end) {
            while(start<end && !vowels.contains(String.valueOf(reverseVowelsArray[start])))
                start++;

            while(start<end && !vowels.contains(String.valueOf(reverseVowelsArray[end])))
                end--;

            char temp = reverseVowelsArray[start];
            reverseVowelsArray[start] = reverseVowelsArray[end];
            reverseVowelsArray[end] = temp;

            start++;
            end--;
        }

        return String.valueOf(reverseVowelsArray);
    }
    /* Alternative solution
    char[] reverseVowelsArray = s.toCharArray();
    String vowels = "aeiouAEIOU";

    while(start<end) {
        while(start<end && !vowels.contains(String.valueOf(reverseVowelsArray[start])))
         start++;

        while(start<end && !vowels.contains(String.valueOf(reverseVowelsArray[end])))
         end--;

         char temp = reverseVowelsArray[start];
         reverseVowelsArray[start] = reverseVowelsArray[end];
         reverseVowelsArray[end] = temp;

         start++;
         end--;
    }

    return String.valueOf(reverseVowelsArray);
     */
    public static void main(String[] args) {
        ReverseAvowelIntheString solution = new ReverseAvowelIntheString();

        // Test Case 1
        String s1 = "hello";
        String expectedOutput1 = "holle";
        String actualOutput1 = solution.reverseVowels(s1);
        System.out.println("Test Case 1: " + (expectedOutput1.equals(actualOutput1)));

        // Test Case 2
        String s2 = "DesignGUrus";
        String expectedOutput2 = "DusUgnGires";
        String actualOutput2 = solution.reverseVowels(s2);
        System.out.println("Test Case 2: " + (expectedOutput2.equals(actualOutput2)));

        // Test Case 3
        String s3 = "AEIOU";
        String expectedOutput3 = "UOIEA";
        String actualOutput3 = solution.reverseVowels(s3);
        System.out.println("Test Case 3: " + (expectedOutput3.equals(actualOutput3)));

        // Test Case 4
        String s4 = "aA";
        String expectedOutput4 = "Aa";
        String actualOutput4 = solution.reverseVowels(s4);
        System.out.println("Test Case 4: " + (expectedOutput4.equals(actualOutput4)));

        // Test Case 5
        String s5 = "";
        String expectedOutput5 = "";
        String actualOutput5 = solution.reverseVowels(s5);
        System.out.println("Test Case 5: " + (expectedOutput5.equals(actualOutput5)));
    }
}
