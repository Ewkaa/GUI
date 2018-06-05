package Gui;

import javax.swing.*;

import java.awt.Component;
import java.awt.Color;
import java.awt.ComponentOrientation;

import java.io.IOException;

public class StatusBar{
    public static String StatusBarTag="Status: ";
    public static JTextField StatusBar = new JTextField("Status: ");

    public Component SendStatusBar() throws IOException{
        StatusBar.setVisible(true);
        StatusBar.setEditable(false);
        StatusBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        StatusBar.setBackground(Color.WHITE);
        StatusBar.setHorizontalAlignment(JTextField.RIGHT);
        StatusBar.setText(StatusBarTag+ Content.Status);
        StatusBar.repaint();
        return StatusBar;

    }
}
