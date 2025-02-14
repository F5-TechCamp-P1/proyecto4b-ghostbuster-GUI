package dev.cachaguercus.proyecto4;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;

public class CachaguercusApp {
    public static void main(String[] args) {
        GhostBusterModel model = new GhostBusterModel();
        GhostBusterController ghostBusterController = new GhostBusterController(model);
        ghostBusterController.run();
    }
}
