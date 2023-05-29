package it.polimi.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI extends JFrame {

    private JLabel numberLabel1;
    private JLabel numberLabel2;
    private JLabel numberLabel3;
    private JLabel numberLabel4;

    public TestGUI() {
        setTitle("MyShelfie - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Center panel split in 4 parts
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        // *** UP-LEFT ***
        // Displays the LivingRoom Board as a 9x9 board

        JLabel[][] upLeftLabels;
        JPanel tablePanel = new JPanel(new GridLayout(9, 9));
        upLeftLabels = new JLabel[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Create a cell
                JLabel cellLabel = new JLabel();
                cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
                cellLabel.setVerticalAlignment(SwingConstants.CENTER);
                cellLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Add the cell to the table panel
                tablePanel.add(cellLabel);

                // Save the cell label reference in the 2D array
                upLeftLabels[row][col] = cellLabel;
            }
        }

        centerPanel.add(tablePanel);

        // *** UP-RIGHT ***
        // Displays other players' Bookshelves
        numberLabel2 = new JLabel("2");
        numberLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel2.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.add(numberLabel2);

        // *** BOTTOM-LEFT ***
        // Displays personal and common goals
        numberLabel3 = new JLabel("3");
        numberLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel3.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.add(numberLabel3);

        // *** BOTTOM-RIGHT ***
        // Displays player personal bookshelf
        JPanel bottomRightPanel = new JPanel(new GridLayout(7, 8));
        JLabel[][] bottomRightLabels = new JLabel[7][8];

        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 8; col++) {
                // Create a cell
                JLabel cellLabel = new JLabel();
                cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
                cellLabel.setVerticalAlignment(SwingConstants.CENTER);
                cellLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Add the cell to the bottom-right panel
                bottomRightPanel.add(cellLabel);

                // Save the cell label reference in the 2D array
                bottomRightLabels[row][col] = cellLabel;
            }
        }

        centerPanel.add(bottomRightPanel);

        // *** BOTTOM ***
        // Displays commands to play
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JButton[] buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            bottomPanel.add(buttons[i]);
        }

        // First button
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call to update method
                update();
            }
        });

        // Add panels to main frame
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                resizeFont();
            }
        });

        setMinimumSize(new Dimension(500, 500));  // Minimum window size
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full screen
        setVisible(true);
    }

    // Update method (associated with the first button)
    private void update() {
        System.out.println("First button pressed!");
    }

    // Resize font based on window size
    private void resizeFont() {
        int fontSize = Math.min(getWidth(), getHeight()) / 10; // Set text to 1/10 of window size
        Font font = new Font("Arial", Font.BOLD, fontSize);

        numberLabel1.setFont(font);
        numberLabel2.setFont(font);
        numberLabel3.setFont(font);
        numberLabel4.setFont(font);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestGUI());
    }
}
