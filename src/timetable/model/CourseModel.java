package timetable.model;

import timetable.dto.Course;

import java.util.ArrayList;

// TODO: persistence for selected courses
public class CourseModel {

    ArrayList<Course> searchCourses, selectedCourses;

    public CourseModel() {
        searchCourses = new ArrayList<>();
        selectedCourses = new ArrayList<>();
    }

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> sc) {
        selectedCourses = sc;
    }

    public ArrayList<Course> getSearchCourses() {
        return searchCourses;
    }

}
