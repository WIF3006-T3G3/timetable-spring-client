package timetable.dao;

import com.google.gson.Gson;
import timetable.dto.Timetable;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TimetableDAO {
    public final String PATH = "dat\\timetable.json";

    public Timetable[] getTimetables() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(PATH)) {
            return gson.fromJson(reader, Timetable[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Timetable[]{};
        }
    }
}
