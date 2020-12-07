package timetable.components;

import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Chin Jia Xiong
 */
public class TimetablePanel extends JPanel {
    SettingTable leftTable, rightTable;

    public TimetablePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // search bar
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel searchPanel = new SearchPanel();
        add(searchPanel, gbc);

        // search title
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel searchTitle = SimulatorComponentFactory.getInstance().createLabel("Search Result");
        add(searchTitle, gbc);

        // search list
        gbc.gridy = 2;
        JPanel searchList = new RoundedPanel(10, Color.decode("#999999"));
        searchList.setLayout(new BoxLayout(searchList, BoxLayout.Y_AXIS));
        searchList.add(new JLabel("okok"));
        searchList.setPreferredSize(new Dimension(600, 200));
        add(searchList, gbc);

        // selected title
        gbc.gridy = 3;
        JLabel selectedTitle = SimulatorComponentFactory.getInstance().createLabel("Selected");
        add(selectedTitle, gbc);

        // selected list
        gbc.gridy = 4;
        JPanel selectedList = new RoundedPanel(10, Color.decode("#999999"));
        selectedList.setLayout(new BoxLayout(selectedList, BoxLayout.Y_AXIS));
        selectedList.add(new JLabel("okok"));
        selectedList.setPreferredSize(new Dimension(600, 200));
        add(selectedList, gbc);
//        leftTable = new SettingTable(new TimetableDAO().getDistinctCodes());
//        add(leftTable, BorderLayout.WEST);
//
//        JPanel arrowPanel = new JPanel();
//        arrowPanel.setLayout(new BorderLayout());
//        JLabel leftArrow = SimulatorComponentFactory.getInstance().createImageLabel("/images/left_arrow.png",
//                0, 0, 60, 60);
//        leftArrow.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                onClickLeft();
//            }
//        });
//        arrowPanel.add(leftArrow, BorderLayout.WEST);
//
//        JLabel rightArrow = SimulatorComponentFactory.getInstance().createImageLabel("/images/right_arrow.png",
//                0, 0, 60, 60);
//        rightArrow.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                onClickRight();
//            }
//        });
//        arrowPanel.add(rightArrow, BorderLayout.EAST);
//        add(arrowPanel, BorderLayout.CENTER);
//
//        rightTable = new SettingTable(new ArrayList<>());
//        add(rightTable, BorderLayout.EAST);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new BorderLayout());
//        JButton proceedButton = SimulatorComponentFactory.getInstance().createButton("Proceed");
//        buttonPanel.add(proceedButton, BorderLayout.WEST);
//        proceedButton.addActionListener((evt) -> {
//            Main.navigate(new MainMenuFrame());
//        });
//
//        JButton backButton = SimulatorComponentFactory.getInstance().createButton("Back");
//        buttonPanel.add(backButton, BorderLayout.EAST);
//        backButton.addActionListener((evt) -> {
//            Main.navigate(new MainMenuFrame());
//        });
//        add(buttonPanel, BorderLayout.SOUTH);
//
        setBackground(Color.white);
    }

    private void onClickRight() {
        JTable table1 = leftTable.getTable();
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        JTable table2 = rightTable.getTable();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

        int row = table1.getSelectedRow();
        if (row != -1) {
            if (table1.getRowSorter() != null)
                row = table1.getRowSorter().convertRowIndexToModel(row);
            if (row != -1) {
                String item = model1.getValueAt(row, 0).toString();
                model1.removeRow(row);
                model2.addRow(new Object[]{item});
            }
        }
    }

    private void onClickLeft() {
        JTable table1 = leftTable.getTable();
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        JTable table2 = rightTable.getTable();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

        int row = table2.getSelectedRow();
        if (row != -1) {
            if (table2.getRowSorter() != null)
                row = table2.getRowSorter().convertRowIndexToModel(row);
            if (row != -1) {
                String item = model2.getValueAt(row, 0).toString();
                model2.removeRow(row);
                model1.addRow(new Object[]{item});
            }
        }
    }

    private void onProceed() {
//        if (jTable2.getRowCount() == 0)
//            JOptionPane.showMessageDialog(this, "You need to specify course code to display!");
//        else {
//            String[] items = new String[jTable2.getRowCount()];
//            for (int i = 0; i < jTable2.getRowCount(); i++) {
//                items[i] = model2.getValueAt(i, 0).toString();
//            }
//            BetterTimetable.go(items);
//            this.dispose();
//        }
    }
}
