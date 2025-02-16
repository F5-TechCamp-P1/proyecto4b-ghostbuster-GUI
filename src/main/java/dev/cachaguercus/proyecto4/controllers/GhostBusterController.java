package dev.cachaguercus.proyecto4.controllers;

import java.util.List;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.ButtonsFrame;
import dev.cachaguercus.proyecto4.views.CaptureFrame;
import dev.cachaguercus.proyecto4.views.ExitFrame;
import dev.cachaguercus.proyecto4.views.GBMainFrame;
import dev.cachaguercus.proyecto4.views.ListFrame;

public class GhostBusterController {
    private GhostBusterModel model;

    public GhostBusterController(GhostBusterModel model) {
        this.model = model;
    }

    public void run() {
        GBMainFrame gbMainFrame = new GBMainFrame(this);
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
        ButtonsFrame buttonsFrame = new ButtonsFrame(this);
        buttonsFrame.setVisible(true);
        buttonsFrame.setLocationRelativeTo(null);
    }

    public String getGBModelName() {
        return model.getName();
    }

    public void captureGhost() {
    CaptureFrame captureFrame = new CaptureFrame(this);
    captureFrame.setVisible(true);
    captureFrame.setLocationRelativeTo(null);
    }

    public void listGhosts() {
        ListFrame listFrame = new ListFrame(this);
        listFrame.setVisible(true);
        listFrame.setLocationRelativeTo(null);
    }

    public void exitGame() {
        ExitFrame exitFrame = new ExitFrame(this);
        exitFrame.setVisible(true);
        exitFrame.setLocationRelativeTo(null);
    }

    public void addGhost(String name, enumGhostType ghostType, enumDangerLevel dangerLevel, String specialSkill) {
        int lastGhostId = GhostBusterModel.getGhostTrap().size() + 1;
        GhostModel ghost = new GhostModel(lastGhostId, name, ghostType, dangerLevel, specialSkill, LocalDate.now());
        GhostBusterModel.captureGhost(ghost);

    }

    public List<GhostModel> getList(){
        return GhostBusterModel.getGhostTrap();
    }

    public void deleteGhost(int ghostId) {
        GhostBusterModel.removeGhost(GhostBusterModel.getGhostTrap().get(ghostId));
    }

    public void playAgain(){
        GBMainFrame gbMainFrame = new GBMainFrame(this); 
        gbMainFrame.setLocationRelativeTo(null);
        gbMainFrame.setVisible(true);
    }
}

