package figure;
import tetris.gui.Block;

public abstract class BaseFigure {
    //Fields
    protected final Block[] blocks = new Block[4];
        //Block colors
        static final int RED = 1;
        static final int YELLOW = 2;
        static final int PINK = 3;
        static final int BLUE = 4;
        static final int GREEN = 5;
        static final int GREY = 6;
    //Constructors
    public BaseFigure(){}
    //Methods
    public Block[] getBlocks(){
        return blocks;
    }
    public void move(int dx, int dy){
        for (Block block : blocks){//Korrektion
            block.x += dx;
            block.y += dy;
        }
    }
    public void rotate(int d){
        //parameter d = +/- 1
        int cx = blocks[2].x;
        int cy = blocks[2].y;
        for (Block block : blocks){
            int dx = block.x - cx;
            int dy = block.y - cy;
            block.x = cx + d * dy;
            block.y = cy - d * dx;
        }
    }
}
