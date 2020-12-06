package timetable.components;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Simulator frame inherits the base frame configuration with all the parent components for the simulator.
 */
public class TimetableFrame extends BaseFrame {
    @Override
    public void createComponents() {
        // Empty JavaFX Panel to trigger launch event for audio player component
        JFXPanel jfxPanel = new JFXPanel();
        add(jfxPanel);

        // logo
        JPanel logoPanel = new LogoPanel();
        add(logoPanel, BorderLayout.NORTH);
//
//        // drawing board
//        JLayeredPane board = new BoardPanel();
//        board.addPropertyChangeListener(new ScreenshotController(this));
//        add(board, BorderLayout.CENTER);
//
//        // bottom menu
//        JPanel bottomMenuPanel = new BottomMenuPanel();
//        bottomMenuPanel.addPropertyChangeListener(new AddComponentController(board));
//        add(bottomMenuPanel, BorderLayout.SOUTH);
    }
}
