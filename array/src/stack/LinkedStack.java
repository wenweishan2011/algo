package stack;

/**
 * 基于链表实现的栈
 * @param <T>
 */
public class LinkedStack<T> {
    private Node<T> top;

    public void push(T data){
        if(top == null){
            top = new Node<>(data, null);
        }else{
            top = new Node<>(data, top.next);
        }
    }

    public T pop(){
        if(top == null) return null;
        Node<T> result = top;
        top = top.next;
        return result.data;
    }


    static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }
}
