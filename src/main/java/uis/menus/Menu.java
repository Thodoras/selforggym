package uis.menus;

import utils.SystemValues;

import javax.swing.*;

abstract public class Menu {

    private JFrame jFrame;
    private JPanel jPanel = new JPanel();

    public Menu(JFrame jFrame) {
        this.jFrame = jFrame;
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
}
