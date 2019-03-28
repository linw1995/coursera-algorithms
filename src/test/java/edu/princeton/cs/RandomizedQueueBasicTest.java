package edu.princeton.cs;

import java.lang.IllegalArgumentException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomizedQueueBasicTest {
    @Test
    public void testIsEmpty() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assertTrue(rq.isEmpty());
        Integer item = 1;
        rq.enqueue(item);
        assertFalse(rq.isEmpty());
        assertEquals(item, rq.dequeue());
        assertTrue(rq.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnqueueInvalidItem() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueFromEmptyQueue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testSampleFromEmptyQueue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.sample();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCallUnsupportOperation() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        Iterator<Integer> iterator = rq.iterator();
        iterator.remove();
    }
}
