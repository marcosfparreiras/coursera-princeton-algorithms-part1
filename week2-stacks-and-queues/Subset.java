import edu.princeton.cs.algs4.StdIn;

public class Subset {
  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    int n = 0;
    RandomizedQueue<String> rqueue = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      n++;
      String s = StdIn.readString();
      rqueue.enqueue(s);
    }
    for (int i = 0; i < n - k; i++) {
      rqueue.dequeue();
    }
    for (String s : rqueue) {
      System.out.format("%s\n", s);
    }
  }
}
