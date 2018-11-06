package figure;

import tetris.gui.Block;

public class IFigure extends BaseFigure {
    //Fields

    //Constructor
    public IFigure(int x, int y){
        super();
        blocks[0] = new Block(x, y, YELLOW);
        blocks[1] = new Block(x - 1, y, YELLOW);
        blocks[2] = new Block(x + 1, y, YELLOW);
        blocks[3] = new Block(x + 2, y, YELLOW);
        /*for(int i = 0; i<4; i++){
            blocks[i] = new Block(x,y-i,COLOR);
        }*/
    }
    //Methods
}
