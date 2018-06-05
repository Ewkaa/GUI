package Gui;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import java.util.Timer;

public class ComponentArena {

   public static JPanel ComponentPanel;
    public Component ComponentField() throws IOException{
        ComponentPanel =  new JPanel(new BorderLayout());

        ComponentPanel.add(new TopSection().SendTopSection(), BorderLayout.NORTH);
        ComponentPanel.add(new MiddleSection().SendTable(),BorderLayout.CENTER);
        ComponentPanel.add(new BottomSection().SendBottomSection(),BorderLayout.SOUTH);

        return ComponentPanel;
    }
}
