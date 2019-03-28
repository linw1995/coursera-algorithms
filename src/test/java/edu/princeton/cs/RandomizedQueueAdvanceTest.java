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
public class RandomizedQueueAdvanceTest {

    @Parameters(name = "{index}: input={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 1 }, { 2 }, { 4 }, { 8 }, { 16 }, { 32 }, { 64 }, { 128 }, { 256 },
                { 512 }, { 1024 } });
    }

    private int input;

    public RandomizedQueueAdvanceTest(int input) {
        this.input = input;
    }

    @Test
    public void testIsEmpty() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assertTrue(rq.isEmpty());
        for (Integer item = 0; item < input; item++) {
            rq.enqueue(item);
            assertFalse(rq.isEmpty());
        }
        for (int idx = 0; idx < input; idx++) {
            assertFalse(rq.isEmpty());
            rq.dequeue();
        }
        assertTrue(rq.isEmpty());
    }

    @Test
    public void testEnqueueDequeue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assertEquals(0, rq.size());
        for (Integer item = 1; item < input; item++) {
            rq.enqueue(item);
            assertEquals((int) item, rq.size());
        }
        for (Integer item = input - 1; item > 0; item--) {
            assertEquals((int) item, rq.size());
            rq.dequeue();
        }
        assertEquals(0, rq.size());
    }

    @Test
    public void testIterator() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        for (Integer item = 1; item < input; item++) {
            rq.enqueue(item);
        }
        for (Integer item : rq) {

        }
    }
}
