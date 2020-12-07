package timetable.components;

import timetable.dto.Timetable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListPanel extends JPanel {

    public ListPanel() {
        super();

        // layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
    }

    public void update(ArrayList<Timetable> courses) {
        removeAll();
        // add courses
        for (Timetable course : courses) {
            add(new CourseCard(course));
            add(Box.createRigidArea(new Dimension(5, 10)));
        }
        // revalidate
        revalidate();
        repaint();
    }
}
