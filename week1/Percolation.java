import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  // create n-by-n grid, with all sites blocked

  private int n;

  public Percolation(int n) {
    if(n <= 0) {
      throw new IllegalArgumentException(Integer.toString(n));
    }
    this.n = n;
    WeightedQuickUnionUF unionfind = new WeightedQuickUnionUF(n * n);
  }

  // open site (row i, column j) if it is not open already
  public void open(int i, int j) {
    if(i <= 0 || i > n || j <=0 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
  }

  //  // is site (row i, column j) open?
  //  public boolean isOpen(int i, int j)

  //  // is site (row i, column j) full?
  //  public boolean isFull(int i, int j)

  //  // does the system percolate?
  //  public boolean percolates()

   // test client (optional)
   public static void main(String[] args) {
     System.out.println("Testing client");

     int n = 10;
     if(args.length != 0) {
       n = Integer.parseInt(args[0]);
     }

     System.out.format("Using n: %d\n", n);
     new Percolation(n);
   }
}
