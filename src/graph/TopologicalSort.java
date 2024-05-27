package graph;

import java.util.*;

public class TopologicalSort {
    // Initialize graph
    //Build graph
    //Travese graph for all source without any incoming edges
    //Sort them by adding children having 0 incoming edges
    //Check for cycle
    //Return sorted order

    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        //Initialize graph
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> vertexDegree = new HashMap<>();
        Queue<Integer> sourceSet = new LinkedList<>();

        for(int i=0;i<vertices;i++) {
            graph.put(i,new ArrayList<Integer>());
            vertexDegree.put(i,0);
        }

        //Build the graph
        for(int i=0;i < edges.length;i++) {
            int source = edges[i][0];
            int target = edges[i][1];

            graph.get(source).add(target);
            vertexDegree.put(target,vertexDegree.get(target) + 1);
        }

        //Traverse Graph for nodes where degree is 0
        for(Map.Entry<Integer,Integer> entry : vertexDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sourceSet.add(entry.getKey());
            }
        }
        //Sort the vertex and add them into queue
        while(!sourceSet.isEmpty()) {

            int source = sourceSet.poll();
            result.add(source);

            for(Integer children : graph.get(source)) {
                vertexDegree.put(children,vertexDegree.get(children) -  1);

                if(vertexDegree.get(children) ==0)
                    sourceSet.add(children);
            }
        }
        //Check for graph cycle
       if(result.size() != vertices)
       return new ArrayList<>();

        return result;
    }
    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4, new int[][] { new int[] { 3, 2 },
                new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 },
                new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 },
                new int[] { 6, 2 }, new int[] { 5, 3 }, new int[] { 5, 4 },
                new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
