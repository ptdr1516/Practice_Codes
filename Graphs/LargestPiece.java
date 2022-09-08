package Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());


        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = LargestPiece.solve(edge,edge.length);
        System.out.println(ans);
    }
    static class Count {
        int c;

        public Count(int c) {
            this.c = c;
        }
    }

    static int solve(String[] cake, int n) {
        boolean[][] visited = new boolean[n][n];
        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Count count = new Count(0);
                // find the 1 in cake which is unvisited, and call the function DFS
                if (cake[i].charAt(j) - '0' == 1 && !visited[i][j]) {
                    DFS(cake, n, i, j, visited, count);
                    // count the no. of visited nodes from local visited and also update
                    // the global visited
                    maxCount = Math.max(count.c, maxCount);
                }
            }
        }
        return maxCount;
    }

    private static  void DFS(String[] adjMatrix, int n, int i, int j, boolean[][] visited, Count count) {
        visited[i][j] = true;
        count.c++;
        if (i+1 < n && adjMatrix[i+1].charAt(j) == '1' && !visited[i+1][j])
            DFS(adjMatrix, n, i+1, j, visited, count);
        if (i-1 >= 0 && adjMatrix[i-1].charAt(j) == '1' && !visited[i-1][j])
            DFS(adjMatrix, n, i-1, j, visited, count);
        if (j+1 < n && adjMatrix[i].charAt(j+1) == '1' && !visited[i][j+1])
            DFS(adjMatrix, n, i, j+1, visited, count);
        if (j-1 >= 0 && adjMatrix[i].charAt(j-1) == '1' && !visited[i][j-1])
            DFS(adjMatrix, n, i, j-1, visited, count);

    }
}
