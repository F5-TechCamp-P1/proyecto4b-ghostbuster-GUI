package dev.cachaguercus.proyecto4.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;

public class GBMainFrame extends JFrame {

    public GBMainFrame() {
        initComponents();
    }

    public void initComponents() {
        setSize(1000, 1500);
        setTitle("Cachagüercus Asturias");
        setVisible(true);
    }
}