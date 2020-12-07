package timetable.screens;

import timetable.components.NavPanel;
import timetable.components.TimetablePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Simulator frame inherits the base frame configuration with all the parent components for the simulator.
 */
public class MainMenuFrame extends BaseFrame {

    @Override
    public void createComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // nav bar
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel navPanel = new NavPanel();
        mainPanel.add(navPanel, gbc);

        // main content
        gbc.gridx = 0;
        gbc.gridy = 1;
        TimetablePanel timetablePanel = new TimetablePanel();
        mainPanel.add(timetablePanel, gbc);

        add(mainPanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.white);
        setBackground(Color.white);
    }
}
