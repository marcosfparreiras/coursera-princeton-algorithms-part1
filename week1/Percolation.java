import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private static final int CLOSED = 0;
  private static final int OPENED = 1;
  private int n;
  private int[] sites;
  private int virtualTopIndex;
  private int virtualBottomIndex;
  private WeightedQuickUnionUF unionFind;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException(Integer.toString(n));
    }
    this.n = n;
    this.unionFind = new WeightedQuickUnionUF(n * n + 2);
    this.sites = new int[n*n];

    // Initialize sites array
    for (int i = 0; i < n*n; i++) {
      this.sites[i] = CLOSED;
    }

    // Connect first row to virtual top site
    this.virtualTopIndex = n * n;
    for (int j = 1; j <= n; j++) {
      int site_index = linearIndex(1, j);
      this.unionFind.union(site_index, this.virtualTopIndex);
    }

    // Connect last row to virtual bottom site
    this.virtualBottomIndex = n * n + 1;
    for (int j = 1; j <= n; j++) {
      int site_index = linearIndex(n, j);
      this.unionFind.union(site_index, this.virtualBottomIndex);
    }
  }

  // open site (row i, column j) if it is not open already
  public void open(int i, int j) {
    if (i <= 0 || i > n || j <= 0 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
    this.sites[linearIndex(i, j)] = OPENED;
    this.connectToAdjacents(i, j);
  }

  // is site (row i, column j) open?
  public boolean isOpen(int i, int j) {
    if (i <= 0 || i > n || j <= 0 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
    return this.sites[linearIndex(i, j)] == OPENED;
  }

  // is site (row i, column j) full?
  public boolean isFull(int i, int j) {
    int site_index = linearIndex(i, j);
    return unionFind.connected(site_index, virtualTopIndex);
  }

  // does the system percolate?
  public boolean percolates() {
    return this.unionFind.connected(virtualTopIndex, virtualBottomIndex);
  }

  public void printSites() {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.format("  %d", sites[linearIndex(i, j)]);
      }
      System.out.println("");
    }
  }

  public double openSitesRate() {
    int openned = opennedSites();
    return (double) openned / n;
  }

  // test client (optional)
  public static void main(String[] args) {
    Percolation p = new Percolation(3);
    System.out.println("\nInitial Configuration");
    p.printSites();
    System.out.println("--------------------");
    p.open(2, 1);
    p.open(1, 2);
    System.out.println("\nIntermediary Configuration");
    p.printSites();
    System.out.format("(2,2) is open?, %b\n", p.isOpen(2, 3));
    System.out.format("(2,2) is full?, %b\n", p.isFull(2, 2));
    System.out.println("--------------------");
    p.open(2, 2);
    p.open(2, 3);
    p.open(3, 3);
    System.out.println("\nFinal Configuration");
    p.printSites();
    System.out.println("");
    System.out.format("(2,2) is open?, %b\n", p.isOpen(2, 3));
    System.out.format("(2,2) is full?, %b\n", p.isFull(2, 2));
    System.out.format("percolates?, %b\n", p.percolates());
    System.out.println("--------------------\n");
  }

  private int opennedSites() {
    int openned = 0;
    for (int i = 0; i < n; i++) {
      if (sites[i] == OPENED) {
        openned++;
      }
    }
    return openned;
  }

  private void connectToAdjacents(int i, int j) {
    connectToAdjacent(i, j, i, j - 1);
    connectToAdjacent(i, j, i, j + 1);
    connectToAdjacent(i, j, i - 1, j);
    connectToAdjacent(i, j, i + 1, j);
  }

  private void connectToAdjacent(int i, int j, int ii, int jj) {
    int site_index = linearIndex(i, j);
    int adjacent_index = linearIndex(ii, jj);
    if (ii >= 1 && ii <= n && jj >= 1 && jj <= n) {
      if (isOpen(ii, jj)) {
        this.unionFind.union(site_index, adjacent_index);
      }
    }
  }

  private int linearIndex(int i, int j) {
    return n * (i-1) + j -1;
  }
}
