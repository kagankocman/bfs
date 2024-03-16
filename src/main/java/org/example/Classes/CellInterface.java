package org.example.Classes;
import javax.swing.*;
import java.awt.*;

public class CellInterface extends JPanel {
    private Cell[][] cells;
    private JButton[][] buttons;

    public CellInterface(Cell[][] cells) {
        this.cells = cells;
        this.buttons = new JButton[cells.length][cells[0].length];
        initializePanel();
    }

    private void initializePanel() {
        setLayout(new GridLayout(cells.length, cells[0].length));

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                buttons[i][j] = new JButton();
                setButtonProperties(buttons[i][j], cells[i][j]);
                add(buttons[i][j]);
            }
        }
    }

    private void setButtonProperties(JButton button, Cell cell) {
        // İstenirse hücrenin özelliklerine göre butonun özelliklerini ayarlayabilirsiniz
        // Örneğin, görünürlük, engel olup olmama durumu vb.
        // Bu örnekte sadece butonun görünürlüğünü ayarlıyoruz
        button.setVisible(cell.isVisible());
    }

    public static void startUI(Cell[][] map) {

        // Arayüzü oluşturun ve gösterin
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cell Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);

            CellInterface panel = new CellInterface(map);
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
