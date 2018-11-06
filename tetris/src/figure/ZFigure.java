package figure;

import tetris.gui.Block;

public class ZFigure extends BaseFigure {
    //Fields

    //Constructor
    public ZFigure(int x, int y){
        super();
        blocks[0] = new Block(x, y, RED);
        blocks[1] = new Block(x, y-1, RED);
        blocks[2] = new Block(x-1, y-1, RED);
        blocks[3] = new Block(x-1, y-2, RED);

    }
    //Methods

}
