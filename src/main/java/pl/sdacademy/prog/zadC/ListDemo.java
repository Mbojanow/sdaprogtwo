package pl.sdacademy.prog.zadC;

public class ListDemo {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(5);

        linkedList.add(3);
        linkedList.add(6);
        linkedList.add(12);
        linkedList.add(7);

        System.out.println(linkedList.get(3));
    }
}
