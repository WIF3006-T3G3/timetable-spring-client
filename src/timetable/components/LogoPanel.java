package timetable.components;

import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Title to describe the simulator.
 */
public class LogoPanel extends JPanel {

    /**
     * Initialize the title with white background
     */
    public LogoPanel() {
        super();
        JLabel logo = SimulatorComponentFactory.getInstance().createImageLabel("/images/logo.png",
                0, 0, 300, 300);
        add(logo);
        setBackground(Color.white);
    }
}
