package figure;

import tetris.gui.Block;

public class JFigure extends BaseFigure {
    //Fields
    //ColorCode Color = ColorCode.setColorRed();
    //Constructor
    public JFigure(int x, int y){
        super();
        figureName = "JFigure";
        //System.out.println(this.toString());
        blocks[0] = new Block(x, y, RED);
        blocks[1] = new Block(x, y-1, RED);
        blocks[2] = new Block(x, y-2, RED);
        blocks[3] = new Block(x-1, y-2, RED);




    }
    //Methods: adapt rotate()
    public int hashCode(){return 1;}

}
