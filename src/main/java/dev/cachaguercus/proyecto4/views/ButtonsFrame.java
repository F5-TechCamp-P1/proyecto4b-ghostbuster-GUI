package dev.cachaguercus.proyecto4.views;

import java.awt.*;
import javax.swing.*;
import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class ButtonsFrame extends JFrame {
    private GhostBusterController ghostBusterController;
    private GhostBackgroundPanel backgroundPanel;

    public ButtonsFrame(GhostBusterController controller) {
        this.ghostBusterController = controller;
        initComponents();
    }

    private void initComponents() {
        backgroundPanel = new GhostBackgroundPanel("images/ghosts.jpg");
        setContentPane(backgroundPanel);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listButton = new JButton("Ver Fantasmas Capturados");
        JButton exitButton = new JButton("Terminar juego");

        String name = ghostBusterController.getGBModelName();

        JLabel welcomeLabel = new JLabel(
                "<html><center>¡Bienvenido, " + name + ", a la Base Ghostbusters Asturias!<br>Gestiona tus fantasmas atrapados y protege la región.</center></html>",
                SwingConstants.CENTER);
                welcomeLabel.setForeground(Color.BLACK);
                welcomeLabel.setOpaque(true);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        captureButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(captureButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(listButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(exitButton);
        mainPanel.add(Box.createVerticalGlue());

        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Ghostbusters Asturias");
        setLocationRelativeTo(null);

        captureButton.addActionListener(e -> captureGhost());
        listButton.addActionListener(e -> listGhosts());
        exitButton.addActionListener(e -> exitGame());
    }

    private void captureGhost() {
        dispose();
        ghostBusterController.captureGhost();
    }

    private void listGhosts() {
        dispose();
        ghostBusterController.listGhosts();
    }

    private void exitGame() {
        dispose();
        ghostBusterController.exitGame();
    }
}
