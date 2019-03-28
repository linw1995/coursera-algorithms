package edu.princeton.cs;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DequeAdvanceTest {

    @Parameters(name = "{index}: input={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 1 }, { 2 }, { 4 }, { 8 }, { 16 }, { 32 }, { 64 }, { 128 }, { 256 },
                { 512 }, { 1024 } });
    }

    private int input;

    public DequeAdvanceTest(int input) {
        this.input = input;
    }

    @Test
    public void testIsEmpty() {
        Deque<Integer> deq = new Deque<Integer>();
        assertTrue(deq.isEmpty());
        for (Integer item = 0; item < input; item++) {
            deq.addLast(item);
            assertFalse(deq.isEmpty());
        }
        for (int idx = 0; idx < input; idx++) {
            assertFalse(deq.isEmpty());
            deq.removeLast();
        }
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testAddAndRemoveLast() {
        Deque<Integer> deq = new Deque<Integer>();
        assertEquals(0, deq.size());
        for (Integer item = 1; item < input; item++) {
            deq.addLast(item);
            assertEquals((int) item, deq.size());
        }
        for (Integer item = input - 1; item > 0; item--) {
            assertEquals((int) item, deq.size());
            assertEquals(item, deq.removeLast());
        }
        assertEquals(0, deq.size());
    }

    @Test
    public void testAddAndRemoveFirst() {
        Deque<Integer> deq = new Deque<Integer>();
        assertEquals(0, deq.size());
        for (Integer item = 1; item < input; item++) {
            deq.addFirst(item);
            assertEquals((int) item, deq.size());
        }
        for (Integer item = input - 1; item > 0; item--) {
            assertEquals((int) item, deq.size());
            assertEquals(item, deq.removeFirst());
        }
        assertEquals(0, deq.size());
    }

    @Test
    public void testAddFristRemoveLast() {
        Deque<Integer> deq = new Deque<Integer>();
        assertEquals(0, deq.size());
        for (Integer item = 1; item < input; item++) {
            deq.addFirst(item);
            assertEquals((int) item, deq.size());
        }
        for (Integer item = 1; item < input; item++) {
            assertEquals(item, deq.removeLast());
            assertEquals((int) (input - item - 1), deq.size());
        }
        assertEquals(0, deq.size());
    }

    @Test
    public void testAddLastRemoveFirst() {
        Deque<Integer> deq = new Deque<Integer>();
        assertEquals(0, deq.size());
        for (Integer item = 1; item < input; item++) {
            deq.addLast(item);
            assertEquals((int) item, deq.size());
        }
        for (Integer item = 1; item < input; item++) {
            assertEquals(item, deq.removeFirst());
            assertEquals((int) (input - item - 1), deq.size());
        }
        assertEquals(0, deq.size());
    }

    @Test
    public void testIterator() {
        Deque<Integer> deq = new Deque<Integer>();
        for (Integer item = 1; item < input; item++) {
            deq.addLast(item);
        }
        Integer expected = 1;
        for (Integer item : deq) {
            assertEquals(expected, item);
            expected++;
        }
    }
}
