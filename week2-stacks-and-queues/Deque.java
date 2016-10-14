import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// public class Deque<Item> implements Iterable<Item> {
public class Deque<Item> {

  private class Node {
    Item item;
    Node next;
    Node previous;
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
    while(node != null) {
      count++;
      node = node.next;
    }
    return count;
  }

  // add the item to the front
  public void addFirst(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    if (oldFirst != null) {
      oldFirst.previous = first;
    }
  }

  // add the item to the end
  public void addLast(Item item) {
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
  // public Iterator<Item> iterator() {

  // }

  // unit testing
  public static void main(String[] args) {
    System.out.println("Testing");
    Deque<String> d = new Deque<>();
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    // d.addFirst("a");
    d.addLast("a");
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

    d.addFirst("k");
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

    d.addLast("b");
    d.addLast("c");
    d.addLast("d");
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

    d.removeFirst();
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

    d.removeFirst();
    d.removeFirst();
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

    d.removeLast();
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

    d.removeLast();
    d.print();
    d.printReverse();
    System.out.format("Size: %s\n\n", d.size());

  }

  private void print() {
    int count = 0;
    Node node = first;
    while(node != null) {
      System.out.format("%s - ", node.item);
      node = node.next;
    }
    System.out.println();
  }

  private void printReverse() {
    int count = 0;
    Node node = last;
    while(node != null) {
      System.out.format("%s - ", node.item);
      node = node.previous;
    }
    System.out.println();
  }
}
