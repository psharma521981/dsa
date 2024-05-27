package warmup;

public class Pangram {
    public boolean checkIfPangram(String sentence) {
       //Validate your input
      //Iterate over character array and check if each character is a small case or upper case character(using ascii)
      //stored it according to it's index into an array
      //Iterate over array and check any index is left as '0'

        //Approach Second
        //Do validation by checking empty or length lesss then 26
        //Create set of Character type
        //Convert string into character array
        //iterate over  array and check each character is letter or not.
        //if it is letter then store into the set
        // at the end check the size of the set

        if(sentence==null || sentence.length() < 26)
            return false;
        int[] numericChar = new int[26];
        for(int i=0;i<sentence.length();i++) {
            if(sentence.charAt(i) >= 65 && sentence.charAt(i) <=90)
                numericChar[sentence.charAt(i) - 65] = 1;
            else if(sentence.charAt(i) >= 97 && sentence.charAt(i) <=122)
                numericChar[sentence.charAt(i) - 97] = 1;
        }
        for(int i=0;i<numericChar.length;i++) {
            if(numericChar[i] ==0)
                return false;
        }
        return true;
    }
    /*
    Alternate Solution

    Set<Character> seen = new HashSet<>();
    for (char currChar : sentence.toLowerCase().toCharArray()) {
        if (Character.isLetter(currChar)) {
          seen.add(currChar);
      }
    }
    return seen.size() == 26;
     */
    public static void main(String[] args) {
        Pangram sol = new Pangram();

        // Test case 1: "TheQuickBrownFoxJumpsOverTheLazyDog"
        // Expected output: true
        System.out.println(sol.checkIfPangram("TheQuickBrownFoxJumpsOverTheLazyDog"));

        // Test case 2: "This is not a pangram"
        // Expected output: false
        System.out.println(sol.checkIfPangram("This is not a pangram"));

        // Test case 3: "abcdef ghijkl mnopqr stuvwxyz"
        // Expected output: true
        System.out.println(sol.checkIfPangram("abcdef ghijkl mnopqr stuvwxyz"));

        // Test case 4: ""
        // Expected output: false
        System.out.println(sol.checkIfPangram(""));

        // Test case 5: "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        // Expected output: true
        System.out.println(sol.checkIfPangram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}
