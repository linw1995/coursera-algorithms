package edu.princeton.cs;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private int MIN_CAPACITY = 4;
  private static final double LARGE_SIZE_RATIO = 1.5;

  private Item[] arr;
  private int endIdx;

  // construct an empty randomized queue
  public RandomizedQueue() {
    this.arr = (Item[]) new Object[MIN_CAPACITY];
    this.endIdx = 0;
  }

  // is the randomized queue empty?
  public boolean isEmpty() { return this.endIdx == 0; }

  private int capacity() { return this.arr.length; }

  private void resize(int capacity) {
    Item[] newArr = (Item[]) new Object[capacity];
    System.arraycopy(this.arr, 0, newArr, 0, this.size());
    this.arr = newArr;
  }

  // return the number of items on the randomized queue
  public int size() { return this.endIdx; }

  // add the item
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    this.arr[this.endIdx++] = item;

    if (this.size() >= this.capacity()) {
      this.resize((int)(this.capacity() * LARGE_SIZE_RATIO));
    }
  }

  // remove and return a random item
  public Item dequeue() {
    if (this.size() <= 0) {
      throw new NoSuchElementException();
    }
    int idx = StdRandom.uniform(0, this.endIdx);
    Item item = this.arr[idx];
    this.arr[idx] = this.arr[--this.endIdx];
    this.arr[this.endIdx] = null;

    if (this.size() > MIN_CAPACITY && this.size() <= this.capacity() / 4) {
      this.resize(this.capacity() / 2);
    }
    return item;
  }

  // return a random item (but do not remove it)
  public Item sample() {
    if (this.size() <= 0) {
      throw new NoSuchElementException();
    }
    int idx = StdRandom.uniform(0, this.endIdx);
    return this.arr[idx];
  }

  private RandomizedQueue<Item> copy() {
    RandomizedQueue<Item> rv = new RandomizedQueue<Item>();
    rv.arr = (Item[]) new Object[this.size()];
    rv.endIdx = this.size();
    rv.MIN_CAPACITY = this.size();
    System.arraycopy(this.arr, 0, rv.arr, 0, this.size());
    return rv;
  }

  private class RandomizedQueueIterator implements Iterator<Item> {
    private RandomizedQueue<Item> rq;

    public RandomizedQueueIterator(RandomizedQueue<Item> randomizedQueue) {
      this.rq = randomizedQueue.copy();
    }

    public boolean hasNext() { return this.rq.size() > 0; }

    public Item next() { return this.rq.dequeue(); }
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() { return new RandomizedQueueIterator(this); }
}
