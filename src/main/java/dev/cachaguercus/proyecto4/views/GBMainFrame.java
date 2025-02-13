package dev.cachaguercus.proyecto4.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GBMainFrame extends JFrame {
    public GBMainFrame() {
        setTitle("Cachagüercus Asturias");
        setSize(1000, 1500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Ghost Busters Asturias");
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        title.setAlignmentX(CENTER_ALIGNMENT);

        String name = "";

        JLabel messageToPlayer = new JLabel("Bienvenido " + name);
        messageToPlayer.setAlignmentX(CENTER_ALIGNMENT);

        JLabel gbNameRequest = new JLabel("Introduce tu nombre:");
        JTextField gbNameInput = new JTextField(20);
        gbNameInput.setMaximumSize(new Dimension(200, 25));
        JButton button = new JButton("Comenzar juego");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = gbNameInput.getText();
                messageToPlayer.setText("Bienvenido " + name);
            }
        });

        add(title);
        add(messageToPlayer);
        add(Box.createVerticalStrut(10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setAlignmentX(CENTER_ALIGNMENT);
        inputPanel.add(gbNameRequest);
        inputPanel.add(gbNameInput);
        inputPanel.add(button);

        add(inputPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}