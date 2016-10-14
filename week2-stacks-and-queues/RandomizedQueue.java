import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private class Node {
    private Item item;
    private Node next;
    private Node previous;
  }

  private Item[] s;
  private int n = 0;

  // construct an empty randomized queue
  public RandomizedQueue() {
    s = (Item[]) new Object[1];
  }

  // // is the queue empty?
  public boolean isEmpty() {
    return n == 0;
  }

  // // return the number of items on the queue
  public int size() {
    return n;
  }

  // // add the item
  public void enqueue(Item item) {
    if (item == null) {
      throw new java.lang.NullPointerException();
    }
    if (n == s.length) {
      resize(2 * s.length);
    }
    s[n++] = item;
  }

  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = s[i];
    }
    s = copy;
  }

  // // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    int pickedIndex = StdRandom.uniform(size());
    Item item = s[pickedIndex];
    s[pickedIndex] = s[--n];
    s[n] = null;
    if (n > 0 && n == s.length/4) {
      resize(s.length/2);
    }
    return item;
  }

  // // return (but do not remove) a random item
  public Item sample() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return s[StdRandom.uniform(size())];
  }

  // // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private class RandomizedQueueIterator implements Iterator<Item> {
    private int i = 0;
    private Item[] shuffledQueue = shuffleQueue();

    public boolean hasNext() {
      return i < n;
    }

    public void remove() {
      throw new java.lang.UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      return shuffledQueue[i++];
    }

    private Item[] shuffleQueue() {
      Item[] queueCopy = (Item[]) new Object[n];
      for (int k = 0; k < n; k++) {
        queueCopy[k] = s[k];
      }
      StdRandom.shuffle(queueCopy);
      return queueCopy;
    }
  }

  // unit testing
  public static void main(String[] args) {
    System.out.println("Testing");
    RandomizedQueue<String> rq = new RandomizedQueue<String>();
    rq.enqueue("a");
    rq.enqueue("b");
    rq.enqueue("c");
    rq.enqueue("d");
    rq.enqueue("e");
    rq.enqueue("f");
    rq.enqueue("g");
    rq.print();
    System.out.format("Dequeued: %s\n", rq.dequeue());
    rq.print();
    System.out.format("Dequeued: %s\n", rq.dequeue());
    rq.print();


    System.out.println("Using Iterator:");
    for (String s : rq) {
      System.out.format("%s - ", s);
    }
    System.out.println();

    System.out.println("Using Iterator:");
    for (String s : rq) {
      System.out.format("%s - ", s);
    }
    System.out.println();

    System.out.println("Using Iterator:");
    for (String s : rq) {
      System.out.format("%s - ", s);
    }
    System.out.println();
    System.out.println(rq.size());
    System.out.println(rq.sample());
    System.out.println(rq.sample());
  }

  private void print() {
    for (int i = 0; i < size(); i++) {
      System.out.format("%s - ", s[i]);
    }
    System.out.println();
  }
}
