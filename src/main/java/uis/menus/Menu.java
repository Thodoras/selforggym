package uis.menus;

import utils.Constants;
import utils.SystemValues;

import javax.swing.*;

abstract public class Menu {

    private static final JFrame jFrame = new JFrame(Constants.LABEL);
    protected static final int TITLE_WIDTH = getSystemResolutionWidth() / 6;
    protected static final int TITLE_HEIGHT = getSystemResolutionHeight() / 24;
    protected static final int TITLE_POS_X = (getSystemResolutionWidth() / 2) - TITLE_WIDTH / 2;
    protected static final int TITLE_POS_Y = getSystemResolutionHeight() / 24;

    private JPanel jPanel = new JPanel();
    private JLabel title = new JLabel();

    protected Menu() {
        setupFrame();
        jPanel.setLayout(null);
    }

    abstract public void render();

    protected static int getSystemResolutionWidth() {
        return (int) SystemValues.getInstance().getScreenSizeWidth();
    }

    protected static int getSystemResolutionHeight() {
        return (int) SystemValues.getInstance().getScreenSizeHeight();
    }

    protected JFrame getJFrame() {
        return jFrame;
    }

    protected JPanel getJPanel() {
        return jPanel;
    }

    protected JLabel getTitle() {
        return title;
    }

    protected void addTitle(String message) {
        getTitle().setBounds(TITLE_POS_X, TITLE_POS_Y, TITLE_WIDTH, TITLE_HEIGHT);
        getTitle().setText(message);
        getTitle().setHorizontalAlignment(SwingConstants.CENTER);
        getTitle().setVerticalAlignment(SwingConstants.CENTER);
        getJPanel().add(getTitle());
    }

    private void setupFrame() {
        getJFrame().setBounds(0, 0, getSystemResolutionWidth(), getSystemResolutionHeight());
        getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getJFrame().setResizable(false);
        getJFrame().setLayout(null);
        getJFrame().setVisible(true);
    }

}
