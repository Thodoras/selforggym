import uis.menus.MainMenu;
import utils.Constants;
import utils.database.Connection;
import utils.database.Schema;

import javax.swing.*;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try {
            Connection.getInstance().connect();
            Schema.getInstance().migrate();
            MainMenu.getInstance().render();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

//        System.out.println("Hello World!");
//        JFrame jFrame = new JFrame("Αυτοδιαχειριζόμενο γυμναστήριο");
//        jFrame.setBounds(0, 0, getSystemResolutionWidth(), getSystemResolutionHeight());
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setVisible(true);
//
//        JLabel jLabel = new JLabel("Hello World!");
//        jLabel.setHorizontalAlignment(SwingConstants.LEFT);
//        jLabel.setVerticalAlignment(SwingConstants.TOP);
//        Font font = new Font("Verdana", Font.BOLD, 20);
//        jLabel.setFont(font);
//        jFrame.add(jLabel);
//
//        GridLayout grid = new GridLayout(3,1);
//        jFrame.setLayout(grid);
//
//        JButton jButton1 = new JButton("Press me!");
//        JButton jButton2 = new JButton("Press me!");
//        jFrame.add(jButton1);
//        jFrame.add(jButton2);
    }

//    private static int getSystemResolutionWidth() {
//        return (int) SystemValues.getInstance().getScreenSizeWidth();
//    }
//
//    private static int getSystemResolutionHeight() {
//        return (int) SystemValues.getInstance().getScreenSizeHeight();
//    }

}
