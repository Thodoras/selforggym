package uis.menus.manageMenus;

import uis.menus.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

abstract public class ManageMenu extends Menu {

    protected static final int POS_X = getSystemResolutionWidth() / 6;
    protected static final int POS_Y = getSystemResolutionHeight() / 12;
    protected static final int BUTTON_WIDTH = getSystemResolutionWidth() / 6;
    protected static final int BUTTON_HEIGHT = getSystemResolutionHeight() / 12;
    protected static final int TABLE_WIDTH = 3*getSystemResolutionWidth() / 6;
    protected static final int TABLE_HEIGHT = 8*getSystemResolutionHeight() / 12;
    protected static final int HORIZONTAL_DISTANCE = getSystemResolutionWidth() / 6;
    protected static final int VERTICAL_DISTANCE = getSystemResolutionHeight() / 12;
    protected static final int MESSAGE_LABEL_WIDTH = getSystemResolutionWidth() / 6;
    protected static final int MESSAGE_LABEL_HEIGHT = 2*getSystemResolutionHeight() / 24;

    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");
    private JTable jTable;
    protected DefaultTableModel defaultTableModel;
    private JScrollPane jScrollPane;

    protected void setPanelInFrame() {
        getJFrame().setContentPane(getJPanel());
        getJFrame().revalidate();
    }

    protected void addButton(JButton button, int buttonPosX, int buttonPosY) {
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
    }

    protected void addTable() {
        jTable = new JTable(defaultTableModel);
        jTable.setBounds(POS_X, POS_Y + VERTICAL_DISTANCE, TABLE_WIDTH, TABLE_HEIGHT);
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(POS_X, POS_Y + VERTICAL_DISTANCE, TABLE_WIDTH, TABLE_HEIGHT);
        jTable.setFillsViewportHeight(true);
        getJPanel().add(jScrollPane);
    }

    protected JButton getAddButton() {
        return addButton;
    }

    protected JButton getEditButton() {
        return editButton;
    }

    protected JButton getDeleteButton() {
        return deleteButton;
    }

    protected JButton getBackButton() {
        return backButton;
    }

    protected JTable getJTable() {
        return jTable;
    }

    protected DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

}
