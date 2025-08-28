package src.miscellaneously.interview;

public class FindEmbeddedWord {

    public static void main(String[] args) {
        String[] s = new String[] { "cat", "rate", "min", "baby" };
        System.out.println(find_embedded_word(s, "catrina"));
        System.out.println(find_embedded_word(s, "xyzxyzbb"));
        System.out.println(find_embedded_word(s, "axyzxyzbb"));

    }

    /*public static String find_embedded_word(String[] words, String mainString) {

        if (mainString == null || mainString.isEmpty() || words.length < 1)
            return null;

        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> tmpCountMap = new HashMap<>();

        for (int i = 0; i < mainString.length(); i++) {
            Character ch = mainString.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < words.length; i++) {
            tmpCountMap = new HashMap(count);
            String str = words[i];
            int j = 0;
            while (j < str.length()) {
                Character ch = str.charAt(j);

                if (count.get(ch) == null || count.get(ch) == 0) {
                    break;
                } else {
                    count.put(ch, count.get(ch) - 1);
                }
                j++;
            }

            if (str.length() == j)
                return str;

            count = new HashMap(tmpCountMap);
        }

        return null;

    }*/

    public static String find_embedded_word(String[] words, String mainString) {

        if (mainString == null || mainString.isEmpty() || words.length < 1)
            return null;

        int[] mainStringCount = new int[26];

        for (int i = 0; i < mainString.length(); i++) {
            Character ch = mainString.charAt(i);
            mainStringCount[ch - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int j = 0;
            int[] stringCount = new int[26];
            while (j < str.length()) {
                Character ch = str.charAt(j);
                if (mainStringCount[ch - 'a'] == 0) {
                    break;
                } else {
                    stringCount[ch - 'a']++;
                }
                j++;
            }
            boolean found = true;
            if (j == str.length()) {
                for (int k = 0; k < stringCount.length; k++) {
                    if (stringCount[k] != 0 && !(stringCount[k] <= mainStringCount[k])) {
                        found = false;
                    }
                }
                if (found)
                    return str;
            }
        }

        return null;

    }

}
