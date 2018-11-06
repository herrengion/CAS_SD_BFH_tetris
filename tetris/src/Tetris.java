import tetris.gui.GUI;

public class Tetris {
    //Fields
    private static int height = 19;
    private static int width = 9;
    //Constructors
    public Tetris(){
        //empty
    }
    //Methods
    public static void main(String[] args) {
        //Try args für width und height
        //System.out.println("Hello Tetris");
        GUI gui = new GUI(width,height);
        Game game = new Game(gui);
        game.start();
    }
}


