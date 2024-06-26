package org.example.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CellInterface extends JPanel {
    static JFrame frame = new JFrame();
    private Cell[][] cells;
    private HashMap<Types, ImageIcon> iconMap;

    public CellInterface(Cell[][] cells) {
        this.cells = cells;
        this.iconMap = new HashMap<>();
        loadIcons();

        setLayout(new GridLayout(cells.length, cells[0].length));

        updatePanel();
    }
    private void loadIcons() {
        String path = "C:\\Users\\Kagan\\IdeaProjects\\Prolab2_1_UIadded\\src\\main\\java\\org\\example\\Classes\\icons\\";
        // Iconları yükle
        iconMap.put(Types.Bee, new ImageIcon(path + "bee.png"));
        iconMap.put(Types.Tree, new ImageIcon(path + "tree.png"));
        iconMap.put(Types.Mountain, new ImageIcon(path + "mountain.png"));
        iconMap.put(Types.Bird, new ImageIcon(path + "bird.png"));
        iconMap.put(Types.Gold, new ImageIcon(path + "gold.png"));
        iconMap.put(Types.Wall, new ImageIcon(path + "wall.png"));
        iconMap.put(Types.Silver, new ImageIcon(path + "silver.png"));
        iconMap.put(Types.Rock, new ImageIcon(path + "rock.png"));
        iconMap.put(Types.Character, new ImageIcon(path + "hero.png"));
        iconMap.put(Types.Copper, new ImageIcon(path + "copper.png"));
        iconMap.put(Types.Emerald, new ImageIcon(path + "diamond.png"));
    }
    public void updatePanel() {

        removeAll();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                Cell cell = cells[i][j];
                if (cell.getWinter()) {
                    JButton button = new JButton();
                    button.setBackground(Color.white);
                    if (cell.isObstacle()) {
                        button.setBackground(Color.red);
                    } else if (cell.isVisited()) {
                        button.setBackground(Color.green);
                    }
                    button.setIcon(iconMap.get(cell.objectType));
                    add(button);
                } else {
                    JButton button = new JButton();
                    button.setBackground(Color.yellow);
                    if (cell.isObstacle()) {
                        button.setBackground(Color.red);
                    } else if (cell.isVisited()) {
                        button.setBackground(Color.green);
                    }
                    button.setIcon(iconMap.get(cell.objectType));
                    add(button);
                }
            }
        }

        revalidate();
        repaint();
    }
    public static void closeUI() {
        frame.dispose();
    }
    public static void startUI(Cell[][] map) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(870, 870);
        frame.setLocation(350,0);
        frame.add(new CellInterface(map));
        frame.setVisible(true);
    }
}

