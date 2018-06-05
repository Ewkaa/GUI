package Gui;

import javax.swing.*;

import java.awt.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.Arrays;

public class AuthorBox {
    private static int AuthorBoxHEIGHT=300;
    private static int AuthorBoxWIDHT=450;


    public static Component AuthorBox() throws IOException{
        ActionLogic.StatusBarAction("About Author");
        JFrame author_frame = new JFrame();
            author_frame.setSize(AuthorBoxWIDHT, AuthorBoxHEIGHT);
            author_frame.setResizable(false);
            author_frame.setLayout(new FlowLayout());
            author_frame.setUndecorated(true);
            author_frame.setLocationRelativeTo(null);
            author_frame.setVisible(true);

        //----------closing JDialog by clicking outside
            author_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            author_frame.addWindowFocusListener(new WindowFocusListener() {
                @Override
                public void windowGainedFocus(WindowEvent e) {
                }
                @Override
                public void windowLostFocus(WindowEvent e) {
                    author_frame.dispose();
                }
            });

//Layout
        GridBagLayout layout  = new GridBagLayout();
        layout.columnWidths = new int[] {50,50,50,50,50,50,50,50,50}; //450--9
        layout.rowHeights = new int[30];//300----6
        Arrays.fill(layout.rowHeights,10);
        GridBagConstraints xyz = new GridBagConstraints();
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(layout);
        panel.setVisible(true);
        author_frame.setContentPane(panel);

// ------------------------[LEFT] LOGO IMAGE--------------------------//
        ImageIcon logoImage = new ImageIcon("src/main/resources/images/logo.png");
        JLabel logo = new JLabel(logoImage);
        logo.setVisible(true);
        xyz.gridx=0;
        xyz.gridy=0;
        xyz.gridheight=30;
        xyz.gridwidth=5;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(logo,xyz);
// ------------------------[RIGHT] APPLICATION NAME--------------------------//
        JLabel Name_App = new JLabel();
        Name_App.setFont(new Font("Arial",Font.BOLD,42));
        Name_App.setHorizontalAlignment(JLabel.CENTER);
        Name_App.setText(Content.ProgramName);
        Name_App.setForeground(Color.WHITE);
        Name_App.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=5;
        xyz.gridheight=2;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Name_App,xyz);
// ------------------------[RIGHT] PROGRAM VERSION--------------------------//
        JLabel Program_version_Box = new JLabel();
        Program_version_Box.setFont(new Font("Arial",Font.PLAIN,14));
        Program_version_Box.setHorizontalAlignment(JLabel.CENTER);
        Program_version_Box.setText("["+Content.Version+"]");
        Program_version_Box.setForeground(Color.LIGHT_GRAY);
        Program_version_Box.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=7;
        xyz.gridheight=1;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Program_version_Box,xyz);
// ------------------------[RIGHT] line--------------------------

// ------------------------[RIGHT] CREATED--------------------------//
        JLabel Created_box = new JLabel();
        Created_box.setFont(new Font("Arial",Font.PLAIN,22));
        Created_box.setHorizontalAlignment(JLabel.CENTER);
        Created_box.setText("Created by:");
        Created_box.setForeground(Color.GRAY);
        Created_box.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=12;
        xyz.gridheight=2;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Created_box,xyz);
// ------------------------[RIGHT] line--------------------------//

// ------------------------[RIGHT] AUTHOR NAME--------------------------//
        JLabel Autor_Name = new JLabel();
        Autor_Name.setFont(new Font("Arial",Font.PLAIN,34));
        Autor_Name.setHorizontalAlignment(JLabel.CENTER);
        Autor_Name.setText("Ewelina Kalemba");
        Autor_Name.setForeground(Color.GRAY);
        Autor_Name.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=14;
        xyz.gridheight=2;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Autor_Name,xyz);
// ------------------------[RIGHT] AUTHOR NAME2--------------------------//
        JLabel Autor_Name2 = new JLabel();
        Autor_Name2.setFont(new Font("Arial",Font.PLAIN,14));
        Autor_Name2.setHorizontalAlignment(JLabel.CENTER);
        Autor_Name2.setForeground(Color.DARK_GRAY);
        Autor_Name2.setText("<html><center>Infromatyka<br> studia zaoczne semestr 4</center><html>");
        Autor_Name2.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=16;
        xyz.gridheight=3;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Autor_Name2,xyz);
// ------------------------[RIGHT] AUTHOR EMAIL--------------------------//
        JLabel Autor_email = new JLabel();
        Autor_email.setFont(new Font("Arial",Font.PLAIN,14));
        Autor_email.setHorizontalAlignment(JLabel.CENTER);
        Autor_email.setForeground(Color.DARK_GRAY);
        Autor_email.setText("jakielartur@gmail.com");
        Autor_email.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=20;
        xyz.gridheight=1;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Autor_email,xyz);
// ------------------------[RIGHT] COPYRIGHT--------------------------//
        JLabel Copyright_box = new JLabel();
        Copyright_box.setFont(new Font("Arial",Font.PLAIN,10));
        Copyright_box.setHorizontalAlignment(JLabel.CENTER);
        Copyright_box.setForeground(Color.DARK_GRAY);
        Copyright_box.setText("2018-2018 Artur Jakiel ");
        Copyright_box.setVisible(true);
        xyz.gridx=5;
        xyz.gridy=24;
        xyz.gridheight=2;
        xyz.gridwidth=3;
        xyz.fill = GridBagConstraints.BOTH;
        panel.add(Copyright_box,xyz);


        return author_frame;
    }
}
