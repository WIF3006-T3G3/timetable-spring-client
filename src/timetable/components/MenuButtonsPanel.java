package timetable.components;

import timetable.Main;
import timetable.factory.SimulatorComponentFactory;
import timetable.screens.MainMenuFrame;
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
        GridLayout gridLayout = new GridLayout(1, 2);
        setLayout(gridLayout);

        JButton manageButton = SimulatorComponentFactory.getInstance().createButton("Manage Timetable");
        manageButton.setMaximumSize(new Dimension(300, 40));
        add(manageButton);
        manageButton.addActionListener((evt) -> {
            // navigate to setting frame
            Main.navigate(new MainMenuFrame());
        });

        JButton timetableButton = SimulatorComponentFactory.getInstance().createButton("View Timetable");
        timetableButton.setMaximumSize(new Dimension(300, 40));
        add(timetableButton);
        timetableButton.addActionListener((evt) -> {
            // navigate to my timetable
            Main.navigate(new MyTimetableFrame());
        });

        setBackground(Color.white);
    }
}
