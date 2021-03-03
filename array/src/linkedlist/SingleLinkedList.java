package linkedlist;

/**
 * 实现单链表支持增删操作
 * &链表反转
 */
class SingleLinkList<T> {
    private final Node<T> head;

    public SingleLinkList(){
        head = new Node<>(null);
    }

    public void add(T data) {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(data);
    }

    public void insert(T data, int index) {
        if(index < 0) throw new IllegalArgumentException("插入位置错误");
        Node<T> temp = head;
        int curr = 0;
        while (temp.next != null && curr != index) {
            curr++;
            temp = temp.next;
        }
        if(index != curr) System.out.println("给定的插入位置超过链表的长度，数据插入到链表尾部");
        Node<T> newNode = new Node<>(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public Node<T> get(int index) {
        int curr = 0;
        Node<T> temp = head.next;
        while (curr != index && temp.next != null) {
            temp = temp.next;
            curr++;
        }
        if (curr == index) return temp;
        return null;
    }

    /**
     * 移除链表中数据为data的节点
     */
    public void remove(T data) throws Exception {
        if (data == null) {
            throw new Exception("data 不可为 null");
        }
        if (head.next == null) {
            throw new Exception("链表还没有数据");
        }
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
    }

    public void removeIndex(int index) {
        if (index < 0) throw new IllegalArgumentException("index 不能小于0");

        Node<T> temp = head;
        int curr = 0;
        while (curr != index && temp.next != null) {
            curr++;
            temp = temp.next;
        }
        if (curr == index) temp.next = temp.next.next;
    }

    public void removeNode(Node<T> data) throws Exception {
        if (data == null) {
            throw new Exception("node 不可为 null");
        }
        if (head.next == null) {
            return;
        }
        Node<T> temp = head;
        while (temp.next != null && temp.next != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            return;
        }
        temp.next = temp.next.next;
    }

    /**
     * 链表反转
     */
    public void reverse(){
        if(head.next == null) return;
        Node<T> curr = head.next;
        //防止产生环
        head.next = null;
        Node<T> prev = null;
        Node<T> next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = prev;
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

    public static void main(String[] args) throws Exception {
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());

        list.reverse();
        System.out.println(list.toString());


        list.insert(2, 10);
        System.out.println(list.toString());

        list.removeNode(list.get(1));
        System.out.println(list.toString());

        list.add(2);
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());

        list.add(4);
        list.add(5);
        System.out.println(list.toString());
        list.removeIndex(0);
        System.out.println(list.toString());
    }

    static class Node<T> {

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        T data;
        Node<T> next;
    }
}
