package PriorityQueues;

public class PriorityQueueTest {

    public static void main(String[] args) throws PriorityQueueException {

        Priority_Queue<String> pq = new Priority_Queue<String>();
        pq.insert("abc", 15);
        pq.insert("def", 13);
        pq.insert("fsas", 90);
        pq.insert("fsfafsfaf", 150);
        pq.insert("bxajsbjasjx", 120);

        while (!pq.isEmpty()) {
            System.out.println(pq.getMin());
            pq.removeMin();
        }
    }
}
