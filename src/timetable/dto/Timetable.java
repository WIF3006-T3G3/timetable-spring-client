package timetable.dto;

public class Timetable {
    private String id, code, groups, lecturerCode, location, start, end, types;
    boolean added = false;

    public String getCode() {
        return code;
    }

    public String getGroups() {
        return groups;
    }

    public String getLecturerCode() {
        return lecturerCode;
    }

    public String getLocation() {
        return location;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s", id, code, groups, lecturerCode, location, start, end, types);
    }
}
