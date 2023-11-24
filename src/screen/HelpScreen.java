package screen;

import engine.Cooldown;
import engine.Core;
import engine.SoundManager;

import java.awt.event.KeyEvent;

public class HelpScreen extends Screen{

    public HelpScreen(int width, int height, int fps) {
        super(width, height, fps);

        this.returnCode = 1;
    }

    public final int run() {
        super.run();

        return this.returnCode;
    }

    protected final void update() {
        super.update();

        draw();
    }

    private void draw() {
        drawManager.initDrawing(this);
        drawManager.completeDrawing(this);
    }
}
