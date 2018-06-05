package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelpBox {
    public static Component HelpBox()throws IOException{
        JDialog HelpBoxFrame = new JDialog();
            HelpBoxFrame.setTitle("Help");
            HelpBoxFrame.setSize(500,400);
            HelpBoxFrame.setResizable(false);
            HelpBoxFrame.setLocationRelativeTo(null);
            HelpBoxFrame.setVisible(true);


        JTextArea HelpTextArea = new JTextArea();
            HelpTextArea.setEditable(false);
            HelpTextArea.setFont(new Font("Calibri",Font.BOLD,16));
            HelpTextArea.setLineWrap(true);
        JScrollPane HelpTextAreaSP = new JScrollPane(HelpTextArea);
            HelpTextAreaSP.setPreferredSize(new Dimension(350,400));
            HelpTextAreaSP.setBounds(150,0,343,375);
            HelpTextArea.setVisible(true);

        String[] listElement = {"Pomoc1"} ;

        JList<String> setHelpText = new JList<>(listElement);
            setHelpText.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setHelpText.setLayoutOrientation(JList.VERTICAL);
            setHelpText.setVisibleRowCount(-1);
            setHelpText.setFont(new Font("Calibri",Font.PLAIN,12));
            setHelpText.setBorder(BorderFactory.createTitledBorder("Help"));
            setHelpText.setBounds(0,0,150,400);

        setHelpText.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                    String name = (String) setHelpText.getSelectedValue();//put operation here
                    try{
                        BufferedReader readHelp = new BufferedReader(new FileReader(name+".txt"));
                        StringBuilder HelpstringBuilder = new StringBuilder();
                        String line = null;
                        while ((line = readHelp.readLine())!=null){
                            HelpstringBuilder.append(line+"\n");
                            HelpTextArea.setText(HelpstringBuilder.toString());
                        }
                            readHelp.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
            }
        });

        HelpBoxFrame.add(setHelpText);
        HelpBoxFrame.add(HelpTextAreaSP);

        return HelpBoxFrame;
    }
}
