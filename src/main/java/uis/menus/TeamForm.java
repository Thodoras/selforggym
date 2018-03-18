package uis.menus;

import controllers.TeamController;
import dtos.TeamDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamForm extends Menu {

    private static int POS_X = getSystemResolutionWidth() / 6;
    private static int POS_Y = getSystemResolutionHeight() / 12;
    private static int BUTTON_WIDTH = getSystemResolutionWidth() / 6;
    private static int BUTTON_HEIGHT = getSystemResolutionHeight() / 12;
    private static int LABEL_WIDTH = getSystemResolutionWidth() / 6;
    private static int LABEL_HEIGHT = getSystemResolutionHeight() / 24;
    private static int FIELD_WIDTH = 3*getSystemResolutionWidth() / 6;
    private static int FIELD_HEIGHT = getSystemResolutionHeight() / 24;
    private static int ROW_HOR_DISTANCE = getSystemResolutionWidth() / 6;
    private static int ROW_VER_DISTANCE = getSystemResolutionHeight() / 24;

    private JLabel teamNameLabel = new JLabel("Team Name:");
    private JLabel teamActivityLabel = new JLabel("Team Activity:");
    private JTextField teamNameField = new JTextField();
    private JTextField teamActivityField = new JTextField();
    private JButton submitButton = new JButton("Submit");

    private TeamController teamController = new TeamController();

    public TeamForm(JFrame jFrame) {
        super(jFrame);
        initializeButtonListeners();
    }

    private void initializeButtonListeners() {
        ButtonListener listener = new ButtonListener();
        submitButton.addActionListener(listener);
    }

    @Override
    public void render() {
        setPanelInFrame();
        addRow(teamNameLabel, teamNameField, POS_X, POS_Y + 2*ROW_VER_DISTANCE);
        addRow(teamActivityLabel, teamActivityField, POS_X, POS_Y + 3*ROW_VER_DISTANCE);
        addButton(submitButton, POS_X + 3*ROW_HOR_DISTANCE, POS_Y + 16*ROW_VER_DISTANCE);
    }

    private void setPanelInFrame() {
        getJFrame().setContentPane(getJPanel());
        // Swing magic below
        getJFrame().invalidate();
        getJFrame().validate();
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
        button.setBounds(buttonPosX, buttonPosY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getJPanel().add(button);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == submitButton) {
                TeamDto teamDto = new TeamDto();
                teamDto.setTeamName(teamNameField.getText());
                teamDto.setTeamActivity(teamActivityField.getText());
                teamController.addTeam(teamDto);
            }
        }
    }

}
