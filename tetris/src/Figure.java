import tetris.gui.Block;
import tetris.gui.GUI;
import tetris.gui.ActionEvent;

public class Figure {
    //Fields
    private final Block[] blocks = new Block[4];
    private static final int COLOR = 3;

    //Constructors
    public Figure(int x, int y){
        for(int i = 0; i<4; i++){
            blocks[i] = new Block(x,y-i,COLOR);
        }
    }
    /*public Figure(int x, int y){ //alternative für rotieren
        for(int i = 3; i==0; i--){
            blocks[i] = new Block(x,y-i,COLOR);
        }
    }*/
    //Methods
    public Block[] getBlocks(){
        /*for(int i = 0; i<4; i++){
            blocks[i] = new Block(xFig,yFig-i,COLOR);
        }*/
        return blocks;
    }
    public void move(int dx, int dy){
        //TBD!!!
        //updateGUI();
        //createBlock(block.x,block.y-1 ,block.color);
        //Figure figure = game.getFigure();
        //game.createFigure();
        for (Block block : blocks){//Korrektion
            block.x += dx;
            block.y += dy;
        }
        /*for(int i = 0; i<4; i++){
            blocks[i].x = blocks[i].x+dx;
            blocks[i].y = blocks[i].y+dy;
        }*/
    }
    public void rotate(int d){
    //parameter d = +/- 1
        int cx = blocks[0].x;
        int cy = blocks[0].y;
        for (Block block : blocks){
            int dx = block.x - cx;
            int dy = block.y - cy;
            block.x = cx + d * dy;
            block.y = cy - d * dx;
        }

        /*switch (d){
            case 1://Rotate right
                blocks[1].y = blocks[0].y;
                blocks[2].y = blocks[0].y;
                blocks[3].y = blocks[0].y;

                blocks[1].x = blocks[0].x+1;
                blocks[2].x = blocks[0].x+2;
                blocks[3].x = blocks[0].x+3;
                /*int a =blocks[0].y-blocks[1].y;
                blocks[0].y=(blocks[1].y-blocks[0].x)+blocks[1].x;
                blocks[0].x=blocks[1].x + a;

                a=blocks[2].y-blocks[1].y;
                blocks[2].y=(blocks[1].y-blocks[2].x)+blocks[1].x;
                blocks[2].x=blocks[1].x + a;

                a=blocks[3].y-blocks[1].y;
                blocks[3].y=(blocks[1].y-blocks[3].x)+blocks[1].x;
                blocks[3].x=blocks[1].x + a;
                break;*/

            /*case -1://Rotate left
                blocks[1].y = blocks[0].y;
                blocks[2].y = blocks[0].y;
                blocks[3].y = blocks[0].y;

                blocks[1].x = blocks[0].x-1;
                blocks[2].x = blocks[0].x-2;
                blocks[3].x = blocks[0].x-3;
                /*a =blocks[0].y-blocks[1].y;
                blocks[0].y=(blocks[1].y+blocks[0].x)-blocks[1].x;
                blocks[0].x=blocks[1].x - a;

                a=blocks[2].y-blocks[1].y;
                blocks[2].y=(blocks[1].y+blocks[2].x)-blocks[1].x;
                blocks[2].x=blocks[1].x - a;

                a=blocks[3].y-blocks[1].y;
                blocks[3].y=(blocks[1].y+blocks[3].x)-blocks[1].x;
                blocks[3].x=blocks[1].x - a;
                break;
        }*/
    }
}
