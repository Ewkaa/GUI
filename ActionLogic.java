package  Gui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.*;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;


public class ActionLogic {
    public static Content content = new Content();
// ------------------------NEW FILE--------------------------//
    private static void NewfileFormula()throws IOException {
        try {
            for(int i=0;i<5;i++) {
                for (int j = 0; j < 5; j++) {
                    content.math.ClearArray(i, j);
                    MiddleSection.SendTable().repaint();
                    BottomSection.SendBottomSection().repaint();
                }
            } //clear component
            Content.NameFile = "Untitled";
            ActionLogic.StatusBarAction("Complied", "Creating new file");
        } catch (Exception e) {
            ActionLogic.StatusBarAction("Error", "Creating new file");
            ImageIcon iconError = new ImageIcon(new ImageIcon("src/Gui/main/resources/images/error.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Operation flailed, cannot create a file.",
                    "Error", JOptionPane.OK_OPTION, iconError);
        }
    }
    //------NEW FILE LOGIC
    public static void NewfileLogic()throws IOException {
        ActionLogic.StatusBarAction("Creating new file");
        if (content.math.Sum() == 0) {
            NewfileFormula();
        }else{
            int optionMessage;
            optionMessage = StandardOptionDialog.StandardOptionMessage("Do you want to save before create new File", "Newfile");
            if (optionMessage == 0)
                try {
                    SaveLogic();
                } catch (Exception e) {
                    ActionLogic.StatusBarAction("Error ", "Creating new file");
                    ImageIcon iconError = new ImageIcon(new ImageIcon("src/main/resources/images/error.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
                    JOptionPane.showMessageDialog(null, "Operation flailed, cannot create a file.",
                            "Error", JOptionPane.OK_OPTION, iconError);
                }
            if (optionMessage == 1)
                NewfileFormula();
            else
                ActionLogic.StatusBarAction("Canceled", "Creating new file");
        }

    }
// ------------------------SAVE LOGIC--------------------------//
    public static void SaveLogic() throws IOException {
        ActionLogic.StatusBarAction("Saving to file");

        if (new File(Content.FilePath).exists()) {
            try {
                AppMain.getInstance().setTitle(ActionLogic.SentTitle(Content.NameFile, Content.FilePath));
                try {
                    File file = new File (Content.FilePath,Content.NameFile);
                    BufferedWriter fileWriter = null;
                    fileWriter = new BufferedWriter(new FileWriter(file));

                    double[][] save_array = new double[5][5];
                    for(int i=0;i<5;i++) {
                        for(int j=0;j<5;j++) {
                            save_array[i][j]=content.math.get_array()[i][j];
                            fileWriter.write(String.valueOf(save_array[i][j]));
                        }
                    }

                    //ComponentArena.TextBox.write(fileWriter);
                    fileWriter.close();
                } catch (Exception e) {
                    ActionLogic.StatusBarAction("Saving Error", "Error");
                    ImageIcon iconError = new ImageIcon(new ImageIcon("src/main/resources/images/error.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
                    JOptionPane.showMessageDialog(null, "Operation flailed, cannot save to file.",
                            "Error", JOptionPane.OK_OPTION, iconError);
                }
            } catch (Exception e) {
                ActionLogic.StatusBarAction("Saving Error", "Error");
            }
        }else
            SaveAsLogic();
    }
    // ------------------------SAVE AS LOGIC--------------------------//
    public static void SaveAsLogic() throws IOException {
        ActionLogic.StatusBarAction("Saving to file...");
        int optionMessage;
        optionMessage = StandardOptionDialog.StandardOptionMessage("Are you Want to save it", "Save");
        if (optionMessage == 0)
            try {
                FileDialog fileDialog = new FileDialog(AppMain.getInstance(), "Save File", FileDialog.SAVE);
                fileDialog.setVisible(true);

                if (fileDialog.getFile() != null)
                    Content.NameFile = fileDialog.getFile();
                    Content.FilePath = fileDialog.getDirectory();

                AppMain.getInstance().setTitle(ActionLogic.SentTitle(Content.NameFile, Content.FilePath));
                    try {
                        File file = new File (Content.FilePath,Content.NameFile);
                        BufferedWriter fileWriter = null;
                        fileWriter = new BufferedWriter(new FileWriter(file));

                        double[][] save_array = new double[5][5];
                        for(int i=0;i<5;i++) {
                            for(int j=0;j<5;j++) {
                                save_array[i][j]=content.math.get_array()[i][j];
                                fileWriter.write(String.valueOf(save_array[i][j]));
                            }
                        }

                        //ComponentArena.TextBox.write(fileWriter);
//                    FileWriter fileWriter = new FileWriter(Content.NameFile);
//                    fileWriter.write(ComponentArena.TextBox.getText());
//                    AppMain.getInstance().setTitle(ActionLogic.SentTitle(Content.NameFile, Content.FilePath));
                        fileWriter.close();
                } catch (Exception e) {
                    ActionLogic.StatusBarAction("Saving Error", "Error");
                    ImageIcon iconError = new ImageIcon(new ImageIcon("src/main/resources/images/error.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
                    JOptionPane.showMessageDialog(null, "Operation flailed, cannot save to file.",
                            "Error", JOptionPane.OK_OPTION, iconError);
                }
            } catch (Exception e){
                ActionLogic.StatusBarAction("Saving Error", "Error");
            }
        else
            ActionLogic.StatusBarAction("Canceled","Saving");
    }
    // ------------------------OPEN LOGIC--------------------------//
    private static void OpenFormula() throws IOException {
        try {
            FileDialog fileDialog = new FileDialog(AppMain.getInstance(), "Open File", FileDialog.LOAD);
            fileDialog.setVisible(true);

            if (fileDialog.getFile() != null)
                Content.NameFile = fileDialog.getFile();
                Content.FilePath = fileDialog.getDirectory();
                AppMain.getInstance().setTitle(ActionLogic.SentTitle(Content.NameFile, Content.FilePath));
            try {
                BufferedReader reader = new BufferedReader(new FileReader(Content.NameFile));
                //StringBuilder stringBuilder = new StringBuilder();
                //String line = null;
                //while ((line = reader.readLine()) != null) {
                //   stringBuilder.append(line + "\n");
                    //ComponentArena.TextBox.setText(stringBuilder.toString());
                String[][] load_array = new String[5][5];
                for(int i=0;i<5;i++) {
                    for(int j=0;j<5;j++) {
                        load_array[i][j]=reader.readLine();
                        content.math.set_array(Double.parseDouble(load_array[i][j]), i, j);
                       content.middleSection.Table.setValueAt(load_array[i][j], i, (4-j));
                        System.out.print(load_array[i][j]);
                    }
                    System.out.println("");
                }
                content.middleSection.Table.repaint();

                reader.close();
            } catch (IOException e) {
                ActionLogic.StatusBarAction("Canceled", "Open File");

            }
//------------------------------------------------END OPEN FORMULA---------------------------------------
        } catch (IOException e) {
            ActionLogic.StatusBarAction("Open Error", "Error");
            ImageIcon iconError = new ImageIcon(new ImageIcon("src/main/resources/images/error.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Operation flailed, cannot save to file.",
                    "Error", JOptionPane.OK_OPTION, iconError);
        }
    }
    //------OPEN LOGIC
    public static void OpenLogic() throws IOException {
        ActionLogic.StatusBarAction("Open file");
        //if ("".equals(ComponentArena.TextBox.getText())) {
            if (false) {
            OpenFormula();
        } else{
            int optionMessage;
            optionMessage = StandardOptionDialog.StandardOptionMessage("Are you Want to save it", "Save");
            if (optionMessage == 0)
                SaveAsLogic();
            if (optionMessage == 1) {
                OpenFormula();
            } else
                //---------------------INFO STATUS BAR
                ActionLogic.StatusBarAction("Canceled", "Open file");
        }
    }
// ------------------------COPY LOGIC--------------------------//
    public static void CopyLogic() throws IOException{
        ActionLogic.StatusBarAction("Copied ");
        String copyText = "test";//ComponentArena.TextBox.getSelectedText();
        StringSelection copySelection = new StringSelection(copyText);
        content.clipboard.setContents(copySelection,copySelection);
    }
// ------------------------CUT LOGIC--------------------------//
    public static void CutLogic() throws IOException{
        ActionLogic.StatusBarAction("Cut");
        String cutString = "test";//CComponentArena.TextBox.getSelectedText();
        StringSelection cutSelection = new StringSelection(cutString);
        content.clipboard.setContents(cutSelection,cutSelection);
        //ComponentArena.TextBox.replaceRange("", ComponentArena.TextBox.getSelectionStart(), ComponentArena.TextBox.getSelectionEnd());
    }
// ------------------------PASTE LOGIC--------------------------//
    public static void PasteLogic() throws IOException{
        ActionLogic.StatusBarAction("Pasted");
        try{
            Transferable pasteText = content.clipboard.getContents(AppMain.getInstance());
            String pasteContent = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            //topSection.SendTopSection().sendValue.replaceRange(pasteContent, TopSection.SendTopSection().sendValue.getSelectionStart(), TopSection.SendTopSection().sendValue.getSelectionEnd());
        }catch (Exception e){
            ActionLogic.StatusBarAction("Something Happen", "Error");
        }
    }

    // ------------------------Clear Table LOGIC--------------------------//
    public void ClearTable()throws IOException {
        ActionLogic.StatusBarAction("Clear a table");
        int optionMessage;
        optionMessage = StandardOptionDialog.StandardOptionMessage("Do you want to Clear a table", "Clear table");
        if (optionMessage == 0)
            try {
                for(int i=0;i<5;i++) {
                    for (int j = 0; j < 5; j++) {
                        content.math.ClearArray(i, j);
                        content.middleSection.Table.setValueAt(0, i, 4-j);
                        content.middleSection.Table.repaint();
                    }
                }
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(content.math.array[i][j]+" ");
                    }
                    System.out.println("");
                }
                BottomSection.SendBottomSection().repaint();
                System.out.println("Clear TEST 0");
                ActionLogic.StatusBarAction("Cleared", "Table Operation");
            } catch (Exception e) {
                ActionLogic.StatusBarAction("Error ", "Table Operation");
                ImageIcon iconError = new ImageIcon(new ImageIcon("src/main/resources/images/error.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
                JOptionPane.showMessageDialog(null, "Operation flailed, cannot clare a table.",
                        "Error", JOptionPane.OK_OPTION, iconError);
            }
        if (optionMessage == 1)
            ActionLogic.StatusBarAction("Canceled", "Table Operation");
        if (optionMessage == 2)
            ActionLogic.StatusBarAction("Canceled", "Table Operation");
    }
    // ------------------------fillTableButton LOGIC--------------------------//
    public static void fillTable()throws IOException{
        try {
            content.math.write(TopSection.sliderRow.getValue(), TopSection.sliderColumn.getValue(), TopSection.sendValue.getText());
            content.middleSection.Table.setValueAt(TopSection.sendValue.getText(), TopSection.sliderRow.getValue(), TopSection.sliderColumn.getValue());
            content.middleSection.Table.repaint();
        }catch (NumberFormatException e) {
            ActionLogic.StatusBarAction("Canceled", "Open File");
        }
    }
    // ------------------------sum button LOGIC--------------------------//
    public static String sum_button(){
        return Double.toString(content.math.Sum());
    }
    // ------------------------sum button LOGIC--------------------------//
    public static String Average_button(){
        return Double.toString(content.math.Average());
    }
    // ------------------------sum button LOGIC--------------------------//
    public static String MinMax_button() {
        double[] wynik = new double[2];
        String sendresult = new String("");

        wynik = content.math.MaxMin();
        sendresult = "min:    " + wynik[0] + "\nmaks:    " + wynik[1];
        return sendresult;
    }
    // ------------------------STATUS BAR THROWS LOGIC--------------------------//
    public static void StatusBarAction(String ActionTag) throws IOException{
        Content.Status = ActionTag;
        StatusBar.StatusBar.setText(StatusBar.StatusBarTag+ Content.Status);
        StatusBar.StatusBar.repaint();
    }
    public static void StatusBarAction( String ActionTag,String NewStatusBarTag) throws IOException{
        Content.Status = ActionTag;
        StatusBar.StatusBar.setText(NewStatusBarTag+": "+ Content.Status);
        StatusBar.StatusBar.repaint();
    }
    // ------------------------TITLE LOGIC --------------------------//
    public static String SentTitle(String Name,String Path){
        return (Name+" ["+Path+"] "+" --"+Content.ProgramName);

    }
}
