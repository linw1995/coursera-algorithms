package edu.princeton.cs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  private static final int MIN_CAPACITY = 4;
  private static final double LARGE_SIZE_RATIO = 1.5;

  private Item[] arr;
  private int beginIdx;
  private int endIdx;

  // construct an empty deque
  public Deque() {
    this.arr = (Item[]) new Object[MIN_CAPACITY];
    this.beginIdx = 0;
    this.endIdx = 0;
  }

  // is the deque empty?
  public boolean isEmpty() { return this.beginIdx == this.endIdx; }

  // return the capacity of deque
  private int capacity() { return this.arr.length; }

  // return the number of items on the deque
  public int size() {
    if (this.beginIdx <= this.endIdx) {
      return this.endIdx - this.beginIdx;
    } else {
      return this.capacity() + this.endIdx - this.beginIdx;
    }
  }

  private void resize(int capacity) {
    Item[] newArr = (Item[]) new Object[capacity];

    if (this.endIdx > this.beginIdx) {
      System.arraycopy(this.arr, this.beginIdx, newArr, 0, this.size());
    } else {
      System.arraycopy(this.arr, this.beginIdx, newArr, 0,
                       this.capacity() - this.beginIdx);
      System.arraycopy(this.arr, 0, newArr, this.capacity() - this.beginIdx,
                       this.endIdx);
    }

    this.endIdx = this.size();
    this.arr = newArr;
    this.beginIdx = 0;
  }

  // add the item to the front
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    int nextBeginIdx = this.beginIdx - 1;
    if (nextBeginIdx < 0) {
      nextBeginIdx = this.capacity() + nextBeginIdx;
    }
    if (nextBeginIdx == this.endIdx) {
      this.resize((int)(this.capacity() * LARGE_SIZE_RATIO));
      nextBeginIdx = this.capacity() - 1;
    }
    this.arr[nextBeginIdx] = item;
    this.beginIdx = nextBeginIdx;
  }

  // add the item to the end
  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    int nextEndIdx = this.endIdx + 1;
    if (nextEndIdx >= this.capacity()) {
      nextEndIdx = nextEndIdx - this.capacity();
    }
    if (nextEndIdx == this.beginIdx) {
      this.resize((int)(this.capacity() * LARGE_SIZE_RATIO));
      nextEndIdx = this.endIdx + 1;
    }
    this.arr[this.endIdx] = item;
    this.endIdx = nextEndIdx;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    int nextSize = this.size() - 1;
    if (nextSize < 0) {
      throw new NoSuchElementException();
    }
    if (nextSize > MIN_CAPACITY && nextSize < this.capacity() / 4) {
      this.resize(this.capacity() / 2);
    }
    int nextBeginIdx = this.beginIdx + 1;
    if (nextBeginIdx >= this.capacity()) {
      nextBeginIdx = 0;
    }
    Item item = this.arr[this.beginIdx];
    this.arr[beginIdx] = null;
    this.beginIdx = nextBeginIdx;
    return item;
  }

  // remove and return the item from the end
  public Item removeLast() {
    int nextSize = this.size() - 1;
    if (nextSize < 0) {
      throw new NoSuchElementException();
    }
    if (nextSize > MIN_CAPACITY && nextSize < this.capacity() / 4) {
      this.resize(this.capacity() / 2);
    }
    int nextEndIdx = this.endIdx - 1;
    if (nextEndIdx < 0) {
      nextEndIdx = this.capacity() - 1;
    }
    Item item = this.arr[nextEndIdx];
    this.arr[nextEndIdx] = null;
    this.endIdx = nextEndIdx;
    return item;
  }

  private class DequeIterator implements Iterator<Item> {
    private int curIdx;

    public DequeIterator() { curIdx = beginIdx; }

    public boolean hasNext() { return curIdx != endIdx; }

    public Item next() {
      Item item = arr[curIdx++];
      if (item == null) {
        throw new NoSuchElementException();
      }
      if (endIdx > beginIdx) {
        if (curIdx < beginIdx) {
          curIdx = beginIdx;
        }
      } else {
        if (curIdx >= capacity()) {
          curIdx = 0;
        }
      }
      return item;
    }
  }

  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() { return new DequeIterator(); }
}
