package queue;

public class ArrayQueue<T> {
    private int head;
    private int tail;
    private int capacity;
    private Object[] array;

    public ArrayQueue(int initCapacity) {
        this.capacity = initCapacity;
        array = new Object[initCapacity];
    }

    public void enqueue(T data) {
        if (tail == capacity) return;
        array[tail] = data;
        tail++;
    }

    public T dequeue() {
        if (tail == head) return null;
        Object result = array[head];
        head++;
        return (T) result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = head; i < tail; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }
}
