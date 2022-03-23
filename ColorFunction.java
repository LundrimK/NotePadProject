import java.awt.*;

public class ColorFunction {
    Main main;
    public ColorFunction(Main main){
        this.main=main;
    }
    public void changeColor(String color){
        switch (color){
            case "white":
                main.window.getContentPane().setBackground(Color.WHITE);
                main.textArea.setBackground(Color.WHITE);
                main.textArea.setForeground(Color.BLACK);
                break;
            case "Red":
                main.window.getContentPane().setBackground(Color.RED);
                main.textArea.setBackground(Color.RED);
                main.textArea.setForeground(Color.WHITE);
                break;
            case "Blue":
                main.window.getContentPane().setBackground(Color.BLUE);
                main.textArea.setBackground(Color.BLUE);
                main.textArea.setForeground(Color.WHITE);
                break;
        }
    }
}
