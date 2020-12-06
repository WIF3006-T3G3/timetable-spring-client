package timetable.dao;

import com.google.gson.Gson;
import timetable.dto.Timetable;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

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

    public ArrayList<String> getDistinctCodes() {
        Timetable[] table = getTimetables();
        ArrayList<String> code = new ArrayList<>();
        for (Timetable t : table) {
            if (!code.contains(t.getCode())) {
                code.add(t.getCode());
            }
        }
        return code;
    }
}
