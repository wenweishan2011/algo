package queue;

/**
 * 循环队列(空一个元素位置)
 */
public class CircularQueue<T> {
    private int head;
    private int tail;
    private int capacity;
    private Object[] array;

    public CircularQueue(int initCapacity) {
        this.capacity = initCapacity;
        array = new Object[initCapacity];
    }

    public void enqueue(T data) {
        //队满
        if ((tail + 1) % capacity == head) return;
        array[tail] = data;
        tail = (tail + 1) % capacity;
    }

    public T dequeue() {
        if (head == tail) return null;
        T result = (T) array[head];
        head = (head + 1) % capacity;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = head; i % capacity != tail; i = (i + 1) % capacity) {
            sb.append(array[i]);
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.enqueue(4);
        System.out.println(queue.toString());
        queue.dequeue();
        queue.enqueue(5);
        System.out.println(queue.toString());
    }
}
