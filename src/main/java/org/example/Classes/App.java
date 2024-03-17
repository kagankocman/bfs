package org.example.Classes;

public class App {
    static int moveCounter;
    public static void GoldChestCollected(Cell road) {

        System.out.println("Altın sandık toplandı! (" + road.point.x + "," + road.point.y + ") ve (" +
                road.point.x + "," + (road.point.y + 1) + ")'da bulundu!");
    }
    public static void SilverChestCollected(Cell road) {

        System.out.println("Gümüş sandık toplandı! (" + road.point.x + "," + road.point.y + ") ve (" +
                road.point.x + "," + (road.point.y + 1) + ")'da bulundu!");
    }
    public static void EmeraldChestCollected(Cell road) {

        System.out.println("Zümrüt sandık toplandı! (" + road.point.x + "," + road.point.y + ") ve (" +
                road.point.x + "," + (road.point.y + 1) + ")'da bulundu!");
    }
    public static void CopperChestCollected(Cell road) {

        System.out.println("Bakır sandık toplandı! (" + road.point.x + "," + road.point.y + ") ve (" +
                road.point.x + "," + (road.point.y + 1) + ")'da bulundu!");
    }
}
