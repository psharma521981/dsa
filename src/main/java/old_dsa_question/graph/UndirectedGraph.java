package src.miscellaneously.old.dsa.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraph {


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.printGraph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);

        graph.printGraph();

        graph.dfs(0);

        graph.bfs(0);

    }


}

/*
 * class Graph { int[][] vertax; int edge;
 * 
 * Graph(int node) { vertax = new int[node][node];
 * 
 * for (int i = 0; i < node; i++) { for (int j = 0; j < node; j++) {
 * vertax[i][j] = 0; } } edge = 0; }
 * 
 * void addEdge(int u,int v) { vertax[u][v] = 1; vertax[v][u] = 1; edge++;
 * 
 * }
 * 
 * void printGraph() { System.out.println(
 * "----------------------------------------------------------"); for (int i =
 * 0; i < vertax.length; i++) { for (int j = 0; j < vertax[0].length; j++) {
 * System.out.print("\t" + vertax[i][j]); } System.out.println(); } } }
 */

class Graph {
    List<Integer>[] vertax;
    int edge;

    Graph(int node) {
        vertax = new LinkedList[node];
        for (int i = 0; i < node; i++)
            vertax[i] = new LinkedList<Integer>();

        edge = 0;
    }

    void addEdge(int u,int v) {

        vertax[u].add(v);
        vertax[v].add(u);
        
        edge++;
        
    }

    void printGraph() {
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < vertax.length; i++) {
            for (Integer element : vertax[i])
                System.out.print("\t" + element);

            System.out.println();
        }

    }

    void dfs(int node) {
        System.out.println();
        System.out.println("-------------------------DFS------------------------------");

        boolean[] visited = new boolean[this.vertax.length];

        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        Stack<Integer> visitGraph = new Stack<Integer>();

        visitGraph.push(node);

        while (!visitGraph.isEmpty()) {

            int element = visitGraph.pop();
            if (!visited[element]) {
                visited[element] = true;
                System.out.print(element);
            }

            for (Integer traverseEle : vertax[element]) {
                if (!visited[traverseEle]) {
                    visitGraph.push(traverseEle);
                }
            }

        }
    }

    void bfs(int node) {
        System.out.println();
        System.out.println("-------------------------BFS------------------------------");

        boolean[] visited = new boolean[this.vertax.length];

        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        Queue<Integer> visitGraph = new LinkedList<Integer>();

        visitGraph.add(node);

        while (!visitGraph.isEmpty()) {

            int element = visitGraph.poll();
            if (!visited[element]) {
                visited[element] = true;
                System.out.print(element);
            }

            for (Integer traverseEle : vertax[element]) {
                if (!visited[traverseEle]) {
                    visitGraph.add(traverseEle);
                }
            }

        }
    }
}
