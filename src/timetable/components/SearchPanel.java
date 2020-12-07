package timetable.components;

import timetable.dao.TimetableDAO;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    public SearchPanel() {
        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,5,0,5);
        JLabel codeLabel = SimulatorComponentFactory.getInstance().createLabel("Course Code");
        add(codeLabel, gbc);

        gbc.gridx = 1;
        JComboBox<String> codeCombo = new JComboBox<>();
        for (String i : new TimetableDAO().getDistinctCodes())
            codeCombo.addItem(i);
        add(codeCombo, gbc);

        gbc.gridx = 2;
        JLabel groupLabel = SimulatorComponentFactory.getInstance().createLabel("Group");
        add(groupLabel, gbc);

        gbc.gridx = 3;
        JComboBox<String> groupCombo = new JComboBox<>();
        for (String i : new TimetableDAO().getDistinctCodes())
            groupCombo.addItem(i);
        add(groupCombo, gbc);

        gbc.gridx = 4;
        JButton button = SimulatorComponentFactory.getInstance().createButton("Search");
        add(button, gbc);

        setBackground(Color.white);
    }
}
