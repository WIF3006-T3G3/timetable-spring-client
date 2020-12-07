package timetable.components;

import timetable.dto.Timetable;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;

public class CourseCard extends JPanel {
    public CourseCard(Timetable table) {
        super();
        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(SimulatorComponentFactory.getInstance().createLabel(table.getCode()), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.insets = new Insets(0, 50, 0, 0);
        add(SimulatorComponentFactory.getInstance().createButton("Add"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(SimulatorComponentFactory.getInstance().createLabel("Time: " + table.getStart() + " - " + table.getEnd()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(SimulatorComponentFactory.getInstance().createLabel("Venue: " + table.getLocation()), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 50, 0, 0);
        add(SimulatorComponentFactory.getInstance().createLabel("Lecturer: " + table.getLecturerCode()), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(SimulatorComponentFactory.getInstance().createLabel("Group: " + table.getGroups()), gbc);

        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(700, 100));
    }
}
