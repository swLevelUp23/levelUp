package entity;

import engine.Cooldown;
import engine.Core;
import engine.DrawManager;
import engine.GameState;

public class EnemyGraphics {
    private Cooldown animationCooldown;
    private DrawManager.SpriteType spriteType;

    public EnemyGraphics(final DrawManager.SpriteType spriteType) {
        this.spriteType = spriteType;
        this.animationCooldown = Core.getCooldown(500);
    }

    public final void update() {
        if (animationCooldown.checkFinished()) {
            animationCooldown.reset();
            if (spriteType == DrawManager.SpriteType.EnemyShipA1)
                spriteType = DrawManager.SpriteType.EnemyShipA2;
            else
                spriteType = DrawManager.SpriteType.EnemyShipA1;
        }
    }

    public final DrawManager.SpriteType getSpriteType() {
        return spriteType;
    }


}
