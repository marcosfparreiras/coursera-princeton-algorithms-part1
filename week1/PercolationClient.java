public class PercolationClient {
  // test client (optional)
  public static void main(String[] args) {
    example2();
  }

  public static void example2() {
    int n = 5;
    Percolation p = new Percolation(n);

    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");

    p.open(1,3);
    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");

    p.open(4,4);
    p.open(4,3);
    p.open(3,3);
    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");

    p.open(2,4);
    p.open(4,5);
    p.open(3,5);
    p.open(2,5);
    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");

    p.open(1,5);
    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");

    p.open(5,2);
    p.open(5,1);
    p.open(4,1);
    p.open(3,1);
    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");

    p.open(3,2);
    p.printSites();
    showAllFull(p, n);
    System.out.println("-----------------");
  }

  public static void showAllFull(Percolation p, int n) {
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if(p.isFull(i,j)) {
          System.out.format("%d, %d is full\n", i, j);
        }
      }
    }
  }

  public static void example1() {
    Percolation p = new Percolation(5);
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
