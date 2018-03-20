package uis.menus;

import utils.Constants;
import utils.SystemValues;

import javax.swing.*;

abstract public class Menu {

    private static final JFrame jFrame = new JFrame(Constants.LABEL);
    private JPanel jPanel = new JPanel();

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

    private void setupFrame() {
        getJFrame().setBounds(0, 0, getSystemResolutionWidth(), getSystemResolutionHeight());
        getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getJFrame().setResizable(false);
        getJFrame().setLayout(null);
        getJFrame().setVisible(true);
    }
}
