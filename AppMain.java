package  Gui;

import javax.swing.*;


import java.awt.*;
import java.io.IOException;

//---------------------------------------------------//
public class AppMain extends JFrame{
    public static Content content = new Content();

    //---------BORDER--------//
     public static int WIDTH = 800;
     public int HEIGHT = 600;
    //---------Frame--------//
    private static AppMain instance;



    public AppMain() throws IOException{
        super("");
        this.setTitle(ActionLogic.SentTitle(Content.NameFile,Content.FilePath));
            MainFrameUI();
            this.setVisible(true);



    }
    public void MainFrameUI()throws IOException {
        frameInit();
        //Container MainFrameUI = new Container();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ImageIcon appicon = new ImageIcon("src/Gui/main/resources/images/appicon.png");
        setIconImage(appicon.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        JPanel MainFrameUIPanel = new JPanel(new BorderLayout());
        setContentPane(MainFrameUIPanel);



        MainFrameUIPanel.add(new ToolBox().SendToolBar(),BorderLayout.NORTH);
        MainFrameUIPanel.add(new ComponentArena().ComponentField(),BorderLayout.CENTER);
        MainFrameUIPanel.add(new StatusBar().SendStatusBar(),BorderLayout.PAGE_END);

        setJMenuBar(new MenuBar().SendMenuBar());

    }


    // --------------------------------------------------//
    public static AppMain getInstance(){
        return instance;
    }

    // ------------------------ MAIN --------------------------//
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            System.out.println("ERROR: default system look can't be loaded");
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    instance = new AppMain();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                instance.setVisible(true);
            }
        });
    }
}
