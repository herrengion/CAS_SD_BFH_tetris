import figure.*;
import tetris.gui.ActionHandler;
import tetris.gui.GUI;
import tetris.gui.ActionEvent;
import tetris.gui.Block;
import java.lang.Math;



public class Game {


    //Fields
    private Block block;
    private Block[] blocks = new Block[4];
    private GUI gui;
    private BaseFigure figure;
    private FigureController figurecontroller;

    //Constructors
    public Game(GUI gui){
        this.gui = gui;
    }



    //Methods

    private void createFigure(int x, int y, int color){

        //Field variable
        Double randomNum = 7*Math.random();

        switch (randomNum.intValue()){
            case 0:
                figure = new IFigure((gui.getFieldWidth()>>2)+1, gui.getFieldHeight()-2);
                break;
            case 1:
                figure = new JFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                break;
            case 2:
                figure = new LFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                break;
            case 3:
                figure = new OFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                break;
            case 4:
                figure = new SFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                break;
            case 5:
                figure = new TFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                break;
            case 6:
                figure = new ZFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                break;
        }
        blocks = figure.getBlocks();
        updateGUI();
    }
    public void start() {
        createFigure(5,18,3);
        figurecontroller = new FigureController();
        gui.setActionHandler(figurecontroller);
    }
    private void updateGUI(){
        gui.clear();
        gui.drawBlocks(blocks);
    }
    private void createBlock(int x, int y, int color) {
        block = new Block(x,y,color);
        gui.drawBlock(block);

    }


    //Sub Classes
    private class FigureController implements ActionHandler {

        //public void handleEvent(ActionEvent event) {

        public void moveDown(){
            figure.move(0,-1);
            updateGUI();
        }

        public void moveLeft(){
            figure.move(-1,0);
            updateGUI();
        }

        public void moveRight(){
            figure.move(1,0);
            updateGUI();
        }

        public void rotateLeft(){
            figure.rotate(-1);
            updateGUI();
        }

        public void rotateRight(){
            figure.rotate(1);
            updateGUI();
        }

        public void drop(){
            createFigure(blocks[0].x+1,3, blocks[0].color); //TBD, temporary!!!
            updateGUI();
        }

    }

}
