package dev.cachaguercus.proyecto4.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostModel;

public class ListFrame extends JFrame {

    private GhostBusterController controller;
    private DefaultTableModel tableModel;

    public ListFrame(GhostBusterController controller) {
        this.controller = controller;

        setTitle("Lista de Fantasmas Capturados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());


        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Tipo", "Nivel de Peligro", "Habilidad Especial", "Fecha de Captura", "Acción"}, 0);


        if (controller != null) {
            updateGhostList();
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);


        Action deleteAction = new AbstractAction("Eliminar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    int ghostId = (int) tableModel.getValueAt(row, 0);
                    int confirmation = JOptionPane.showConfirmDialog(ListFrame.this, "¿Seguro que desea eliminar este fantasma?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        controller.deleteGhost(ghostId);
                        updateGhostList();
                    }
                }
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(table, deleteAction, 6);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }



    private void updateGhostList() {
        tableModel.setRowCount(0);
        if (controller != null) {
            List<GhostModel> ghosts = controller.getList();
            if (ghosts != null) {
                for (GhostModel ghost : ghosts) {
                    if (ghost != null) {
                        tableModel.addRow(new Object[]{
                                ghost.getId(),
                                ghost.getName(),
                                ghost.getGhost_type().getGhostTypeDescription(),
                                ghost.getDanger_level().getNumericLevel(),
                                ghost.getSpecial_skill(),
                                ghost.getCapture_date()
                        });
                    }
                }
            }
        }
    }



    private class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {

        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, Action action, int column) {
            this.table = table;
            renderButton = new JButton();
            editButton = new JButton();
            editButton.setAction(action);
            editButton.setOpaque(true);
            this.table.getColumnModel().getColumn(column).setCellRenderer(this);
            this.table.getColumnModel().getColumn(column).setCellEditor(this);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (hasFocus) {
                editButton.setForeground(table.getForeground());
                editButton.setBackground(UIManager.getColor("Button.background"));
            }
            if (isSelected) {
                editButton.setForeground(table.getSelectionForeground());
                editButton.setBackground(table.getSelectionBackground());
            } else {
                editButton.setForeground(table.getForeground());
                editButton.setBackground(UIManager.getColor("Button.background"));
            }

            editButton.setText("Eliminar");
            return editButton;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            text = (value == null) ? "" : value.toString();
            editButton.setText(text);
            return editButton;
        }

        @Override
        public Object getCellEditorValue() {
            return text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            fireEditingStopped();
        }
    }
}