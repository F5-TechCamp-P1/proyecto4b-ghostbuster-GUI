package dev.cachaguercus.proyecto4.controllers;

import java.time.LocalDate;
import java.util.Scanner;

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

    public void removeGhost() {
        view.displayReleaseGhost();
        String name = scanner.nextLine();

        for (GhostModel ghost : GhostBusterModel.getGhostTrap()) {
            if (ghost.getName().equals(name)) {
                GhostBusterModel.removeGhost(ghost);
                view.displaySuccessfulRelease();
                return;
            }
        }
    }

    public void listGhosts() {
        view.displayGhostTrap();
    }

    public void exitGame() {
        view.displayExitMessage();
    }
}
