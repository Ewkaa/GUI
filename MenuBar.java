package Gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultEditorKit;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import java.io.IOException;

public class MenuBar  {
    private Action[] textActions = { new DefaultEditorKit.CutAction(),
            new DefaultEditorKit.CopyAction(), new DefaultEditorKit.PasteAction(), };

    public JMenuBar nemuBar = new JMenuBar();

    public JMenuBar SendMenuBar() throws IOException{
        nemuBar = new JMenuBar();

        //first menu bar
        JMenu file = new JMenu(" File ");
        file.setMnemonic(KeyEvent.VK_A);
        nemuBar.add(file);

        //Clear whole TextField and before ask for save before clear
        ImageIcon iconNewfile = new ImageIcon(new ImageIcon("src/main/resources/images/new.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
        JMenuItem NewMenufile = new JMenuItem("new",iconNewfile);
        NewMenufile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        NewMenufile.setToolTipText("Create new text file");
        NewMenufile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.NewfileLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        file.add(NewMenufile);

        //Open TextField from txt file
        ImageIcon iconOpenfile = new ImageIcon(new ImageIcon("src/main/resources/images/open.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
        JMenuItem Openfile = new JMenuItem("Open",iconOpenfile);
        Openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        Openfile.setToolTipText("Open text file");
        Openfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.OpenLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        file.add(Openfile);

        //Save TextField to txt file
        ImageIcon iconSavefile = new ImageIcon(new ImageIcon("src/main/resources/images/save.png").getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        JMenuItem Savefile = new JMenuItem("Save",iconSavefile);
        Savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        Savefile.setToolTipText("Save current text file");
        Savefile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.SaveLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        file.add(Savefile);

        //Save as TextField to txt file
        ImageIcon iconSaveAsfile = new ImageIcon(new ImageIcon("src/main/resources/images/saveas.png").getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        JMenuItem SaveAsfile = new JMenuItem("Save As",iconSaveAsfile);
        SaveAsfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK+InputEvent.SHIFT_MASK));
        SaveAsfile.setToolTipText("Save current text file");
        SaveAsfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.SaveAsLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        file.add(SaveAsfile);

        file.addSeparator();

        ImageIcon iconClose = new ImageIcon(new ImageIcon("src/main/resources/images/exit.png").getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        JMenuItem Close = new JMenuItem("Close",iconClose);
        Close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        Close.setToolTipText("Exit Application");
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(Close);


        //second nemu bar
        JMenu edit = new JMenu(" Edit ");
        nemuBar.add(edit);
        //-------------------copy textCutLogic
        ImageIcon iconCopyEdit = new ImageIcon(new ImageIcon("src/main/resources/images/copy.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
        JMenuItem copy = new JMenuItem("Copy",iconCopyEdit);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.CopyLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        edit.add(copy);
        //-------------------cut text CutLogic
        ImageIcon iconCutEdit = new ImageIcon(new ImageIcon("src/main/resources/images/cut.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
        JMenuItem cut = new JMenuItem("Cut",iconCutEdit);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.CutLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        edit.add(cut);
        //-------------------paste text
        ImageIcon iconPasteEdit = new ImageIcon(new ImageIcon("src/main/resources/images/save.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
        JMenuItem paste = new JMenuItem("Paste",iconPasteEdit);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionLogic.PasteLogic();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        edit.add(paste);

        //third menu bar
        JMenu info = new JMenu(" Info ");
        nemuBar.add(info);

        ImageIcon iconAuthorInfo = new ImageIcon(new ImageIcon("src/main/resources/images/properties.png").getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        JMenuItem Author = new JMenuItem("Author",iconAuthorInfo);
        Author.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AuthorBox.AuthorBox();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        info.add(Author);

        ImageIcon iconHelp = new ImageIcon(new ImageIcon("src/main/resources/images/help.png").getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        JMenuItem Help = new JMenuItem("About",iconHelp);
        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HelpBox.HelpBox();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        info.add(Help);

        return nemuBar;
    }
}
