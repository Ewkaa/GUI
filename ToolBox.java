package Gui;

import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class ToolBox {
    public JToolBar UIToolBar;
    public Component SendToolBar() throws IOException {
            UIToolBar = new JToolBar();
            UIToolBar.setSize(50,350);
            UIToolBar.setVisible(true);
            UIToolBar.setFloatable(false);
            UIToolBar.setRollover(false);

        //first toolBar icon NEW, OPEN, SAVE
        ImageIcon iconNewToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/new.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton NewToolBar = new JButton(iconNewToolBar);
            NewToolBar.setToolTipText("Create new Text File");
            NewToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ActionLogic.NewfileLogic();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        UIToolBar.add(NewToolBar);

        ImageIcon iconOpenToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/open.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton OpenToolBar = new JButton(iconOpenToolBar);
            OpenToolBar.setToolTipText("Open Text File");
            OpenToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ActionLogic.OpenLogic();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        UIToolBar.add(OpenToolBar);

        ImageIcon iconSaveToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/save.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton SaveToolBar = new JButton(iconSaveToolBar);
            SaveToolBar.setToolTipText("Save current Text File");
            SaveToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ActionLogic.SaveLogic();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        UIToolBar.add(SaveToolBar);

        ImageIcon iconSaveAsToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/saveas.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton SaveToolBarAs = new JButton(iconSaveAsToolBar);
        SaveToolBarAs.setToolTipText("Save current Text File");
        SaveToolBarAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.SaveAsLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        UIToolBar.add(SaveToolBarAs);

        UIToolBar.addSeparator();

        //seconds toolBar icon COPY, CUT, PASTE
        ImageIcon iconCopyToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/copy.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton CopyToolBar = new JButton(iconCopyToolBar);
            CopyToolBar.setToolTipText("Copy");
            CopyToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ActionLogic.CopyLogic();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        UIToolBar.add(CopyToolBar);

        ImageIcon iconCutToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/cut.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton CutToolBar = new JButton(iconCutToolBar);
        CutToolBar.setToolTipText("Cut");
        CutToolBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.CutLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        UIToolBar.add(CutToolBar);

        ImageIcon iconPasteToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/paste.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton PasteToolBar = new JButton(iconPasteToolBar);
            PasteToolBar.setToolTipText("Paste");
            PasteToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ActionLogic.PasteLogic();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        UIToolBar.add(PasteToolBar);

        /////////////////////////////////////////////////
        UIToolBar.addSeparator();
        /////////////////////////////////////////////////

        //third toolBar icon HElp
        ImageIcon iconHelpToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/help.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton HelpToolBar = new JButton(iconHelpToolBar);
            HelpToolBar.setToolTipText("Help");
            HelpToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        HelpBox.HelpBox();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        UIToolBar.add(HelpToolBar);

        /////////////////////////////////////////////////
        UIToolBar.addSeparator();
        /////////////////////////////////////////////////

        //last toolBar icon EXIT
        ImageIcon iconExitToolBar = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/exit.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        JButton ExitToolBar = new JButton(iconExitToolBar);
            ExitToolBar.setToolTipText("Exit Application");
            ExitToolBar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        UIToolBar.add(ExitToolBar);

        /////////////////////////////////////////////////
        UIToolBar.addSeparator();
        /////////////////////////////////////////////////

    return UIToolBar;
    }
    public static Content content = new Content();
}
