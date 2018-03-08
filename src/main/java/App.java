import utils.SystemValues;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        JFrame jFrame = new JFrame("Αυτοδιαχειριζόμενο γυμναστήριο");
        jFrame.setBounds(0, 0, getSystemResolutionWidth(), getSystemResolutionHeight());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        JLabel jLabel = new JLabel("Hello World!");
        jLabel.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel.setVerticalAlignment(SwingConstants.TOP);
        jFrame.add(jLabel);
    }

    private static int getSystemResolutionWidth() {
        return (int) SystemValues.getInstance().getScreenSizeWidth();
    }

    private static int getSystemResolutionHeight() {
        return (int) SystemValues.getInstance().getScreenSizeHeight();
    }

}
