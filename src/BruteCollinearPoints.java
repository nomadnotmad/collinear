import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i + 1 < points.length; ++i) {
            if (points[i] == null) throw new IllegalArgumentException();
            if (points[i].compareTo(points[i + 1]) == 0) throw new IllegalArgumentException();
        }
        Point[] pointsArray = points.clone();
        Arrays.sort(pointsArray);
        for (int i0 = 0; i0 < pointsArray.length - 3; ++i0) {
            for (int i1 = i0 + 1; i1 < pointsArray.length - 2; ++i1) {
                for (int i2 = i1 + 1; i2 < pointsArray.length - 1; ++i2) {
                    if (pointsArray[i0].slopeTo(pointsArray[i1]) == pointsArray[i0].slopeTo(pointsArray[i2])) {
                        for (int i3 = i2 + 1; i3 < points.length; ++i3) {
                            if (pointsArray[i0].slopeTo(pointsArray[i1])  == pointsArray[i0].slopeTo(pointsArray[i3])) {
                                lineSegments.add(new LineSegment(pointsArray[i0], pointsArray[i3]));
                            }
                        }
                    }
                }
            }
        }

    }
    // the number of line segments
    public int numberOfSegments() {
        return lineSegments.size();
    }
    // the line segments
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}