package pl.sdacademy.prog.zadg;

public class QueueDemo {
  public static void main(String[] args) {

    final PriorityQueue<Integer, Integer> priorityQueue = new PriorityQueue<>(1);

    priorityQueue.offer(1);
    priorityQueue.offer(2);
    priorityQueue.offer(7, 3);
    priorityQueue.offer(4);
    priorityQueue.offer(111, 2);
    priorityQueue.offer(3);

    while (priorityQueue.peek() != null) {
      System.out.println(priorityQueue.poll());
    }

  }
}
