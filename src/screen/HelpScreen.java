package screen;

import engine.Cooldown;
import engine.Core;
import engine.SoundManager;
import entity.Bullet;

import java.awt.event.KeyEvent;

public class HelpScreen extends Screen{

    static int page = 1;

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
        else if (inputManager.isKeyDown(KeyEvent.VK_LEFT) && this.inputDelay.checkFinished())
            page = 1;
        else if(inputManager.isKeyDown(KeyEvent.VK_RIGHT) && this.inputDelay.checkFinished())
            page = 2;

        draw();
    }

    private void draw() {
        drawManager.initDrawing(this);
        drawManager.drawHelpScreen(this, page);
        drawManager.completeDrawing(this);
    }
}
