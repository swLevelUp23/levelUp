package entity;

import engine.Cooldown;
import engine.DrawManager;
import engine.GameState;

import java.awt.*;
import java.util.Set;

public class EnemyShipD extends EnemyShip {
    /** HP의 배율 */
    private final double HPPOWER = 1.5;
    /** 총알의 속도 배율 */
    private final double BULLETSPEEDPOWER = 2;
    /** 슈팅 쿨다운 배율 */
    private final double BULLETCOOLDOWN = 0;
    /** 제거시 올라가는 점수 */
    private final int POINT = 30;
    /** 적 생명력 */
    public EnemyShipD(final int positionX, final int positionY,
                      final DrawManager.SpriteType spriteType, final GameState gameState) {
        super(positionX, positionY, spriteType, gameState);
        super.HP = (int)(super.HP * HPPOWER);
        super.pointValue = POINT;

    }

    public final void update() {
        if (this.animationCooldown.checkFinished()) {
            this.animationCooldown.reset();
            if (spriteType == DrawManager.SpriteType.EnemyShipD1)
                spriteType = DrawManager.SpriteType.EnemyShipD2;
            else
                spriteType = DrawManager.SpriteType.EnemyShipD1;
        }
        switch (super.HP) {
            case 2:
                changeColor(Color.YELLOW);
                break;
            case 1:
                changeColor(Color.GREEN);
                break;
            default:
                changeColor(Color.RED);
        }
    }
    public final void shoot(final Set<Bullet> bullets, Cooldown shootingCooldown) {
        bullets.add(BulletPool.getBullet(positionX
                + width / 2, positionY, (int)(super.BULLET_SPEED * BULLETSPEEDPOWER),0));
        shootingCooldown.timedown(BULLETCOOLDOWN);
    }

}
