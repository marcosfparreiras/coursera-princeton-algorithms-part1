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
      int siteIndex = linearIndex(1, j);
      this.unionFind.union(siteIndex, this.virtualTopIndex);
    }

    // Connect last row to virtual bottom site
    this.virtualBottomIndex = n * n + 1;
    for (int j = 1; j <= n; j++) {
      int siteIndex = linearIndex(n, j);
      this.unionFind.union(siteIndex, this.virtualBottomIndex);
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
    int siteIndex = linearIndex(i, j);
    return isOpen(i, j) && unionFind.connected(siteIndex, virtualTopIndex);
  }

  // does the system percolate?
  public boolean percolates() {
    return this.unionFind.connected(virtualTopIndex, virtualBottomIndex);
  }

  private void connectToAdjacents(int i, int j) {
    connectToAdjacent(i, j, i, j - 1);
    connectToAdjacent(i, j, i, j + 1);
    connectToAdjacent(i, j, i - 1, j);
    connectToAdjacent(i, j, i + 1, j);
  }

  private void connectToAdjacent(int i, int j, int ii, int jj) {
    int siteIndex = linearIndex(i, j);
    int adjacentIndex = linearIndex(ii, jj);
    if (ii >= 1 && ii <= n && jj >= 1 && jj <= n) {
      if (isOpen(ii, jj)) {
        this.unionFind.union(siteIndex, adjacentIndex);
      }
    }
  }

  private int linearIndex(int i, int j) {
    return n * (i-1) + j -1;
  }
}
