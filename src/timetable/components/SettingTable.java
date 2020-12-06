package timetable.components;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class SettingTable extends JPanel {

    private JTable table;
    private JTextField searchBar;

    public JTable getTable() {
        return table;
    }

    public SettingTable(ArrayList<String> records) {
        setLayout(new BorderLayout());
        // initialize components
        searchBar = new JTextField();
        add(searchBar, BorderLayout.NORTH);

        table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Course Code"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table.setRowHeight(36);
        table.setSelectionBackground(new java.awt.Color(102, 102, 102));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // initialize records
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (String record : records) {
            model.addRow(new Object[]{record});
        }
        // initialize filter
        TableRowSorter<TableModel> sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            public void filter() {
                if (searchBar.getText().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(searchBar.getText().toUpperCase(), 0));
                    } catch (Exception e) {
                        sorter.setRowFilter(null);
                    }
                }
            }
        });
        JScrollPane tablePane = new JScrollPane(table);
        tablePane.setPreferredSize(new Dimension(200, 300));
        add(tablePane, BorderLayout.CENTER);
    }
}
