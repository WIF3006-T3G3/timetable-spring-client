package timetable.components;

import timetable.dao.TimetableDAO;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;

public class SearchList extends JPanel {
    public SearchList() {
        // layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (String code : new TimetableDAO().getDistinctCodes()) {
            add(SimulatorComponentFactory.getInstance().createLabel(code));
        }

        setBackground(Color.decode("#999999"));
    }
}
