package timetable;

import timetable.screens.MainMenuFrame;

import javax.swing.*;

public class Main {

    private static JFrame currentFrame;

    public static void navigate(JFrame frame) {
        if (currentFrame != null) currentFrame.setVisible(false);
        currentFrame = frame;
        currentFrame.setVisible(true);
    }

    /**
     * main is the launcher for the main frame
     */
    public static void main(String[] args) {
        navigate(new MainMenuFrame());
    }
}
