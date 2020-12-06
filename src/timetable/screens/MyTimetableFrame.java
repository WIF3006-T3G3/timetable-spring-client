package timetable.screens;

import timetable.components.MyTimetablePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Simulator frame inherits the base frame configuration with all the parent components for the simulator.
 */
public class MyTimetableFrame extends BaseFrame {
    @Override
    public void createComponents() {
        JScrollPane panel = new JScrollPane(new MyTimetablePanel());
        add(panel, BorderLayout.CENTER);
    }
}
