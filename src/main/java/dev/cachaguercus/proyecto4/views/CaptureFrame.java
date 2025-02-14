package dev.cachaguercus.proyecto4.views;

import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController; // Importa el controlador
import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;

public class CaptureFrame extends JFrame {
    public CaptureFrame(GhostBusterController controller) {  // <-- Agregamos el controlador como parámetro
        setTitle("Capturar Fantasma");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

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

            // Llamamos al controlador para capturar el fantasma
            controller.addGhost(name, ghostType, dangerLevel, specialSkill);

            JOptionPane.showMessageDialog(this, "Fantasma capturado exitosamente!", "Captura", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        add(new JLabel("Nombre del Fantasma:"));
        add(nameField);
        add(new JLabel("Tipo de Fantasma:"));
        add(ghostTypeComboBox);
        add(new JLabel("Nivel de Peligro:"));
        add(dangerLevelComboBox);
        add(new JLabel("Habilidad Especial:"));
        add(specialSkillField);
        add(captureButton);

        setVisible(true);
    }
}
