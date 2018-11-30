import figure.*;
import tetris.gui.ActionHandler;
import tetris.gui.GUI;
import tetris.gui.ActionEvent;
import tetris.gui.Block;
import java.lang.Math;
import java.util.*;


public class Game {


    //Fields
    private Block block;
    private Block[] blocks = new Block[4];
    private GUI gui;
    private BaseFigure figure;
    private BaseFigure previousFigure = new DummyFigure();
    private FigureController figurecontroller;
    //private boolean atStart;
    private List<Block> previousBlocks = new ArrayList<>();
    //Fields
    Field field = new Field(Tetris.width, Tetris.height);

    //private Boolean isFirstIteration = true;

    //Constructors
    public Game(GUI gui){
        this.gui = gui;
    }



    //Methods

    private void createFigure(int x, int y, int color) /*throws CollisionException*/{

        //Field variable
        Double randomNum = 7*Math.random();


        try {
            switch (randomNum.intValue()) {
                case 0:
                    figure = new IFigure((gui.getFieldWidth() >> 2) + 1, gui.getFieldHeight() - 2);
                    break;
                case 1:
                    figure = new JFigure(gui.getFieldWidth() / 2, gui.getFieldHeight() - 2);
                    break;
                case 2:
                    figure = new LFigure(gui.getFieldWidth() / 2, gui.getFieldHeight() - 2);
                    break;
                case 3:
                    figure = new OFigure(gui.getFieldWidth() / 2, gui.getFieldHeight() - 2);
                    break;
                case 4:
                    figure = new SFigure(gui.getFieldWidth() / 2, gui.getFieldHeight() - 2);
                    break;
                case 5:
                    figure = new TFigure(gui.getFieldWidth() / 2, gui.getFieldHeight() - 2);
                    break;
                case 6:
                    figure = new ZFigure(gui.getFieldWidth() / 2, gui.getFieldHeight() - 2);
                    break;
            }
            blocks = figure.getBlocks();
            updateGUI();
            //System.out.println(figure.toString());
            if (previousFigure.hashCode() == figure.hashCode()/*&&!isFirstIteration*/) {
                System.out.println("Same Figure as previous one");
            }
            //isFirstIteration = false;
            previousFigure = figure;
            //atStart = false;
            field.detectCollision(blocks);
        }
        catch (CollisionException e){
            System.out.println("End of Game");
            stop();
        }
    }

    //New in Version 6
    private void figureLanded(){
        field.addBlocks(blocks);
        //gui.drawBlocks(field.getBlocks());
        createFigure(field.getWidth()/2,field.getHeight(),3);
        updateGUI();
    }

    public void start(){
        createFigure(5,18,3);
        figurecontroller = new FigureController();
        gui.setActionHandler(figurecontroller);
        //atStart = true;
        //figureLanded();
    }
    public void stop(){
        //gui.clear();
        //gui.drawBlocks(previousBlocks);
        updateGUI();
        gui.setActionHandler(null);
        field.removeAllBlocks();
    }
    private void updateGUI(){
        gui.clear();
        gui.drawBlocks(previousBlocks);
        gui.drawBlocks(blocks);
        previousBlocks = field.getBlocks();
        //atStart = false;
    }
    private void createBlock(int x, int y, int color) {
        block = new Block(x,y,color);
        gui.drawBlock(block);

    }



    //Sub Classes
    private class FigureController implements ActionHandler {
        //Fields
        //Field field = new Field(Tetris.width, Tetris.height);
        //public void handleEvent(ActionEvent event) {

        //check w/ @Override, if everything ok
        @Override
        public void moveDown(){
            figure.move(0,-1);
            try {
                field.detectCollision(blocks);
            }
            catch (CollisionException e){
                System.err.println("Error: "+ e);
                figure.move(0,1);
                figureLanded();
                /*if(e.isMovementVertical){
                    figure.move(0,1);
                    figureLanded();
                }*/
            }
            updateGUI();
            System.out.println("moveleft() Position x: "+blocks[0].x+" y: "+blocks[0].y);
        }
        @Override
        public void moveLeft(){
            figure.move(-1,0);
            try {
                field.detectCollision(blocks);
            }
            catch (CollisionException e){
                System.err.println("Error: "+ e);
                figure.move(1,0);
            }
            updateGUI();
            System.out.println("moveleft() Position x: "+blocks[0].x+" y: "+blocks[0].y);
        }
        @Override
        public void moveRight(){
            figure.move(1,0);
            try {
                field.detectCollision(blocks);
            }
            catch (CollisionException e){
                System.err.println("Error: "+ e);
                figure.move(-1,0);
            }
            updateGUI();
            System.out.println("moveRight() Position x: "+blocks[0].x+" y: "+blocks[0].y);

        }
        @Override
        public void rotateLeft(){
            figure.rotate(-1);
            try {
                field.detectCollision(blocks);
            }
            catch (CollisionException e){
                System.err.println("Error: "+ e);
                figure.rotate(1);
            }
            updateGUI();
        }
        @Override
        public void rotateRight(){
            figure.rotate(1);
            try {
                field.detectCollision(blocks);
            }
            catch (CollisionException e){
                System.err.println("Error: "+ e);
                figure.rotate(-1);
            }
            updateGUI();
        }

        public void drop(){
            //boolean isFigureAtBottom = false;
            //while(isFigureAtBottom == false) {
            while(true){
            try {
                    field.detectCollision(blocks);
                }
                catch (CollisionException e) {
                    System.err.println("Error: "+ e);
                    figure.move(0, 1);
                    figureLanded();
                    break;
                    /*System.err.println("Error: " + e);
                    if(e.isMovementVertical){
                        isFigureAtBottom = true;
                        figure.move(0, 1);
                        figureLanded();
                        break;*/
                }
                figure.move(0, -1);
            }
                //figure.move(0, -1);

                //createFigure(blocks[0].x+1,3, blocks[0].color); //TBD, temporary!!
            updateGUI();
        }
            //updateGUI();
        }
    }

//}
