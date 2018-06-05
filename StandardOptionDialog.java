package Gui;

import javax.swing.JOptionPane;

public class StandardOptionDialog {
    public static int StandardOptionMessage(String messageContent, String title){
        String[] options = new String[] {"Yes", "No", "Cancel"};
        int response = JOptionPane.showOptionDialog(null, messageContent, title,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        return response;

    }
}
