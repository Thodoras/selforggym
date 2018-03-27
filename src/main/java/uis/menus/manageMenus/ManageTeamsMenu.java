package uis.menus.manageMenus;

import controllers.TeamController;
import dtos.TeamDto;
import uis.menus.ManageActivitiesMenu;
import uis.menus.Menu;
import uis.menus.TeamForm;
import utils.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Thread.sleep;

public class ManageTeamsMenu extends ManageMenu {

    private static final ManageTeamsMenu INSTANCE = new ManageTeamsMenu();
    private static final String TITLE = "Manage Teams Menu";

    private JLabel messageLabel = new JLabel();
    private TeamController teamController = TeamController.getInstance();

    private ManageTeamsMenu() {
        initializeTable(new Object[]{"Team Name", "Activity"});
        initializeButtonListeners();
    }

    public static ManageTeamsMenu getInstance() {
        return INSTANCE;
    }

    private void initializeButtonListeners() {
        ButtonListener listener = new ButtonListener();
        getAddButton().addActionListener(listener);
        getEditButton().addActionListener(listener);
        getDeleteButton().addActionListener(listener);
        getBackButton().addActionListener(listener);
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
        getSwingTools().addLabel(getJPanel()
                , messageLabel
                , new Rectangle(getSystemResolutionWidth()/2 - MESSAGE_LABEL_WIDTH/2, MESSAGE_LABEL_HEIGHT, TITLE_WIDTH, TITLE_HEIGHT));
    }

    private void populatePanelIfNeeded() {
        if (getJPanel().getComponents().length == 0) {
            addTitle(TITLE);
            addButton(getAddButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 1*VERTICAL_DISTANCE);
            addButton(getEditButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 2*VERTICAL_DISTANCE);
            addButton(getDeleteButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 3*VERTICAL_DISTANCE);
            addButton(getBackButton(), POS_X + 3*HORIZONTAL_DISTANCE, POS_Y + 4*VERTICAL_DISTANCE);
            addTable();
        }
    }

    private void populateTable() {

        try {
            getDefaultTableModel().setNumRows(0);
            List<TeamDto> teamDtos = teamController.getAllTeams();
            for (TeamDto teamDto : teamDtos) {
                getDefaultTableModel().addRow(new String[]{
                        teamDto.getTeamName(),
                        teamDto.getTeamActivity()
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private class ButtonListener implements ActionListener {

        private static final String DELETE_ROW = "Row succssfully deleted";
        private static final String WARNING = "Warning!";

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == getAddButton()) {
                TeamForm.getInstance().addRender();
            }
            if (actionEvent.getSource() == getEditButton()) {
                if (getJTable().getSelectedRow() != -1) {
                    TeamForm.getInstance().editRender(setupDto());
                }
            }
            if (actionEvent.getSource() == getDeleteButton()) {
                if (getJTable().getSelectedRow() != -1) {
                    deleteRow(setupDto());
                }
            }
            if (actionEvent.getSource() == getBackButton()) {
                ManageActivitiesMenu.getInstance().render();
            }
        }

        private TeamDto setupDto() {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeamName((String) getJTable().getValueAt(getJTable().getSelectedRow(), 0));
            teamDto.setTeamActivity((String) getJTable().getValueAt(getJTable().getSelectedRow(), 1));
            return teamDto;
        }

        private void deleteRow(TeamDto teamDto) {

            int reply = showMessage("Are you sure tou want to delete it?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                try {
                    TeamController.getInstance().deleteTeam(teamDto);
                    ManageTeamsMenu.getInstance().render("Row succssfully deleted");
                } catch (SQLException e) {
                    showMessage(Constants.GENERIC_ERROR_MESSAGE, JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        private Integer showMessage(String message, int typeOfPane) {
            if (typeOfPane == JOptionPane.YES_NO_OPTION) {
                return JOptionPane.showConfirmDialog(getJFrame()
                        , message
                        , WARNING
                        , typeOfPane);
            }
            if (typeOfPane == JOptionPane.WARNING_MESSAGE) {
                JOptionPane.showMessageDialog(getJFrame()
                        , message
                        , WARNING
                        , typeOfPane);
            }
            return -1;
        }
    }
}
