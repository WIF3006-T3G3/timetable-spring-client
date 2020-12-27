package timetable.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // get course dao spring bean
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        CourseDAO courseDAO = (CourseDAO) context.getBean("courseDAOBean");
        Course[] courses = courseDAO.getCourses();

        JLabel codeLabel = SimulatorComponentFactory.getInstance().createLabel("Course Code");
        add(codeLabel);
        add(Box.createRigidArea(new Dimension(20, 5)));

        codeCombo = new JComboBox<>();
        ArrayList<String> codeSelected = new ArrayList<>();
        Arrays.sort(courses, Comparator.comparing(Course::getCode));
        for (Course t : courses)
            if (!codeSelected.contains(t.getCode())) {
                codeCombo.addItem(t.getCode());
                codeSelected.add(t.getCode());
            }
        add(codeCombo);
        add(Box.createRigidArea(new Dimension(20, 5)));

        JLabel typeLabel = SimulatorComponentFactory.getInstance().createLabel("Type");
        add(typeLabel);
        add(Box.createRigidArea(new Dimension(20, 5)));

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
        add(typeCombo);
        add(Box.createRigidArea(new Dimension(20, 5)));

        button = SimulatorComponentFactory.getInstance().createButton("Search");
        button.addActionListener((evt) -> {
            if (codeCombo.getSelectedItem() == null || typeCombo.getSelectedItem() == null) return;
            // fire event to search courses by code and type
            firePropertyChange(Events.SEARCH_COURSES, null, new String[]{
                    codeCombo.getSelectedItem().toString(), typeCombo.getSelectedItem().toString()
            });
        });
        button.setBackground(Color.decode("#D13838"));
        button.setForeground(Color.white);
        add(button);

        // when code changes, change the type options
        codeCombo.addActionListener(new CodeComboController(codeCombo, typeCombo, courseDAO));

        setBackground(Color.white);
    }
}
