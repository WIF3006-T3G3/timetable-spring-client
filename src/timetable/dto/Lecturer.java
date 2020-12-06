package timetable.dto;

public class Lecturer {
    String id, code, name, cv;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", id, code, name, cv);
    }
}
