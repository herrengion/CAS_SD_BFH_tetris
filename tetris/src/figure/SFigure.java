package figure;

import tetris.gui.Block;

public class SFigure extends BaseFigure {
    //Fields

    //Constructor
    public SFigure(int x, int y){
        super();
        figureName = "SFigure";
        //System.out.println(this.toString());
        blocks[0] = new Block(x, y, BLUE);
        blocks[1] = new Block(x, y-1, BLUE);
        blocks[2] = new Block(x+1, y-1, BLUE);
        blocks[3] = new Block(x+1, y-2, BLUE);

    }
    //Methods
    public int hashCode(){return 4;}

}
