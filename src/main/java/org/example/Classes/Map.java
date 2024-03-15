package org.example.Classes;

import java.util.Random;
import java.util.Scanner;

public class Map {
    public Map() {
        /*boyuta göre random harita üret
        engelleri yerleştir
        hazineleri yerleştir
        başlangıç noktası belirle ve karakteri yerleştir
        geri kalan noktaları yol yap*/

        System.out.print("Haritanın boyutunu giriniz: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        var map = new Cell[length][length];

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

        // Ağaçları ve Dağları oluşturup mape ekleyen fonksiyon
        for (int i = 0; i < length / 3; i++) {
            Random random = new Random();
            int random_i = random.nextInt(length);
            int random_j = random.nextInt(length);
            if ((random_i < length - 1) && (random_j < length - 1)) {

                // alan sorgulanması için bir metot yazılabilir isAvailable(map, x, y, alan) gibi
                // buradaki alan boş mu sorgulaması for'la yapılmalı, 2x2'lik alanın sorgulanması için
//                int alan = 2;
//                for (int j = 0; j < alan - 1; j++) {
//                    if (map[random_i + j][random_j].objectType.equals(Types.Empty)) {
//
//                    }
//                    if (map[random_i][random_j + j].objectType.equals(Types.Empty)) {
//
//                    }
//                    if (map[random_i + j][random_j + j].objectType.equals(Types.Empty)) {
//
//                    }
//                }

                if (map[random_i][random_j].objectType.equals(Types.Empty) &&
                        map[random_i][random_j + 1].objectType.equals(Types.Empty) &&
                        map[random_i + 1][random_j].objectType.equals(Types.Empty) &&
                        map[random_i][random_j + 1].objectType.equals(Types.Empty)) {
                    if (map[random_i][random_j].getSummer()) {
                        map[random_i][random_j].objectType = Types.Tree;
                        map[random_i][random_j + 1].objectType = Types.Tree;

                    } else if (map[random_i][random_j].getWinter()) {
                        map[random_i][random_j].objectType = Types.Mountain;
                        map[random_i][random_j + 1].objectType = Types.Mountain;
                        map[random_i + 1][random_j].objectType = Types.Mountain;
                        map[random_i + 1][random_j + 1].objectType = Types.Mountain;
                    }
                    if (map[random_i + 1][random_j].getSummer()) {
                        map[random_i + 1][random_j].objectType = Types.Tree;
                        map[random_i + 1][random_j + 1].objectType = Types.Tree;
                    } else if (map[random_i + 1][random_j].getWinter()) {
                        map[random_i + 1][random_j].objectType = Types.Mountain;
                        map[random_i + 1][random_j + 1].objectType = Types.Mountain;
                    }
                } else continue; // 2x2'lik alan boş değilse geç

//                map[random_i][random_j].point.x = random_i;
//                map[random_i][random_j].point.y = random_j;
            } else continue; // ızgaranın içinde değilse geç
        }


        // Yolları ekleyen fonksiyon
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                // yeni nesnelerden sonra eklemeler gelecek
                if (map[i][j].objectType.equals(Types.Tree)) {
                    continue;
                } else if (map[i][j].objectType.equals(Types.Mountain)) {
                    continue;
                } else {
                    map[i][j].objectType = Types.Road;
                    map[i][j].point.x = i;
                    map[i][j].point.y = j;
                }
            }
        }

        // Tüm mapi yazdıran fonksiyon
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (map[i][j].objectType.equals(Types.Tree)) {
                    System.out.print("T");
                } else if (map[i][j].objectType.equals(Types.Mountain)) {
                    System.out.print("M");
                } else {
                    if (map[i][j].getSummer()) System.out.print("*");
                    else System.out.print("x");
                }
            }
            System.out.println();
        }
    }
}
