package dev.cachaguercus.proyecto4.views;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class GBMainFrame extends JFrame {
    private GhostBusterController ghostBusterController;

    public GBMainFrame(GhostBusterController controller) {
        this.ghostBusterController = controller;
        initComponents();
    }

    private void initComponents() {
        JLabel title = new JLabel("GhostBusters Asturias");
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        title.setAlignmentX(CENTER_ALIGNMENT);

        String name = "";
        JLabel welcomeMessage = new JLabel("¡Bienvenid@ " + name
                + " a la Base Ghostbusters Asturias! Gestiona tus fantasmas atrapados y protege la región.");
        welcomeMessage.setAlignmentX(CENTER_ALIGNMENT);

        JLabel nameRequest = new JLabel("Ingresa tu nombre: ");
        JTextField nameField = new JTextField(20);
        JButton playBtn = new JButton("Jugar");

        JPanel inputPanel = new JPanel();
        inputPanel.add(nameRequest);
        inputPanel.add(nameField);
        inputPanel.add(playBtn);
        inputPanel.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(title);
        container.add(welcomeMessage);
        container.add(inputPanel);

        setContentPane(container);
        setTitle("GhostBusters Asturias");
        setSize(800, 400);
        setVisible(true);
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
