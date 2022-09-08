package Graphs;

import java.util.Scanner;

public class isConnected {

    public static void isConnect(int[][] adjMatrix, boolean[] visited, int currentVertex) {
        visited[currentVertex] = true;
        int n = adjMatrix.length;
        for (int j = 0; j < n; j++) {
            if (adjMatrix[currentVertex][j] == 1 && !visited[j]) {
                isConnect(adjMatrix, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            adjMatrix[fv][sv] = 1;
            adjMatrix[sv][fv] = 1;
        }

        boolean[] visited = new boolean[adjMatrix.length];
        isConnect(adjMatrix, visited, 0);
        // Now check if all elements are visited or not
        int length = visited.length;
        int i = 0;

        while (i < visited.length) {
            if (visited[i] != true) {
                System.out.print("false");
                System.exit(0);
            }
            i++;
        }
        System.out.print("true");
        System.exit(0);
    }
}
