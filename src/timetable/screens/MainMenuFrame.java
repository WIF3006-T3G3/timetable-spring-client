package timetable.screens;

import timetable.components.LogoPanel;
import timetable.components.MenuButtonsPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Simulator frame inherits the base frame configuration with all the parent components for the simulator.
 */
public class MainMenuFrame extends BaseFrame {
    @Override
    public void createComponents() {
        // logo
        JPanel logoPanel = new LogoPanel();
        add(logoPanel, BorderLayout.NORTH);

        // buttons panel
        JPanel buttonsPanel = new MenuButtonsPanel();
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
