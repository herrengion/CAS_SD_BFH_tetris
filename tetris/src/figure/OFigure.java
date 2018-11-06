package figure;

import tetris.gui.Block;

public class OFigure extends BaseFigure {
//Fields

    //Constructor
    public OFigure(int x, int y) {
        super();
        blocks[0] = new Block(x, y, GREY);
        blocks[1] = new Block(x + 1, y, GREY);
        blocks[2] = new Block(x, y - 1, GREY);
        blocks[3] = new Block(x + 1, y - 1, GREY);
    }

    //Methods: adapt rotate()
    @Override
    public void rotate(int d) {
    }
}
