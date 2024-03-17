package org.example.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CellInterfaceSmoke extends JPanel {
    private Cell[][] cells;
    private HashMap<Types, ImageIcon> iconMap;

    public CellInterfaceSmoke(Cell[][] cells) {
        this.cells = cells;
        this.iconMap = new HashMap<>();
        loadIcons();

        setLayout(new GridLayout(cells.length, cells[0].length));

        updatePanel();
    }

    private void loadIcons() {
        String path = "C:\\Users\\Kagan\\IdeaProjects\\Prolab2_1\\src\\main\\java\\org\\example\\Classes\\icons\\";
        iconMap.put(Types.Bee, new ImageIcon(path + "bee.png"));
        iconMap.put(Types.Tree, new ImageIcon(path + "tree.png"));
        iconMap.put(Types.Mountain, new ImageIcon(path + "mountain.png"));
        iconMap.put(Types.Bird, new ImageIcon(path + "bird.png"));
        iconMap.put(Types.Gold, new ImageIcon(path + "gold.png"));
        iconMap.put(Types.Wall, new ImageIcon(path + "wall.png"));
        iconMap.put(Types.Silver, new ImageIcon(path + "silver.png"));
        iconMap.put(Types.Rock, new ImageIcon(path + "rock.png"));
        iconMap.put(Types.Character, new ImageIcon(path + "hero.png"));
    }

    public void updatePanel() {
        removeAll();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                Cell cell = cells[i][j];
                if (cell.isVisible()) {
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
                } else {
                    add(new JButton());
                }
            }
        }

        revalidate();
        repaint();
    }

    public static void startUI(Cell[][] map) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new CellInterfaceSmoke(map));
        frame.setVisible(true);
    }
}


