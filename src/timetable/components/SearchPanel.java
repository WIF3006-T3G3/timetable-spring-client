package timetable.components;

import timetable.controller.CodeComboController;
import timetable.dao.TimetableDAO;
import timetable.dto.Timetable;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SearchPanel extends JPanel {

    private JButton button;
    private JComboBox<String> typeCombo, codeCombo;

    public JButton getButton() {
        return button;
    }

    public JComboBox<String> getTypeCombo() {
        return typeCombo;
    }

    public JComboBox<String> getCodeCombo() {
        return codeCombo;
    }

    public SearchPanel() {
        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        TimetableDAO timetableDAO = new TimetableDAO();
        Timetable[] tables = timetableDAO.getTimetables();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 5, 0, 5);
        JLabel codeLabel = SimulatorComponentFactory.getInstance().createLabel("Course Code");
        add(codeLabel, gbc);

        gbc.gridx = 1;
        codeCombo = new JComboBox<>();
        ArrayList<String> codeSelected = new ArrayList<>();
        Arrays.sort(tables, Comparator.comparing(Timetable::getCode));
        for (Timetable t : tables)
            if (!codeSelected.contains(t.getCode())) {
                codeCombo.addItem(t.getCode());
                codeSelected.add(t.getCode());
            }
        add(codeCombo, gbc);

        gbc.gridx = 2;
        JLabel typeLabel = SimulatorComponentFactory.getInstance().createLabel("Type");
        add(typeLabel, gbc);

        gbc.gridx = 3;
        typeCombo = new JComboBox<>();
        ArrayList<String> selected = new ArrayList<>();
        Arrays.sort(tables, Comparator.comparing(Timetable::getTypes));
        for (Timetable table : timetableDAO.getTimetables()) {
            if (codeCombo.getSelectedItem() != null &&
                    table.getCode().equals(codeCombo.getSelectedItem().toString()) &&
                    !selected.contains(table.getTypes())) {
                typeCombo.addItem(table.getTypes());
                selected.add(table.getTypes());
            }
        }
        add(typeCombo, gbc);

        gbc.gridx = 4;
        button = SimulatorComponentFactory.getInstance().createButton("Search");
        add(button, gbc);

        codeCombo.addActionListener(new CodeComboController(codeCombo, typeCombo, timetableDAO));

        setBackground(Color.white);
    }
}
