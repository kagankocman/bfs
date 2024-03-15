package org.example.Classes;
import java.util.*;

enum LabyrinthElement {
    Empty,
    Tree,
    Mountain,
    Rock,
    Bird,
    Bee,
    Gold,
    Silver,
    Emerald,
    Copper,
    Road,
    Hero
}

class Point2 {
    public int x;
    public int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LabyrinthSolver {

    public static List<Point2> findShortestPath(LabyrinthElement[][] labyrinth, Point2 start, Point2 end) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point2> queue = new LinkedList<>();
        var parent = new HashMap<Point2, Point2>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point2 current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                break;
            }

            for (int[] dir : directions) {
                int nextX = current.x + dir[0];
                int nextY = current.y + dir[1];

                if (nextX >= 0 && nextX < labyrinth.length &&
                        nextY >= 0 && nextY < labyrinth[0].length &&
                        labyrinth[nextX][nextY] != LabyrinthElement.Tree &&
                        labyrinth[nextX][nextY] != LabyrinthElement.Mountain &&
                        labyrinth[nextX][nextY] != LabyrinthElement.Rock &&
                        labyrinth[nextX][nextY] != LabyrinthElement.Bird &&
                        labyrinth[nextX][nextY] != LabyrinthElement.Bee &&
                        !parent.containsKey(new Point2(nextX, nextY))) {
                    Point2 next = new Point2(nextX, nextY);
                    queue.add(next);
                    parent.put(next, current);
                }
            }
        }

        List<Point2> path = new ArrayList<>();
        Point2 currentPoint2 = end;

        while (!currentPoint2.equals(start)) {
            path.add(currentPoint2);
            currentPoint2 = parent.get(currentPoint2);
        }

        path.add(start);
        Collections.reverse(path);
        return path;
    }

    public static void ExecuteExample() {
        // Sample labyrinth generation
        Random random = new Random();
        int length = 10;
        var labyrinth = new LabyrinthElement[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // Randomly assign elements to the labyrinth
                int randElement = random.nextInt(12); // 12 elements in the enumeration
                labyrinth[i][j] = LabyrinthElement.values()[randElement];
                System.out.printf(labyrinth[i][j] + " ");
            }
            System.out.println();
        }

        Point2 start = new Point2(0, 0);
        Point2 end = new Point2(length-1, length-1);

        List<Point2> shortestPath = findShortestPath(labyrinth, start, end);

        System.out.println("Shortest path:");
        for (Point2 point2 : shortestPath) {
            System.out.println("(" + point2.x + ", " + point2.y + ")");
        }
    }
}

