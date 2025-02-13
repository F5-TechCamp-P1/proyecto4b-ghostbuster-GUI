package dev.cachaguercus.proyecto4.views;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;

public class GhostBusterGUI {
    private JFrame frame;
    private GhostBusterModel model;
    private GhostBusterController controller;

    public GhostBusterGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Ghostbusters Asturias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1500);
        frame.setLayout(new GridLayout(3, 1));

        JLabel nameLabel = new JLabel("Ingresa tu nombre:", SwingConstants.CENTER);
        JTextField nameField = new JTextField();
        JButton enterButton = new JButton("Aceptar");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ghostBusterName = nameField.getText();
                if (!ghostBusterName.isEmpty()) {
                    frame.dispose();
                    model = new GhostBusterModel();
                    model.setName(ghostBusterName);
                    controller = new GhostBusterController(model, new GhostBusterView());
                    launchMainMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa tu nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(enterButton);
        frame.setVisible(true);
    }

    private void launchMainMenu() {
        frame = new JFrame("Ghostbusters Asturias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        JLabel welcomeLabel = new JLabel("Bienvenido, " + model.getName() + "!", SwingConstants.CENTER);
        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listButton = new JButton("Ver Fantasmas Capturados");
        JButton releaseButton = new JButton("Liberar Fantasma");
        JButton exitButton = new JButton("Salir");

        captureButton.addActionListener(e -> captureGhost());
        listButton.addActionListener(e -> listGhosts());
        releaseButton.addActionListener(e -> releaseGhost());
        exitButton.addActionListener(e -> exitGame());

        frame.add(welcomeLabel);
        frame.add(captureButton);
        frame.add(listButton);
        frame.add(releaseButton);
        frame.add(exitButton);
        frame.setVisible(true);
    }

    private void captureGhost() {
        JFrame captureFrame = new JFrame("Capturar Fantasma");
        captureFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        captureFrame.setSize(400, 300);
        captureFrame.setLayout(new GridLayout(6, 1));

        JTextField nameField = new JTextField();
        JComboBox<enumGhostType> ghostTypeComboBox = new JComboBox<>(enumGhostType.values());
        JComboBox<enumDangerLevel> dangerLevelComboBox = new JComboBox<>(enumDangerLevel.values());
        JTextField specialSkillField = new JTextField();
        JButton captureButton = new JButton("Capturar");

        captureButton.addActionListener(e -> {
            String name = nameField.getText();
            enumGhostType ghostType = (enumGhostType) ghostTypeComboBox.getSelectedItem();
            enumDangerLevel dangerLevel = (enumDangerLevel) dangerLevelComboBox.getSelectedItem();
            String specialSkill = specialSkillField.getText();
            LocalDate captureDate = LocalDate.now();

            GhostModel ghost = new GhostModel(model.getGhostTrap().size() + 1, name, ghostType, dangerLevel, specialSkill, captureDate);
            model.captureGhost(ghost);

            JOptionPane.showMessageDialog(captureFrame, "Fantasma capturado exitosamente!", "Captura", JOptionPane.INFORMATION_MESSAGE);
            captureFrame.dispose();
        });

        captureFrame.add(new JLabel("Nombre del Fantasma:"));
        captureFrame.add(nameField);
        captureFrame.add(new JLabel("Tipo de Fantasma:"));
        captureFrame.add(ghostTypeComboBox);
        captureFrame.add(new JLabel("Nivel de Peligro:"));
        captureFrame.add(dangerLevelComboBox);
        captureFrame.add(new JLabel("Habilidad Especial:"));
        captureFrame.add(specialSkillField);
        captureFrame.add(captureButton);

        captureFrame.setVisible(true);
    }

    private void listGhosts() {
        JFrame listFrame = new JFrame("Lista de Fantasmas Capturados");
        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listFrame.setSize(600, 400);
        listFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        StringBuilder listContent = new StringBuilder();
        for (GhostModel ghost : model.getGhostTrap()) {
            listContent.append("ID: ").append(ghost.getId()).append(", Nombre: ").append(ghost.getName())
                    .append(", Tipo: ").append(ghost.getGhost_type().getGhostTypeDescription())
                    .append(", Nivel de Peligro: ").append(ghost.getDanger_level().getNumericLevel())
                    .append(", Habilidad Especial: ").append(ghost.getSpecial_skill())
                    .append(", Fecha de Captura: ").append(ghost.getCapture_date()).append("\n");
        }

        textArea.setText(listContent.toString());
        listFrame.add(scrollPane, BorderLayout.CENTER);
        listFrame.setVisible(true);
    }

    private void releaseGhost() {
        JFrame releaseFrame = new JFrame("Liberar Fantasma");
        releaseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        releaseFrame.setSize(400, 200);
        releaseFrame.setLayout(new GridLayout(3, 1));

        JTextField nameField = new JTextField();
        JButton releaseButton = new JButton("Liberar");

        releaseButton.addActionListener(e -> {
            String name = nameField.getText();
            GhostModel ghostToRemove = null;
            for (GhostModel ghost : model.getGhostTrap()) {
                if (ghost.getName().equals(name)) {
                    ghostToRemove = ghost;
                    break;
                }
            }

            if (ghostToRemove != null) {
                model.removeGhost(ghostToRemove);
                JOptionPane.showMessageDialog(releaseFrame, "Fantasma liberado exitosamente!", "Liberar", JOptionPane.INFORMATION_MESSAGE);
                releaseFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(releaseFrame, "Fantasma no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        releaseFrame.add(new JLabel("Nombre del Fantasma a Liberar:"));
        releaseFrame.add(nameField);
        releaseFrame.add(releaseButton);

        releaseFrame.setVisible(true);
    }

    private void exitGame() {
        JFrame exitFrame = new JFrame("Adiós");
        exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exitFrame.setSize(400, 300);
        exitFrame.setLayout(new BorderLayout());

        JLabel goodbyeLabel = new JLabel("¡Gracias por jugar! ¡Adiós!", SwingConstants.CENTER);
        URL imgURL = getClass().getResource("/ghost.png");
        if (imgURL != null) {
            ImageIcon ghostIcon = new ImageIcon(imgURL);
            JLabel ghostImageLabel = new JLabel(ghostIcon);
            exitFrame.add(ghostImageLabel, BorderLayout.CENTER);
        } else {
            JLabel errorLabel = new JLabel("Imagen no encontrada", SwingConstants.CENTER);
            exitFrame.add(errorLabel, BorderLayout.CENTER);
        }

        exitFrame.add(goodbyeLabel, BorderLayout.NORTH);
        exitFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GhostBusterGUI();
    }
}
