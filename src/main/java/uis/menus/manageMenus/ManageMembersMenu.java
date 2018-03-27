package uis.menus.manageMenus;

import uis.menus.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManageMembersMenu extends ManageMenu {

    private static final ManageMembersMenu INSTANCE = new ManageMembersMenu();
    private static final String TITLE = "Manage Members Menu";

    private ManageMembersMenu() {
        initializeTable(new Object[]{"Member Name"});
    }

    public static ManageMembersMenu getInstance() {
        return INSTANCE;
    }

    @Override
    public void render() {
        polpulatePanelIfNeeded();
        setPanelInFrame();
    }

    private void polpulatePanelIfNeeded() {
        if (getJPanel().getComponents().length == 0) {
            addTitle(TITLE);
            addButton(getAddButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 1*VERTICAL_DISTANCE);
            addButton(getEditButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 2*VERTICAL_DISTANCE);
            addButton(getDeleteButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 3*VERTICAL_DISTANCE);
            addButton(getBackButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 4*VERTICAL_DISTANCE);
            addTable();
        }
    }
}
