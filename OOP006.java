import java.util.*;
class Point {
    private double x, y, z;
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public boolean equals(Point p) {
        return this.x == p.x && this.y == p.y && this.z == p.z;
    }
}
class Line {
    private Point start, end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    public double length() {
        if (start.equals(end)) return -1;
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        double dz = end.getZ() - start.getZ();
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Point> points = new LinkedHashMap<>();
        List<String> order = new ArrayList<>();
        String firstPointName = null;
        try {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) break;
                if (!sc.hasNextLine()) {
                    firstPointName = line;
                    break;
                }
                String coordLine = sc.nextLine().trim();
                String[] parts = coordLine.split("\\s+");
                if (parts.length != 3) {
                    System.out.println("invalid input");
                    return;
                }
                points.put(line, new Point(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
                order.add(line);
            }
            if (firstPointName == null || !points.containsKey(firstPointName)) {
                System.out.println("invalid input");
                return;
            }
            Point firstPoint = points.get(firstPointName);
            for (String name : order) {
                if (name.equals(firstPointName)) continue;
                Point other = points.get(name);
                Line line = new Line(firstPoint, other);
                double len = line.length();
                if (len < 0) {
                    System.out.println("Line " + firstPointName + name + ": same point");
                } else {
                    System.out.printf("Line %s%s: %.2f%n", firstPointName, name, len);
                }
            }
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }
}