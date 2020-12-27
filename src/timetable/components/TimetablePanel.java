package timetable.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import timetable.controller.AddCourseController;
import timetable.controller.RemoveCourseController;
import timetable.controller.SearchCoursesController;
import timetable.dao.CourseDAO;
import timetable.dao.TimetableDAO;
import timetable.factory.SimulatorComponentFactory;
import timetable.model.CourseModel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chin Jia Xiong
 */
public class TimetablePanel extends JPanel {
    CourseModel courseModel;
    CourseDAO courseDAO;
    TimetableDAO timetableDAO;

    public TimetablePanel() {
        // init model
        // get course dao spring bean
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        courseDAO = (CourseDAO) context.getBean("courseDAOBean");
        // get timetable dao spring bean
        timetableDAO = (TimetableDAO) context.getBean("timetableDAOBean");
        courseModel = new CourseModel();
        courseModel.setSelectedCourses(timetableDAO.getTimetable());

        // init layout manager
        setLayout(new GridBagLayout());
        setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();

        // init search bar
        SearchPanel searchPanel = new SearchPanel();
        add(searchPanel, gbc);

        // init search result label
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel searchTitle = SimulatorComponentFactory.getInstance().createLabel("Search Result");
        add(searchTitle, gbc);

        // init search result list
        SearchList searchList = new SearchList();
        gbc.gridy = 2;
        add(searchList, gbc);

        // init selected title
        gbc.gridy = 3;
        JLabel selectedTitle = SimulatorComponentFactory.getInstance().createLabel("Selected");
        add(selectedTitle, gbc);

        // init selected list
        SelectedList selectedList = new SelectedList(courseModel.getSelectedCourses());
        gbc.gridy = 4;
        add(selectedList, gbc);

        // search courses event
        searchPanel.addPropertyChangeListener(new SearchCoursesController(searchList, courseDAO, courseModel));
        // add course event
        searchList.addPropertyChangeListener(new AddCourseController(searchList, selectedList, courseModel, timetableDAO));
        // search courses event
        selectedList.addPropertyChangeListener(new SearchCoursesController(searchList, courseDAO, courseModel));
        // remove course event
        selectedList.addPropertyChangeListener(new RemoveCourseController(selectedList, courseModel, timetableDAO));
    }
}
