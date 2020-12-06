package timetable.dto;

public class Timetable {
    private String id, code, groups, lecturerCode, location, start, end, types;

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s", id, code, groups, lecturerCode, location, start, end, types);
    }
}
