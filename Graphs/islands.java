package Graphs;

import java.util.Scanner;

public class islands {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        int count = 1;
        boolean[] visited = new boolean[adjMatrix.length];
        DFS(adjMatrix, n, 0, visited);
        //if all visited then it is connected else false
        boolean isConnected = true;
        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                count++;
                isConnected = false;
                DFS(adjMatrix, n, i, visited);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int[][] adjMatrix, int n, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                DFS(adjMatrix, n, i, visited);
            }
        }
    }
}
