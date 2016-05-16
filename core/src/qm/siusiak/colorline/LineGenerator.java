package qm.siusiak.colorline;

import com.badlogic.gdx.Gdx;

import java.util.Random;

/**
 * Created by parktyka2 on 2016-05-13.
 */
public class LineGenerator {

    private static final float rangeY = Gdx.graphics.getHeight() * 0.05f;
    private static final float rangeX = Gdx.graphics.getWidth() * 0.05f;
    private Line line;
    private Random random;
    private float pastX;
    private float pastY;
    private float x;
    private float y;
    private float r;
    private float g;
    private float b;
    private int pastWay;
    private int way;
    private float randPositionX;
    private float randPositionY;

    public LineGenerator() {
        line = new Line(pastX, pastY, x, y, r, g, b);
        random = new Random();
        pastX = Gdx.graphics.getWidth() / 2;
        pastY = Gdx.graphics.getHeight() / 2;
    }

    public Line getLine() {
        randColor();
        randWay();
        line.set(pastX, pastY, x, y, r, g, b);
        pastY = y;
        pastX = x;
        return line;
    }

    public void randColor() {
        String cheat = "0." + (random.nextInt(100));
        r = Float.parseFloat(cheat);
        cheat = "0." + (random.nextInt(100));
        g = Float.parseFloat(cheat);
        cheat = "0." + (random.nextInt(100));
        b = Float.parseFloat(cheat);
    }

    public boolean randWay() {
        way = random.nextInt(8);

        if (way == 0 && pastWay != 2) {
            randPositionX = pastX + rangeX;
            randPositionY = pastY;
        }
        if (way == 1 && pastWay != 3) {
            randPositionX = pastX;
            randPositionY = pastY - rangeY;
        }
        if (way == 2 && pastWay != 0) {
            randPositionX = pastX - rangeX;
            randPositionY = pastY;
        }
        if (way == 3 && pastWay != 1) {
            randPositionX = pastX;
            randPositionY = pastY + rangeY;
        }
        if (way == 4 && pastWay != 6){
            randPositionX = pastX + rangeX;
            randPositionY = pastY + rangeY;
        }
        if (way == 5 && pastWay != 7){
            randPositionX = pastX + rangeX;
            randPositionY = pastY - rangeY;
        }
        if (way == 6 && pastWay != 4){
            randPositionX = pastX - rangeX;
            randPositionY = pastY - rangeY;
        }
        if (way == 7 && pastWay != 5){
            randPositionX = pastX - rangeX;
            randPositionY = pastY + rangeY;
        }
        if (randPositionX < 0 || randPositionX > Gdx.graphics.getWidth() ||
                randPositionY < 0 || randPositionY > Gdx.graphics.getHeight()){
            randWay();
        } else {
            this.x = randPositionX;
            this.y = randPositionY;
            pastWay = way;
        }
        return false;
    }
}

