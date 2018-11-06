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
    private void createBlock(int x, int y, int color) {
        block = new Block(x,y,color);
        gui.drawBlock(block);

    }
    //Sub Class Figure Controller
    private class FigureController{ //TODO implements ActionHandler {

        private void handleEvent(ActionEvent event) {
            switch (event) {

                    case MOVE_DOWN:
                        //previousBlock = block;
                        //updateGUI();
                        //createBlock(block.x,block.y-1 ,block.color);
                        figure.move(0,-1);
                        updateGUI();
                        //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                        break;
                    case MOVE_LEFT:
                        updateGUI();
                        //createBlock(block.x-1,block.y ,block.color);
                        figure.move(-1,0);
                        updateGUI();
                        //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                        break;
                    case MOVE_RIGHT:
                        updateGUI();
                        //createBlock(block.x+1,block.y,block.color);
                        figure.move(1,0);
                        updateGUI();
                        //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                        break;
                    case ROTATE_LEFT:
                        //updateGUI();
                        figure.rotate(1);
                        //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                        //gui.drawBlocks(blocks);//move to constructor Figure
                        updateGUI();
                        break;
                    case ROTATE_RIGHT:
                        //updateGUI();
                        figure.rotate(-1);
                        //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                        //gui.drawBlocks(blocks);//move to constructor Figure
                        updateGUI();
                        break;
                    case DROP:
                        createFigure(blocks[0].x+1,3, blocks[0].color); //TBD, temporary!!!
                        updateGUI();
                        break;
                    default:
                        break;
                }
            //updateGUI();//laut korrektion updategui hier.
        }
    }
    private void createFigure(int x, int y, int color){

        //Corrections: nur new Figure, mit gui.getfieldheight()-1
        Double randomNum = 7*Math.random();

        switch (randomNum.intValue()){
            case 0:
                figure = new IFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
            case 1:
                figure = new JFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
            case 2:
                figure = new LFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
            case 3:
                figure = new OFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
            case 4:
                figure = new SFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
            case 5:
                figure = new TFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
            case 6:
                figure = new ZFigure(gui.getFieldWidth()/2, gui.getFieldHeight()-2);
                //blocks = figure.getBlocks();
                //updateGUI();
                break;
        }
        /*if(randomNum <= 1) {
            figure = new SFigure(x, y);
        }*/
        blocks = figure.getBlocks();
        updateGUI();
        //gui.drawBlocks(blocks);

    }
    /*private void handleEvent(ActionEvent event) {
        switch (event) {

            case MOVE_DOWN:
                //previousBlock = block;
                //updateGUI();
                //createBlock(block.x,block.y-1 ,block.color);
                figure.move(0,-1);
                updateGUI();
                //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                break;
            case MOVE_LEFT:
                updateGUI();
                //createBlock(block.x-1,block.y ,block.color);
                figure.move(-1,0);
                updateGUI();
                //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                break;
            case MOVE_RIGHT:
                updateGUI();
                //createBlock(block.x+1,block.y,block.color);
                figure.move(1,0);
                updateGUI();
                //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                break;
            case ROTATE_LEFT:
                //updateGUI();
                figure.rotate(1);
                //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                //gui.drawBlocks(blocks);//move to constructor Figure
                updateGUI();
                break;
            case ROTATE_RIGHT:
                //updateGUI();
                figure.rotate(-1);
                //createFigure(blocks[0].x,blocks[0].y, blocks[0].color);
                //gui.drawBlocks(blocks);//move to constructor Figure
                updateGUI();
                break;
            case DROP:
                createFigure(blocks[0].x+1,3, blocks[0].color); //TBD, temporary!!!
                updateGUI();
                break;
            default:
                break;
        }
        //updateGUI();//laut korrektion updategui hier.
    }*/
    public void start() {
        createFigure(5,18,3);
        figurecontroller = new FigureController();
        while(true){
            ActionEvent event = gui.waitEvent();
            figurecontroller.handleEvent(event);
        }
    }
    private void updateGUI(){
        gui.clear();
        gui.drawBlocks(blocks);
    }

    //public Figure getFigure(){return figure};

}
