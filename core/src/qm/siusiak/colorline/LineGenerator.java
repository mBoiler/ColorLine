package qm.siusiak.colorline;

import com.badlogic.gdx.Gdx;

import java.util.Random;

/**
 * Created by parktyka2 on 2016-05-13.
 */
public class LineGenerator {

    private static final float range = 50;

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
        way = random.nextInt(4);
        if (way == 0 && pastWay != 2) {
            if (pastX + range < Gdx.graphics.getWidth()) {
                this.x = pastX + range;
            } else {
                randWay();
            }
            this.y = pastY;
            pastWay = way;
            return true;
        }
        if (way == 1 && pastWay != 3) {
            this.x = pastX;
            if (pastY + range < Gdx.graphics.getHeight()) {
                this.y = pastY + range;
            } else {
                randWay();
            }
            pastWay = way;
            return true;
        }
        if (way == 2 && pastWay != 0) {
            if (pastX - range > 0) {
                this.x = pastX - range;
            } else {
                randWay();
            }
            this.y = pastY;
            pastWay = way;
            return true;
        }
        if (way == 3 && pastWay != 1) {
            this.x = pastX;
            if (pastY - range > 0) {
                this.y = pastY - range;
            } else {
                randWay();
            }
            pastWay = way;
            return true;
        }
        randWay();
        return false;
    }
}
