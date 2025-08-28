package src.miscellaneously.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  To execute Java, please define "static void main" on a class
  named Solution.
 
  If you need more classes, simply define them inline.

 Find the start/end of the journey given list of boarding passes

A ---------->C----------->D----------->E-----------> B

A->C (pass 1) - BP1
C->D (pass 2) - BP2 
D->E (pass 3) - BP3
E->B (pass 4) - BP4

public class BP  
{
   public String start; 
   public String end; 
      
   // getters and setters..
}

Input
1. Example
A ---------->C----------->D----------->E-----------> B

D->E  (BP3)
A->C  (BP1)
C->D  (BP2)
E->B  (BP4)

2. Example
V ---------->L----------->M----------->F-----------> C
F->C
V->L
L->M
M->F */
class BP {

    String from;
    String to;

    BP(String from, String to) {
        this.from = from;
        this.to = to;
    }

}
public class FromToBoardingPassPC {

    public static void main(String[] args) {
        List<BP> listOfBP = new ArrayList<>();
        listOfBP.add(new BP("A", "C"));
        listOfBP.add(new BP("C", "D"));
        listOfBP.add(new BP("D", "E"));
        listOfBP.add(new BP("E", "B"));

        generateRoute(listOfBP);

    }

    private static void generateRoute(List<BP> listOfBP) {
        Map<String,String> routeMap = new HashMap<>();
        Map<String, String> reverseRouteMap = new HashMap<>();
        
        listOfBP.forEach(bp -> routeMap.put(bp.from, bp.to));
        
        listOfBP.forEach(bp -> reverseRouteMap.put(bp.to, bp.from));

        String source = null;
        for (Map.Entry<String, String> entry : routeMap.entrySet()) {
            if (!reverseRouteMap.containsKey(entry.getKey())) {
                source = entry.getKey();
            }
        }

        String to = routeMap.get(source);
        StringBuilder sb = new StringBuilder();
        while (to != null) {
            sb.append(source + " -> " + to).append("\n");
            source = to;
            to = routeMap.get(source);
        }
        System.out.println(sb);
    }

    private static void generateRouteTopologicalSort(List<BP> listOfBP) {

    }

}
