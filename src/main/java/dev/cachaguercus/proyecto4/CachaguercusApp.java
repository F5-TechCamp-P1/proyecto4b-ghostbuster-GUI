package dev.cachaguercus.proyecto4;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class CachaguercusApp {
    public static void main(String[] args) {
        GhostBusterController ghostBusterController = new GhostBusterController(null);
        ghostBusterController.run();
    }
}
