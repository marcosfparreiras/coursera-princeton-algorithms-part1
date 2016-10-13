import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// public class Deque<Item> implements Iterable<Item> {
public class Deque<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private Node first, last;

  // construct an empty deque
  public Deque() {
    first = new Node();
    last = new Node();
    first.next = null;
    last.next = null;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return first == null;
  }

  // return the number of items on the deque
  public int size() {
    int count = 0;
    Node node = first;
    while(node.next != null) {
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
  }

  // add the item to the end
  public void addLast(Item item) {
    // Node oldLast = last;
    // last = new Node();
    // last.item = item;
    // last.next = null;
    // if (isEmpty()) {
    //   first = last;
    // }
    // else {
    //   oldLast.next = last;
    // }
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
    return item;
  }

  private void print() {
    int count = 0;
    Node node = first;
    while(node.next != null) {
      count++;
      System.out.format("%s - ", node.item);
      node = node.next;
    }
    System.out.println();
  }

  // remove and return the item from the end
  // public Item removeLast() {

  // }

  // return an iterator over items in order from front to end
  // public Iterator<Item> iterator() {

  // }

  // unit testing
  public static void main(String[] args) {
    System.out.println("Testing");
    Deque<String> d = new Deque<>();
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    d.addFirst("a");
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    d.addFirst("b");
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    d.removeFirst();
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    // d.addLast("d");
    // d.print();
    // System.out.format("Size: %s\n\n", d.size());

    d.addFirst("e");
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    d.removeFirst();
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    d.removeFirst();
    d.print();
    System.out.format("Size: %s\n\n", d.size());

    d.removeFirst();
    d.print();
    System.out.format("Size: %s\n\n", d.size());
  }
}
