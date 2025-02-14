package dev.cachaguercus.proyecto4.controllers;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.GBMainFrame;

public class GhostBusterController {
    private GhostBusterModel model;
    private int lastGhostId = 0;

    public GhostBusterController(GhostBusterModel model) {
        this.model = model;
    }

    public void run() {
        GBMainFrame gbMainFrame = new GBMainFrame();
        gbMainFrame.setVisible(true);
        gbMainFrame.setLocationRelativeTo(null);

    }

    public void saveGBModelName(String name){
        String ghostBustername = name;
        model.setName(ghostBustername);
    }

    public void selectOptionMainMenu() {
        ButtonsFrame buttonsFrame = new ButtonsFrame();
        buttonsFrame.setVisible(true);
        buttonsFrame.setLocationRelativeTo(null);
     }

   public void captureGhost() {
        view.displayCaptureGhost();
        String name = scanner.nextLine();

        view.displayGhostTypes();
        int option = Integer.parseInt(scanner.nextLine());
        enumGhostType ghostType = enumGhostType.values()[option - 1];

        view.displayDangerLevels();
        int option2 = Integer.parseInt(scanner.nextLine());
        enumDangerLevel dangerLevel = enumDangerLevel.values()[option2 - 1];

        view.displaySpecialSkill();
        String specialSkill = scanner.nextLine();

        LocalDate captureDate = LocalDate.now();

        GhostModel ghost = new GhostModel(++lastGhostId, name, ghostType, dangerLevel, specialSkill, captureDate);
        GhostBusterModel.captureGhost(ghost);

        view.displaySuccessfulCapture(name, captureDate);
    }

    // Método para agregar un fantasma a la lista
    public void addGhost(String name, enumGhostType ghostType, enumDangerLevel dangerLevel, String specialSkill) {
        LocalDate captureDate = LocalDate.now();
        GhostModel ghost = new GhostModel(GhostBusterModel.getGhostTrap().size() + 1, name, ghostType, dangerLevel, specialSkill, captureDate);
        GhostBusterModel.captureGhost(ghost);
        JOptionPane.showMessageDialog(null, "Fantasma capturado con éxito!", "Captura", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para listar los fantasmas capturados
    public void listGhosts() {
        StringBuilder ghostsList = new StringBuilder("Fantasmas capturados:\n");
        for (GhostModel ghost : GhostBusterModel.getGhostTrap()) {
            ghostsList.append(ghost.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, ghostsList.toString(), "Lista de Fantasmas", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para eliminar un fantasma
    public void removeGhost() {
        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre del fantasma a liberar:");
        if (name != null) {
            for (GhostModel ghost : GhostBusterModel.getGhostTrap()) {
                if (ghost.getName().equalsIgnoreCase(name)) {
                    GhostBusterModel.removeGhost(ghost);
                    JOptionPane.showMessageDialog(null, "Fantasma liberado!", "Liberación", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Fantasma no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para salir del juego
    public void exitGame() {
        JOptionPane.showMessageDialog(null, "¡Gracias por jugar!", "Salir", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

