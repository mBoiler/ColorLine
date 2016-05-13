package qm.siusiak.colorline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;

public class ColorLine extends ApplicationAdapter {

    private Line line;
    private Array<Line> lineArray;
    private LineGenerator lineGenerator;
    private float time;

    @Override
    public void create() {
        lineArray = new Array<Line>();
        lineGenerator = new LineGenerator();
        line = lineGenerator.getLine();
        lineArray.add(line);
    }

    @Override
    public void render() {

        time += Gdx.graphics.getDeltaTime();

        if (time > 0.5) {
            line = lineGenerator.getLine();
            lineArray.add(line);
            time = 0;
        }

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (Line line : lineArray) {
            line.draw();
        }
    }

    @Override
    public void dispose() {
        for (Line line : lineArray) {
            line.dispose();
        }
        super.dispose();
    }
}
