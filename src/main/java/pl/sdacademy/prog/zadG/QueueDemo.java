package pl.sdacademy.prog.zadG;

public class QueueDemo {

    public static void main(String[] args) {
//        final MyQueue<Integer> integers = new MyQueue<>();
//
//        integers.add(3);
//        integers.add(4);
//        integers.add(5);
//        integers.add(7);
//        integers.add(6);
//
//        final int size = integers.size();
//        for (int idx = 0; idx < size; idx++) {
//            System.out.println(integers.poll());
//        }

//        final MyPriorityQueue<Integer, Integer> myPriorityQueue = new MyPriorityQueue<>(0);
//
//        myPriorityQueue.offer(3);
//        myPriorityQueue.offer(4);
//        myPriorityQueue.offer(6);
//        myPriorityQueue.offer(12);
//        myPriorityQueue.offer(7);
//        myPriorityQueue.enqueue(100, 3);
//        myPriorityQueue.enqueue(200, 3);
//        myPriorityQueue.enqueue(150, 3);
//        myPriorityQueue.enqueue(122, 2);
//
//        final int size = myPriorityQueue.size();
//        for (int idx = 0; idx < size; idx++) {
//            System.out.println(myPriorityQueue.poll());
//        }

        final MyPriorityQueue<Integer, CustomPriority> myPriorityQueue = new MyPriorityQueue<>(CustomPriority.LOW);

        myPriorityQueue.offer(3);
        myPriorityQueue.offer(4);
        myPriorityQueue.offer(6);
        myPriorityQueue.offer(12);
        myPriorityQueue.offer(7);
        myPriorityQueue.enqueue(100, CustomPriority.HIGH);
        myPriorityQueue.enqueue(200, CustomPriority.HIGH);
        myPriorityQueue.enqueue(150, CustomPriority.MEDIUM);
        myPriorityQueue.enqueue(122, CustomPriority.HIGH);

        final int size = myPriorityQueue.size();
        for (int idx = 0; idx < size; idx++) {
            System.out.println(myPriorityQueue.poll());
        }
    }
}
