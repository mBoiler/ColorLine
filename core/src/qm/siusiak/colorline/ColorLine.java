package qm.siusiak.colorline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class ColorLine extends ApplicationAdapter {

    private Line line;
    private LineGenerator lineGenerator;
    private float time;


    @Override
    public void create() {
        lineGenerator = new LineGenerator();
        line = lineGenerator.getLine();
    }

    @Override
    public void render() {

        time += Gdx.graphics.getDeltaTime();

        if (time > 0.5) {
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
