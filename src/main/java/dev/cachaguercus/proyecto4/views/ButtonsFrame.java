package dev.cachaguercus.proyecto4.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class ButtonsFrame extends JFrame {
    private GhostBusterController ghostBusterController;

    public ButtonsFrame(GhostBusterController controller) {
        this.ghostBusterController = controller;
        initComponents();
    }

    private void initComponents() {
        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listButton = new JButton("Ver Fantasmas Capturados");
        JButton exitButton = new JButton("Terminar juego");

        String name = ghostBusterController.getGBModelName();

        JLabel welcomeLabel = new JLabel(
                "¡Bienvenido, " + name + ", a la Base Ghostbusters Asturias! Gestiona tus fantasmas atrapados y protege la región.",
                SwingConstants.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setTitle("Ghostbusters Asturias");
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(captureButton);
        buttonPanel.add(listButton);
        buttonPanel.add(exitButton);

        add(welcomeLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);

        captureButton.addActionListener(e -> captureGhost());
        listButton.addActionListener(e -> listGhosts());
        exitButton.addActionListener(e -> exitGame());
    }

    private void captureGhost() {
        ghostBusterController.captureGhost();
    }

    private void listGhosts() {
        ghostBusterController.listGhosts();
    }

    private void exitGame() {
        ghostBusterController.exitGame();
    }
}
