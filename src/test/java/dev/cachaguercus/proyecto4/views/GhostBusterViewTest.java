package dev.cachaguercus.proyecto4.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.text.MessageFormat;
import java.lang.StringBuilder;

public class GhostBusterViewTest {

    @Test
    @DisplayName("Should display the Welcome message and request a name to the GhostBuster")
    void testDisplayWelcomeMessage() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        ghostBusterView.displayWelcomeMessage();

        String expectedMessage = "\n" +
            "============================================================\n" +
            "    ¡Bienvenido a la Base Ghostbusters Asturias!\n" +
            "    Gestiona tus fantasmas atrapados y protege la región\n" +
            "============================================================\n" +
            "\n" +
            "Introduce tu nombre: ";
        String actualMessage = ghostBusterView.displayWelcomeMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should display the initial menu ask the user to select an option")
    void testDisplayInitialMenu() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        ghostBusterView.displayInitialMenu();

        String expectedMessage = "\n" +
            "============================================\r\n" +
            "OPCIONES:\n" +
            "============================================\r\n" +
            "1. Capturar un nuevo fantasma\n" +
            "2. Ver lista de fantasmas capturados\n" +
            "3. Liberar un fantasma\n" +
            "4. Salir\n" +
            "============================================\r\n" +
            "\n" +
            "Por favor, selecciona una opción (1-4):";
        String actualMessage = ghostBusterView.displayInitialMenu();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("To initiate the ghost capture, should display a request to enter a ghost name")
    void testDisplayCaptureGhost() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        ghostBusterView.displayCaptureGhost();
        String expectedMessage = "Capturar un Nuevo Fantasma\r\n" +
                "============================================\r\n" +
                "Ingresa el nombre del fantasma: ";
        String actualMessage = ghostBusterView.displayCaptureGhost();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    @DisplayName("Should ask to select a ghost type and show the options")
    void testDisplayGhostTypes() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        String expectedMessage = "Selecciona la clase del fantasma:\r\n" +
                "1. Clase I - Manifestación menor\r\n" +
                "2. Clase II - Aparición móvil\r\n" +
                "3. Clase III - Entidad inteligente\r\n" +
                "4. Clase IV - Fantasma histórico\r\n" +
                "5. Clase V - Espíritu antropomorfo\r\n" +
                "6. Clase VI - Espíritu demoníaco\r\n" +
                "7. Clase VII - Entidad ultraterrena";
        String actualMessage = ghostBusterView.displayGhostTypes();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should ask to select a danger level and show the options")
    void testDisplayDangerLevels() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        String expectedMessage = "\r\n" +
            "============================================\r\n" +
            "SELECCIONA EL NIVEL DE PELIGRO:\r\n" +
            "============================================\r\n" +
            "1. Bajo\r\n" +
            "2. Medio\r\n" +
            "3. Alto\r\n" +
            "4. Crítico\r\n" +
            "============================================\r\n" +
            "\n";
        String actualMessage = ghostBusterView.displayDangerLevels();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    @DisplayName("Should ask to enter a special skill for the captured ghost")
    void testDisplaySpecialSkill() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        String expectedMessage = "Añade la habilidad especial del fantasma: ";
        String actualMessage = ghostBusterView.displaySpecialSkill();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should display a successful capture message")
    void testDisplaySuccessfulCapture() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        GhostModel ghostModel = new GhostModel(0, null, null, null, null, null);
        ghostModel.setName("Casper");
        ghostModel.setCapture_date(LocalDate.now());
        String name = ghostModel.getName();
        LocalDate capture_date = ghostModel.getCapture_date();
        String expectedMessage = MessageFormat.format(
                "Fantasma {0} capturado exitosamente con nivel de afinidad ectoplásmica {1}.", name, capture_date);
        String actualMessage = ghostBusterView.displaySuccessfulCapture(name, capture_date);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should display the list of captured ghosts")
    void testDisplayGhostTrap() {
        GhostBusterModel ghostBusterModel = new GhostBusterModel();
        GhostModel casper = new GhostModel(0, "Casper", enumGhostType.CLASE_I, enumDangerLevel.BAJO,"aparecerse y sonreir", LocalDate.now());
        List<GhostModel> list = ghostBusterModel.getGhostTrap();
        String tableline;
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("\r\n")
                         .append("==================================================================\r\n")
                         .append("ID Nombre      Clase     Nivel de Peligro  Fecha de Captura\r\n")
                        .append("==================================================================\r\n");
        for (GhostModel ghost : list) {
            int id = ghost.getId();
            String name = ghost.getName();
            enumGhostType type = ghost.getGhost_type();
            enumDangerLevel danger = ghost.getDanger_level();
            LocalDate capture_date = ghost.getCapture_date();

            tableline = MessageFormat.format("{0} {1} {2} {3} {4}", id, name, type, danger, capture_date);
            expectedMessage.append("\r\n")
            .append(tableline);

        }
        GhostBusterView ghostBusterView = new GhostBusterView();
        String actualMessage = ghostBusterView.displayGhostTrap();
        assertThat(actualMessage, equalTo(expectedMessage.toString()));
    }

    @Test
    @DisplayName("When the ghostbuster select option 3 from main menu, should display a request to enter the id of the ghost to release")
    void testDisplayReleaseGhost() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        String expectedMessage = "Ingresa el nombre del fantasma que quieres liberar: ";
        String actualMessage = ghostBusterView.displayReleaseGhost();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("When the ghostbuster released a ghost, should display a success message")
    void testDisplaySuccessfulRelease() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        String expectedMessage = "Fantasma liberado con éxito";
        String actualMessage = ghostBusterView.displaySuccessfulRelease();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("When the ghostbuster select option 4 from main menu, should display a farewell confirmation message")
    void testDisplayExitMessage() {
        GhostBusterView ghostBusterView = new GhostBusterView();
        String expectedMessage = "Salir del Programa\n" +
                        "============================================\n" +
                        "    ¡Gracias por proteger Asturias!\n" +
                        "    ¡Nos vemos en la próxima cacería paranormal!\n" +
                        "============================================";
        String actualMessage = ghostBusterView.displayExitMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
