package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingNinjaProblem {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }


        String[] Graph = new String[input[0]];

        for (int i = 0; i < input[0]; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] Graph = takeInput();
        System.out.println(new CodingNinjaProblem().solve(Graph, Graph.length, Graph[0].length()));
    }

    public static int solve(String[] graph, int n, int m) {
        // Store String CODINGNINJA
        String codingNinja = "CODINGNINJA";
        // Function will track the word CODINGNINJA
        boolean ans = isWordTracaiable(graph, n, m, codingNinja);
        // Ans - T : 1, F : 0
        return ans ? 1:0;
    }

    public static boolean isWordTracaiable(String[] graph, int n, int m, String codingNinja) {
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (graph[i].charAt(j) == codingNinja.charAt(0)) {
                    visited[i][j] = true;
                    boolean ans = isWordTracaiable(graph, n - 1, m - 1, i, j, visited, codingNinja, 1);
                    if (ans) {
                        return ans;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWordTracaiable(String[] graph, int n, int m, int vi, int vj, boolean[][] visited, String codingNinja, int wi) {
        if (wi >= codingNinja.length()) {
            return true;
        }
        // Visit all directions
        boolean ans = false;

        if (vj < m && graph[vi].charAt(vj + 1) == codingNinja.charAt(wi) && !visited[vi][vj-1]) {
            visited[vi][vj+1] = true;
            ans = isWordTracaiable(graph, n, m, vi, vj+1, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vj > 0 && graph[vi].charAt(vj - 1) == codingNinja.charAt(wi) && !visited[vi][vj-1]) {
            visited[vi][vj-1] = true;
            ans = isWordTracaiable(graph, n, m, vi, vj-1, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vi < n && graph[vi+1].charAt(vj) == codingNinja.charAt(wi) && !visited[vi+1][vj]) {
            visited[vi+1][vj] = true;
            ans = isWordTracaiable(graph, n, m, vi+1, vj, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vi > 0 && graph[vi-1].charAt(vj) == codingNinja.charAt(wi) && !visited[vi-1][vj]) {
            visited[vi-1][vj] = true;
            ans = isWordTracaiable(graph, n, m, vi-1, vj, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vi < n && vj < m && graph[vi+1].charAt(vj + 1) == codingNinja.charAt(wi) && !visited[vi+1][vj+1]) {
            visited[vi+1][vj+1] = true;
            ans = isWordTracaiable(graph, n, m, vi+1, vj+1, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vi > 0 && vj > 0 && graph[vi-1].charAt(vj-1) == codingNinja.charAt(wi) && !visited[vi-1][vj-1]) {
            visited[vi-1][vj-1] = true;
            ans = isWordTracaiable(graph, n, m, vi-1, vj-1, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vi > 0 && vj < m && graph[vi-1].charAt(vj+1) == codingNinja.charAt(wi) && !visited[vi-1][vj+1]) {
            visited[vi-1][vj+1] = true;
            ans = isWordTracaiable(graph, n, m, vi-1, vj+1, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        if (vi < n && vj > 0 && graph[vi+1].charAt(vj-1) == codingNinja.charAt(wi) && !visited[vi+1][vj-1]) {
            visited[vi+1][vj-1] = true;
            ans = isWordTracaiable(graph, n, m, vi+1, vj-1, visited, codingNinja, wi+1);
            if (ans) {
                return ans;
            }
        }
        return false;
    }
}