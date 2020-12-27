package timetable.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import timetable.dao.CourseDAO;
import timetable.dao.TimetableDAO;

import javax.swing.*;
import java.awt.*;

public class MyTimetablePanel extends JPanel {

    TimetableDAO timetableDAO;

    public MyTimetablePanel() {
        super();
        // get timetable dao spring bean
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        timetableDAO = (TimetableDAO) context.getBean("timetableDAOBean");
        setLayout(new BorderLayout());
        ViewTimetable viewTimetable = new ViewTimetable();
        viewTimetable.update(timetableDAO.getTimetable());
        add(viewTimetable, BorderLayout.CENTER);
    }
}
