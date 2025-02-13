package dev.cachaguercus.proyecto4;

import javax.swing.*;

import dev.cachaguercus.proyecto4.views.GBMainFrame;

public class CachaguercusApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GBMainFrame mainframe = new GBMainFrame();
            }
        });
    }
}

