package dev.cachaguercus.proyecto4.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.ButtonsFrame;
import dev.cachaguercus.proyecto4.views.CaptureFrame;
import dev.cachaguercus.proyecto4.views.ExitFrame;
import dev.cachaguercus.proyecto4.views.GBMainFrame;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.mockito.ArgumentMatchers.any;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;


public class GhostBusterControllerTest {

    private GhostBusterController controller;
    private GhostBusterModel model;
    private Robot robot;
    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        model = new GhostBusterModel();
        controller = new GhostBusterController(model);
        robot = BasicRobot.robotWithNewAwtHierarchy();
    }

    @AfterEach
    public void tearDown() {
        if (window != null) {
            window.cleanUp();
        }
    }    

    @Test
    @DisplayName("Should open GBMainFrame")
    void testRun() {
        GuiActionRunner.execute(() -> controller.run());
        window = findFrame(GBMainFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
    }

    @Test
    @DisplayName("Should open ButtonsFrame")
    void testSelectOptionMainMenu() {
        GuiActionRunner.execute(() -> controller.selectOptionMainMenu());
        window = findFrame(ButtonsFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
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
    @DisplayName("Should open ExitFrame")
    void testExitGame() {
        GuiActionRunner.execute(() -> controller.exitGame());
        window = findFrame(ExitFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
    }

}