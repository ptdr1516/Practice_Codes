import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class RottenOranges {

    Queue<int[]> queue;
    int count_fresh = 0;
    int grid[][];
    int rows;
    int cols;

    public RottenOranges(int[][] grid) {
        queue = new LinkedList<>();
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m;
        n = s.nextInt();
        m = s.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                grid[i][j] = s.nextInt();
            }
        }
        RottenOranges obj = new RottenOranges(grid);
        obj.countFresh();
        System.out.println(obj.rot());
    }

    private void countFresh() {
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
    }

    private int rot() {
        //if count of fresh oranges is zero --> return 0
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                    //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}