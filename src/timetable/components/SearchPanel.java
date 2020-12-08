package timetable.components;

import timetable.constants.Events;
import timetable.controller.CodeComboController;
import timetable.dao.CourseDAO;
import timetable.dto.Course;
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
        CourseDAO courseDAO = new CourseDAO();
        Course[] courses = courseDAO.getCourses();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 5, 0, 5);
        JLabel codeLabel = SimulatorComponentFactory.getInstance().createLabel("Course Code");
        add(codeLabel, gbc);

        gbc.gridx = 1;
        codeCombo = new JComboBox<>();
        ArrayList<String> codeSelected = new ArrayList<>();
        Arrays.sort(courses, Comparator.comparing(Course::getCode));
        for (Course t : courses)
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
        Arrays.sort(courses, Comparator.comparing(Course::getTypes));
        for (Course c : courseDAO.getCourses()) {
            if (codeCombo.getSelectedItem() != null &&
                    c.getCode().equals(codeCombo.getSelectedItem().toString()) &&
                    !selected.contains(c.getTypes())) {
                typeCombo.addItem(c.getTypes());
                selected.add(c.getTypes());
            }
        }
        add(typeCombo, gbc);

        gbc.gridx = 4;
        button = SimulatorComponentFactory.getInstance().createButton("Search");
        button.addActionListener((evt) -> {
            if (codeCombo.getSelectedItem() == null || typeCombo.getSelectedItem() == null) return;
            // fire event to search courses by code and type
            firePropertyChange(Events.SEARCH_COURSES, null, new String[]{
                    codeCombo.getSelectedItem().toString(), typeCombo.getSelectedItem().toString()
            });
        });
        add(button, gbc);

        // when code changes, change the type options
        codeCombo.addActionListener(new CodeComboController(codeCombo, typeCombo, courseDAO));

        setBackground(Color.white);
    }
}
