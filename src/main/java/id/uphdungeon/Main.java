package id.uphdungeon;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame();

            // Basic Window Settings
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("UPH Dungeon");

            // Add the GamePanel (the actual game world)
            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);

            window.pack(); // Sizes the window to fit the GamePanel
            window.setLocationRelativeTo(null); // Centers the window
            window.setVisible(true);

            gamePanel.startGameThread();
        });
    }
}
