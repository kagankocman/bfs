package org.example.Classes;

import java.util.*;

public class Map {
    List<Cell> golds = new ArrayList<>();
    List<Cell> silvers = new ArrayList<>();
    Cell character;

    public Map() {

        System.out.print("Haritanın boyutunu giriniz: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        var map = new Cell[length][length];

        map = createMap(map, length);

        map = createTrees(map, length);

        map = createRocks(map, length);

        map = createWalls(map, length);

        map = createMountains(map, length);

        map = createBirds(map, length);

        map = createBees(map, length);

        map = createGold(map, length);

        map = createSilver(map, length);

        map = createCharacter(map, length);

        map = createRoads(map, length);
        printMap(map, length);

        // Gold sandıkları en kısaya göre sıralanacak
        // Silver sandıkları en kısaya göre sıralanacak

        collectGolds(map);

        collectSilvers(map);

        printMap(map, length);


//        CellInterface.startUI(map);
    }

    public boolean isAvailable(int x, int y, int alan_x, int alan_y, Cell[][] map) {

        for (int i = 0; i < alan_x - 1; i++) {
            for (int j = 0; j < alan_y - 1; j++) {
                if (!(map[i + x][j + y].objectType.equals(Types.Empty))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Cell[][] createMap(Cell[][] map, int length) {
        // Tüm mapi oluşturan fonksiyonlar
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                Point p = new Point(i, j);
                Cell c = new Cell(p);
                c.objectType = Types.Empty;
                c.setSummer(true);
                c.setVisible(false);
                map[i][j] = c;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = length / 2; j < length; j++) {
                Point p = new Point(i, j);
                Cell c = new Cell(p);
                c.objectType = Types.Empty;
                c.setWinter(true);
                c.setVisible(false);
                map[i][j] = c;
            }
        }
        return map;
    }

    public Cell[][] createTrees(Cell[][] map, int length) {
        // Ağaçları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < (length / 8); i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            int random_type = random.nextInt(4); // 0,1,2,3

            int alan;
            if (random_type == 0) {
                alan = 2;
            } else if (random_type == 1) {
                alan = 3;
            } else if (random_type == 2) {
                alan = 4;
            } else {
                alan = 5;
            }
            boolean key;
            if (((random_i + alan) < length) && ((random_j + alan) < length)) {
                key = isAvailable(random_i, random_j, alan, alan, map);
            } else continue;

            if (key) {
                for (int j = 0; j < alan; j++) {
                    for (int k = 0; k < alan; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Tree;
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createRocks(Cell[][] map, int length) {
        // Kayaları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < (length / 8); i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            int random_type = random.nextInt(2); // 0,1

            int alan;
            if (random_type == 0) {
                alan = 2;
            } else {
                alan = 3;
            }
            boolean key;
            if (((random_i + alan) < length) && ((random_j + alan) < length)) {
                key = isAvailable(random_i, random_j, alan, alan, map);
            } else continue;

            if (key) {
                for (int j = 0; j < alan; j++) {
                    for (int k = 0; k < alan; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Rock;
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createWalls(Cell[][] map, int length) {
        // Duvarları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < (length / 15); i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            boolean key;
            if (((random_i + 1) < length) && ((random_j + 10) < length)) {
                key = isAvailable(random_i, random_j, 1, 10, map);
            } else continue;

            if (key) {
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < 10; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Wall;
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createMountains(Cell[][] map, int length) {
        // Dağları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < (length / 20); i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            boolean key;
            if (((random_i + 15) < length) && ((random_j + 15) < length)) {
                key = isAvailable(random_i, random_j, 15, 15, map);
            } else continue;

            if (key) {
                for (int j = 0; j < 15; j++) {
                    for (int k = 0; k < 15; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Mountain;
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createBirds(Cell[][] map, int length) {
        // Kuşları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            boolean key;
            if (((random_i + 10) < length) && ((random_j + 2) < length)) {
                key = isAvailable(random_i, random_j, 10, 2, map);
            } else continue;

            if (key) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 2; k++) {
                        map[j + random_i][k + random_j].setObstacle(true);
                    }
                }

                for (int j = 4; j < 6; j++) {
                    for (int k = 0; k < 2; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Bird;
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createBees(Cell[][] map, int length) {
        // Arıları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            boolean key;
            if (((random_i + 2) < length) && ((random_j + 8) < length)) {
                key = isAvailable(random_i, random_j, 2, 8, map);
            } else continue;

            if (key) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 8; k++) {
                        map[j + random_i][k + random_j].setObstacle(true);
                    }
                }

                for (int j = 0; j < 2; j++) {
                    for (int k = 3; k < 5; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Bee;
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createGold(Cell[][] map, int length) {
        // Altın sandıkları oluşturup mape ekleyen fonksiyon

        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            boolean key;
            if ((random_i < length) && ((random_j + 1) < length)) {
                key = isAvailable(random_i, random_j, 1, 2, map);
            } else continue;

            if (key) {
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < 2; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Gold;
                        golds.add(map[j + random_i][k + random_j]);
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createSilver(Cell[][] map, int length) {
        // Gümüş sandıkları oluşturup mape ekleyen fonksiyon

        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);

            boolean key;
            if ((random_i < length) && ((random_j + 1) < length)) {
                key = isAvailable(random_i, random_j, 1, 2, map);
            } else continue;

            if (key) {
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < 2; k++) {
                        map[j + random_i][k + random_j].objectType = Types.Silver;
                        silvers.add(map[j + random_i][k + random_j]);
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createCharacter(Cell[][] map, int length) {
        // Karakteri oluşturup mape ekleyen fonksiyon

        Random random = new Random();
        int random_i;
        int random_j;

        do {
            random_i = random.nextInt(length);
            random_j = random.nextInt(length);
        } while (!isAvailable(random_i, random_j, 1, 2, map));

        character = map[random_i][random_j];
        map[random_i][random_j].objectType = Types.Character;
//        map[random_i][random_j].isVisible();

        return map;
    }

    public Cell[][] createRoads(Cell[][] map, int length) {
        // Yolları ekleyen fonksiyon
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (map[i][j].objectType.equals(Types.Empty)) {
                    map[i][j].objectType = Types.Road;
                    map[i][j].point.x = i;
                    map[i][j].point.y = j;
                }
            }
        }
        return map;
    }

    public void printMap(Cell[][] map, int length) {
        // Tüm mapi yazdıran fonksiyon
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (map[i][j].objectType.equals(Types.Tree)) {
                    System.out.print("T");
                } else if (map[i][j].objectType.equals(Types.Rock)) {
                    System.out.print("R");
                } else if (map[i][j].objectType.equals(Types.Wall)) {
                    System.out.print("W");
                } else if (map[i][j].objectType.equals(Types.Mountain)) {
                    System.out.print("M");
                } else if (map[i][j].objectType.equals(Types.Bird)) {
                    System.out.print("B");
                } else if (map[i][j].objectType.equals(Types.Bee)) {
                    System.out.print("E");
                } else if (map[i][j].objectType.equals(Types.Gold)) {
                    System.out.print("G");
                } else if (map[i][j].objectType.equals(Types.Character)) {
                    System.out.print("C");
                } else if (map[i][j].isObstacle()) {
                    System.out.print("|");
                } else if (map[i][j].isVisited()) {
                    System.out.print("-");
                } else {
                    if (map[i][j].getSummer()) System.out.print("*");
                    else System.out.print("x");
                }
            }
            System.out.println();
        }
    }


    public static List<Cell> findShortestPath(Cell[][] labyrinth, Cell start, Cell end) {

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Cell> queue = new LinkedList<>();
        var parent = new HashMap<Cell, Cell>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            for (int[] dir : directions) {
                int nextX = current.point.x + dir[0];
                int nextY = current.point.y + dir[1];

                if (nextX >= 0 && nextX < labyrinth.length &&
                        nextY >= 0 && nextY < labyrinth[0].length &&
                        !(labyrinth[nextX][nextY].objectType.equals(Types.Tree)) &&
                        !(labyrinth[nextX][nextY].objectType.equals(Types.Mountain)) &&
                        !(labyrinth[nextX][nextY].objectType.equals(Types.Rock)) &&
                        !(labyrinth[nextX][nextY].objectType.equals(Types.Wall)) &&
                        !(labyrinth[nextX][nextY].objectType.equals(Types.Bird)) &&
                        !(labyrinth[nextX][nextY].objectType.equals(Types.Bee)) &&
                        !parent.containsKey(labyrinth[nextX][nextY])) {
                    Cell next = labyrinth[nextX][nextY];
//                    labyrinth[nextX][nextY].setVisited(true);
                    queue.add(next);
                    parent.put(next, current);
                }
            }
        }

        List<Cell> path = new ArrayList<>();
        Cell currentCell = end;

        while (currentCell != null && !currentCell.equals(start)) {
            path.add(currentCell);
            currentCell = parent.get(currentCell);
        }

        if (currentCell != null)
            path.add(start);

        Collections.reverse(path);
        return path;
    }

    public Cell[][] updateMap(Cell[][] map, Cell road) {

        // Yolları işaretleyen fonksiyon
        if (road.objectType.equals(Types.Gold)) {
            System.out.println("Altın sandık toplandı! (" + road.point.x + "," + road.point.y + ") ve (" +
                    road.point.x + "," + (road.point.y + 1) + ")'da bulundu!");
            road.objectType = Types.Road;
            map[road.point.x][road.point.y + 1].objectType = Types.Road;
        } else if (road.objectType.equals(Types.Silver)) {
            System.out.println("Gümüş sandık toplandı! (" + road.point.x + "," + road.point.y + ") ve (" +
                    road.point.x + "," + (road.point.y + 1) + ")'da bulundu!");
            road.objectType = Types.Road;
            map[road.point.x][road.point.y + 1].objectType = Types.Road;
        }

        road.setVisited(true);
        character = road;
        return map;
    }

    public void collectGolds(Cell[][] map) {
        for (Cell gold : golds) {
            List<Cell> shortestPath = findShortestPath(map, character, gold);
            for (Cell cell : shortestPath) {
                map = updateMap(map, cell);
            }
        }
    }
    public void collectSilvers(Cell[][] map) {
        for (Cell silver : silvers) {
            List<Cell> shortestPath = findShortestPath(map, character, silver);
            for (Cell cell : shortestPath) {
                map = updateMap(map, cell);
            }
        }
    }
}
