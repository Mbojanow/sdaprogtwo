package pl.sdacademy.prog.queue;

import java.util.Queue;

public class QueueDemo {
  public static void main(String[] args) {
    final PriorityQueue<Integer, Integer> queue = new PriorityQueue<>(1);
    queue.offer(1);
    queue.offer(3);
    queue.offer(5, 1);
    queue.offer(17, 3);
    queue.offer(100, 2);
    queue.offer(0, 3);

    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }
}
