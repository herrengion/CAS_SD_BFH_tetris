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
                for(Block block : blocks) {
                    if (block.x == this.getWidth() || block.x == 0) {
                        throw new CollisionException("horizontal limit");
                    }
                    if (block.y < this.getHeight()) {
                    }
                    throw new CollisionException("vertical limit");
                    }
    }
}
