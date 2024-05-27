package graph;

import java.util.*;

public class TasksSchedulingOrder {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        //Validate input
        if(tasks <=0)
            return null;
        //Create empty graph and degree of incoming edges to vertex
        Map<Integer, List> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();

        for(int i=0;i<tasks;i++) {
            graph.put(i,new ArrayList());
            degree.put(i,0);
        }
        for(int i=0;i<prerequisites.length;i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            degree.put(child,degree.get(child) + 1);
        }
        //Look for vertext with 0 incoming edges OR finding the source
        Queue<Integer> entryQueue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:degree.entrySet()) {
            //Add to the queue
            if(entry.getValue() == 0)
                entryQueue.add(entry.getKey());
        }
        List<Integer> order = new ArrayList<>();
        //Traverse the queue to define the order of output
        while(!entryQueue.isEmpty()) {
            int source = entryQueue.poll();
            order.add(source);

            List<Integer> children = graph.get(source);

            for(Integer child : children) {
                degree.put(child,degree.get(child) - 1);

                if(degree.get(child) == 0)
                    entryQueue.add(child);
            }
        }
        if(tasks == order.size())
            return order;
        else
            return new ArrayList<>();
    }
    public static void main(String[] args) {
        List<Integer> result = TasksSchedulingOrder.findOrder(3, new int[][] {
                new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TasksSchedulingOrder.findOrder(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TasksSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 },
                new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 },
                new int[] { 1, 3 } });
        System.out.println(result);

        result = TasksSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 2 },
                new int[] { 1, 2}, new int[] { 2, 0 }});

        System.out.println(result);
    }
}
