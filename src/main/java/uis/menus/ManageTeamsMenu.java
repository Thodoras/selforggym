package uis.menus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageTeamsMenu extends Menu {

    private static int POS_X = getSystemResolutionWidth() / 6;
    private static int POS_Y = getSystemResolutionHeight() / 12;
    private static int BUTTON_WIDTH = getSystemResolutionWidth() / 6;
    private static int BUTTON_HEIGHT = getSystemResolutionHeight() / 12;
    private static int LIST_WIDTH = 3*getSystemResolutionWidth() / 6;
    private static int LIST_HEIGHT = 8*getSystemResolutionHeight() / 12;
    private static int HORIZONTAL_DISTANCE = getSystemResolutionWidth() / 6;
    private static int VERTICAL_DISTANCE = getSystemResolutionHeight() / 12;

    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");

    private DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    private JList<String> jList;
    private JScrollPane jScrollPane;

    public ManageTeamsMenu(JFrame jFrame, JPanel jPanel) {
        super(jFrame);
        initializeButtonListeners();
    }

    private void initializeButtonListeners() {
        ButtonListener listener = new ButtonListener();
        addButton.addActionListener(listener);
    }

    @Override
    public void render() {
        setPanelInFrame();
        addButton(addButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 1*VERTICAL_DISTANCE);
        addButton(editButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 2*VERTICAL_DISTANCE);
        addButton(deleteButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 3*VERTICAL_DISTANCE);
        addButton(backButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 4*VERTICAL_DISTANCE);
        addTable();
    }

    private void setPanelInFrame() {
        getJFrame().setContentPane(getJPanel());
        // Swing magic below
        getJFrame().invalidate();
        getJFrame().validate();
    }

    private void addButton(JButton button, int buttonPosX, int buttonPosY) {
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
    }

    private void addTable() {
        defaultListModel.addElement("foo");
        defaultListModel.addElement("bar");
        jList = new JList<>(defaultListModel);
        jList.setBounds(POS_X, POS_Y + VERTICAL_DISTANCE, LIST_WIDTH, LIST_HEIGHT);
//        jScrollPane = new JScrollPane(jList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        jScrollPane.setBounds(POS_X, POS_Y + VERTICAL_DISTANCE, LIST_WIDTH, LIST_HEIGHT);
        getJPanel().add(jList);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == addButton) {
                TeamForm menu = new TeamForm(getJFrame());
                menu.render();
            }
        }
    }
}
