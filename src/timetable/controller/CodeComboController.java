package timetable.controller;

import timetable.dao.TimetableDAO;
import timetable.dto.Timetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CodeComboController implements ActionListener {

    JComboBox<String> codeCombo, typeCombo;
    TimetableDAO timetableDAO;

    public CodeComboController(JComboBox<String> cc, JComboBox<String> tc, TimetableDAO table) {
        codeCombo = cc;
        typeCombo = tc;
        timetableDAO = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        typeCombo.removeAllItems();
        Timetable[] tables = timetableDAO.getTimetables();

        // update type combo
        ArrayList<String> selected = new ArrayList<>();
        Arrays.sort(tables, Comparator.comparing(Timetable::getTypes));
        for (Timetable table : tables) {
            if (codeCombo.getSelectedItem() != null &&
                    table.getCode().equals(codeCombo.getSelectedItem().toString()) &&
                    !selected.contains(table.getTypes())) {
                typeCombo.addItem(table.getTypes());
                selected.add(table.getTypes());
            }
        }
    }
}