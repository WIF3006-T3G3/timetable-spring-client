package timetable.components;

import timetable.Main;
import timetable.factory.SimulatorComponentFactory;
import timetable.screens.MyTimetableFrame;

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
        JButton timetableButton = SimulatorComponentFactory.getInstance().createButton("My Timetable");
        add(timetableButton);
        timetableButton.addActionListener((evt) -> {
            // navigate to my timetable
            Main.navigate(new MyTimetableFrame());
        });
        setBackground(Color.white);
    }
}
