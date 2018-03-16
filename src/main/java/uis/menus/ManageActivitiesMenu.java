package uis.menus;

import javax.swing.*;

public class ManageActivitiesMenu extends Menu {

    private static int BUTTON_POS_X = getSystemResolutionWidth() / 5;
    private static int BUTTON_POS_Y = 3 * getSystemResolutionHeight() / 8;
    private static int BUTTON_WIDTH = 3 * getSystemResolutionWidth() / 5;
    private static int BUTTON_HEIGHT = getSystemResolutionHeight() / 8;
    private static int BUTTON_DISTANCE = getSystemResolutionHeight() / 8;

    JButton manageTeamsButton = new JButton("Manage Teams");
    JButton manageMembersButton = new JButton("Manage Members");
    JButton backButton = new JButton("Back");

    private JPanel previousPanel;

    public ManageActivitiesMenu(JFrame jFrame, JPanel previousPanel) {
        super(jFrame);
        this.previousPanel = previousPanel;
    }

    @Override
    void render() {
        setPanelInFrame();
        addButton(manageTeamsButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*1);
        addButton(manageMembersButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*2);
        addButton(backButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*3);
    }

    private void setPanelInFrame() {
        getJFrame().setContentPane(getJPanel());
        // Swing magic below
        getJFrame().invalidate();
        getJFrame().validate();
    }

    private JButton addButton(JButton button, int buttonPosX, int buttonPosY) {
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
        return button;
    }
}