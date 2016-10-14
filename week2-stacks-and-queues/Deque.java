import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

  private class Node {
    private Item item;
    private Node next;
    private Node previous;
  }

  private Node first, last;

  // construct an empty deque
  public Deque() {
    first = null;
    last = first;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return first == null || last == null;
  }

  // return the number of items on the deque
  public int size() {
    int count = 0;
    Node node = first;
    while (node != null) {
      count++;
      node = node.next;
    }
    return count;
  }

  // add the item to the front
  public void addFirst(Item item) {
    if (item == null) {
      throw new java.lang.NullPointerException();
    }
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    if (oldFirst == null) {
      last = first;
    }
    else {
      oldFirst.previous = first;
    }
  }

  // add the item to the end
  public void addLast(Item item) {
    if (item == null) {
      throw new java.lang.NullPointerException();
    }
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    }
    else {
      oldLast.next = last;
      last.previous = oldLast;
    }
  }

  // remove and return the item from the front
  public Item removeFirst() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    Item item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    else {
      first.previous = null;
    }
    return item;
  }

  // remove and return the item from the end
  public Item removeLast() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    Item item = last.item;
    last = last.previous;
    if (isEmpty()) {
      first = null;
    }
    else {
      last.next = null;
    }
    return item;
  }

  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      Item item = current.item;
      current = current.next;
      return item;
    }

    public void remove() {
      throw new java.lang.UnsupportedOperationException();
    }
  }

  // unit testing
  public static void main(String[] args) {
    StdOut.println("Testing");
    Deque<String> d = new Deque<>();
    d.completeState();
    // d.print();
    // StdOut.printf("Size: %s\n", d.size());
    // if(d.isEmpty()) { StdOut.println("Is empty"); }

    d.addFirst("d");
    d.completeState();

    d.addFirst("c");
    d.completeState();

    d.addFirst("b");
    d.completeState();

    d.addLast("e");
    d.completeState();

    d.removeLast();
    d.completeState();

    d.removeLast();
    d.completeState();

    d.removeLast();
    d.completeState();

    d.removeLast();
    d.completeState();

    d.addLast("u");
    d.completeState();

    d.addLast("v");
    d.completeState();

    d.removeFirst();
    d.completeState();

    // for (String s : d) {
    //   StdOut.printf("%s - ", s);
    // }

    // Iterator<String> i = d.iterator();
    // i.remove();

  }

  private void completeState() {
    StdOut.println("\n---------------------");
    StdOut.print("Direct  order: ");
    print();
    StdOut.print("Inverse order: ");
    printReverse();
    StdOut.printf("Size: %d\n", size());
    if (isEmpty())
      StdOut.println("Is empty");
    else
      StdOut.println("Is NOT empty");
  }

  private void print() {
    int count = 0;
    Node node = first;
    while (node != null) {
      StdOut.printf("%s - ", node.item);
      node = node.next;
    }
    StdOut.println();
  }

  private void printReverse() {
    int count = 0;
    Node node = last;
    while (node != null) {
      StdOut.printf("%s - ", node.item);
      node = node.previous;
    }
    StdOut.println();
  }
}
