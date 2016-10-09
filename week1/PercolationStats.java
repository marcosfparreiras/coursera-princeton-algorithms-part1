// import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private double[] results;
  private int n;
  private int trials;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    this.n = n;
    this.trials = trials;
    this.results = new double[trials];
    // Run experiment for each trial
    for (int i = 0; i < trials; i++) {
      this.results[i] = MonteCarmoSimulationSimulation(n);
    }
    printReport();
  }

  public void printReport() {
    System.out.format("\nmean: %f\n", this.mean());
    System.out.format("stddev: %f\n", this.stddev());
    // System.out.format("mean: %f", this.mean());
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(results);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(results);
  }

  // // low  endpoint of 95% confidence interval
  // public double confidenceLo()

  // // high endpoint of 95% confidence interval
  // public double confidenceHi()

  public static void main(String[] args) {    // test client (described below)
    PercolationStats stats = new PercolationStats(200, 100);
  }

  private double MonteCarmoSimulationSimulation(int n) {
    // Initialize all sites to be blocked.
    Percolation p = new Percolation(n);
    // Repeat the following until the system percolates:
    while(!p.percolates()) {
      int sitei = StdRandom.uniform(n) + 1;
      int sitej = StdRandom.uniform(n) + 1;
      // Open the site (row i, column j).
      p.open(sitei, sitej);
    }
    return rate;
  }
}
