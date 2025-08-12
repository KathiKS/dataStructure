package graph;

import java.util.Arrays;

public class Dijkstra {
    static int[][] adjacencyMatrix;
    static int numVertices;

    public Dijkstra(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(adjacencyMatrix[i], 0);
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight; 
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public void dijkstra(int start) {
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + adjacencyMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjacencyMatrix[u][v];
                }
            }
        }

        printSolution(dist, start);
    }

    																																																																		private void printSolution(int[] dist, int start) {
        System.out.println("Vertex \t Distance from Source " + start);
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Dijkstra graph = new Dijkstra(vertices);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 0, 7);
        graph.addEdge(3, 2, 6);
        graph.addEdge(4, 1, 3);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);
        graph.dijkstra(0);
    }
}
