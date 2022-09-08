package Graphs;

import java.util.Scanner;

public class DepthFirstTraversal {
    /*Depth-First Traversal*/
    /* Time Complexity - O(V^2) V: Vertices/No. of nodes - In case of Adjacency Matrix */
    /* Time Complexity - O(V + 2E) V: Vertices, E: Edges - In case of Adjacency List */
    public static void DFTraversal(int adjMatrix[][]) {
        // Keep track of already visited nodes so
        // it won't include in next recursion.
        boolean visited[] = new boolean[adjMatrix.length];

        // For Connected and Disconnected Graph
        for (int i = 0; i < adjMatrix.length; i++) {
            // After visiting all the nodes of graph and which are not visited yet
            // call will be made on that nodes.
            if (!visited[i]) {
                // Keep the track of source(currentVertex) starting from i.
                DFTraversal(adjMatrix, i, visited);
                System.out.println();
            }

        }
    }

    public static void DFTraversal(int adjMatrix[][], int currentVertex, boolean visited[]) {
        // Visited nodes will be marked as True.
        visited[currentVertex] =  true;
        // Explore currentVertex
        System.out.print(currentVertex + " ");
        // Finding Neighbor
        for (int i = 0; i < adjMatrix.length; i++) {
            // In adjacent matrix values assigned to vertices as 1 are neighbors
            // of currentVertex
            // Neighbor shouldn't visit the same node again
            if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
                // i is neighbor of currentVertex
                DFTraversal(adjMatrix, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // n : Vertices
        int n = s.nextInt();
        // e : Edges
        int e = s.nextInt();
        // Create 2D Array for adjacent Matrix with n vertices.
        int adjMatrix[][] = new int[n][n];
        // Get the edges and marking them in the matrix with 1.
        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            // For ex: 0 1 and 1 0 are same with respect to graph as edge
            // marking both vertices to 1
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        DFTraversal(adjMatrix);
        // Print the Matrix
//        for (int i = 0; i < n; i++) {
//            for (int j =0; j < n; j++) {
//                System.out.print(adjMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
