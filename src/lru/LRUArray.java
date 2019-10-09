package lru;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现LRU缓存
 * 1. 时间复杂度 O(n)
 * 2. 空间复杂度 O(n)
 * 3. 不持支null的缓存
 */
public class LRUArray<T> {

    private static final int DEFAULT_CAPACITY = 1 << 3;

    private int capacity;
    private int count;
    private T[] values;
    private Map<T, Integer> holder;

    public LRUArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUArray(int capacity) {
        this.capacity = capacity;
        values = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<>(capacity);
    }

    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("不持支null");
        }
        Integer index = holder.get(object);
        if (index == null) {
            if (count == capacity) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 容量满时
     * 删除最后一个， 之前的数据向后移动一位
     *
     * @param object
     */
    private void removeAndCache(T object) {
        //最后一个数据
        T key = values[--count];
        holder.remove(key);
        cache(object, count);
    }

    private void cache(T object, int end){
        rightShift(end);
        values[0] = object;
        holder.put(object, 0);
        count += 1;
    }

    /**
     * 更新当前位置
     * index处的数据放入第一位，0-index位置的数据后移一位
     *
     * @param index
     */
    private void update(Integer index) {
        T temp = values[index];
        rightShift(index);
        values[0] = temp;
        holder.put(temp, 0);
    }

    /**
     * 节点前数据右移一位
     * @param index
     */
    private void rightShift(Integer index) {
        for (int i = index - 1; i >= 0; i--) {
            values[i + 1] = values[i];
            holder.put(values[i], i + 1);
        }
    }

    @Override
    public String toString() {
        return "LRUArray{" +
                "capacity=" + capacity +
                ", count=" + count +
                ", values=" + Arrays.toString(values) +
                ", holder=" + holder +
                '}';
    }
}

