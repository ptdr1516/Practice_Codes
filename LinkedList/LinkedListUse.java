package LinkedList;
import javax.print.attribute.standard.NumberOfDocuments;
import java.util.ArrayList;
import java.util.Scanner;

class DoubleNode{
    Node<Integer> head;
    Node<Integer> tail;
    DoubleNode(){

    }

    DoubleNode(Node<Integer> head, Node<Integer> tail){
        this.head = head;
        this.tail = tail;
    }
}
public class LinkedListUse {

    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
//        System.out.println("n1 " + n1 + " data " + n1.data + " next " + n1.next);
        n2.next = n3;
//        System.out.println("n2 " + n2 + " data " + n2.data + " next " + n2.next);
        n3.next = n4;
//        System.out.println("n3 " + n3 + " data " + n3.data + " next " + n3.next);
//        System.out.println("n4 " + n4 + " data " + n4.data + " next " + n4.next);
        return n1;
    }
    /*Printing Linked List*/
    public static void Print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; //Stores reference of next node
        }
        System.out.println();
    }

    /*Incrementing Linked List*/
    public static void increment(Node<Integer> head){
//        head = new Node<>(100);
            Node<Integer> temp = head;
            while (temp != null){
                temp.data++;
                temp = temp.next; //Stores reference of next node
            }
            System.out.println();
        }
//        System.out.println("Print " + head);
//        System.out.println(head.data);
//        System.out.println(head.next);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);
//        System.out.println(head.next.next.next.data);

    /*Finding Length of the Linked List*/
    public static int length(Node<Integer> head){
        Node<Integer> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static Node<Integer> takeInput(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null, tail = null;
        while(data != -1){
            Node<Integer> currentNode = new Node<>(data);
            if(head == null){
                head = currentNode;
                tail = currentNode;
            }
            else {
//                Node<Integer> tail = head;
//                while (tail.next != null){
//                    tail = tail.next;
//                }
                tail.next = currentNode;
                tail = currentNode;
            }
            data = s.nextInt();
        }
        return head;
    }

    /*Inserting node in Linked List at particular position*/
    public static Node<Integer> insert(Node<Integer> head, int pos, int data){
        if(pos == 0){
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
        }
        else {
            Node<Integer> temp = head;
            for(int i = 0; i < pos - 1 && temp != null; i++){
                temp = temp.next;
            }
            if(temp != null && pos > 0){
                Node<Integer> newNode = new Node<>(data);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return head;
    }
    /*Deleting node from particular position in Linked List*/
    public static Node<Integer> deleteNode(Node<Integer> head, int pos){
        if (pos < 0){
            return head;
        } else if (pos == 0) {
            head = head.next;
        }
        else {
            Node<Integer> prevNode = head;
            for (int i = 0; i < pos - 1 && prevNode !=  null; i++){
                prevNode = prevNode.next;
            }
            if(prevNode != null && prevNode.next != null){
                prevNode.next = prevNode.next.next;
            }
        }
        return head;
    }
    /*Finding particular node in Linked List*/
    public static int findNode(Node<Integer> head, int n){
        Node<Integer> node = head;
        int count = 0;
        while (node != null){
            if(node.data == n){
                return count;
            }
            else {
                node = node.next;
                count++;
            }
        }
        return -1;
    }
    /*Appending last k nodes to start position in LL*/
    public static Node<Integer> appendLastNtoFirst(Node<Integer> head, int n){
        Node<Integer> tail = head;

        int l = length(head);
        int count = 1;
        Node<Integer> newTail = null;
        Node<Integer> newHead = null;
        while(tail.next != null)
        {
            if(count == l - n){
                newTail = tail;
            }
            if(count == l - n + 1){
                newHead = tail;
            }
            tail = tail.next;
            count++;
        }
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
    /*Palindrome check in LL*/
    public static boolean isPalindrome(Node<Integer> head){
        Node<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while (node != null){
            arr.add(node.data);
            node = node.next;
        }
        int start = 0, end = arr.size() - 1;
        while (start < end){
            if(arr.get(start) != arr.get(end)){
                return false;
            }
            else{
                start = start + 1;
                end = end - 1;
            }
        }
        return true;
    }
    /*Removing Duplicates in LL*/
    public static Node<Integer> removeDuplicates(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> uniqueNode = head.next, node = head;
        while(uniqueNode != null){
            if(!(uniqueNode.data).equals(node.data)){
                node.next = uniqueNode;
                node = node.next;
            }
            uniqueNode = uniqueNode.next;
        }
        node.next = uniqueNode;
        return head;
    }
    /*Printing reverse using LL*/
    public static void printReverse(Node<Integer> root) {
        Node<Integer> smallOutput = printReverseRecursion(root);
    }

    public static Node<Integer> printReverseRecursion(Node<Integer> node) {
        if(node == null){
            return node;
        }
        Node<Integer> smallOutput = printReverseRecursion(node.next);
        System.out.print(node.data + " ");
        return smallOutput;
    }
    /*Printing LL Recursively*/
    public static void printR(Node<Integer> head){
        if(head == null){
         //Base Case
            return;
        }
        System.out.print(head.data + " ");
        //printR(head.next); //Recursion call of the next node
    }

    /*Insertion Recursively*/
    public static Node<Integer> insertR(Node<Integer> head, int elem, int pos){
        if(head == null && pos > 0){
            return head;
        }
        if(pos == 0){
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }
        else{
            //Node<Integer> smallerHead = insertR(head.next, elem,pos - 1);
            //head.next = smallerHead;
            head.next = insertR(head.next, elem,pos - 1);
            return head;
        }
    }
    public static Node<Integer> deleteNodeR(Node<Integer> head, int pos){
        if(head == null){
            return head;
        }
        if(pos == 0){
            head = head.next;
            return head;
        }
        //Node<Integer> smallerHead = deleteNodeR(head.next,pos - 1);
        //head.next = smallerHead;
        head.next = deleteNodeR(head.next,pos - 1);
        return head;
    }
    /*Reverse Recursively*/
    public static Node<Integer> reverseR(Node<Integer> head){
        if(head ==  null || head.next ==null){
            return head;
        }
        Node<Integer> smallHead = reverseR(head.next);
        Node<Integer> tail = smallHead;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return smallHead;
    }
    public static DoubleNode reverseRBetter(Node<Integer> head){
        DoubleNode ans;
        if(head == null || head.next == null){
            ans = new DoubleNode(head,head);
            //ans.head = head;
            //ans.tail = head;
            return ans;
        }
        //This Double Node will have both head and tail of reversed LL.
        DoubleNode smallAns = reverseRBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode(smallAns.head,head);
        //ans.head = smallAns.head;
        //ans.tail = head;
        return ans;
    }
    public static Node<Integer> reverseRBest(Node<Integer> head){
        if(head ==  null || head.next ==null){
            return head;
        }
        Node<Integer> smallHead = reverseR(head.next);
        Node<Integer> reversedTail = head.next;
        reversedTail.next = head;
        head.next = null;
        return smallHead;

    }
//    public static Node<Integer> reverseRBetter1(Node<Integer> head){
//        DoubleNode ans = reverseRBetter(head);
//        return ans.head;
//    }

    /*Mid Point in a LL*/
    public static Node<Integer> midPoint(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*Merging Two Sorted LL*/
    public static Node<Integer> mergeTwoSortedLL(Node<Integer> head1, Node<Integer> head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node<Integer> newHead = null, node1 = head1, node2 = head2, newNode = null;
        int data1 = node1.data, data2 = node2.data;
        if(data1 < data2){
            newHead = node1;
            node1 = node1.next;
        }
        else {
            newHead = node2;
            node2 = node2.next;
        }
        newNode = newHead;
        while(node1 != null && node2 != null){
            data1 = node1.data;
            data2 = node2.data;

            if(data1 < data2){
                newNode.next = node1;
                newNode = newNode.next;
                node1 = node1.next;
            }
            else {
                newNode.next = node2;
                newNode = newNode.next;
                node2 = node2.next;
            }
        }

        while(node1 != null){
            newNode.next = node1;
            newNode = newNode.next;
            node1 = node1.next;
        }
        while(node2 != null){
            newNode.next = node2;
            newNode = newNode.next;
            node2 = node2.next;
        }
        return newHead;
    }
    public static Node<Integer> mergeSort(Node<Integer> head) {
        //Your code goes here
        if (head==null || head.next==null)
        {
            return head;
        }
       Node<Integer> midNode = midPoint(head), part1Head = head, part2Head = null;

        part2Head = midNode.next;
        midNode.next = null;

        Node<Integer> head1 = mergeSort(part1Head);
        Node<Integer> head2 = mergeSort(part2Head);
        Node<Integer> newHead = mergeTwoSortedLL(head1,head2);
        return newHead;
    }

    public static int findNodeRec(Node<Integer> head, int n){
        if (head == null){
            return -1;
        }
        if (head.data.equals(n)){
            return 0;
        }
        int smallOutput = findNodeRec(head.next, n);
        if(smallOutput == -1){
            return smallOutput;
        }
        else {
            return smallOutput + 1;
        }
    }
    public static Node<Integer> evenAfterOdd(Node<Integer> head) {
        if (head==null || head.next==null)
        {
            return head;
        }
        Node<Integer> node = head, evenNode = null, oddNode = null, oddHead = null, evenHead = null;
        while(node != null)
        {
            int data = node.data;

            if (data % 2 == 0)
            {
                if (evenNode == null)
                {
                    evenNode = node;
                    evenHead = node;
                }
                else
                {
                    evenNode.next = node;
                    evenNode = evenNode.next;
                }
            }
            else
            {
                if (oddNode == null)
                {
                    oddNode = node;
                    oddHead = node;
                }
                else
                {
                    oddNode.next = node;
                    oddNode = oddNode.next;
                }
            }
            node = node.next;
        }
        if (oddHead == null)
        {
            return evenHead;
        }
        else
        {
            oddNode.next = evenHead;
        }

        if (evenNode != null)
        {
            evenNode.next = null;
        }
        return oddHead;
    }

    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N){
        if(M == 0){
            return null;
        }
        if(N == 0){
            return head;
        }
        Node<Integer> node = head, delNode = null;
        while(node != null)
        {
            for (int i = 0; i < M -1 && node != null; i++){
                node = node.next;
            }
            if(node == null){
                break;
            }
            delNode = node.next;
            for (int i = 0; i < N && delNode != null; i++){
                delNode = delNode.next;
            }
            node.next = delNode;
            node = delNode;
        }
        return head;
    }
    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if(i == j){
            return head;
        }
        Node<Integer> temp = head;
        Node<Integer> c1 = null, c2 = null, p1 = null, p2 = null;
        int pos = 1;

        while (temp != null){
            if(pos == i){
                p1 = temp;
                c1 = temp.next;
            }
            else if(pos == j){
                p2 = temp;
                c2 = temp.next;
            }
            temp = temp.next;
            pos++;
        }
        if(p1 != null){
            p1.next = c2;
        }
        else {
            head = c2;
        }
        if(p2 != null){
            p2.next = c1;
        }
        else {
            head = c1;
        }

        Node<Integer> currentFirstNode = c1.next;
        c1.next = c2.next;
        c2.next = currentFirstNode;

        return head;
    }
    public static Node<Integer> kReverse(Node<Integer> head, int k){
        //Base Case
        if(k == 0 || k == 1){
            return head;
        }
        Node<Integer> current = head, fwd = null, prev = null;
        int count = 0;

        //Reverse first k nodes of LL
        while(count < k && current != null){
            fwd = current.next;
            current.next = prev;
            prev = current;
            current = fwd;
            count++;
        }
        if(fwd != null){
            head.next = kReverse(fwd,k);
        }
        return prev;
    }
    public static Node<Integer> bubbleSort(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        for (int i = 0; i < length(head) - 1; i++){
            Node<Integer> curr = head;
            Node<Integer> prev = null;
            Node<Integer> fwd = curr.next;

            while(curr.next != null){
                if(curr.data <= curr.next.data){
                    prev = curr;
                    curr = curr.next;
                    fwd = curr.next;
                }
                else{
                    if(prev == null){
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                        head = prev;
                    }
                    else{
                        prev.next = fwd;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    }
                    fwd = curr.next;
                }
            }
        }
        return head;
    }
    public static void deleteAlternateNodes(Node<Integer> head){
        if(head == null || head.next == null){
            return;
        }
        Node<Integer> temp = head;
        while (temp != null && temp.next != null){
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

             /***MAIN FUNCTION***/
    public static void main(String[] args) {
        Node<Integer> head = takeInput();//createLinkedList();
        //System.out.println(findNodeRec(head,4));//mergeSort(head);
        deleteAlternateNodes(head);//bubbleSort(head);//kReverse(head,4);//swapNodes(head,3,4);//skipMdeleteN(head,2,2);//evenAfterOdd(head);
        Print(head);
        //Print(head);
        //DoubleNode ans = reverseRBetter(head);
        //head = reverseRBest(head);
        //printR(head);
        //printR(ans.head);
        //increment(head);
        //insert(head,2,80);
        //Print(head);
        //printR(head);
        //fun(head);//deleteNodeR(head,2);//insertR(head,10,8);
        //printR(head);
        //printReverse(head);
        //System.out.println(isPalindrome(head));
        //System.out.println(appendLastNtoFirst(head,3));
//        System.out.println(findNode(head,2));
//        System.out.println(deleteNode(head,0));
//        System.out.println(length(head));


//        Node<Integer> n1 = new Node<>(10);
//        System.out.println(n1);
//        System.out.println(n1.data);
//        System.out.println(n1.next);
    }
}
