package dev.cachaguercus.proyecto4.controllers;

import java.time.LocalDate;
import java.util.Scanner;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.ButtonsFrame;
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
        if (model == null) {
            model = new GhostBusterModel();
        }

            model.setName(name);

    }

    public void selectOptionMainMenu() {
        ButtonsFrame buttonsFrame = new ButtonsFrame();
        buttonsFrame.setVisible(true);
        buttonsFrame.setLocationRelativeTo(null);
    }

    public String getGBModelName() {
        return model.getName();
    }

    public void captureGhost() {
    CaptureFrame captureFrame = new CaptureFrame();
    captureFrame.setVisible(true);
    captureFrame.setLocationRelativeTo(null);
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
        ListFrame listFrame = new ListFrame();
        listFrame.setVisible(true);
        listFrame.setLocationRelativeTo(null);
    }

    public void exitGame() {
        ExitFrame exitFrame = new ExitFrame();
        exitFrame.setVisible(true);
        exitFrame.setLocationRelativeTo(null);
    }
}
