package uis.menus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Menu {

    private static int BUTTON_POS_X = getSystemResolutionWidth() / 5;
    private static int BUTTON_POS_Y = 3 * getSystemResolutionHeight() / 8;
    private static int BUTTON_WIDTH = 3 * getSystemResolutionWidth() / 5;
    private static int BUTTON_HEIGHT = getSystemResolutionHeight() / 8;
    private static int BUTTON_DISTANCE = getSystemResolutionHeight() / 8;

    private JButton manageActivitiesButton = new JButton("Manage Activities");
    private JButton manageParticipationButton = new JButton("Manage Participation");
    private JButton manageEconomyButton = new JButton("Manage Payments");
    private JButton exitButton = new JButton("Exit");

    public MainMenu(JFrame jFrame) {
        super(jFrame);
        initializeButtonListener();
    }

    private void initializeButtonListener() {
        ButtonListener listener = new ButtonListener();
        manageActivitiesButton.addActionListener(listener);
    }

    @Override
    public void render() {
        getJFrame().setContentPane(getJPanel());
        addButton(manageActivitiesButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*0);
        addButton(manageParticipationButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*1);
        addButton(manageEconomyButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*2);
        addButton(exitButton, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*3);
        setupFrame();
    }

    private JButton addButton(JButton button, int buttonPosX, int buttonPosY) {
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
        return button;
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == manageActivitiesButton) {
                ManageActivitiesMenu menu = new ManageActivitiesMenu(getJFrame(), getJPanel());
                menu.render();
            }
        }
    }

}
