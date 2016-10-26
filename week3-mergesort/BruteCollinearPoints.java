import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
  // finds all line segments containing 4 points

  private ArrayList<LineSegment> segments = new ArrayList<>();

  public BruteCollinearPoints(Point[] points) {
    // corner cases
    if (points == null) {
      throw new java.lang.NullPointerException("argument is null");
    }
    Arrays.sort(points);
    treatCornerCasesForPoints(points);
    findAllLineSegments(points);

  }

  // the number of line segments
  public int numberOfSegments() {
    return this.segments.size();
  }

  // the line segments
  public LineSegment[] segments() {
    return segments.toArray(new LineSegment[segments.size()]);
  }

  // Client for unit testing
  // public static void main(String[] args) {
  //   // read the n points from a file
  //   In in = new In(args[0]);
  //   int n = in.readInt();
  //   Point[] points = new Point[n];
  //   for (int i = 0; i < n; i++) {
  //     int x = in.readInt();
  //     int y = in.readInt();
  //     points[i] = new Point(x, y);
  //   }

  //   // draw the points
  //   StdDraw.enableDoubleBuffering();
  //   StdDraw.setXscale(0, 32768);
  //   StdDraw.setYscale(0, 32768);
  //   for (Point p : points) {
  //     p.draw();
  //   }
  //   StdDraw.show();

  //   // print and draw the line segments
  //   BruteCollinearPoints collinear = new BruteCollinearPoints(points);
  //   for (LineSegment segment : collinear.segments()) {
  //     StdOut.println(segment);
  //     segment.draw();
  //   }
  //   StdDraw.show();
  // }

  private void findAllLineSegments(Point[] points) {
    for (int first = 0; first < points.length - 4; first++) {
      for (int second = first + 1; second < points.length - 3; second++) {
        double slope12 = points[first].slopeTo(points[second]);
        for (int third = second + 1; third < points.length - 2; third++) {
          double slope23 = points[second].slopeTo(points[third]);
          for (int forth = 0; third + 1 < points.length - 1; forth++) {
            double slope34 = points[third].slopeTo(points[forth]);
            if (slope12 == slope34) {
              this.segments.add(new LineSegment(points[first], points[forth]));
            }
          }
        }
      }
    }
  }

  private void treatCornerCasesForPoints(Point[] points) {
    for (int i = 0; i < points.length - 2; i++) {
      if (points[i] == null) {
        throw new java.lang.NullPointerException("any point is null");
      }
      if (points[i] == points[i+1]) {
        throw new java.lang.IllegalArgumentException(
          "argument to the constructor contains a repeated point"
        );
      }
    }
  }
}
