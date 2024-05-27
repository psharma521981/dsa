package graph;

import java.util.*;

public class TopologicalSort2 {
    //Input validation
    //initialize the graph
    //build the graph and indegree for each vertax
    //check of source and fetch it's children and decrese the indegree
    //add each source in to result

    public static List<Integer> sort(int vertices, int[][] edges) {
        //Input validation

        if(vertices  < 1 || edges.length < 1)
            return null;

        //initialize the graph
        List<Integer> output = new ArrayList<>();
        Map<Integer,List> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();
        Queue<Integer> sortedQueue = new LinkedList<>();

        for(int i=0; i<vertices; i++) {
            graph.put(i,new ArrayList<>());
            degree.put(i,0);
        }
        //Build the graph

        for(int i=0; i<vertices; i++) {
            int source = edges[i][0];
            int target = edges[i][1];
            graph.get(source).add(target);
            degree.put(target,degree.get(target) + 1);
        }
        //
        for(Map.Entry<Integer,Integer> entry : degree.entrySet()) {
            if(entry.getValue() == 0) {
                sortedQueue.add(entry.getKey());
            }
        }

        while(!sortedQueue.isEmpty()) {
            int element = sortedQueue.poll();
            output.add(element);
            List<Integer> children = graph.get(element);
            for(Integer child:children) {
                int degreeCount = degree.get(child);
                if(degreeCount==0)
                    sortedQueue.add(child);
                degree.put(child,degreeCount - 1);
            }
        }

        return output;
    }
    public static void main(String[] args) {
        List<Integer> result = TopologicalSort2.sort(4, new int[][] { new int[] { 3, 2 },
                new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort2.sort(5, new int[][] { new int[] { 4, 2 },
                new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort2.sort(7, new int[][] { new int[] { 6, 4 },
                new int[] { 6, 2 }, new int[] { 5, 3 }, new int[] { 5, 4 },
                new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
