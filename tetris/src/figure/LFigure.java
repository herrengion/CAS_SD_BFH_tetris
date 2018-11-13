package figure;

import tetris.gui.Block;

public class LFigure extends BaseFigure {
    //Fields

    //Constructor
    public LFigure(int x, int y){
        super();
        figureName = "LFigure";
        //System.out.println(this.toString());
        blocks[0] = new Block(x, y, PINK);
        blocks[1] = new Block(x, y-1, PINK);
        blocks[2] = new Block(x, y-2, PINK);
        blocks[3] = new Block(x+1, y-2, PINK);

    }
    //Methods: adapt rotate()
    public int hashCode(){return 2;}

}
