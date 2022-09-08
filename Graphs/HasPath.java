package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {

    public static void hasPath(int[][] adjMatrix, int v1, int v2, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        int n = adjMatrix.length;

        while (q.size() != 0) {
            int currentVertex = q.remove();
            visited[currentVertex] = true;
            // when vertice v2 is found in the path
            if (currentVertex == v2) {
                System.out.println("true");
                return;
            }
            // only insert nodes into queue if they have not been explored already
            for (int i = 0; i < n; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println("false");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int e = s.nextInt();
        int adjMatrix[][] = new int[n][n];

        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            adjMatrix[fv][sv] = 1;
            adjMatrix[sv][fv] = 1;
        }
        int v1 = s.nextInt();
        int v2 = s.nextInt();
        boolean visited[] = new boolean[adjMatrix[0].length];
        hasPath(adjMatrix, v1, v2, visited);
    }
}
