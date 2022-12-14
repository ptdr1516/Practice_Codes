package HuffmanCoding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}
// comaparator class helps to comapare the node
// on the basis of one of its attrbute.
// Here we will compare on the basis of data values of the nodes.

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}
 class Huffman {
    public static void printCode(HuffmanNode root, String s) {
        // Base Case : if the left and right nodes are null then its a leaf node
        // and we print the code s generated by traversing the tree.
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        // if we go to left then add "0" to the code.
        // if we go to right then add "1" to the code.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 7;
        char[] charArray = { 'a', 'b', 'c', 'd', 'x', 'g', 'z'};
        int[] charfreq = { 30, 10, 8, 15, 4, 25, 2 };

        // Creating a Priority Queue q
        // Makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            // Creating a Huffman node object and add it to the priority queue
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }
        // Create a root node
        HuffmanNode root = null;

        // Here we will extract the two minimum value from the heap each time until
        // its size reduces to 1, extract until all the nodes are extracted.
        while (q.size() > 1) {
            // first min extract
            HuffmanNode x = q.peek();
            q.poll();

            // second min extract
            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes assigning values to the f node.
            f.data = x.data + y.data;
            f.c = '-';

            // first extracted node as left child.
            f.left = x;

            // second extracted node as right child.
            f.right = y;

            // marking the f node as the root node.
            root = f;

            // add this node to the priority queue.
            q.add(f);
        }
        printCode(root, "");
    }
}
