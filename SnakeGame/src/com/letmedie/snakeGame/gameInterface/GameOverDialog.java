package com.letmedie.snakeGame.gameInterface;

import javax.swing.*;
import java.awt.*;

public class GameOverDialog {
    public GameOverDialog(int score) {
        JFrame dialogFrame = new JFrame("Game Over");
        dialogFrame.setSize(300, 150);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogFrame.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Game Over! Your score: " + score, SwingConstants.CENTER);
        dialogFrame.add(messageLabel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dialogFrame.dispose());
        dialogFrame.add(okButton, BorderLayout.SOUTH);

        dialogFrame.setVisible(true);
    }
}
