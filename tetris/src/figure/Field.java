package figure;

import tetris.gui.Block;

import java.util.*;

public class Field extends Object {
    //Fields
    private int width;
    private int height;

    private Block block;
    private List<Block> blocks = new LinkedList<>();
    private Iterator<Block> iter = blocks.iterator();

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

    /*private boolean isRowFull(int y){
        int i=0;
        while(iter.hasNext()){
        //for(int i=0; i<blocks.size()-1;i++){
            if(blocks.get(i).y==y){
                for(int j=0; j<this.getWidth()-1;j++){
                    if(blocks.get(i+j).y!=y){
                        return false;
                    }
                }
                return true;
            }
            i++;
            iter.next();
        }
        return false;
    }*/

    private boolean isRowFull(int y){
        int a = 0;
        for(int i = 0; i <blocks.size(); i++){
            if(blocks.get(i).y==y){
                a++;
            }
        }
        return a == this.width;
    }

    private void removeRow(int y){
        int breakpoint = blocks.size();
        for(int i=blocks.size()-1; i>=0;i--){
            if(blocks.get(i).y==y){
                blocks.remove(i);
                breakpoint = i;
            }
        }
        //Move above rows down
        /*for(int j = breakpoint; j>blocks.size()-1 ;j++){
            blocks.get(j).y--;
        }*/
    }

    public int removeFullRows(){
        int rowCount = 0;
        //int breakPoint=blocks.size()-1;
        for(int i=this.getHeight()-1;i>=0;i--){
            if(isRowFull(i)){
                //breakPoint = i;
                removeRow(i);
                rowCount++;
                //Move above rows down
                for(int j = blocks.size()-1; j>=0 ;j--){
                    if(blocks.get(j).y>i){
                    blocks.get(j).y--;
                    }
                }
            }
        }
        return rowCount;
    }
}
