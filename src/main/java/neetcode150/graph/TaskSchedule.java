package src.neetcode150.graph;

import java.util.*;

public class TaskSchedule {
    public boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

        //Validate the input
        if(prerequisites==null || tasks==0)
            return false;

        //Create graph and initialize the degree
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();
        //Empty graph
        for(int i=0;i<tasks;i++) {
            graph.put(i,new ArrayList<>());
            degree.put(i,0);
        }
        //Inittialize the graph
        for(int[] row:prerequisites) {
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
        List<Integer> result= new ArrayList<>();
        //repeate the same until queue is empty
        //Add each zero degree node to result and if result size is total no. node then return true or else false
        while(!degreeQueue.isEmpty()) {
            int node = degreeQueue.poll();
            result.add(node);
            List<Integer> children = graph.get(node);

            for(Integer child:children) {
                degree.put(child,degree.get(child) -1);
                if(degree.get(child)==0) {
                    degreeQueue.add(child);
                }
            }
        }

        return (result.size() == tasks) ? true : false;
    }
    public static void main(String[] args) {
        TaskSchedule sol = new TaskSchedule();
        boolean result = sol.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = sol.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = sol.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 },
                new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 1, 4 },
                new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
