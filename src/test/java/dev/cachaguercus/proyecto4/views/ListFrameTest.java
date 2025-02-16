package dev.cachaguercus.proyecto4.views;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.views.ListFrame;

public class ListFrameTest {

    private GhostBusterController mockController;
    private ListFrame listFrame;

    @BeforeEach
    void setUp() {
        mockController = mock(GhostBusterController.class);
        listFrame = new ListFrame(mockController);
    }

    @Test
    @DisplayName("Should start with an empty table")
    void testTableStartsEmpty() {
        DefaultTableModel model = (DefaultTableModel) listFrame.table.getModel();
        assertEquals(0, model.getRowCount(), "Table should be empty at initialization.");
    }

    @Test
    @DisplayName("Should populate the table with captured ghosts")
    void testUpdateGhostList_PopulatesTableCorrectly() {
        GhostModel ghost1 = new GhostModel(1, "Casper", enumGhostType.CLASE_I, enumDangerLevel.CRITICO, "Invisibilidad", LocalDate.now());
        GhostModel ghost2 = new GhostModel(2, "Manolin", enumGhostType.CLASE_II, enumDangerLevel.BAJO, "Posesiones infernales", LocalDate.now());

        List<GhostModel> mockData = Arrays.asList(ghost1, ghost2);
        when(mockController.getList()).thenReturn(mockData);

        listFrame.updateGhostList();

        DefaultTableModel model = (DefaultTableModel) listFrame.table.getModel();
        assertEquals(2, model.getRowCount(), "Table should have two rows after update.");
        assertEquals("Casper", model.getValueAt(0, 1), "First ghost name should be Casper.");
        assertEquals("Manolin", model.getValueAt(1, 1), "Second ghost name should be Manolin.");
    }
}
