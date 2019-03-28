package edu.princeton.cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.IllegalArgumentException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;

public class DequeBasicTest {
  @Test
  public void testIsEmpty() {
    Deque<Integer> deq = new Deque<Integer>();
    assertTrue(deq.isEmpty());
    Integer item = 1;
    deq.addLast(item);
    assertFalse(deq.isEmpty());
    assertEquals(item, deq.removeLast());
    assertTrue(deq.isEmpty());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddFirstInvalidItem() {
    Deque<Integer> deq = new Deque<Integer>();
    deq.addFirst(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddLastInvalidItem() {
    Deque<Integer> deq = new Deque<Integer>();
    deq.addLast(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void testRemoveFirstFromEmptyDeque() {
    Deque<Integer> deq = new Deque<Integer>();
    deq.removeFirst();
  }

  @Test(expected = NoSuchElementException.class)
  public void testRemoveLastFromEmptyDeque() {
    Deque<Integer> deq = new Deque<Integer>();
    deq.removeLast();
  }

  @Test(expected = NoSuchElementException.class)
  public void testNextFromEmptyIterator() {
    Deque<Integer> deq = new Deque<Integer>();
    Iterator<Integer> iterator = deq.iterator();
    iterator.next();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testCallUnsupportOperation() {
    Deque<Integer> deq = new Deque<Integer>();
    Iterator<Integer> iterator = deq.iterator();
    iterator.remove();
  }

  @Test
  public void testIntermixedOperation() {
    Deque<Integer> deque = new Deque<Integer>();
    deque.addLast(1);
    for (Integer item : deque) {
      assertEquals(1, (int)item);
    }
    assertEquals(1, (int)deque.removeFirst());
    assertFalse(deque.iterator().hasNext());
    deque.addLast(3);
    for (Integer item : deque) {
      assertEquals(3, (int)item);
    }
    assertEquals(3, (int)deque.removeFirst());
    assertFalse(deque.iterator().hasNext());
    deque.addLast(5);
    for (Integer item : deque) {
      assertEquals(5, (int)item);
    }
    deque.addLast(6);
    Integer expects[] = {5, 6};
    int idx = 0;
    for (Integer item : deque) {
      assertEquals(expects[idx++], item);
    }
  }
}
