/*import java.io.*;
import java.util.Scanner;

public class Scoring {
    //Fields
    private static final String HIGH_SCORE_FILE = "C:\\Users\\gion.herren\\Dropbox\\CAS\\Software_Dev_BFH\\02_JAVA\\CAS_SD_BFH_tetris-master\\tetris\\src\\highscore.txt";
    private int highScore;
    private int level;
    private int score;
    //private static final int SCORE_PER_LEVEL;
    //private static final int[] SCORE_REWARDS;

    //Constructors
    public Scoring(){
        //Construct a scoring and read the high score file
            File dir = new File(HIGH_SCORE_FILE);

            try(FileReader reader = new FileReader(HIGH_SCORE_FILE)){
            //try(Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter((new OutputStreamWriter(new FileOutputStream(HIGH_SCORE_FILE),"UTF-8")))){
                    while(true){
                        String line = reader.toString();
                        if(line.isEmpty()){break;}
                    }
            }
            catch (IOException e){
                System.err.println("Error: "+ e);
            }
    }

    //Methods
    public int getHighScore(){return highScore;}

    public int getLevel(){return level;}

    public int getScore(){return score;}

    private void loadHighScore(){}

    public void reset(){}

    private void saveHighScore(){}

    public void updateHighScore(){}

    public void updateScore(int nrows){}

}*/

//package tetris.model;

import java.io.*;

public class Scoring {

    private int level;
    private int score;
    private int highscore = 0;
    private static int SCORE_PER_LEVEL = 1500;
    private static int [] SCORE_REWARDS = new int[4];
    private static String HIGH_SCORE_FILE = "C:\\Users\\Gion\\Dropbox\\CAS\\Software_Dev_BFH\\02_JAVA\\CAS_SD_BFH_tetris-master\\tetris\\highscore.data";

    public Scoring () {
        this.level=1;
        this.score=0;
        SCORE_REWARDS = new int[]{0,40,100,300,1200};
        loadHighScore();
    }

    private void loadHighScore() {
        try {
            FileInputStream fis = new FileInputStream(HIGH_SCORE_FILE);
            DataInputStream dis = new DataInputStream(fis);
            this.highscore = dis.readInt(); //updated
            dis.close();
        } catch (IOException e){
            System.out.println("IOException : "+e);
            System.out.println("Highscore konnte nicht geladen werden und wird auf 0 gesetzt.");
            highscore = 0;
        }
    }
    private void saveHighscore() {
        try {
            FileOutputStream fos = new FileOutputStream(HIGH_SCORE_FILE);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(highscore);
            dos.close();
        }
        catch (IOException e)
        { System.out.println("IOException : " + e);
            System.out.println("Highscore konnte nicht abgespeichert werden.");
        }

    }


    public void updateHighScore () {
        if (this.score > this.getHighscore()){
            this.highscore = this.score;
            System.out.println("highscore geschlagen, Gratulation");
            saveHighscore();
        } else {
            System.out.println("Highscore nicht geschlagen, bad luck");
        }


    }
    public void updateScore(int rows) {
        score = score + SCORE_REWARDS[rows];
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }


    public int getHighscore() {
        return highscore;
    }
    public void reset() {
        this.score=0;
        this.level=1;
    }

}
