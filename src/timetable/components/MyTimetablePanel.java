package timetable.components;

import timetable.dao.TimetableDAO;

import javax.swing.*;
import java.awt.*;

public class MyTimetablePanel extends JPanel {

    TimetableDAO timetableDAO;

    public MyTimetablePanel() {
        super();
        timetableDAO = new TimetableDAO();
        setLayout(new BorderLayout());
        ViewTimetable viewTimetable = new ViewTimetable();
        viewTimetable.update(timetableDAO.getTimetable());
        add(viewTimetable, BorderLayout.CENTER);
    }
}
