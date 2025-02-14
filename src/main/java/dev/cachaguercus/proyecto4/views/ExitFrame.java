package dev.cachaguercus.proyecto4.views;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.cachaguercus.proyecto4.controllers.GhostBusterController;

public class ExitFrame extends JFrame {
    GhostBusterController controller;
    
    public ExitFrame() {

        JLabel title = new JLabel("GhostBusters Asturias");
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel goodbyeMessage = new JLabel("¡Gracias por proteger Asturias!¡Nos vemos en la próxima cacería paranormal!");
        goodbyeMessage.setAlignmentX(CENTER_ALIGNMENT);

        JButton playAgainBtn = new JButton("Volver a la cacería paranormal");
        playAgainBtn.setAlignmentX(CENTER_ALIGNMENT);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(goodbyeMessage);
        panel.add(playAgainBtn);    
        setContentPane(panel);

        
        setSize(800, 400); 
        setLocationRelativeTo(null);
        setTitle("GhostBusters Asturias");
        setVisible(true); 

        playAgainBtn.addActionListener(e -> {
            startAgain();
            
        });
    }

    public void startAgain() {
        controller.playAgain();
        dispose();
    }    

}
