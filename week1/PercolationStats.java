import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.util.ArrayList;

public class PercolationStats {

  private double[] results;
  private int n;
  private int trials;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }
    this.n = n;
    this.trials = trials;
    this.results = new double[trials];
    // Run experiment for each trial
    for (int i = 0; i < trials; i++) {
      this.results[i] = monteCarmoSimulation();
    }
    // printReport();
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(results);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(results);
  }

  // low  endpoint of 95% confidence interval
  public double confidenceLo() {
    return mean() - (1.96 * stddev() / Math.sqrt(n));
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean() + (1.96 * stddev() / Math.sqrt(n));
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Error! Pass the size and trials for the experiment:");
      System.out.println("To run a experiment with size 200 over 100 trials:");
      System.out.println("$ java-algs4 PercolationStats 200 100");
      return;
    }
    int n = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    new PercolationStats(n, trials);
  }

  private double monteCarmoSimulation() {
    // Initialize ArrayList to control blocked sites with all indexes from 0 to n*n-1
    ArrayList<Integer> blockedSites = new ArrayList<Integer>();
    for (int i = 0; i < n * n; i++) {
      blockedSites.add(i);
    }
    double opennedSites = 0;
    // Initialize all sites to be blocked.
    Percolation p = new Percolation(n);
    // Repeat the following until the system percolates:

    while (!p.percolates()) {
      int arrayListIndex = StdRandom.uniform(blockedSites.size());
      int linearIndex = blockedSites.remove(arrayListIndex);
      int sitei = linearIndex / n + 1;
      int sitej = linearIndex % n + 1;

      // int sitei = StdRandom.uniform(n) + 1;
      // int sitej = StdRandom.uniform(n) + 1;
      // Open the site (row i, column j).
      // if (!p.isOpen(sitei, sitej)) {
        p.open(sitei, sitej);
        opennedSites++;
      // }
    }
    return opennedSites / (n * n);
  }

  // private void printReport() {
  //   System.out.format("\nExperiment size: n = %d; trials = %d\n", n, trials);
  //   System.out.format("mean: %f\n", mean());
  //   System.out.format("stddev: %f\n", stddev());
  //   System.out.format(
  //     "95%% confidence interval: %f, %f\n\n", confidenceLo(), confidenceHi()
  //   );
  // }
}
