package src.miscellaneously.interview;


import java.util.*;

/*

Parse the inout given and separetd by spaces and found top k users for most of the words

Need to check better parsing logic.
 */
public class ParsingInoutAndFoundTopK_Snap {
    public static void main(String[] s) {

        String input = "12:03:55 12:05:55 [user3] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "01:03:55 12:05:55 [user1] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "02:03:55 12:05:55 [user2] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "03:03:55 12:05:55 [user1] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "12:03:55 12:05:55 [user2] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "12:03:55 12:05:55 [user1] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "12:03:55 12:05:55 [user1] Sds sdsdsd dssdsd døds ffddf dfdf\n" +
                "12:03:55 12:05:55 [user2] Sds sdsdsd dssdsd døds ffddf dfdf";

        String[] modifiedInput = input.split("\\n");
       List<String> output = findTopKUsers(parseInput(modifiedInput),2);
        output.forEach(System.out::println);

    }
   public static Map<String,Integer> parseInput(String[] inputArray) {
       Map<String,Integer> userToMessageMap = new HashMap<>();
       for(String input:inputArray){
           String message[] = input.split("\\s+");

           String userId = message[2];
           String msg = message[3];
           userToMessageMap.put(userId,userToMessageMap.getOrDefault(userId,0)+msg.length());
       }
       return userToMessageMap;
   }
    public static List<String> findTopKUsers(Map<String,Integer> userToMessageMap, int k) {

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> entry : userToMessageMap.entrySet()) {
            queue.add(entry);
            while (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> output = new ArrayList<>();
        while(!queue.isEmpty()) {
            output.add(queue.poll().getKey());
        }
        return output;
    }
}
