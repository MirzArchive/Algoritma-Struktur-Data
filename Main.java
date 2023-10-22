import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(10);
        queue.add(50);
        queue.add(100);
        System.out.println(queue);
    }
}
