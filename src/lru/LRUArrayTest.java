package lru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUArrayTest {

    @Test
    void testDefaultConstructor() {
        LRUArray<Integer> array = new LRUArray<>();
        array.offer(1);
        array.offer(2);
        array.offer(3);
        array.offer(4);
        System.out.println(array.toString());
        array.offer(5);
        array.offer(6);
        array.offer(7);
        System.out.println(array.toString());
    }
    
    @Test
    public void testSpecifiedConstructor(){
        LRUArray<Integer> array = new LRUArray<>(3);
        array.offer(1);
        array.offer(2);
        array.offer(3);
        System.out.println(array.toString());
        array.offer(4);
        array.offer(5);
        System.out.println(array.toString());
    }
    
}