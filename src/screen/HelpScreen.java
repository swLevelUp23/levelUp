package screen;

import engine.Cooldown;
import engine.Core;
import engine.SoundManager;
import entity.Bullet;

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

        if (inputManager.isKeyDown(KeyEvent.VK_ESCAPE)) {
            this.returnCode = 1;
            this.isRunning = false;
        }
        draw();
    }

    private void draw() {
        drawManager.initDrawing(this);
        drawManager.drawHelpScreen(this);
        drawManager.completeDrawing(this);
    }
}
