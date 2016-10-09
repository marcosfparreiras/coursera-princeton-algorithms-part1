import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  // create n-by-n grid, with all sites blocked

  private int n;
  private int[] sites;
  private int virtual_top_index;
  private int virtual_bottom_index;
  public WeightedQuickUnionUF unionfind;
  private static final int CLOSED = 0;
  private static final int OPENED = 1;

  public Percolation(int n) {
    if(n <= 0) {
      throw new IllegalArgumentException(Integer.toString(n));
    }
    this.n = n;
    this.unionfind = new WeightedQuickUnionUF(n * n + 2);
    this.sites = new int[n*n];

    // Initialize sites array
    for (int i = 0; i < n*n; i++) {
      this.sites[i] = CLOSED;
    }

    // Connect first row to virtual top site
    this.virtual_top_index = n * n;
    for (int j = 1; j <= n; j++) {
      int site_index = linearIndex(1, j);
      this.unionfind.union(site_index, this.virtual_top_index);
    }

    // Connect last row to virtual bottom site
    this.virtual_bottom_index = n * n + 1;
    for (int j = 1; j <= n; j++) {
      int site_index = linearIndex(n, j);
      this.unionfind.union(site_index, this.virtual_bottom_index);
    }
  }

  // open site (row i, column j) if it is not open already
  public void open(int i, int j) {
    if(i <= 0 || i > n || j <=0 || j > n) {
      throw new java.lang.IndexOutOfBoundsException();
    }
    this.sites[linearIndex(i,j)] = OPENED;
    this.connectToAdjacents(i, j);
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
    if ( ii >= 1 && ii <= n && jj >= 1 && jj <= n ) {
      System.out.println("Valido");
      if(isOpen(ii, jj)) {
        System.out.println("UMA VEZ");
        this.unionfind.union(site_index, adjacent_index);
      }
    }
  }

  public int linearIndex(int i, int j) {
    return n * (i-1) + j -1;
  }

   // is site (row i, column j) open?
   public boolean isOpen(int i, int j) {
     return this.sites[linearIndex(i,j)] == OPENED;
   }

   // is site (row i, column j) full?
   public boolean isFull(int i, int j) {

   }

   // does the system percolate?
   public boolean percolates() {
     return this.unionfind.connected(virtual_top_index, virtual_bottom_index);
   }

  public void pritSites() {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n; j++) {
        System.out.format("  %d", sites[linearIndex(i,j)]);
      }
      System.out.println("");
    }
  }

   // test client (optional)
   public static void main(String[] args) {
     System.out.println("Testing client");

     int n = 10;
     if(args.length != 0) {
       n = Integer.parseInt(args[0]);
     }

     System.out.format("Using n: %d\n", n);
     Percolation p = new Percolation(n);
     p.pritSites();
     p.open(1,2);
     p.pritSites();
     p.open(1,3);
     p.pritSites();
     System.out.format("(1,1) is open?, %b\n", p.isOpen(1,1));
     System.out.format("(1,2) is open?, %b\n", p.isOpen(1,2));
     System.out.format("(1,2) is open?, %b\n", p.isOpen(1,3));
     int index1 = p.linearIndex(1,2);
     int index2 = p.linearIndex(1,3);
     System.out.println(p.unionfind.connected(index1, index2));

   }
}

// 0  1  2  3  4
// 5  6  7  8  9
// 10 11 12 13 14
// 15 16 17 18 19
// 20 21 22 23 24

// n * (i-1) + j -1
// n = 5

// 1, 5


// i=1, y=1
// 0

// i=3, y=1
// 10

// i=4, y=5
// 19
// 5*3 + 4
