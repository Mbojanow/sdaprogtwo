package pl.sdacademy.prog.zadC;

public class ListDemo {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(5);

        linkedList.add(3);
        linkedList.add(6);
        linkedList.add(12);
        linkedList.add(7);

        linkedList.addHead(2);
        linkedList.remove(5);

        linkedList.add(5, 99);
        linkedList.add(2, 1);


        for (int idx = 0; idx < linkedList.size(); idx++) {
            System.out.println(linkedList.get(idx));
        }
    }
}
