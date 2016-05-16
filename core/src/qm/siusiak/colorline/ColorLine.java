package qm.siusiak.colorline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ColorLine extends ApplicationAdapter {

    private int count;
    private SpriteBatch batch;
    private Line line;
    private LineGenerator lineGenerator;
    private float time;
    private TextureRegion screenShot;

    @Override
    public void create() {
        batch = new SpriteBatch();
        lineGenerator = new LineGenerator();
        line = lineGenerator.getLine();
        screenShot = null;
    }

    @Override
    public void render() {

        time += Gdx.graphics.getDeltaTime();
        if (time > 0.5f) {
                line = lineGenerator.getLine();
                time = 0;
        }
        line.draw();

    }

    @Override
    public void dispose() {
        line.dispose();
        super.dispose();
    }

}
