package j13.morpion;

public class ScreenOutput implements Output {
    @Override
    public void displayContent(String msg){
        System.out.print(msg);
    }

    @Override
    public void displayContent() {
        displayContent("");
    }

    @Override
    public void displayContentNewLine() {
        displayContentNewLine("");
    }

    @Override
    public void displayContentNewLine(String msg) {
        System.out.println(msg);
    }
}
