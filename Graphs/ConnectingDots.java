package Graphs;

import java.util.Scanner;

public class ConnectingDots {



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int m = Integer.parseInt(s.nextLine());

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = s.nextLine();
        }

        System.out.println(solve(board, n, m));

    }

    static boolean solve(String[] board, int n, int m) {
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    DFS(board,n,m,-1,-1,i,j,board[i].charAt(j), visited);
                }
            }
        }

        return hasCycle?true:false;
    }

    static int[] dx = new int[]{0,1,-1,0};
    static int[] dy = new int[]{1,0,0,-1};
    static boolean hasCycle = false;

    private static void DFS(String[] adjMatrix, int n, int m, int fromX, int fromY, int x, int y, char color, boolean[][] visited) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (adjMatrix[x].charAt(y) != color) {
            return;
        }
        if (visited[x][y]) {
            // if it is already visited, then cycle exists, return true
            hasCycle = true;
            return;
        }
        visited[x][y] = true;
        // to find adj node
        for (int dir = 0; dir < 4; dir++) {
            // for each adj and not visited
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            if (nextX == fromX && nextY == fromY) {
                continue;
            }

            DFS(adjMatrix, n, m, x, y,nextX,nextY, color, visited);
        }
    }
}
