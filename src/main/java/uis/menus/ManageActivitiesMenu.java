package uis.menus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageActivitiesMenu extends Menu {

    private static final ManageActivitiesMenu INSTANCE = new ManageActivitiesMenu();
    private static final String TITLE = "Manage Activities Menu";
    private static final int BUTTON_POS_X = getSystemResolutionWidth() / 5;
    private static final int BUTTON_POS_Y = 3 * getSystemResolutionHeight() / 8;
    private static final int BUTTON_WIDTH = 3 * getSystemResolutionWidth() / 5;
    private static final int BUTTON_HEIGHT = getSystemResolutionHeight() / 8;
    private static final int BUTTON_DISTANCE = getSystemResolutionHeight() / 8;

    private JButton manageTeamsButton = new JButton("Manage Teams");
    private JButton manageMembersButton = new JButton("Manage Members");
    private JButton backButton = new JButton("Back");

    private ManageActivitiesMenu() {
        initializeButtonListeners();
    }

    public static ManageActivitiesMenu getInstance() {
        return INSTANCE;
    }

    private void initializeButtonListeners() {
        ButtonListener listener = new ButtonListener();
        manageTeamsButton.addActionListener(listener);
    }

    @Override
    public void render() {
        populatePanelIfNeeded();
        setPanelInFrame();
    }

    private void populatePanelIfNeeded() {
        if (getJPanel().getComponents().length == 0) {
            addButton(manageTeamsButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*0);
            addButton(manageMembersButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*1);
            addButton(backButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*2);
            addTitle(TITLE);
        }
    }

    private void setPanelInFrame() {
        getJFrame().setContentPane(getJPanel());
        getJFrame().revalidate();
    }

    private void addButton(JButton button, int buttonPosX, int buttonPosY) {
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == manageTeamsButton) {
                ManageTeamsMenu.getInstance().render();
            }
        }
    }
}
