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
        // Crear el panel de fondo
        backgroundPanel = new GhostBackgroundPanel("images/ghost_background.jpeg");
        setContentPane(backgroundPanel);

        // Crear un panel principal para los componentes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        // Crear componentes
        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listButton = new JButton("Ver Fantasmas Capturados");
        JButton exitButton = new JButton("Terminar juego");

        String name = ghostBusterController.getGBModelName();

        JLabel welcomeLabel = new JLabel(
                "<html><center>¡Bienvenido, " + name + ", a la Base Ghostbusters Asturias!<br>Gestiona tus fantasmas atrapados y protege la región.</center></html>",
                SwingConstants.CENTER);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Configurar botones
        captureButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir componentes al panel principal
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(captureButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(listButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(exitButton);
        mainPanel.add(Box.createVerticalGlue());

        // Añadir el panel principal al panel de fondo
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Ghostbusters Asturias");
        setLocationRelativeTo(null);

        // Añadir action listeners
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
