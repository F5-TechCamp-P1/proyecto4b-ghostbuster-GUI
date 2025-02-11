package dev.cachaguercus.proyecto4;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.views.GhostBusterView;

public class CachaguercusApp {

    public static void main(String[] args) {
        GhostBusterModel model = new GhostBusterModel();
        GhostBusterView view = new GhostBusterView();
        GhostBusterController controller = new GhostBusterController(model, view);

        controller.run();
    }
}