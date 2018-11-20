package figure;

import tetris.gui.Block;

public class Field extends Object {
    //Fields
    private int width;
    private int height;
    //Constructor
    public Field(int width, int height){
        this.height=height;
        this.width=width;
    }
    //Methods

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void detectCollision(Block[] blocks) throws CollisionException{
                for(int i=0 ; i<4 ; i++) {
                    if (blocks[i].x == this.getWidth() || blocks[i].x < 0) {
                        throw new CollisionException("limit reached", false);
                    }
                    if (blocks[i].y < 0 || blocks[i].y > this.getHeight()){
                        throw new CollisionException("limit reached", true);
                    }
                }
    }
}
