import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionsOfTheNotepad {
    Main main;
    String fileName;
    String fileAddress;
    public FunctionsOfTheNotepad(Main main){
        this.main=main;
    }
    public void newFileFunction(){
        main.textArea.setText("");
        main.window.setTitle("New");
        fileName=null;
        fileAddress=null;
    }
    public void open(){
        FileDialog fileDialog=new FileDialog(main.window," Open ",FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile()!=null){
            fileName=fileDialog.getFile();
            fileAddress=fileDialog.getDirectory();
            main.window.setTitle(fileName);
        }
        System.out.println("File address and file name "+fileAddress+fileName);
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(fileAddress+fileName));
            main.textArea.setText("");
            String string =null;

            while((string =bufferedReader.readLine()) !=null){
                main.textArea.append(string+"\n");
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
    public void saveAsText(){
        FileDialog fileDialog=new FileDialog(main.window,"Save",FileDialog.SAVE);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            fileName=fileDialog.getFile();
            fileAddress=fileDialog.getDirectory();
            main.window.setTitle(fileName);

            try{
                FileWriter fileWriter=new FileWriter(fileAddress+fileName);
                fileWriter.write(main.textArea.getText());
                fileWriter.close();
            }
            catch(Exception e){
                e.getMessage();
            }
        }
    }
    public void saveText(){
        if(fileName==null){
            saveAsText();
        }
        else{
            try{
                FileWriter fileWriter=new FileWriter(fileAddress+fileName);
                fileWriter.write(main.textArea.getText());
                main.window.setTitle(fileName);
                fileWriter.close();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
    }
    public void exitProgram(){
        System.exit(0);
    }
}
