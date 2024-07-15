package src.strings.patterns.problems;

public class LastWordLength {
    public static void main(String args[]) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon   "));
    }

    public static int lengthOfLastWord(String s){

        //Validation of Input
   if(s==null || s.length() == 0)
     return 0;
   String inputWithTriming = s.trim();

    int lengthOfWord = 0;

  for(int i = 0; i<inputWithTriming.length();i++) {

      if(inputWithTriming.charAt(i) == ' ') {
          lengthOfWord = 0;
      } else {
          lengthOfWord++;
      }
  }
  return lengthOfWord;
       /* String[] arrayOFString=s.split(" ");
        int size = arrayOFString.length;
        return arrayOFString[size-1].length();*/
    }
}
/*
  String[] arrayOFString=s.split(" ");
      int size = arrayOFString.length;
  return arrayOFString[size-1].length();
 */

