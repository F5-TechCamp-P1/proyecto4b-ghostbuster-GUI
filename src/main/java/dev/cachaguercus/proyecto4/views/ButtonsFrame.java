package dev.cachaguercus.proyecto4.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class ButtonsFrame extends JFrame {
    public ButtonsFrame() {
        initComponents();
    }

    private void initComponents() {
        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listButton = new JButton("Ver Fantasmas Capturados");
        JButton exitButton = new JButton("Terminar juego");

        GhostBusterController ghostBusterController = new GhostBusterController(null);
        String name = ghostBusterController.getGBModelName();

        JLabel welcomeLabel = new JLabel(
                "¡Bienvenido, " + name +", a la Base Ghostbusters Asturias! Gestiona tus fantasmas atrapados y protege la región.",
                SwingConstants.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Ghostbusters Asturias");
        setLayout(new FlowLayout());
        setVisible(true);

        captureButton.addActionListener(e -> captureGhost());
        listButton.addActionListener(e -> listGhosts());
        exitButton.addActionListener(e -> exitGame());

        add(welcomeLabel);
        add(captureButton);
        add(listButton);
        add(exitButton);
    }

    private void captureGhost() {
        GhostBusterController controller = new GhostBusterController(null);
        controller.captureGhost();

    }

    private void listGhosts() {
        GhostBusterController controller = new GhostBusterController(null);
        controller.listGhosts();
    }

    private void exitGame() {
        GhostBusterController controller = new GhostBusterController(null);
        controller.exitGame();
    }

}
