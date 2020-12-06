package timetable.dto;

public class Timetable {
    String id, code, groups, lecturerCode, location, start, end, types;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s", id, code, groups, lecturerCode, location, start, end, types);
    }
}
