import tetris.gui.GUI;

public class Tetris {
    //Fields (used to be static, public due to exception handling)
    public static int height = 19;
    public static int width = 9;
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
        //Scoring scoring = new Scoring();
        game.start();


    }
    //other methods
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
}


