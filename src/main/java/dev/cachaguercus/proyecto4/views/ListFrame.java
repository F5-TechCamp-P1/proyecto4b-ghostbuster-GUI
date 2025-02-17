package dev.cachaguercus.proyecto4.views;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostModel;

public class ListFrame extends JFrame {

    private final GhostBusterController controller;
    private final DefaultTableModel tableModel;
    final JTable table;

    public ListFrame(GhostBusterController controller) {
        this.controller = controller;

        setTitle("Lista de Fantasmas Capturados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 800);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Nombre", "Tipo", "Peligro", "Habilidad Especial", "Fecha de Captura", "Acción"
        }, 0);

        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        add(new JScrollPane(table), BorderLayout.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        int[] columnsToCenter = { 0,3,5 };
        for (int column : columnsToCenter) {
            table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
        }

        if (controller != null) {
            updateGhostList();
        }

        setupDeleteButtonColumn();

        setVisible(true);
    }

    void updateGhostList() {
        tableModel.setRowCount(0);
        List<GhostModel> ghosts = controller.getList();

        if (ghosts != null) {
            for (GhostModel ghost : ghosts) {
                tableModel.addRow(new Object[] {
                        ghost.getId(),
                        ghost.getName(),
                        ghost.getGhost_type().getGhostTypeDescription(),
                        ghost.getDanger_level().getNumericLevel(),
                        ghost.getSpecial_skill(),
                        ghost.getCapture_date(),
                        "Liberar"
                });
            }
        }
        adjustColumnWidths();
    }

    void adjustColumnWidths() {
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(75);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void setupDeleteButtonColumn() {
        Action deleteAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                System.out.println();
                if (row >= 0) {
                    int ghostId = (int) tableModel.getValueAt(row, 0);
                    int confirmation = JOptionPane.showConfirmDialog(
                            ListFrame.this, "¿Seguro que desea liberar a este fantasma?",
                            "Confirmar Liberación", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        controller.deleteGhost(ghostId);
                        updateGhostList();
                        JOptionPane.showMessageDialog(ListFrame.this,
                                "Fantasma liberado con éxito.",
                                "Liberación Exitosa",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        };
        new ButtonColumn(table, deleteAction, 6);
    }

    private static class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

        private final JTable table;
        private final JButton button;
        private final Action action;
        private String text;

        public ButtonColumn(JTable table, Action action, int column) {
            this.table = table;
            this.action = action;
            this.button = new JButton("Liberar");
            button.setOpaque(true);
            button.addActionListener(e -> {
                action.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                fireEditingStopped();
            });

            this.table.getColumnModel().getColumn(column).setCellRenderer(this);
            this.table.getColumnModel().getColumn(column).setCellEditor(this);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            button.setBackground(isSelected ? table.getSelectionBackground() : UIManager.getColor("Button.background"));
            return button;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            text = (value == null) ? "" : value.toString();
            button.setText(text);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return text;
        }
    }
}