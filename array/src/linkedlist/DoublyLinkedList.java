package linkedlist;

/**
 * 双向链表支持增删操作
 */
public class DoublyLinkedList<T> {
    private final Node<T> head;

    public DoublyLinkedList(){
        head = new Node<>(null, null, null);
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data, null, null);
        Node<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;
    }

    public void addFirst(T data){
        Node<T> first = new Node<>(data, head.next, head);
        if(head.next != null) {
            head.next.prev = first;
        }
        head.next = first;
    }

    public void delete(T data){
        if(data == null) return;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
                temp.prev.next = temp.next;
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder sb = new StringBuilder("[");
        while (temp.next != null) {
            temp = temp.next;
            sb.append(temp.data);
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());

        list.addFirst(0);
        System.out.println(list.toString());

        list.add(2);
        System.out.println(list.toString());
        list.delete(2);
        System.out.println(list.toString());
        list.delete(3);
        System.out.println(list.toString());
        list.delete(1);
        System.out.println(list.toString());
    }


    static class Node<T> {
        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        T data;
        Node<T> next;
        Node<T> prev;
    }
}
