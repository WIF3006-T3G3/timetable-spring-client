package timetable.dao;

import com.google.gson.Gson;
import timetable.dto.Lecturer;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LecturerDAO {
    public final String PATH = "dat\\lecturer.json";

    public Lecturer[] getLecturers() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(PATH)) {
            return gson.fromJson(reader, Lecturer[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Lecturer[]{};
        }
    }
}
