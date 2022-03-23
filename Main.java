import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorConvertOp;

public class Main implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrap=false;
    JMenuBar menuBar;
    JMenu file,edit,format,color;
    JMenuItem fileNew,fileOpen,fileSave,fileSaveAs,fileExit;
    JMenuItem Color1,Color2,Color3;
    JMenuItem undo,redo;
    FunctionsOfTheNotepad functionsOfTheNotepad=new FunctionsOfTheNotepad(this);
    FormatFunction formatFunction=new FormatFunction(this);
    ColorFunction colorFunction=new ColorFunction(this);
    UndoManager undoManager=new UndoManager();
    EditFunction editFunction=new EditFunction(this);

    JMenuItem wrap,fontArial,FontCSMS,FontIMR,FontSize8,FontSize12,FontSize16,FontSize20,FontSize24,FontSize28;
    JMenu fontMenu,fontSizeMenu;


    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        setWindow();
        setTextArea();
        setMenuBar();
        setMenuItem();
        createFunctionFormat();
        colorMenu();
        editMenu();
        formatFunction.selectFont="Arial";
        formatFunction.createFont(16);
        formatFunction.wrapTheWord();
        colorFunction.changeColor("white");



        window.setVisible(true);
    }
    public void setWindow(){
        window =new JFrame("Begginer NotePad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);
    }
    public void setMenuBar(){
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);
        file=new JMenu("File");
        menuBar.add(file);
        edit=new JMenu("Edit");
        menuBar.add(edit);
        format=new JMenu("Format");
        menuBar.add(format);
        color=new JMenu("Color");
        menuBar.add(color);
    }
    public void setMenuItem(){
        fileNew=new JMenuItem("New");
        fileNew.addActionListener(this);
        fileNew.setActionCommand("New");
        file.add(fileNew);

        fileOpen=new JMenuItem("Open");
        fileOpen.addActionListener(this);
        fileOpen.setActionCommand("Open");
        file.add(fileOpen);

        fileSave=new JMenuItem("Save");
        fileSave.addActionListener(this);
        fileSave.setActionCommand("Save");
        file.add(fileSave);

        fileSaveAs=new JMenuItem("SaveAs");
        fileSaveAs.addActionListener(this);
        fileSaveAs.setActionCommand("SaveAs");
        file.add(fileSaveAs);

        fileExit=new JMenuItem("Exit");
        fileExit.addActionListener(this);
        fileExit.setActionCommand("Exit");
        file.add(fileExit);
    }
    public void createFunctionFormat(){
        wrap=new JMenuItem("Word Wrap: Off");
        wrap.addActionListener(this);
        wrap.setActionCommand("Word Wrap");
        format.add(wrap);
        fontMenu=new JMenu("Font");
        format.add(fontMenu);


        fontArial=new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        fontMenu.add(fontArial);

        FontCSMS=new JMenuItem("Comic Sans MS");
        FontCSMS.addActionListener(this);
        FontCSMS.setActionCommand("Comic Sans MS");
        fontMenu.add(FontCSMS);

        FontIMR=new JMenuItem("Times New Roman");
        FontIMR.addActionListener(this);
        FontIMR.setActionCommand("Times New Roman");
        fontMenu.add(FontIMR);

        fontSizeMenu=new JMenu("Font size");
        format.add(fontSizeMenu);

        FontSize8=new JMenuItem("8");
        FontSize8.addActionListener(this);
        FontSize8.setActionCommand("size 8");
        fontSizeMenu.add(FontSize8);

        FontSize12=new JMenuItem("12");
        FontSize12.addActionListener(this);
        FontSize12.setActionCommand("size 12");
        fontSizeMenu.add(FontSize12);

        FontSize16=new JMenuItem("16");
        FontSize16.addActionListener(this);
        FontSize16.setActionCommand("size 16");
        fontSizeMenu.add(FontSize16);


        FontSize20=new JMenuItem("20");
        FontSize20.addActionListener(this);
        FontSize20.setActionCommand("size 20");
        fontSizeMenu.add(FontSize20);


        FontSize24=new JMenuItem("24");
        FontSize24.addActionListener(this);
        FontSize24.setActionCommand("size 24");
        fontSizeMenu.add(FontSize24);

        FontSize28=new JMenuItem("28");
        FontSize28.addActionListener(this);
        FontSize28.setActionCommand("size 28");
        fontSizeMenu.add(FontSize28);

    }
    public void colorMenu(){
        Color1=new JMenuItem("white");
        Color1.addActionListener(this);
        Color1.setActionCommand("white");
        color.add(Color1);

        Color2=new JMenuItem("Red");
        Color2.addActionListener(this);
        Color2.setActionCommand("Red");
        color.add(Color2);

        Color3=new JMenuItem("Blue");
        Color3.addActionListener(this);
        Color3.setActionCommand("Blue");
        color.add(Color3);
    }
    public void editMenu(){
        undo=new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        edit.add(undo);

        redo=new JMenuItem("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        edit.add(redo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch (command){
            case "New":
                functionsOfTheNotepad.newFileFunction();
                break;
            case "Open":
                functionsOfTheNotepad.open();
                break;
            case "SaveAs":
                functionsOfTheNotepad.saveAsText();
                break;
            case "Save":
                functionsOfTheNotepad.saveText();
            case "Exit":
                functionsOfTheNotepad.exitProgram();
            case "Word Wrap":
                formatFunction.wrapTheWord();
                break;
            case "Arial":
                formatFunction.setFont(command);
                break;
            case "Comic Sans MS":
                formatFunction.setFont(command);
                break;
            case "Times New Roman":
                formatFunction.setFont(command);
                break;
            case "size 8":
                formatFunction.createFont(8);
                break;
            case "size 12":
                formatFunction.createFont(12);
                break;
            case "size 16":
                formatFunction.createFont(16);
                break;
            case "size 20":
                formatFunction.createFont(20);
                break;
            case "size 24":
                formatFunction.createFont(24);
                break;
            case "size 28":
                formatFunction.createFont(28);
                break;
            case "white":
                colorFunction.changeColor(command);
                break;
            case "Red":
                colorFunction.changeColor(command);
                break;
            case "Blue":
                colorFunction.changeColor(command);
                break;
            case "Undo":
                editFunction.undo();
                break;
            case "Redo":
                editFunction.redo();
                break;
        }
    }
}
