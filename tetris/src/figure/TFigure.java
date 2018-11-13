package figure;

import tetris.gui.Block;

public class TFigure extends BaseFigure {
    //Fields

    //Constructor
    public TFigure(int x, int y){
        super();
        figureName = "TFigure";
        //System.out.println(this.toString());
        blocks[0] = new Block(x, y, GREEN);
        blocks[1] = new Block(x+1, y, GREEN);
        blocks[2] = new Block(x+2, y, GREEN);
        blocks[3] = new Block(x+1, y-1, GREEN);

    }
    //Methods
    public void rotate(int d) {
        //parameter d = +/- 1
        int cx = blocks[1].x;
        int cy = blocks[1].y;
        for (Block block : blocks) {
            int dx = block.x - cx;
            int dy = block.y - cy;
            block.x = cx + d * dy;
            block.y = cy - d * dx;
        }
    }
    public int hashCode(){return 5;}

}
