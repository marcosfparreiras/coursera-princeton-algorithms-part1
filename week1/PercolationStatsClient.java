public class PercolationStatsClient {
  // test client (optional)
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
}
