package dev.cachaguercus.proyecto4.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.GhostBusterView;

import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

public class GhostBusterControllerTest {

    @Test
    @DisplayName("Should ask GhostBusterView to displayWelcomeMessage")
    void testRun() {
        GhostBusterView view = Mockito.mock(GhostBusterView.class);
        GhostBusterModel model = new GhostBusterModel();
        String input = "X\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        GhostBusterController controller = new GhostBusterController(model, view);

        controller.run();
        verify(view, times(1)).displayWelcomeMessage();
    }

    @Test
    @DisplayName("Should ask GhostBusterView to displayInitialMenu")
    void testSelectOptionMainMenu() {
        GhostBusterView view = Mockito.mock(GhostBusterView.class);
        GhostBusterModel model = new GhostBusterModel();
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        GhostBusterController controller = new GhostBusterController(model, view);

        controller.selectOptionMainMenu();
        verify(view, times(1)).displayInitialMenu();
    }

    @Test
    @DisplayName("Should ask model to set the GhostBuster name")
    void testRunAsksUserForName() {
        GhostBusterView view = new GhostBusterView();
        GhostBusterModel model = Mockito.mock(GhostBusterModel.class);
        String input = "Cachaguercu\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        GhostBusterController controller = new GhostBusterController(model, view);

        controller.run();
        verify(model, times(1)).setName("Cachaguercu");
    }

   @Test
    @DisplayName("When captureGhost is called, should call model.captureGhost with the correct parameters")
    void testCaptureGhost() {
        GhostBusterModel model = new GhostBusterModel();
        GhostBusterView view = Mockito.mock(GhostBusterView.class);
        InputStream in = new ByteArrayInputStream("Casper\n1\n1\naparecerse y sonreir\n".getBytes());
        System.setIn(in);
        GhostBusterController controller = new GhostBusterController(model, view);

        controller.captureGhost();

        verify(view, times(1)).displaySuccessfulCapture(any(String.class), any(LocalDate.class));
    }

    @Test
    @DisplayName("Should pass a name to model so that it removes the ghost by removeGhost")
    void testRemoveGhost() {
        GhostBusterModel model = Mockito.mock(GhostBusterModel.class);
        GhostBusterView view = Mockito.mock(GhostBusterView.class);
        System.setIn(new ByteArrayInputStream("Casper\n".getBytes()));
        GhostBusterController controller = new GhostBusterController(model, view);
        GhostModel ghost = new GhostModel(0, "Casper", enumGhostType.CLASE_I, enumDangerLevel.BAJO,
        "aparecerse y sonreir", LocalDate.now());
        GhostBusterModel.captureGhost(ghost);
        when(view.displayReleaseGhost()).thenReturn("Casper");
        controller.removeGhost();
        assertThat(GhostBusterModel.getGhostTrap(), not(hasItem(ghost)));
    }

     @Test
    @DisplayName("Should display the list of captured ghosts")
    void testListGhosts() {
        GhostBusterModel model = Mockito.mock(GhostBusterModel.class);
        GhostBusterView view = Mockito.mock(GhostBusterView.class);
        GhostBusterController controller = new GhostBusterController(model, view);
        GhostModel ghost = new GhostModel(0, "Casper", enumGhostType.CLASE_I, enumDangerLevel.BAJO,
                "aparecerse y sonreir", LocalDate.now());
        GhostBusterModel.captureGhost(ghost);
        controller.listGhosts();
        verify(view, times(1)).displayGhostTrap();
    }

    @Test
    @DisplayName("Should display exit message")
    void testExitGame() {
        GhostBusterView view = Mockito.mock(GhostBusterView.class);
        GhostBusterController controller = new GhostBusterController(null, view);
        controller.exitGame();
        verify(view, times(1)).displayExitMessage();
    }

}