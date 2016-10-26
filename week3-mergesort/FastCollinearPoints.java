import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;

public class FastCollinearPoints {

  private ArrayList<LineSegment> segments = new ArrayList<>();

   // finds all line segments containing 4 points
  public FastCollinearPoints(Point[] points) {
    // corner cases
    if (points == null) {
      throw new java.lang.NullPointerException("argument is null");
    }
    Point[] pointsCopy = points.clone();
    Arrays.sort(pointsCopy);
    treatCornerCasesForPoints(pointsCopy);
    findAllLineSegments(pointsCopy);
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
  public static void main(String[] args) {
    // read the n points from a file
    In in = new In(args[0]);
    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = in.readInt();
      int y = in.readInt();
      points[i] = new Point(x, y);
    }

    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
      p.draw();
    }
    StdDraw.show();

    // print and draw the line segments
    FastCollinearPoints collinear = new FastCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
      StdOut.println(segment);
      segment.draw();
    }
    StdDraw.show();
  }

  private void findAllLineSegments(Point[] points) {
    for (int i = 0; i < points.length - 3; i++) {
      Arrays.sort(points, points[i].slopeOrder());

      for (int p = 0, first = 1, last = 2; last < points.length; last++) {
        // find last collinear to p point
        while (last < points.length &&
           points[p].slopeTo(points[first]) == points[p].slopeTo(points[last])) {
          last++;
        }
        // if found at least 3 elements, make segment if it's unique
        if (last - first >= 3 && points[p].compareTo(points[first]) < 0) {
          segments.add(new LineSegment(points[p], points[last - 1]));
        }
        // Try to find next
        first = last;
      }
    }
  }

  private void treatCornerCasesForPoints(Point[] points) {
    for (int i = 0; i < points.length - 1; i++) {
      if (points[i] == null) {
        throw new java.lang.NullPointerException("any point is null");
      }
      for (int j = i + 1; j < points.length; j++) {
        if (points[i].compareTo(points[j]) == 0) {
          throw new java.lang.IllegalArgumentException(
            "argument to the constructor contains a repeated point"
          );
        }
      }
    }
  }
}
