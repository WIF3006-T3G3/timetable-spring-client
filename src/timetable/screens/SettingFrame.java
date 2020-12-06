package timetable.screens;

import timetable.components.SettingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Simulator frame inherits the base frame configuration with all the parent components for the simulator.
 */
public class SettingFrame extends BaseFrame {
    @Override
    public void createComponents() {
        JPanel panel = new SettingPanel();
        add(panel, BorderLayout.CENTER);
    }
}
