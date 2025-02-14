package dev.cachaguercus.proyecto4.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ButtonsFrame extends JFrame {
    public ButtonsFrame() {
        initComponents();
    }

    private void initComponents() {
        // Crear los botones
        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listButton = new JButton("Ver Fantasmas Capturados");
        JButton exitButton = new JButton("Terminar juego");

        // Crear el mensaje de bienvenida con etiquetas HTML para dividir en varias líneas
        JLabel welcomeLabel = new JLabel("<html>¡Bienvenido, GhostBuster, a la Base Ghostbusters Asturias!<br>Gestiona tus fantasmas atrapados y protege la región</html>", SwingConstants.CENTER);

        // Configurar el JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Ghostbusters Asturias");
        setLayout(new FlowLayout()); // Añadir un LayoutManager
        setVisible(true);

        // Añadir ActionListeners a los botones
        captureButton.addActionListener(e -> captureGhost());
        listButton.addActionListener(e -> listGhosts());
        exitButton.addActionListener(e -> exitGame());

        // Añadir los componentes al JFrame
        add(welcomeLabel);
        add(captureButton);
        add(listButton);
        add(exitButton);
    }

    private void captureGhost() {
        JOptionPane.showMessageDialog(this, "Fantasma capturado!");
    }

    private void listGhosts() {
        JOptionPane.showMessageDialog(this, "Lista de fantasmas capturados:");
    }

    private void exitGame() {
        JOptionPane.showMessageDialog(this, "Juego terminado!");
        System.exit(0);
    }

}
