package qm.siusiak.colorline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by parktyka2 on 2016-05-13.
 */
public class Line {

    private float xStart;
    private float yStart;
    private float xEnd;
    private float yEnd;
    private float rColor;
    private float gColor;
    private float bColor;
    private ShapeRenderer line;

    public Line(float xStart, float yStart, float xEnd, float yEnd, float rColor, float gColor, float bColor) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.rColor = rColor;
        this.gColor = gColor;
        this.bColor = bColor;
        this.line = new  ShapeRenderer();
    }

    public void draw(){
        line.begin(ShapeRenderer.ShapeType.Line);
        Gdx.gl20.glLineWidth(10*Gdx.graphics.getDensity());
        line.setColor(rColor,gColor,bColor,1);
        line.line(xStart, yStart, xEnd, yEnd);
        line.end();
    }

    public void set(float xStart, float yStart, float xEnd, float yEnd, float rColor, float gColor, float bColor) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.rColor = rColor;
        this.gColor = gColor;
        this.bColor = bColor;
    }
    public void dispose(){
        line.dispose();
    }
}
