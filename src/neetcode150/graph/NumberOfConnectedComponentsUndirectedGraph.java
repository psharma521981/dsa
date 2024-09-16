package src.neetcode150.graph;

import java.util.*;

public class NumberOfConnectedComponentsUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        //Validate the input
        if(edges==null || n==0)
            return 0;

        //Create graph and initialize the degree
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();
        //Empty graph
        for(int i=0;i<n;i++) {
            graph.put(i,new ArrayList<>());
            degree.put(i,0);
        }
        //Inittialize the graph
        for(int[] row:edges) {
            int parent = row[1];
            int child = row[0];
            graph.get(parent).add(child);
            degree.put(child,degree.get(child) + 1);
        }
        //find the source where incoming degree is zero
        //Put the source into one queue and iterate of it's children and decrese the degree
        //one found any child with degree zero add into the queue
        Queue<Integer> degreeQueue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:degree.entrySet()) {
            if(entry.getValue() == 0) {
                degreeQueue.add(entry.getKey());
            }
        }
        return degreeQueue.size();
    }
    public static void main(String[] args) {
        NumberOfConnectedComponentsUndirectedGraph sol = new NumberOfConnectedComponentsUndirectedGraph();
        System.out.println(sol.countComponents(4, new int[][]{{0,1},{2,3}}));  //Expected 2
        System.out.println(sol.countComponents(5, new int[][]{{0,1},{1,2},{2,0}}));  //Expected 3
        System.out.println(sol.countComponents(3, new int[][]{}));  //Expected 3
    }
}
