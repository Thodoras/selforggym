package uis.tools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SwingTools {

    private static final SwingTools INSTANCE = new SwingTools();

    private SwingTools() {

    }

    public static SwingTools getInstance() {
        return INSTANCE;
    }

    public void setPanelInFrame(JFrame jFrame, JPanel jPanel) {
        jFrame.setContentPane(jPanel);
        jFrame.revalidate();
    }

    public void addButton(JPanel jPanel, JButton button, Rectangle rectangle) {
        setBounds(button, rectangle);
        jPanel.add(button);
    }

    public void addTable(JTable jTable, JPanel jPanel, Rectangle rectangle) {
        setBounds(jTable, rectangle);
        JScrollPane jScrollPane = initializeJScrollPane(jTable, rectangle);
        jTable.setFillsViewportHeight(true);
        jPanel.add(jScrollPane);
    }

    public JScrollPane initializeJScrollPane(JTable jTable, Rectangle rectangle) {
        JScrollPane jScrollPane = new JScrollPane(jTable
                , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setBounds(jScrollPane, rectangle);
        return jScrollPane;
    }

    public void addLabel(JPanel jPanel, JLabel jLabel, Rectangle rectangle) {
        setBounds(jLabel, rectangle);
        jPanel.add(jLabel);
    }

    private void setBounds(JComponent jComponent, Rectangle rectangle) {
        jComponent.setBounds(rectangle.x
                , rectangle.y
                , rectangle.width
                , rectangle.height);
    }
}
