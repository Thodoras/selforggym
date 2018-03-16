package uis.menus;

import utils.Constants;
import utils.SystemValues;

import javax.swing.*;

public class MainMenu extends Menu {

    private static int BUTTON_POS_X = getSystemResolutionWidth() / 5;
    private static int BUTTON_POS_Y = 3 * getSystemResolutionHeight() / 8;
    private static int BUTTON_WIDTH = 3 * getSystemResolutionWidth() / 5;
    private static int BUTTON_HEIGHT = getSystemResolutionHeight() / 8;
    private static int BUTTON_DISTANCE = getSystemResolutionHeight() / 8;

    private static final String MANAGE_MEMBERS = "Manage Members";
    private static final String MANAGE_PARTICIPATION = "Manage Participation";
    private static final String MANAGE_PAYMENTS = "Manage Payments";
    private static final String EXIT = "Exit";

    public MainMenu(JFrame jFrame) {
        super(jFrame);
    }

    @Override
    public void render() {
        addButton(MANAGE_MEMBERS, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*0);
        addButton(MANAGE_PARTICIPATION, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*1);
        addButton(MANAGE_PAYMENTS, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*2);
        addButton(EXIT, BUTTON_POS_X, BUTTON_POS_Y + BUTTON_DISTANCE*3);
        setupFrame();
    }

    private void addButton(String str, int buttonPosX, int buttonPosY) {
        JButton button = new JButton(str);
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
    }

}
