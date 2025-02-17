package dev.cachaguercus.proyecto4.views;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostModel;
import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;

public class ListFrameTest {

    private GhostBusterController mockController;
    private ListFrame listFrame;
    private JTable table;

    @BeforeEach
    void setUp() {
        mockController = mock(GhostBusterController.class);
        listFrame = new ListFrame(mockController);
        table = listFrame.table;
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
        GhostModel ghost1 = new GhostModel(1, "Casper", enumGhostType.CLASE_I, enumDangerLevel.CRITICO, "Invisibilidad",
                LocalDate.now());
        GhostModel ghost2 = new GhostModel(2, "Manolin", enumGhostType.CLASE_II, enumDangerLevel.BAJO,
                "Posesiones infernales", LocalDate.now());

        List<GhostModel> mockData = Arrays.asList(ghost1, ghost2);
        when(mockController.getList()).thenReturn(mockData);

        listFrame.updateGhostList();

        DefaultTableModel model = (DefaultTableModel) listFrame.table.getModel();
        assertEquals(2, model.getRowCount(), "Table should have two rows after update.");
        assertEquals("Casper", model.getValueAt(0, 1), "First ghost name should be Casper.");
        assertEquals("Manolin", model.getValueAt(1, 1), "Second ghost name should be Manolin.");
    }

    @Test
    @DisplayName("Should adjust column widths")
    public void testAdjustColumnWidths() {
        GhostBusterController mockController = mock(GhostBusterController.class);
        ListFrame frame = new ListFrame(mockController);

        frame.adjustColumnWidths();

        assertEquals(50, frame.table.getColumnModel().getColumn(0).getPreferredWidth());
        assertEquals(100, frame.table.getColumnModel().getColumn(1).getPreferredWidth());
    }

    @Test
    @DisplayName("Should align the first column to the center")
    public void testColumnAlignment() {
        GhostBusterController mockController = mock(GhostBusterController.class);
        ListFrame frame = new ListFrame(mockController);

        TableCellRenderer renderer = frame.table.getColumnModel().getColumn(0).getCellRenderer();
        assertTrue(renderer instanceof DefaultTableCellRenderer);
        assertEquals(SwingConstants.CENTER, ((DefaultTableCellRenderer) renderer).getHorizontalAlignment());
    }

    @Test
    @DisplayName("Should clear the table when the list is empty")
    public void testUpdateGhostList_EmptyTable() {
        GhostBusterController mockController = mock(GhostBusterController.class);
        ListFrame frame = new ListFrame(mockController);

        when(mockController.getList()).thenReturn(List.of());

        frame.updateGhostList();

        assertEquals(0, frame.table.getRowCount());
    }

    @Test
    @DisplayName("Should not populate the table if the controller is null")
    public void testListFrame_NoController() {
        ListFrame frame = new ListFrame(null);
        assertNotNull(frame.table);
        assertEquals(0, frame.table.getRowCount());
    }
}
