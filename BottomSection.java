package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BottomSection {
    public static Component SendBottomSection() throws IOException{
        JPanel BottomSectionPanel = new JPanel();
        BottomSectionPanel.setLayout(new BorderLayout());
        BottomSectionPanel.setPreferredSize(new Dimension(0,100));


         JTextArea setResult = new JTextArea();
            setResult.setEditable(false);
            setResult.setFont(new Font("Calibri",Font.BOLD,16));
        JScrollPane setResultSP = new JScrollPane(setResult);
            setResultSP.setBorder(BorderFactory.createTitledBorder("Operations Result"));
            setResultSP.setPreferredSize(new Dimension(487,100));


        String[] listElement = {"Suma elementów","Średnia elementów","Wartość max i min"} ;

        JComboBox<String> setOperationOptions = new JComboBox<>(listElement);

            setOperationOptions.setFont(new Font("Calibri",Font.PLAIN,12));
        JScrollPane setOperationOptionsSP = new JScrollPane(setOperationOptions);
            setOperationOptionsSP.setBorder(BorderFactory.createTitledBorder("Operation list"));
            setOperationOptionsSP.setPreferredSize(new Dimension(300,100));


        setOperationOptions.addActionListener(e -> {

                    String name = (String) setOperationOptions.getSelectedItem();
                    if(name=="Suma elementów"){
                        setResult.setText(ActionLogic.sum_button());
                    } else if(name=="Średnia elementów"){
                        setResult.setText(ActionLogic.Average_button());
                    } else if(name=="Wartość max i min"){
                        setResult.setText(ActionLogic.MinMax_button());
                    }
                    //setResult.setText(name);    //put operation here
                    setResultSP.setBorder(BorderFactory.createTitledBorder("Operations Result ("+name+")"));
                    //ActionLogic.StatusBarAction(name, "Counting");




        BottomSectionPanel.add(setOperationOptions,BorderLayout.WEST);
        BottomSectionPanel.add(setResultSP,BorderLayout.EAST);

    });
        return BottomSectionPanel;
    }}

