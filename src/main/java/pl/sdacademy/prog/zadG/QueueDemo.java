package pl.sdacademy.prog.zadG;

public class QueueDemo {

    public static void main(String[] args) {

        final MyQueue<Integer> queue = new MyQueue<>();

        queue.offer(5);
        queue.offer(7);
        queue.offer(6);
        queue.offer(3);
        final Integer el = queue.poll();
        //System.out.println(el);
        queue.offer(4);

        queue.forEach(System.out::println);
    }
}
