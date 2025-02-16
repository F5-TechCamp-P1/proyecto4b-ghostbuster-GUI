package dev.cachaguercus.proyecto4.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.views.ButtonsFrame;
import dev.cachaguercus.proyecto4.views.CaptureFrame;
import dev.cachaguercus.proyecto4.views.ExitFrame;
import dev.cachaguercus.proyecto4.views.GBMainFrame;
import dev.cachaguercus.proyecto4.views.ListFrame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.swing.finder.WindowFinder.findFrame;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;

public class GhostBusterControllerTest {

    private GhostBusterController controller;
    @Mock
    private GhostBusterModel modelMock;
    private Robot robot;
    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new GhostBusterController(modelMock);
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
    @DisplayName("Should open CaptureFrame")
    void testCaptureGhost() {
        GuiActionRunner.execute(() -> controller.captureGhost());
        window = findFrame(CaptureFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
    }

    @Test
    @DisplayName("Should open ListFrame")
    void testListGhosts() {
        GuiActionRunner.execute(() -> controller.listGhosts());
        window = findFrame(ListFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
    }

    @Test
    @DisplayName("Should open ExitFrame")
    void testExitGame() {
        GuiActionRunner.execute(() -> controller.exitGame());
        window = findFrame(ExitFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
    }

    @Test
    void testPlayAgain() {
        GuiActionRunner.execute(() -> controller.playAgain());
        window = findFrame(GBMainFrame.class).using(robot);
        assertThat(window).isNotNull();
        assertThat(window.target().isShowing()).isTrue();
    }

    /* @Test
    void testDeleteGhost() {
        // Crea un Ghost ficticio para la prueba
        GhostModel ghost = new GhostModel(0, "Caper", enumGhostType.CLASE_II, enumDangerLevel.CRITICO, "volar", LocalDate.now());
        List<GhostModel> ghostTrap = new ArrayList<>();
        ghostTrap.add(ghost);

        // Configura el mock para devolver la lista de Ghosts
        when(modelMock.getGhostTrap()).thenReturn(ghostTrap);

        // Llama al método del controlador
        controller.deleteGhost(0);

        // Verifica que el método removeGhost fue llamado con el Ghost correcto
        verify(modelMock).removeGhost(ghost);
    } */
}
