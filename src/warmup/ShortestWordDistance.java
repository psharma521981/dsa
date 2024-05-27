package warmup;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        // TODO: Write your code here
        //Validate the input. Check null and array size
        //intitialize search string index in main string as -1
        //put condition to check absolute differnce between both string index location
        //found the minimum absolute difference

        if(words==null || words.length < 2 || word1==null || word2==null)
            return 0;

        int word1Pos = -1;
        int word2Pos = -1;
        int minDistance = Integer.MAX_VALUE;
        int i = 0;
        while(i<words.length) {

            if(words[i].equalsIgnoreCase(word1))
                word1Pos = i;
            if(words[i].equalsIgnoreCase(word2))
                word2Pos = i;
            if(word1Pos!=-1 && word2Pos!=-1)
                minDistance = Math.min(minDistance,Math.abs(word1Pos-word2Pos));

            i++;
        }
        return minDistance;
    }
    /* Alternative solution
    if(words==null || words.length < 2 || word1==null || word2==null)
     return 0;

     int word1Pos = -1;
     int word2Pos = -1;
     int minDistance = Integer.MAX_VALUE;
     int i = 0;
     while(i<words.length) {

      if(words[i].equalsIgnoreCase(word1))
         word1Pos = i;
      if(words[i].equalsIgnoreCase(word2))
         word2Pos = i;
      if(word1Pos!=-1 && word2Pos!=-1)
         minDistance = Math.min(minDistance,Math.abs(word1Pos-word2Pos));

       i++;
     }
    return minDistance;
     */
    public static void main(String[] args) {
        ShortestWordDistance solution = new ShortestWordDistance();

        // Test case 1
        String[] words1 = { "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" };
        String word11 = "fox";
        String word21 = "dog";
        int expectedOutput1 = 5;
        int actualOutput1 = solution.shortestDistance(words1, word11, word21);
        System.out.println("Test case 1: " + (expectedOutput1 == actualOutput1));

        // Test case 2
        String[] words2 = { "a", "b", "c", "d", "a", "b" };
        String word12 = "a";
        String word22 = "b";
        int expectedOutput2 = 1;
        int actualOutput2 = solution.shortestDistance(words2, word12, word22);
        System.out.println("Test case 2: " + (expectedOutput2 == actualOutput2));

        // Test case 3
        String[] words3 = { "a", "c", "d", "b", "a" };
        String word13 = "a";
        String word23 = "b";
        int expectedOutput3 = 1;
        int actualOutput3 = solution.shortestDistance(words3, word13, word23);
        System.out.println("Test case 3: " + (expectedOutput3 == actualOutput3));

        // Test case 4
        String[] words4 = { "a", "b", "c", "d", "e" };
        String word14 = "a";
        String word24 = "e";
        int expectedOutput4 = 4;
        int actualOutput4 = solution.shortestDistance(words4, word14, word24);
        System.out.println("Test case 4: " + (expectedOutput4 == actualOutput4));
    }
}
