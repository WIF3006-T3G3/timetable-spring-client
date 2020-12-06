package timetable.components;

import timetable.Main;
import timetable.factory.SimulatorComponentFactory;
import timetable.screens.MainMenuFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Title to describe the simulator.
 */
public class MyTimetablePanel extends JPanel {

    /**
     * Initialize the title with white background
     */
    public MyTimetablePanel() {
        super();

        setLayout(new BorderLayout());

        JLabel table1 = SimulatorComponentFactory.getInstance().createImageLabel("/screenshots/timetable1.png",
                0, 0, 700, 300);
        add(table1, BorderLayout.NORTH);

        JLabel table2 = SimulatorComponentFactory.getInstance().createImageLabel("/screenshots/timetable2.png",
                0, 0, 700, 300);
        add(table2, BorderLayout.CENTER);

        JButton backButton = SimulatorComponentFactory.getInstance().createButton("Back");
        add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener((evt) -> {
            // navigate to main menu
            Main.navigate(new MainMenuFrame());
        });
    }
}
