package timetable.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import timetable.components.SearchList;
import timetable.constants.Events;
import timetable.dao.CourseDAO;
import timetable.dto.Course;
import timetable.model.CourseModel;
import timetable.utility.CourseUtils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Handler for adding new component into the drawing panel.
 */
public class SearchCoursesController implements PropertyChangeListener {

    CourseDAO courseDAO;
    CourseModel courseModel;
    SearchList searchList;

    public SearchCoursesController(SearchList sl, CourseDAO c, CourseModel cm) {
        searchList = sl;
        courseDAO = c;
        courseModel = cm;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Events.SEARCH_COURSES)) {
            String[] data = (String[]) evt.getNewValue();
            Course[] courses = courseDAO.getCourses();

            // get course spring bean
            ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
            CourseUtils courseUtils = (CourseUtils) context.getBean("courseUtilsBean");

            // update list panel
            courseModel.setSearchCourses(new ArrayList<>());
            Arrays.sort(courses, Comparator.comparing(Course::getGroups));
            for (Course c : courses) {
                if (c.getCode().equals(data[0]) &&
                        c.getTypes().equals(data[1]) &&
                        courseUtils.validate(c, courseModel.getSelectedCourses())) {
                    courseModel.getSearchCourses().add(c);
                }
            }
            Collections.sort(courseModel.getSearchCourses());
            searchList.update(courseModel.getSearchCourses());
        }
    }
}
