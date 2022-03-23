public class EditFunction {
    Main main;
    public EditFunction(Main main){
        this.main=main;
    }
    public void undo(){
        main.undoManager.undo();
    }
    public void redo(){
        main.undoManager.redo();
    }
}
