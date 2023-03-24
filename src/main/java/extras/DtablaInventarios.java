/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extras;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hp
 */
public class DtablaInventarios extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        if ((Integer.class.equals(this.getColumnClass(column))) &&(!Object.class.equals(column) )) {
            Integer value = Integer.parseInt((String) this.getValueAt(row, column));

            this.setBackground(Color.WHITE);
            this.setForeground(Color.BLACK);
            if (value <= 5) {
                this.setBackground(Color.YELLOW);
                this.setForeground(Color.RED);
            }
        }
        return super.prepareRenderer(renderer, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

    }

}
