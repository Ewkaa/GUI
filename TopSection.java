package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.IOException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TopSection {
    public ActionLogic actionLogic =new ActionLogic();
    public static JTextField sendValue;
    public static JSlider sliderRow;
    public static JSlider sliderColumn;

    public  Component SendTopSection() throws IOException {
        GridBagLayout layout  = new GridBagLayout();
            layout.columnWidths = new int[] {20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20};
            layout.rowHeights = new int[] {10,10,15,10,10};
        GridBagConstraints xyz = new GridBagConstraints();

        JPanel SendControlButtons = new JPanel(layout);
            SendControlButtons.setPreferredSize(new Dimension(0, 80));
            SendControlButtons.setVisible(true);


//---------Row value change JSlider,label-------------------------//
        JLabel sendRowName = new JLabel("Row");
            sendRowName.setVisible(true);
            sendRowName.setHorizontalAlignment(SwingConstants.CENTER);
            sendRowName.setSize(200, 100);
        sliderRow=new JSlider(0,10,5);
        sliderRow.setPaintTicks(true);
        sliderRow.setMajorTickSpacing(2); //podziałka
        sliderRow.setMajorTickSpacing(1);
        //sliderRow.setValue(i);
        sliderRow.addChangeListener(new ChangeListener() {  //nasłuchiwacz zmiany
            @Override
            public void stateChanged(ChangeEvent e)
            {
                sendRowName.setText("Value : " + ((JSlider) e.getSource()).getValue());
            }
        });
        

//---------Column value change JSlider,Label-------------------------//
        JLabel sendColumnName = new JLabel("Column");
            sendColumnName.setVisible(true);
            sendColumnName.setHorizontalAlignment(SwingConstants.CENTER);
            sendColumnName.setSize(200, 100);
        sliderColumn=new JSlider(0,10,5);
        sliderColumn.setPaintTicks(true);
        sliderColumn.setMajorTickSpacing(2);
        sliderColumn.setMajorTickSpacing(1);
        sliderColumn.setPaintLabels(true);
        sliderColumn.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                sendColumnName.setText("Value : " + ((JSlider) e.getSource()).getValue());
            }
        });

//---------Value enter TextField-------------------------//
            sendValue = new JTextField(17);
            //sendValue.setPreferredSize(new Dimension(200, 50));
            sendValue.setFont(new Font("Arial", Font.PLAIN, 24));
            sendValue.setVisible(true);
            sendValue.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e)
                {
                    if (!Character.isDigit(e.getKeyChar()))
                    e.consume();
                }
            });


//---------ADD TO TABLE BUTTON-------------------------//
            ImageIcon iconfillTableButton = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/fill.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
        JButton fillTableButton = new JButton("add to table", iconfillTableButton);
            fillTableButton.setToolTipText("Pres to add to table");
            fillTableButton.setPreferredSize(new Dimension(170, 70));
            fillTableButton.setVisible(true);
            fillTableButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ActionLogic.StatusBarAction("Added", "Table Operation");
                        /////////////////////////////////////
                        ActionLogic.fillTable();
                        /////////////////////////////////////
                       // MiddleSection.table().repaint();
                        sendValue.setText(null);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });

//---------CLEAR A TABLE BUTTON-------------------------//
            ImageIcon iconClearTableButton = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/clear.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
        JButton ClearTableButton = new JButton("Clear", iconClearTableButton);
            ClearTableButton.setToolTipText("Pres to clare a table");
            ClearTableButton.setPreferredSize(new Dimension(100, 70));
            ClearTableButton.setVisible(true);
            ClearTableButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        actionLogic.ClearTable();
                        sendValue.setText(null);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });


//---------ADD COMPONETS-------------------------//
        ////////////////////////////////////////////--1
            xyz.gridx=1;        //width
            xyz.gridwidth=2;    //width length
            xyz.gridy=4;
            xyz.gridheight=3;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(sendRowName,xyz);

        ////////////////////////////////////////////
            xyz.gridx=3;        //width
            xyz.gridwidth=8;    //width length
            xyz.gridy=4;
            xyz.gridheight=5;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(sliderRow,xyz);

        ////////////////////////////////////////////--2
            xyz.gridx=1;        //width
            xyz.gridwidth=2;    //width length
            xyz.gridy=1;
            xyz.gridheight=3;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(sendColumnName,xyz);

        ////////////////////////////////////////////
            xyz.gridx=3;        //width
            xyz.gridwidth=8;    //width length
            xyz.gridy=1;
            xyz.gridheight=5;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(sliderColumn,xyz);

        ////////////////////////////////////////////--3
            xyz.gridx=12;        //width
            xyz.gridwidth=15;    //width length
            xyz.gridy=2;
            xyz.gridheight= 3;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(sendValue,xyz);

        ////////////////////////////////////////////--4
            xyz.gridx=27;        //width
            xyz.gridwidth=5;    //width length
            xyz.gridy=2;
            xyz.gridheight= 3;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(fillTableButton,xyz);

        ////////////////////////////////////////////--5
            xyz.gridx=32;        //width
            xyz.gridwidth=5;    //width length
            xyz.gridy=2;
            xyz.gridheight= 3;
            xyz.fill = GridBagConstraints.BOTH;
        SendControlButtons.add(ClearTableButton,xyz);

        ////////////////////////////////////////////

        return SendControlButtons;
    }
}