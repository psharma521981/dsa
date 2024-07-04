package warmup;

public class ValidAnagram {

    //Validate the input empty and length of both string
    //intitialize int array for each ascii value of first string
    //check other string ascii value and if not matching return false or else true
    //Alternative solution also can derived if HashMap is used to store the frequency

    public boolean isAnagram(String s, String t) {

        if(s==null || t==null)
            return false;

        int[] charArray = new int[26];
        int index =0;

        while(index<=s.length()-1) {
            charArray[s.charAt(index)-97]++;
            index++;
        }
        index=0;
        while(index<=t.length()-1) {
            charArray[t.charAt(index)-97]--;
            index++;
        }
        index = 0;
        while(index<=charArray.length-1) {
            if(charArray[index] < 0 || charArray[index] >=1)
                return false;

            index++;
        }

        return true;
    }
    /*  Alternative solution
    if (s.length() != t.length()) {
      return false;
    }

    // Create a hash map to store the frequency of characters in both strings.
    HashMap<Character, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      // Increment the frequency of the character in string s.
      freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
      // Decrement the frequency of the character in string t.
      freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) - 1);
    }

    // Check if the frequency of all characters is 0.
    for (char chr : freqMap.keySet()) {
      if (freqMap.get(chr) != 0) {
        return false;
      }
    }

    // If all characters have a frequency of 0, this means that 't' is an anagram of 's'.
    return true;
     */
    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();

        // Test case 1
        String s1 = "listen";
        String t1 = "silent";
        System.out.println(sol.isAnagram(s1, t1)); // Expected output: true

        // Test case 2
        String s2 = "hello";
        String t2 = "world";
        System.out.println(sol.isAnagram(s2, t2)); // Expected output: false

        // Test case 3
        String s3 = "anagram";
        String t3 = "nagaram";
        System.out.println(sol.isAnagram(s3, t3)); // Expected output: true

        // Test case 4
        String s4 = "rat";
        String t4 = "car";
        System.out.println(sol.isAnagram(s4, t4)); // Expected output: false

        // Test case 5
        String s5 = "";
        String t5 = "";
        System.out.println(sol.isAnagram(s5, t5)); // Expected output: true
    }
}
