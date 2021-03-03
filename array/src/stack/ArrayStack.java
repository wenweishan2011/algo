package stack;

import java.util.Arrays;

/**
 * 基于数组实现的栈
 */
public class ArrayStack<T> {
    private Object[] array;
    private int length;
    private int capacity;

    public ArrayStack(int initialCapacity) {
        capacity = initialCapacity;
        array = new Object[initialCapacity];
    }

    public void push(T data) {
        length++;
        while (length > capacity) {
            capacity *= 2;
            Object[] dest = new Object[capacity];
            System.arraycopy(array, 0, dest, 0, length - 1);
            array = dest;
        }
        array[length - 1] = data;
    }

    public T pop() {
        length--;
        if (length < 0) return null;
        return (T) array[length];
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("pop=" + stack.pop() + ", length=" + stack.length + ", capacity=" + stack.capacity);
    }
}
