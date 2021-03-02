package linklist;

/**
 * 循环链表支持增删操作
 */
public class CircularLinkedList<T> {
    private final Node<T> head;

    public CircularLinkedList(){
        head = new Node<>(null, null);
        head.next = head;
    }

    public void add(T data){
        Node<T> temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = new Node<>(data, head);
    }

    public void insert(T data, int index){
        Node<T> temp = head;
        int curr = 0;
        while(temp.next != head && curr != index){
            curr++;
            temp = temp.next;
        }
        if(index != curr) System.out.println("给定的插入位置超过链表的长度，数据插入到链表尾部");
        temp.next = new Node<>(data, temp.next);
    }

    public void delete(T data){
        Node<T> temp = head;
        while(temp.next != head){
            if(temp.next.data == data){
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder sb = new StringBuilder("[");
        while (temp.next != head) {
            temp = temp.next;
            sb.append(temp.data);
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());

        list.insert(2, 2);
        System.out.println(list.toString());

        list.add(2);
        list.delete(2);
        System.out.println(list.toString());
    }

    static class Node<T> {
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        T data;
        Node<T> next;
    }
}
