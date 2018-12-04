package figure;

import tetris.gui.Block;

import java.util.*;

public class Field extends Object {
    //Fields
    private int width;
    private int height;

    private Block block;
    private List<Block> blocks = new ArrayList<>();

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
                        throw new CollisionException("Horizontal limit reached");
                    }
                    if (blocks[i].y < 0 || blocks[i].y > this.getHeight()){
                        throw new CollisionException("Vertical limit reached");
                    }
                    for(int j=0; j<this.blocks.toArray().length; j++){
                        if((blocks[i].y == this.blocks.get(j).y && blocks[i].x == this.blocks.get(j).x) && blocks[i].y > this.getHeight()-8) {
                            throw new CollisionException("Game over");
                        }
                        if(blocks[i].y == this.blocks.get(j).y && blocks[i].x == this.blocks.get(j).x) {
                            throw new CollisionException("Other Block limit reached");
                        }
                    }
                }
    }

    public void addBlocks(Block[] blocks){
        for(int i=0; i<blocks.length;i++){
            this.blocks.add(blocks[i]);
        }
    }

    public List<Block> getBlocks(){
        return blocks;
    }

    public void removeAllBlocks(){
        blocks.clear();
    }

    private boolean isRowFull(int y){
        for(int i=0; i<blocks.size();i++){
            if(blocks.get(i).y==y){
                for(int j=0; (j<this.getWidth()||j<blocks.size()-1);j++){
                    if(blocks.get(i+j).y!=y){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void removeRow(int y){
        int breakPoint=blocks.size()-1;
        for(int i=blocks.size(); i>0;i--){
            if(blocks.get(i).y==y){
                breakPoint = i;
                blocks.remove(i);
            }
        }
        //Move other blocks down
        for(int i = breakPoint; i<blocks.size();i++){
            blocks.get(i).y--;
        }
    }

    public int removeFullRows(){
        int rowCount = 0;
        for(int i=this.getHeight();i>0;i--){
            if(isRowFull(i)){
                removeRow(i);
                rowCount++;
            }
        }
        return rowCount;
    }
}
