package dev.cachaguercus.proyecto4.views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GhostBackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public GhostBackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }
    }
}
