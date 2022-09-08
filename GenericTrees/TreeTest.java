package GenericTrees;
import Queues.QueueEmptyException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTest {
    public static boolean isPresent = false;
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
        if (root == null) {
            isPresent = false;
        }
        else if (root.data == x) {
            return true;
        }
        for (int i = 0; i < root.children.size(); i++) {
            isPresent = checkIfContainsX(root.children.get(i), x);
        }
        return isPresent;
    }
    public static void printLevelWise(TreeNode<Integer> root)  {
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> front = pendingNodes.remove();
            if (front != null) {
                System.out.print(front.data + ": ");
                for (int i = 0; i < front.children.size(); i++) {
                    pendingNodes.add(front.children.get(i));
                    System.out.print(front.children.get(i).data);
                    if (i == front.children.size() - 1) {
                        break;
                    }
                    else {
                        System.out.print(",");
                    }
                }
                System.out.println();
            }
        }
    }
    public static TreeNode<Integer> takeInput() throws QueueEmptyException {
        Scanner s = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter the root data");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> front = pendingNodes.remove();
            System.out.println("Enter the no of children for: " + front.data);
            int numChild = s.nextInt();
            for (int i = 0; i < numChild; i++) {
                System.out.println("Enter the " + i + "th child data for: " + front.data);
                int childData = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                front.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }
    public static int numberOfNodes(TreeNode<Integer> root) {
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            int childCount = numberOfNodes(root.children.get(i));
            count += childCount;
        }
        return count;
    }
    public static void printTree(TreeNode<Integer> root) {

        //Special case and not the base case
        if (root == null) {
            return;
        }

        System.out.print(root.data + ": ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    public static void main(String[] args) throws QueueEmptyException {

//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(1);
//        TreeNode<Integer> node4 = new TreeNode<>(5);
//        TreeNode<Integer> node5 = new TreeNode<>(6);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//
//        node2.children.add(node4);
//        node2.children.add(node5);
        TreeNode<Integer> root = takeInput();
        System.out.println(checkIfContainsX(root, 5));
//        System.out.println("Number of Nodes : " + numberOfNodes(root));
    }
}
