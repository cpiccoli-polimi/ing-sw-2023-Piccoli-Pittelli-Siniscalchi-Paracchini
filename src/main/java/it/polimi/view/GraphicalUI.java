package it.polimi.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUI extends JFrame {

    public GraphicalUI() {
        setTitle("MyShelfie - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pannello superiore con il titolo
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JLabel titleLabel = new JLabel("MyShelfie - Game");
        topPanel.add(titleLabel);

        // Pannello centrale diviso in 4 parti uguali
        JPanel centerPanel = new JPanel(new GridBagLayout());

        // Riquadro 1
        JLabel numberLabel1 = new JLabel("1");
        numberLabel1.setFont(new Font("Arial", Font.BOLD, 72));
        numberLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel1.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Riquadro 2
        JLabel numberLabel2 = new JLabel("2");
        numberLabel2.setFont(new Font("Arial", Font.BOLD, 72));
        numberLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel2.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Riquadro 3
        JLabel numberLabel3 = new JLabel("3");
        numberLabel3.setFont(new Font("Arial", Font.BOLD, 72));
        numberLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel3.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Riquadro 4
        JLabel numberLabel4 = new JLabel("4");
        numberLabel4.setFont(new Font("Arial", Font.BOLD, 72));
        numberLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel4.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(numberLabel1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(numberLabel2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(numberLabel3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(numberLabel4, gbc);

        // Pannello inferiore con la barra dei pulsanti
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JButton[] buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("Pulsante " + (i + 1));
            bottomPanel.add(buttons[i]);
        }

        // Aggiunta dell'azione di ascolto al primo pulsante
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chiamata al metodo Update
                update();
            }
        });

        // Aggiunta dei pannelli al frame principale
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setResizable(true); // Permette la ridimensione manuale della finestra
        setSize(800, 600); // Imposta le dimensioni della finestra a 800x600
        setVisible(true);
    }

    // Metodo di aggiornamento
    private void update() {
        // Logica di aggiornamento
        System.out.println("Metodo Update chiamato!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraphicalUI());
    }
}
