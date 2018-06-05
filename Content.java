package  Gui;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;

public class Content extends JFrame{
    public static String Status;
    public static String ProgramName ="Project";
    public static String NameFile = "Untitled";
    public static String FilePath = "None";
    public static String Version = "1.0.0";
    public Clipboard clipboard = getToolkit().getSystemClipboard();

    public Math math = new Math();
    public MiddleSection middleSection = new MiddleSection();
}
