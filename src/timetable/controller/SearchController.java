package timetable.controller;

import timetable.components.ListPanel;
import timetable.dao.TimetableDAO;
import timetable.dto.Timetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SearchController implements ActionListener {

    JComboBox<String> codeCombo, typeCombo;
    TimetableDAO timetableDAO;
    ListPanel listPanel;

    public SearchController(JComboBox<String> cc, JComboBox<String> tc, ListPanel lp, TimetableDAO table) {
        codeCombo = cc;
        typeCombo = tc;
        listPanel = lp;
        timetableDAO = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Timetable[] tables = timetableDAO.getTimetables();

        // update list panel
        ArrayList<Timetable> rslt = new ArrayList<>();
        Arrays.sort(tables, Comparator.comparing(Timetable::getGroups));
        for (Timetable table : tables) {
            if (codeCombo.getSelectedItem() != null &&
                    typeCombo.getSelectedItem() != null &&
                    table.getCode().equals(codeCombo.getSelectedItem().toString()) &&
                    table.getTypes().equals(typeCombo.getSelectedItem().toString())) {
                rslt.add(table);
            }
        }
        listPanel.update(rslt);
    }
}