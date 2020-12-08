package timetable.dao;

import com.google.gson.Gson;
import timetable.dto.Course;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CourseDAO {
    public final String PATH = "dat\\course.json";

    public Course[] getCourses() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(PATH)) {
            return gson.fromJson(reader, Course[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Course[]{};
        }
    }
}
