import java.util.Arrays;

public class FastCollinearPoints {
    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i + 1 < points.length; ++i) {
            if (points[i] == null) throw new IllegalArgumentException();
            if (points[i].compareTo(points[i + 1]) == 0) throw new IllegalArgumentException();
        }
    }
    // the number of line segments
    public int numberOfSegments() {
        return 0;
    }
    // the line segments
    public LineSegment[] segments() {
        return null;
    }
}