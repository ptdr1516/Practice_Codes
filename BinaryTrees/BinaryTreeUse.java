package BinaryTrees;
import java.util.*;

class LinkedListNode<T>
{
    T data;
    LinkedListNode<T> next;
    public LinkedListNode(T data)
    {
        this.data = data;
    }
}

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of  " + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
//        if(root.left != null){
//            printTree(root.left);
//        }
//        if(root.right != null) {
//            printTree(root.right);
//        }
    }

    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x) {
        if (node == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }

        if (x >= node.data) {
            node.right = insert(node.right, x);
        }
        else {
            node.left = insert(node.left, x);
        }
        return node;
    }
    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftNodeCount = numNodes(root.left);
        int rightNodeCount = numNodes(root.right);

        return 1 + leftNodeCount + rightNodeCount;
    }

    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }

    public static int numLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return numLeaves(root.left) + numLeaves(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.data);
        }

        printAtDepthK(root.left, k - 1);
        printAtDepthK(root.right, k - 1);
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;

    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }

    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            int height = 0;
            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isBal = false;
        }

        if (!leftOutput.isBalanced || !rightOutput.isBalanced) {
            isBal = false;
        }

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }
            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);

            }
        }
        return root;
    }

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return false;
        }

        int rootData = root.data;

        if (k < rootData) {
            return searchInBST(root.left, k);
        } else if (k > rootData) {
            return searchInBST(root.right, k);
        } else {
            return true;
        }
    }

    private static ArrayList<Integer> arr = new ArrayList<Integer>();

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2) {
        elementsInRangeK1K2Helper(root, k1, k2);
        Collections.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void elementsInRangeK1K2Helper(BinaryTreeNode<Integer> root,int k1,int k2) {
        if (root == null) {
            return;
        }

        int rootData = root.data;

        if (rootData < k1) {
            elementsInRangeK1K2Helper(root.right, k1, k2);
        }
        else if(rootData > k2) {
            elementsInRangeK1K2Helper(root.left, k1, k2);
        }
        else {
            arr.add(rootData);
            elementsInRangeK1K2Helper(root.right, k1, k2);
            elementsInRangeK1K2Helper(root.left, k1, k2);
        }
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {
        return sortedArrayToBST(arr, 0, arr.length);
    }

    public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return null;
        }

        int middle;

        if((startIndex + endIndex) % 2 == 0) {
            middle = (startIndex + endIndex) / 2 - 1;
        }
        else {
            middle =  startIndex + endIndex / 2 ;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[middle]);
        root.left = sortedArrayToBST(arr, startIndex, middle);
        root.right = sortedArrayToBST(arr, middle + 1, endIndex);
        return root;
    }

    public static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftMax = largest(root.left);
        if (leftMax >= root.data) {
            return false;
        }
        int rightMin = minimum(root.right);
        if (rightMin < root.data) {
            return false;
        }

        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return isLeftBST && isRightBST;
    }

    public static isBSTReturn isBSTBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }

        isBSTReturn leftAns = isBSTBetter(root.left);
        isBSTReturn rightAns = isBSTBetter(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
        boolean isBST = true;

        if (leftAns.max >= root.data) {
            isBST = false;
        }

        if (rightAns.min < root.data) {
            isBST = false;
        }

        if (!leftAns.isBST) {
            isBST = false;
        }

        if (!rightAns.isBST) {
            isBST = false;
        }

        isBSTReturn ans = new isBSTReturn(min, max, isBST);
        return ans;
    }

    public static boolean isBST2(BinaryTreeNode<Integer> root, int minRange, int maxRange) {
        if (root == null) {
            return true;
        }

        if (root.data < minRange || root.data > maxRange) {
            return false;
        }

        boolean isLeftWithinRange = isBST2(root.left, minRange, root.data - 1);
        boolean isRightWithinRange = isBST2(root.right, root.data, maxRange);
        return isLeftWithinRange && isRightWithinRange;
    }

    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return null;
        }

        if (root.data == x) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
        if (leftOutput != null) {
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
        if (rightOutput != null) {
            rightOutput.add(root.data);
            return rightOutput;
        }

        return null;
    }

    private static ArrayList<LinkedListNode<Integer>> arr1 = new ArrayList<LinkedListNode<Integer>>();

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
        nodesToPrint.add(root);
        nodesToPrint.add(null);
        LinkedListNode<Integer> head = null, tail = null;

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
            if (front == null) {
                if (nodesToPrint.isEmpty()) {
                    break;
                }
                else {
                    nodesToPrint.add(null);
                    tail.next = null;
                    tail = tail.next;
                    head = null;
                }
            }
            else {
                if (head == null) {
                    head = new LinkedListNode<Integer>(front.data);
                    tail = head;
                    arr1.add(head);
                }
                else {
                    tail.next = new LinkedListNode<Integer>(front.data);
                    tail = tail.next;
                }
                if (front.left != null)
                    nodesToPrint.add(front.left);
                if (front.right != null)
                    nodesToPrint.add(front.right);
            }
        }
        return arr1;
    }


        public static void main (String[]args){
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
//
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
//        root.left = rootLeft;
//        root.right = rootRight;
//
//        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
//        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
//        rootLeft.right = twoRight;
//        rootRight.left = threeLeft;

            //BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
            //BinaryTreeNode<Integer> root = takeInputLevelwise();
            //printTreeDetailed(root);
//            System.out.println("Num Nodes " + numNodes(root));
//            System.out.println("Largest " + largest(root));
//            System.out.println("Num leaves " + numLeaves(root));
//            System.out.println("Print at depth k ");
//            printAtDepthK(root, 2);
//            //BinaryTreeNode<Integer> newRoot = removeLeaves(root);
//            //printTreeDetailed(newRoot);
//            System.out.println("Is Balanced " + isBalancedBetter(root).isBalanced);
//            System.out.println(searchInBST(root, 10));
//            elementsInRangeK1K2(root,2,8);
            //isBSTReturn ans = isBSTBetter(root);
            //System.out.println(ans.min + " " + ans.max + " " + ans.isBST);

            BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
            ArrayList<Integer> path = nodeToRootPath(root, 7);
            if (path == null) {
                System.out.println("Not Found");
            }
            for (int i : path) {
                System.out.println(i);
            }
        }
    }
