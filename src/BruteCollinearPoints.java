import java.util.Arrays;

public class BruteCollinearPoints {
    private int numberOfSegments = 0;
    private LineSegment[] lineSegment;
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        lineSegment = new LineSegment[points.length/4];
        for (int i0 = 0; i0 < points.length - 3; ++i0) {
            for (int i1 = i0 + 1; i1 < points.length - 2; ++i1) {
                for (int i2 = i1 + 1; i2 < points.length - 1; ++i2) {
                    if (points[i0].slopeTo(points[i1]) == points[i0].slopeTo(points[i2])) {
                        for (int i3 = i2 + 1; i3 < points.length; ++i3) {
                            if (points[i0].slopeTo(points[i1])  == points[i0].slopeTo(points[i3])) {
                                Point[] pointsSegment = new Point[4];
                                pointsSegment[0] = points[i0];
                                pointsSegment[1] = points[i1];
                                pointsSegment[2] = points[i2];
                                pointsSegment[3] = points[i3];
                                Arrays.sort(pointsSegment);
                                lineSegment[numberOfSegments] = new LineSegment(pointsSegment[0], pointsSegment[3]);
                                numberOfSegments++;
                            }
                        }
                    }
                }
            }
        }
        LineSegment[] buffLineSegment = lineSegment;
        lineSegment = new LineSegment[numberOfSegments];
        for (int i = 0; i < lineSegment.length; ++i) {
            lineSegment[i] = buffLineSegment[i];
        }
    }
    // the number of line segments
    public int numberOfSegments() {
        return numberOfSegments;
    }
    // the line segments
    public LineSegment[] segments() {
        return lineSegment;
    }
}