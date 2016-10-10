public class PercolationClient {
  // test client (optional)
  public static void main(String[] args) {
    Percolation p = new Percolation(3);
    System.out.println("\nInitial Configuration");
    System.out.println("--------------------");
    p.open(2, 1);
    p.open(1, 2);
    System.out.println("\nIntermediary Configuration");
    System.out.format("(2,2) is open?, %b\n", p.isOpen(2, 3));
    System.out.format("(2,2) is full?, %b\n", p.isFull(2, 2));
    System.out.println("--------------------");
    p.open(2, 2);
    p.open(2, 3);
    p.open(3, 3);
    System.out.println("\nFinal Configuration");
    System.out.println("");
    System.out.format("(2,2) is open?, %b\n", p.isOpen(2, 3));
    System.out.format("(2,2) is full?, %b\n", p.isFull(2, 2));
    System.out.format("percolates?, %b\n", p.percolates());
    System.out.println("--------------------\n");
  }
}
