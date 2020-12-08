package timetable.controller;

import timetable.components.SelectedList;
import timetable.constants.Events;
import timetable.dto.Course;
import timetable.model.CourseModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Handler for adding new component into the drawing panel.
 */
public class RemoveCourseController implements PropertyChangeListener {

    CourseModel courseModel;
    SelectedList selectedList;

    public RemoveCourseController(SelectedList sll, CourseModel cm) {
        selectedList = sll;
        courseModel = cm;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Events.REMOVE_COURSE)) {
            Course course = (Course) evt.getNewValue();
            // remove the course from selected
            ArrayList<Course> filteredCourses = (ArrayList<Course>) courseModel.getSelectedCourses().stream().filter(
                    c -> !c.getID().equals(course.getID()))
                    .collect(Collectors.toList());
            courseModel.setSelectedCourses(filteredCourses);
            // update list
            selectedList.update(courseModel.getSelectedCourses());
        }
    }
}
