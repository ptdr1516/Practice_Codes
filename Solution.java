public class Solution {

    public static void print(Node<Integer> head) {
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static int count(Node<Integer> head) {
        int c  = 0;
        while(head!=null){
            c++;
            head = head.next;
        }
        return c;
    }

    public static Node<Integer> reverse(Node<Integer> head){
        if (head == null) return null;
        if (head.next == null) return head;
        Node<Integer> tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;

    }

    public static void multiply(Node<Integer> head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node<Integer> temp1= head1, temp2 = head2, addPos = null;
        Node<Integer> result = new Node<>(0), add = result;
        int len1 = count(head1),len2 = count(head2);

        for (int i = 0; i <len1 ; i++) {
            temp2 = head2;
            add = result;
            for (int j = 0; j < i; j++) {
                if(add.next==null) add.next = new Node<>(0);
                add = add.next;
            }
            int extra = 0;
            for (int j = 0; j < len2; j++) {
                int num = temp2.data*temp1.data+extra;
                int tempNum = num%10;
                addPos = add;
                while(tempNum!=0){
                    tempNum += addPos.data;
                    addPos.data=tempNum%10;
                    tempNum/=10;
                    if(addPos.next ==null && tempNum!=0){
                        addPos.next = new Node<>(0);
                    }
                    addPos = addPos.next;
                }
                extra = num/10;
                if(add.next==null && (j<len2-1||extra!=0)) add.next = new Node<>(0);
                add = add.next;
                temp2 = temp2.next;
            }
            if(extra!=0) add.data += extra;
            temp1 = temp1.next;
        }
        print(reverse(result));
    }
}