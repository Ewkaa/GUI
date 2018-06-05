package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.annotation.Target;

public class MiddleSection {
    public static JTable Table;
    public static Component SendTable() throws IOException{
        Table = new JTable();
        Table.setShowGrid(true);
        Table.setShowHorizontalLines(true);
        Table.setRowSelectionAllowed(false);
        Table.getTableHeader().setReorderingAllowed(false);
        Table.getTableHeader().setResizingAllowed(false);
        Table.setEnabled(false);
        Table.setModel(new javax.swing.table.DefaultTableModel(
                new String[]{"1", "2", "3", "4", "5"}, 5));

        JScrollPane TableScreoll = new JScrollPane(Table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        return TableScreoll;
    }
}
