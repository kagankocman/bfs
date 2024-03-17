package org.example.Classes;

import java.util.*;

public class Map {
    List<Cell> golds = new ArrayList<>();
    List<Cell> silvers = new ArrayList<>();
    List<Cell> emeralds = new ArrayList<>();
    List<Cell> coppers = new ArrayList<>();
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

        map = createEmerald(map, length);

        map = createCopper(map, length);

        map = createCharacter(map, length);

        map = createRoads(map, length);

        character.setVisible(true);

        while (true) {
            System.out.println("1- Haritayı göster");
            System.out.println("2- Başlat");
            System.out.printf("Seçim yapınız: ");

            Scanner scanner1 = new Scanner(System.in);
            int secim = scanner.nextInt();

            if (secim == 1)
                CellInterface.startUI(map);
            else if (secim == 2) {
                character.setVisible(true);

                CellInterfaceSmoke.startUI(map);

                collectGolds(map);

                collectSilvers(map);

                collectEmeralds(map);

                collectCoppers(map);

                System.out.println("Adım sayısı: " + App.moveCounter);
            } else {
                System.out.println("Geçerli bir değer giriniz!");
//                Map map1 = new Map();
            }
        }

        // harita olusturuldu
//        CellInterface.startUI(map);
//        CellInterfaceSmoke.startUI(map);

        // Gold sandıkları en kısaya göre sıralanacak
        // Silver sandıkları en kısaya göre sıralanacak
//        collectGolds(map);
////
//        collectSilvers(map);
//
//        collectEmeralds(map);
//
//        collectCoppers(map);

        // haritanın son hali
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

    public Cell[][] createEmerald(Cell[][] map, int length) {
        // zümrüt sandıkları oluşturup mape ekleyen fonksiyon

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
                        map[j + random_i][k + random_j].objectType = Types.Emerald;
                        emeralds.add(map[j + random_i][k + random_j]);
                    }
                }
            }
        }
        return map;
    }

    public Cell[][] createCopper(Cell[][] map, int length) {
        // bakır sandıkları oluşturup mape ekleyen fonksiyon

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
                        map[j + random_i][k + random_j].objectType = Types.Copper;
                        coppers.add(map[j + random_i][k + random_j]);
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

        return map;
    }

    public Cell[][] createRoads(Cell[][] map, int length) {
        // Yolları ekleyen fonksiyon
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (map[i][j].objectType.equals(Types.Empty)) {
                    map[i][j].objectType = Types.Road;
                }
            }
        }
        return map;
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

        App.moveCounter++;

        // Yolları işaretleyen fonksiyon
        if (road.objectType.equals(Types.Gold)) {
            App.GoldChestCollected(road);
            road.objectType = Types.Road;
            map[road.point.x][road.point.y + 1].objectType = Types.Road;
        } else if (road.objectType.equals(Types.Silver)) {
            App.SilverChestCollected(road);
            road.objectType = Types.Road;
            map[road.point.x][road.point.y + 1].objectType = Types.Road;
        } else if (road.objectType.equals(Types.Emerald)) {
            App.EmeraldChestCollected(road);
            road.objectType = Types.Road;
            map[road.point.x][road.point.y + 1].objectType = Types.Road;
        } else if (road.objectType.equals(Types.Copper)) {
            App.CopperChestCollected(road);
            road.objectType = Types.Road;
            map[road.point.x][road.point.y + 1].objectType = Types.Road;
        }

        road.setVisited(true);
        road.setVisible(true);

        CellInterfaceSmoke.startUI(map);

//        CellInterfaceSmoke.startUI(map);

        character = road;
        return map;
    }

    public void collectGolds(Cell[][] map) {
        for (Cell gold : golds) {
            List<Cell> shortestPath = findShortestPath(map, character, gold);
            for (Cell cell : shortestPath) {
                map = updateMap(map, cell);
                try {
                    Thread.sleep(500); // 1 saniye bekleyin
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void collectSilvers(Cell[][] map) {
        for (Cell silver : silvers) {
            List<Cell> shortestPath = findShortestPath(map, character, silver);
            for (Cell cell : shortestPath) {
                map = updateMap(map, cell);
                try {
                    Thread.sleep(500); // 1 saniye bekleyin
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void collectEmeralds(Cell[][] map) {
        for (Cell emerald : emeralds) {
            List<Cell> shortestPath = findShortestPath(map, character, emerald);
            for (Cell cell : shortestPath) {
                map = updateMap(map, cell);
                try {
                    Thread.sleep(500); // 1 saniye bekleyin
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void collectCoppers(Cell[][] map) {
        for (Cell copper : coppers) {
            List<Cell> shortestPath = findShortestPath(map, character, copper);
            for (Cell cell : shortestPath) {
                map = updateMap(map, cell);
                try {
                    Thread.sleep(500); // 1 saniye bekleyin
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
