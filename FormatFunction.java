import java.awt.*;

public class FormatFunction {
    Main main;
    Font arial,comicSansMS,timesNewRoman;
    String selectFont;
    public FormatFunction(Main main){
        this.main= main;
    }
    public void wrapTheWord(){

        if(main.wordWrap==false){
            main.wordWrap=true;
            main.textArea.setLineWrap(true);
            main.textArea.setWrapStyleWord(true);
            main.wrap.setText("Word Wrap:On");
        }
        else if(main.wordWrap==true){
            main.wordWrap=false;
            main.textArea.setLineWrap(false);
            main.textArea.setWrapStyleWord(false);
            main.wrap.setText("Word Wrap:Off");
        }
    }

    public void createFont(int fontSize){
        arial=new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS=new Font("Comic Sans MS",Font.PLAIN,fontSize);
        timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);

        setFont(selectFont);
    }
    public void setFont(String font){
        selectFont=font;

        switch (selectFont){
            case "Arial":
                main.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                main.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                main.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
