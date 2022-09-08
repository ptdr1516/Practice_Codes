package Graphs;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class BreadthFirstTraversal {
    /* Breadth-First Traversal */
    /* Time Complexity - O(V^2) V: Vertices/No. of nodes - In case of Adjacency Matrix */
    /* Time Complexity - O(V + 2E) V: Vertices, E: Edges - In case of Adjacency List */

    public static void BFTraversal(int edges[][], int sv,boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        while(q.size()!=0){
            int firstelem = q.remove();
            System.out.print(firstelem+" ");
            visited[sv] = true;
            for(int i=0; i<edges[0].length; i++){
                if(edges[firstelem][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    // we have to deal with both connected and non connected
    public static void BFTraversal(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i=0; i< edges.length; i++){
            if(!visited[i]){
                BFTraversal(edges, i, visited);
                System.out.println();
            }
        }
    }

    public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int start, int end) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[start] = true;
        pendingVertices.add(start);
        map.put(start, -1);
        // Initially not found the path
        boolean pathFound = false;

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    pendingVertices.add(i);
                    visited[i] = true;
                    // Mark its parent
                    map.put(i, currentVertex);
                    if (i == end) {
                        // Path Found
                        pathFound = true;
                        break;
                    }
                }
            }
        }
        if (pathFound) {
            ArrayList<Integer> path = new ArrayList<>();
            int currentVertex = end;

            while (currentVertex != -1) {
                path.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }
            return path;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] edges = new int[V][V];

        for (int i = 0; i < E; i++) {
            int V1 = s.nextInt();
            int V2 = s.nextInt();
            edges[V1][V2] = 1;
            edges[V2][V1] = 1;
        }
        int start = s.nextInt();
        int end = s.nextInt();
        ArrayList<Integer> path = getPathBFS(edges, start, end);
        for (Integer i : path) {
            System.out.print(i + " ");
        }
    }
}
