package timetable.utility;

import timetable.dto.Course;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CourseUtils {
    public static boolean validate(Course course, ArrayList<Course> selectedCourses) {
        // check if code and type already exist or not
        ArrayList<Course> filteredCourses = (ArrayList<Course>) selectedCourses.stream().filter(
                c -> c.getCode().equals(course.getCode()) && c.getTypes().equals(course.getTypes()))
                .collect(Collectors.toList());
        if (filteredCourses.size() > 0) return false;
        // check if time clashes or not
        return true;
    }
}
