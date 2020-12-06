package timetable.components;

import timetable.Main;
import timetable.factory.SimulatorComponentFactory;
import timetable.screens.MyTimetableFrame;
import timetable.screens.SettingFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Title to describe the simulator.
 */
public class MenuButtonsPanel extends JPanel {

    /**
     * Initialize the title with white background
     */
    public MenuButtonsPanel() {
        super();
        JButton manageButton = SimulatorComponentFactory.getInstance().createButton("Manage Timetable");
        add(manageButton);
        manageButton.addActionListener((evt) -> {
            // navigate to setting frame
            Main.navigate(new SettingFrame());
        });

        JButton timetableButton = SimulatorComponentFactory.getInstance().createButton("My Timetable");
        add(timetableButton);
        timetableButton.addActionListener((evt) -> {
            // navigate to my timetable
            Main.navigate(new MyTimetableFrame());
        });

        setBackground(Color.white);
    }
}
