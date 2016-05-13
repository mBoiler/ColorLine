package qm.siusiak.colorline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class ColorLine extends ApplicationAdapter {

    SpriteBatch batch;
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

        if (time >0.2) {
            line = lineGenerator.getLine();
            time = 0;
        }
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(screenShot != null) {
            batch.begin();
            batch.draw(screenShot, 0, 0);
            batch.end();
        }
        line.draw();
        screenShot = ScreenUtils.getFrameBufferTexture();
    }

    @Override
    public void dispose() {
        line.dispose();
        super.dispose();
    }

}
