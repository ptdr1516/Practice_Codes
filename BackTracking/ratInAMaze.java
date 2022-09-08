package BackTracking;

import java.util.Scanner;

public class ratInAMaze {

    public static void ratInMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        //return solveMaze(maze, 0, 0, path);
        printAllPaths(maze, 0, 0, path);
    }

    public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
        //Check if i, j cell is valid or not
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return false;
        }
        if (path[i][j] == 1) {
            return false;
        }
        if (maze[i][j] == 0) {
            return false;
        }
        //Include the cell in current path
        path[i][j] = 1;
        //Destination cell
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        //Explore further in all direction
        //Top
        if (solveMaze(maze,i - 1, j, path)) {
            return true;
        }
        //Right
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }
        //Down
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }
        //Left
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }
        return false;
    }

    public static void printAllPaths(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return;
        }
        if (path[i][j] == 1) {
            return;
        }
        if (maze[i][j] == 0) {
            return;
        }

        path[i][j] = 1;

        if (i == n - 1 && j == n - 1) {
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(path[k][l] + " ");
                }
                System.out.println();
            }
            System.out.println();

            path[i][j] = 0;
            return;
        }
        printAllPaths(maze,i - 1, j, path);

        printAllPaths(maze,i , j + 1, path);

        printAllPaths(maze,i + 1, j, path);

        printAllPaths(maze,i , j - 1, path);

        path[i][j] = 0;
        return;
    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter size of maze: ");
//        int n = s.nextInt();
//        int[][] maze = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                maze[i][j] = s.nextInt();
//            }
//        }
        int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};

        ratInMaze(maze);
    }
}
