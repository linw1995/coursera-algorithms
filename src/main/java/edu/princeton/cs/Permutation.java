package edu.princeton.cs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
  public static void main(String[] args) {
    Integer k = Integer.parseInt(args[0]);
    if (k == 0) {
      return;
    }
    RandomizedQueue<String> rq = new RandomizedQueue<String>();
    while (!StdIn.isEmpty()) {
      String line = StdIn.readString();
      rq.enqueue(line);
    }

    while (k-- > 0) {
      String line = rq.dequeue();
      StdOut.println(line);
    }
  }
}
