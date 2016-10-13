import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private int[] sites;
  private int n;
  private int virtualTopIndex;
  private int virtualBottomIndex;
  private WeightedQuickUnionUF unionFind;
  private WeightedQuickUnionUF unionFindFull;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    this.n = n;
    this.unionFind = new WeightedQuickUnionUF(n * n + 2);
    this.unionFindFull = new WeightedQuickUnionUF(n * n + 2);
    this.sites = new int[n*n];

    // Initialize sites array
    for (int i = 0; i < n*n; i++) {
      this.sites[i] = 0;
    }
    // Set virtualTopIndex
    this.virtualTopIndex = n * n;
    // Set virtualBottomIndex
    this.virtualBottomIndex = n * n + 1;
  }

  // open site (row i, column j) if it is not open already
  public void open(int i, int j) {
    if (i < 1 || i > n || j < 1 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
    this.sites[linearIndex(i, j)] = 1;
    this.connectToAdjacents(i, j);
    this.connectToVirtualIndexes(i, j);
  }

  // is site (row i, column j) open?
  public boolean isOpen(int i, int j) {
    if (i < 1 || i > n || j < 1 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
    return this.sites[linearIndex(i, j)] == 1;
  }

  // is site (row i, column j) full?
  public boolean isFull(int i, int j) {
    if (i < 1 || i > n || j < 1 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
    if (isOpen(i, j)) {
      int siteIndex = linearIndex(i, j);
      return unionFindFull.connected(siteIndex, virtualTopIndex);
    }
    return false;
  }

  // does the system percolate?
  public boolean percolates() {
    return unionFind.connected(virtualTopIndex, virtualBottomIndex);
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
        this.unionFindFull.union(siteIndex, adjacentIndex);
      }
    }
  }

  private void connectToVirtualIndexes(int i, int j) {
    int siteIndex = linearIndex(i, j);
    if (i == 1) {
      this.unionFind.union(siteIndex, this.virtualTopIndex);
      this.unionFindFull.union(siteIndex, this.virtualTopIndex);
    }
    if (i == n) {
      this.unionFind.union(siteIndex, this.virtualBottomIndex);
    }
  }

  private int linearIndex(int i, int j) {
    return n * (i-1) + j -1;
  }
}
