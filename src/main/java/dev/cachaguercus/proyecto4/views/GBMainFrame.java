package dev.cachaguercus.proyecto4.views;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class GBMainFrame extends JFrame {
    private GhostBusterController ghostBusterController;
    private GhostBackgroundPanel backgroundPanel;

    public GBMainFrame(GhostBusterController controller) {
        this.ghostBusterController = controller;
        initComponents();
    }

    private void initComponents() {
        backgroundPanel = new GhostBackgroundPanel("images/ghost_background.jpeg");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        JLabel title = new JLabel("GhostBusters Asturias");
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        title.setAlignmentX(CENTER_ALIGNMENT);

        String name = "";
        JLabel welcomeMessage = new JLabel("¡Bienvenid@ " + name
                + " a la Base Ghostbusters Asturias! Gestiona tus fantasmas atrapados y protege la región.");
        welcomeMessage.setForeground(Color.BLACK);
        welcomeMessage.setOpaque(true);
        welcomeMessage.setAlignmentX(CENTER_ALIGNMENT);

        JLabel nameRequest = new JLabel("Ingresa tu nombre: ");
        nameRequest.setForeground(Color.BLACK);
        nameRequest.setOpaque(true);
        JTextField nameField = new JTextField(20);
        JButton playBtn = new JButton("Jugar");
        playBtn.setForeground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);
        inputPanel.add(nameRequest);
        inputPanel.add(nameField);
        inputPanel.add(playBtn);
        inputPanel.setAlignmentX(CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(welcomeMessage);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalGlue());

        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        setTitle("GhostBusters Asturias");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playBtn.addActionListener(e -> openGame(nameField));
    }

    public void openGame(JTextField nameField) {
        String name = nameField.getText();
        ghostBusterController.saveGBModelName(name);
        ghostBusterController.selectOptionMainMenu();
        dispose();
    }

}
