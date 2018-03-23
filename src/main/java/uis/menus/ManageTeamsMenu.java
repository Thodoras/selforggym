package uis.menus;

import controllers.TeamController;
import dtos.TeamDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Thread.sleep;

public class ManageTeamsMenu extends Menu {

    private static final ManageTeamsMenu INSTANCE = new ManageTeamsMenu();
    private static final String TITLE = "Manage Teams Menu";
    private static final String ADD_TEAM_TITLE = "Add Team";
    private static final String EDIT_TEAM_TITLE = "Edit Team";
    private static final int POS_X = getSystemResolutionWidth() / 6;
    private static final int POS_Y = getSystemResolutionHeight() / 12;
    private static final int BUTTON_WIDTH = getSystemResolutionWidth() / 6;
    private static final int BUTTON_HEIGHT = getSystemResolutionHeight() / 12;
    private static final int LIST_WIDTH = 3*getSystemResolutionWidth() / 6;
    private static final int LIST_HEIGHT = 8*getSystemResolutionHeight() / 12;
    private static final int HORIZONTAL_DISTANCE = getSystemResolutionWidth() / 6;
    private static final int VERTICAL_DISTANCE = getSystemResolutionHeight() / 12;
    private static final int MESSAGE_LABEL_WIDTH = getSystemResolutionWidth() / 6;
    private static final int MESSAGE_LABEL_HEIGHT = 2*getSystemResolutionHeight() / 24;

    private JLabel messageLabel = new JLabel();
    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");
    private DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"Team Name", "Activity"});
    private JTable jTable;
    private JScrollPane jScrollPane;
    private TeamController teamController = TeamController.getInstance();

    private ManageTeamsMenu() {
        initializeButtonListeners();
    }

    public static ManageTeamsMenu getInstance() {
        return INSTANCE;
    }

    private void initializeButtonListeners() {
        ButtonListener listener = new ButtonListener();
        addButton.addActionListener(listener);
    }

    @Override
    public void render() {
        populatePanelIfNeeded();
        populateTable();
        setPanelInFrame();
    }

    public void render(String message) {
        addMessage(message);
        render();
    }

    private void addMessage(String message) {
        messageLabel.setText(message);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setBounds(getSystemResolutionWidth()/2 - MESSAGE_LABEL_WIDTH/2, MESSAGE_LABEL_HEIGHT, TITLE_WIDTH, TITLE_HEIGHT);
        getJPanel().add(messageLabel);
    }

    private void populatePanelIfNeeded() {
        if (getJPanel().getComponents().length == 0) {
            addTitle(TITLE);
            addButton(addButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 1*VERTICAL_DISTANCE);
            addButton(editButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 2*VERTICAL_DISTANCE);
            addButton(deleteButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 3*VERTICAL_DISTANCE);
            addButton(backButton, POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 4*VERTICAL_DISTANCE);
            addTable();
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

    private void addTable() {
        jTable = new JTable(defaultTableModel);
        jTable.setBounds(POS_X, POS_Y + VERTICAL_DISTANCE, LIST_WIDTH, LIST_HEIGHT);
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(POS_X, POS_Y + VERTICAL_DISTANCE, LIST_WIDTH, LIST_HEIGHT);
        jTable.setFillsViewportHeight(true);
        getJPanel().add(jScrollPane);
    }

    private void populateTable() {
        try {
            List<TeamDto> teamDtos = teamController.getAllTeams();
            for (TeamDto teamDto : teamDtos) {
                defaultTableModel.addRow(new String[]{
                        teamDto.getTeamName(),
                        teamDto.getTeamActivity()
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == addButton) {
                TeamForm.getInstance().render(ADD_TEAM_TITLE);
            }
        }
    }
}
