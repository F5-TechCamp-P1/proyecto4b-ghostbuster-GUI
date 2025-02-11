package dev.cachaguercus.proyecto4.controllers;

import java.time.LocalDate;
import java.util.Scanner;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.GhostBusterView;

public class GhostBusterController {
    private GhostBusterModel model;
    private GhostBusterView view;
    private static Scanner scanner = new Scanner(System.in);
    private int lastGhostId = 0;

    public GhostBusterController(GhostBusterModel model, GhostBusterView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.displayWelcomeMessage();
        String ghostBustername = scanner.nextLine();
        model.setName(ghostBustername);
        selectOptionMainMenu();
    }

    public void selectOptionMainMenu() {
        view.displayInitialMenu();
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                captureGhost();
                selectOptionMainMenu();
                break;
            case "2":
                listGhosts();
                selectOptionMainMenu();
                break;
            case "3":
                removeGhost();
                selectOptionMainMenu();
                break;
            case "4":
                exitGame();
                break;
            default:
                selectOptionMainMenu();
                break;
        }
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
