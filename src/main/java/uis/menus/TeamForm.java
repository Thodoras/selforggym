package uis.menus;

import controllers.TeamController;
import dtos.TeamDto;
import uis.menus.enums.TeamFormType;
import uis.menus.manageMenus.ManageTeamsMenu;
import utils.Constants;
import utils.exceptions.InputAlreadyExistsException;
import utils.exceptions.InvalidInputException;
import utils.exceptions.MissingFieldException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TeamForm extends Menu {

    private static final TeamForm INSTANCE = new TeamForm();
    private static final int POS_X = getSystemResolutionWidth() / 6;
    private static final int POS_Y = getSystemResolutionHeight() / 12;
    private static final int BUTTON_WIDTH = getSystemResolutionWidth() / 6;
    private static final int BUTTON_HEIGHT = getSystemResolutionHeight() / 12;
    private static final int LABEL_WIDTH = getSystemResolutionWidth() / 6;
    private static final int LABEL_HEIGHT = getSystemResolutionHeight() / 24;
    private static final int FIELD_WIDTH = 3*getSystemResolutionWidth() / 6;
    private static final int FIELD_HEIGHT = getSystemResolutionHeight() / 24;
    private static final int ROW_HOR_DISTANCE = getSystemResolutionWidth() / 6;
    private static final int ROW_VER_DISTANCE = getSystemResolutionHeight() / 24;
    private static final String ADD_TEAM_TITLE = "Add Team";
    private static final String EDIT_TEAM_TITLE = "Edit Team";

    private JLabel teamNameLabel = new JLabel("Team Name:");
    private JLabel teamActivityLabel = new JLabel("Team Activity:");
    private JTextField teamNameField = new JTextField();
    private JTextField teamActivityField = new JTextField();
    private JButton submitButton = new JButton("Submit");
    private JButton cancelButton = new JButton("Cancel");
    private TeamFormType teamFormType;
    private TeamDto oldDto;
    private TeamController teamController = TeamController.getInstance();

    private TeamForm() {
        initializeButtonListeners();
    }

    public static TeamForm getInstance() {
        return INSTANCE;
    }

    private void initializeButtonListeners() {
        ButtonListener listener = new ButtonListener();
        submitButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
    }

    @Override
    public void render() {
        populatePanelIfNeeded();
        setPanelInFrame();
        setTitle();
        setFields();
    }

    public void addRender() {
        setTeamFormType(TeamFormType.ADD);
        render();
    }

    public void editRender(TeamDto teamDto) {
        setTeamFormType(TeamFormType.EDIT);
        setOldDto(teamDto);
        render();
    }

    private void setTeamFormType(TeamFormType teamFormType) {
        this.teamFormType = teamFormType;
    }

    private void setOldDto(TeamDto oldDto) {
        this.oldDto = oldDto;
    }

    private void setTitle() {
        if (teamFormType == TeamFormType.ADD) {
            getTitle().setText(ADD_TEAM_TITLE);
        } else {
            getTitle().setText(EDIT_TEAM_TITLE);
        }
    }

    private void setFields() {
        if (teamFormType == TeamFormType.ADD) {
            teamNameField.setText("");
            teamActivityField.setText("");
        } else {
            teamNameField.setText(oldDto.getTeamName());
            teamActivityField.setText(oldDto.getTeamActivity());
        }
    }

    private void populatePanelIfNeeded() {
        if (getJPanel().getComponents().length == 0) {
            addTitle(getTitle().getText());
            addRow(teamNameLabel, teamNameField, POS_X, POS_Y + 2*ROW_VER_DISTANCE);
            addRow(teamActivityLabel, teamActivityField, POS_X, POS_Y + 3*ROW_VER_DISTANCE);
            addButton(submitButton, POS_X + 2*ROW_HOR_DISTANCE, POS_Y + 16*ROW_VER_DISTANCE);
            addButton(cancelButton, POS_X + 3*ROW_HOR_DISTANCE, POS_Y + 16*ROW_VER_DISTANCE);
        }
    }

    private void addRow(JLabel jLabel, JTextField jTextField, int posX , int posY) {
        addLabel(jLabel, posX, posY);
        addField(jTextField, posX + ROW_HOR_DISTANCE, posY);
    }

    private void addLabel(JLabel jLabel, int posX, int posY) {
        jLabel.setBounds(posX, posY, LABEL_WIDTH, LABEL_HEIGHT);
        getJPanel().add(jLabel);
    }

    private void addField(JTextField jTextField, int posX, int posY) {
        jTextField.setBounds(posX, posY, FIELD_WIDTH, FIELD_HEIGHT);
        getJPanel().add(jTextField);
    }

    private void addButton(JButton button, int buttonPosX, int buttonPosY) {
        getSwingTools().addButton(getJPanel()
                , button
                , new Rectangle(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT));
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == submitButton) {
                submitAction();
            } else if (actionEvent.getSource() == cancelButton) {
                ManageTeamsMenu.getInstance().render();
            }
        }

        private void submitAction() {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeamName(teamNameField.getText());
            teamDto.setTeamActivity(teamActivityField.getText());
            try {
                submitStrategy(teamDto);
            } catch (MissingFieldException e) {
                errorMessage(e.getMessage());
            } catch (InvalidInputException e) {
                errorMessage(e.getMessage());
            } catch (InputAlreadyExistsException e) {
                errorMessage(e.getMessage());
            } catch (Exception e) {
                errorMessage(Constants.GENERIC_ERROR_MESSAGE);
            }
        }

        private void submitStrategy(TeamDto teamDto) throws MissingFieldException
                , InvalidInputException
                , InputAlreadyExistsException
                , SQLException {
            if (teamFormType == TeamFormType.ADD) {
                teamController.addTeam(teamDto);
                ManageTeamsMenu.getInstance().render("Team successfully added!");
            } else {
                teamController.updateTeam(oldDto, teamDto);
                ManageTeamsMenu.getInstance().render("Team " + teamDto.getTeamName() + " successfully updated!");
            }
        }

        private void errorMessage(String message) {
            JOptionPane.showMessageDialog(getJFrame()
                    , message
                    , "Error"
                    , JOptionPane.WARNING_MESSAGE);
        }
    }

}
