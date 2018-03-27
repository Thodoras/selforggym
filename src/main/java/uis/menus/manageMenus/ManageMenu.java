package uis.menus.manageMenus;

import uis.menus.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    private DefaultTableModel defaultTableModel;
    private JScrollPane jScrollPane;

    protected void initializeTable(Object[] headers) {
        jTable = new JTable(initializeTableModel(headers));
    }

    private DefaultTableModel initializeTableModel(Object[] headers) {
        defaultTableModel = new DefaultTableModel(new Object[][]{}, headers);
        return defaultTableModel;
    }

    protected void addButton(JButton button, int buttonPosX, int buttonPosY) {
        getSwingTools().addButton(getJPanel()
                , button
                , new Rectangle(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT));
    }

    protected void addTable() {
        getSwingTools().addTable(getJTable(), getJPanel()
                , new Rectangle(POS_X, POS_Y + VERTICAL_DISTANCE, TABLE_WIDTH, TABLE_HEIGHT));
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
