package array;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 */
public class Array {
    // 数组容量
    private int capacity = 5;
    private final int[] elements;
    // 数组当前有效元素数
    private int size;

    public Array(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("参数错误： 容量需大于0");
        }
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public void add(int element) throws Exception {
        if (size >= capacity) {
            throw new Exception("超出数组容量");
        }

        // 数组没有元素
        if (size == 0) {
            elements[0] = element;
            size++;
            return;
        }
        int insertIndex = findInsertIndex(elements, element);
        if (insertIndex < size) {
            //also : if (size - 1 - middleIndex >= 0) System.arraycopy(elements, middleIndex + 1, elements, middleIndex + 1 + 1, size - 1 - middleIndex);
            for (int i = size - 1; i >= insertIndex; i--) {
                elements[i + 1] = elements[i];
            }
        }
        elements[insertIndex] = element;
        size++;
    }

    /**
     * 二分查找插入的位置
     */
    private int findInsertIndex(int[] elements, int element) {
        int startIndex = 0;
        int endIndex = size - 1;
        int insertIndex;
        if (element >= elements[size - 1]) {
            insertIndex = size;
        } else if (element <= elements[0]) {
            insertIndex = 0;
        } else {
            while (endIndex > startIndex) {
                int middleIndex = (startIndex + endIndex) / 2;
                if (element < elements[middleIndex]) {
                    endIndex = middleIndex - 1;
                } else {
                    startIndex = middleIndex + 1;
                }
            }
            // endIndex == startIndex = true
            insertIndex = endIndex + 1;
        }
        return insertIndex;
    }

    public void delete(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("给定目标 超出数组容量");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = 0;
        size--;
    }

    public void update(int index, int element) throws Exception {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("给定目标 超出数组容量");
        }
        delete(index);
        add(element);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            s.append(elements[i]);
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) throws Exception {
        Array arr = new Array(5);
        arr.add(5);
        arr.add(7);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        System.out.println(arr.toString());

        arr.delete(2);
        System.out.println(arr.toString());

        arr.update(1, 10);
        System.out.println(arr.toString());
    }
}
